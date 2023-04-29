#!/bin/bash

services=(discovery config gateway user order)

for i in ${services[@]}
do 
  echo "$i is run "
  echo "port : "
  read port 
  docker run --name $i --network cloud -d -p ${port}:${port} $i:1
done