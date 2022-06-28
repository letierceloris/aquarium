@echo off
call mvn clean package
call docker build -t aquaGroup/aquarium .
call docker rm -f aquarium
call docker run -d -p 9080:9080 -p 9443:9443 --name aquarium aquaGroup/aquarium