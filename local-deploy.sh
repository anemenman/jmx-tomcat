#!/bin/bash

docker -v && docker-compose -v && git --version
result=$?
if [ $result -ne 0 ]; then exit 0; fi

echo "Setup deploy..."
./gradlew build && docker build -f src/main/docker/Dockerfile --tag=jmx-tomcat .
result=$?
if [ $result -ne 0 ]; then exit 0; fi

#echo "Up docker-compose..."
#cd ../deploy && /usr/local/bin/docker-compose -f docker-compose.yml up --build -d
#result=$?
#if [ $result -ne 0 ]; then exit 0; fi

echo "DONE"
