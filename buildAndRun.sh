#!/bin/sh
mvn clean package && docker build -t aquaGroup/aquarium .
docker rm -f aquarium || true && docker run -d -p 9080:9080 -p 9443:9443 --name aquarium aquaGroup/aquarium