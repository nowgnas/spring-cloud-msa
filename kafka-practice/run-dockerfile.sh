#!/bin/bash

echo "start run dockerfile"

while : 
do 
  echo "run docker file?? 0(NO) any key(YES)"
  read state
  if [${state} -eq '0']
  then 
    break 
  else
    echo "port: "
    read port 
    echo "image name: "
    read image_name
    echo "tag: "
    read tag
    docker run --name ${image_name} -d -p ${port}:${port} ${image_name}:${tag}
  fi
done
echo "run docker file success"