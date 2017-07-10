# queuepublisher


The is a spring boot app which exposes a service to publish a message to Rabbit MQ server

The end point url is
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
