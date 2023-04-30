#!/bin/bash

# Define the service name and the deployment name
SERVICE_NAME=order-service
OLD_VERSION=1.0.0
NEW_VERSION=1.1.0

# Define the traffic percentage for the new version
TRAFFIC_PERCENTAGE=10

# Calculate the number of instances for the new version
NEW_INSTANCES=$(echo "scale=0; $(curl -s localhost:8000/order/actuator/info | jq '.instances') * $TRAFFIC_PERCENTAGE / 100" | bc)

# Deploy the new version with the desired instances
java -jar ${SERVICE_NAME}-${NEW_VERSION}.jar --server.port=8002 --spring.application.name=${SERVICE_NAME} &
NEW_PID=$!

# Wait for the new version to be ready
sleep 30

# Switch the traffic to the new version
sudo iptables -A PREROUTING -t nat -p tcp --dport 80 -m state --state NEW -m statistic --mode nth --every ${TRAFFIC_PERCENTAGE} --jump DNAT --to-destination localhost:8002

# Wait for the new version to receive traffic
sleep 60

# Switch the traffic back to the old version
sudo iptables -D PREROUTING -t nat -p tcp --dport 80 -m state --state NEW -m statistic --mode nth --every ${TRAFFIC_PERCENTAGE} --jump DNAT --to-destination localhost:8002
sudo iptables -A PREROUTING -t nat -p tcp --dport 80 -m state --state NEW -j DNAT --to-destination localhost:8001

# Stop the new version
kill ${NEW_PID}
