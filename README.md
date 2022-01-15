# Messaging Application

## Run

To run the application, run the following command in a terminal window:

`./docker-compose up`

To health check application, open the following url in a browser:

http://localhost:8080/actuator/health

## Test

To test appliciation postman collection file ("Messaging.postman_collection.json") can be imported into Postman.

## Create Account

to create user replace {{username}}, multiple users will be needed for testing

````
curl --location --request POST 'http://localhost:8080/account' \
--header 'Content-Type: application/json' \
--data-raw '{
"username": "{{username}}"
}'
````

## Get Account

to get account info including account id, replace {{username}} account id will be used while sending message, retrieving
inbox and outbox

````
curl --location --request GET 'http://localhost:8080/account/{{username}}'
````

## Send Post

to send post replace

* {{from-account-id}} with sender account id,
* {{to-account-id}} with receiver account id,
* {{text}} with text message

````
curl --location --request POST 'http://localhost:8080/messaging/send' \
--header 'Content-Type: application/json' \
--data-raw '{
    "from": "{{from-account-id}}",
    "to": "{{to-account-id}}",
    "text": "{{text}}"
}'
````

## Retrieve Inbox

to retrieve inbox replace

* {{account-id}} with account id
* {{from-account-id} with the account id that will be filtered

from request parameter is optional, remove it to retrieve all messages

````
curl --location --request GET 'http://localhost:8080/messaging/{{account-id}}/inbox?from={{from-account-id}}'
````

## Retrieve Outbox

to retrieve outbox replace

* {{account-id}} with account id

````
curl --location --request GET 'http://localhost:8080/messaging/{{account-id}}/outbox'
````