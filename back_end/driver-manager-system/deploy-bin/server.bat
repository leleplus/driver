@echo off
mvn  -f ../system-server/pom.xml clean package && mv ../system-server/target/*.jar ./apps/system-server.jar & mvn  -f ../api-server/pom.xml  clean package && mv ../api-server/target/*.jar ./apps/system-server.jar && echo SUCCESSFUL

