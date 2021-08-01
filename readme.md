## A Reference Application which exposes two endpoints to either encrypt or decrypt data
### This reference application is using a custom cryptography starter as its dependency.

**Custom Starter Package:** [Cryptography Starter](https://github.com/soumyabrata09/SB-Custom-Starter)

**Pre-Requisite**
 - Maven in local
 - JDK 1.8 minimum
 
````
mvn clean compile
````
And then
````
mvn clean install
````

**Usage Guide**

To run Locally:
Add the following dependency into the pom.xml
````
    <groupId>com.sam09.lib</groupId>
    <artifactId>cryptography-starter</artifactId>
    <version>1.0.0-SNAPSHOT</version>
````

Change `server.port=<Desired Port>` in the application.yaml file

Execute `mvn spring-boot:run`

**Exposed Endpoints** 
- > v1/encrypt
  ````
  curl -X POST localhost:8080/v1/encrypt \
  -H 'Content-Type: application/json' \
  -d '{"name":"Soumyabrata09","value":"Time is something they say, we never understand until it slips away"}'
  ````
- > v1/decrypt
  ````
  curl -X POST localhost:8080/v1/decrypt \
  -H 'Content-Type:application/json' \
  -d '{"name":"Soumyabrata09","value":"VGltZSBpcyBzb21ldGhpbmcgdGhleSBzYXksIHdlIG5ldmVyIHVuZGVyc3RhbmQgdW50aWwgaXQgc2xpcHMgYXdheQ"}'
  ````
  
  
_TODO_
 - [x] Create a Generic SLF4J logger which can be inject to gereric bean generator and can be used across the project 
 - [ ] Implement Swagger
 - [ ] Onboard the application to Jenkins
 - [ ] Dockerized this application
 - [ ] Provide an endpoint for a graceful shutdown
 - [ ] Enable Prometheus Monitoring
 
[Guidance to write well formatted readme file](https://docs.github.com/en/github/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)