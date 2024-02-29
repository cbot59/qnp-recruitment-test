# qnp-recruitment-test
QNP Recruitment test

## Problems
1. Create restful Api with CRUD operation on one entity, Contact, that contains name, email, phone and address with h2/mysql/postgres using Spring Data JPA/JDBC or other ORM you're familiar with. 
2. Create an endpoint that fetch 2 data concurrently from https://jsonplaceholder.org, for example fetch Users data and Posts data. Calculated the total time it needs to completed the request. 
3. Add rate-limiter to those endpoint for example, that limit to 10 request in 60 seconds. The 11th request within 60 seconds window will return 429 status code and an error message. Use your own algorithm.
4. Add JWT validation for those endpoints.

## Prerequisites
1. Java 21
2. Maven

## Run app
```shell
mvn spring-boot:run
```

## Task 1

### Do `curl` for GET
```shell
curl -X GET --location "http://localhost:8080/contacts" \
    -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJJc3N1ZXIiOiJsb2NhbGhvc3QiLCJVc2VybmFtZSI6InJpdmFsZGkiLCJleHAiOjE3NDA4NDk3MDksImlhdCI6MTcwOTIyNzMwOX0.kj_Mu_FQZM8tgtgyb5wP9LvCmRQgn4W04ehaC1Cq6IQ"
```

### Do `curl` for POST
```shell
curl -X POST --location "http://localhost:8080/contacts" \
    -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJJc3N1ZXIiOiJsb2NhbGhvc3QiLCJVc2VybmFtZSI6InJpdmFsZGkiLCJleHAiOjE3NDA4NDk3MDksImlhdCI6MTcwOTIyNzMwOX0.kj_Mu_FQZM8tgtgyb5wP9LvCmRQgn4W04ehaC1Cq6IQ" \
    -H "Content-Type: application/json" \
    -d '{
          "name": "Rivaldi",
          "email": "rivaldi@yopmail.com",
          "phone": "+628111111111",
          "address": "Jakarta"
        }'
```

## Task 2

### Do `curl`
```shell
curl -X GET --location "http://localhost:8080/user-post/calculate" \
    -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJJc3N1ZXIiOiJsb2NhbGhvc3QiLCJVc2VybmFtZSI6InJpdmFsZGkiLCJleHAiOjE3NDA4NDk3MDksImlhdCI6MTcwOTIyNzMwOX0.kj_Mu_FQZM8tgtgyb5wP9LvCmRQgn4W04ehaC1Cq6IQ"
```

## Task 3

### Do `curl` 11 times within a minute
```shell
curl -X GET --location "http://localhost:8080/user-post/calculate" \
    -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJJc3N1ZXIiOiJsb2NhbGhvc3QiLCJVc2VybmFtZSI6InJpdmFsZGkiLCJleHAiOjE3NDA4NDk3MDksImlhdCI6MTcwOTIyNzMwOX0.kj_Mu_FQZM8tgtgyb5wP9LvCmRQgn4W04ehaC1Cq6IQ"
```


# Task 4

## Do `curl`
```shell
curl -X GET --location "http://localhost:8080/contacts" \
    -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJJc3N1ZXIiOiJsb2NhbGhvc3QiLCJVc2VybmFtZSI6InJpdmFsZGkiLCJleHAiOjE3NDA4NDk3MDksImlhdCI6MTcwOTIyNzMwOX0.kj_Mu_FQZM8tgtgyb5wP9LvCmRQgn4W04ehaC1Cq6IQ"
```
