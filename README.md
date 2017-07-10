# queuepublisher


The is a spring boot app which exposes a service to publish a message to Rabbit MQ server

#To run this app 

download and install rabbit mq
download and install maven
run mvn clean install

Then run the start.bat for windows or start.sh for linux

#The end point url is
http://localhost:8082/publish/greetings

Sample payload is
{
 "message":"Publish Message to Rabbit MQ" 
}

response 

{
"message": "message published"
}

Please Note:

Rabbit MQ should be installed on the machine
