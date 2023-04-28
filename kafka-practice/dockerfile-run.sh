#!/bin/bash

echo "file path: "
read path

echo "tag name: "
read tag

docker build -f ${path} -t ${tag} .