A simple http server for development and test.

## Usage

### run
```shell
    java -jar mock-http-server.jar
```

### request
 
1. default response

| method | request | response |
|---|---|---|
| get | ``curl "http://localhost:8080/get"`` | get world!|
| post(form) | ``curl -d "key1=value1" "http://localhost:8080/post"``| post value1!|
| post(json) | too long not write | hello world!|
| put | ``curl -X PUT "http://localhost:8080/put"`` | put world!|
| delete | ``curl -X DELETE "http://localhost:8080/delete"`` | delete world!|


2. echo response 
echo path will return anything you input.
```
curl "http://localhost:8080/echo"
```

3. custom response
custom path will return file you config.
```
curl "http://localhost:8080/custom"
```

Note: 
1. the application/json request have not complete.
2. the server port is 8080  