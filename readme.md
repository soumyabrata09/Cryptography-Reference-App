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
    <dependency>
        <groupId>com.sam09.lib</groupId>
        <artifactId>cryptography-starter</artifactId>
        <version>1.0.0-SNAPSHOT</version> 
    <dependency>

    <dependency>
	    <groupId>com.sam09.lib</groupId>
	    <artifactId>sb-jackson-starter</artifactId>
		<version>1.0.0-SNAPSHOT</version>
	</dependency>
````
> version tag can be used from the jfrog artifactorty 

Change `server.port=<Desired Port>` in the application.yaml file

Execute `mvn spring-boot:run`

**Exposed Endpoints** 
- > v1/encrypt
  ````
  curl -X POST localhost:8080/v1/crypto-service/encrypt \
  -H 'Content-Type: application/json' \
  -d '{"name":"Soumyabrata09","value":"Time is something they say, we never understand until it slips away"}'
  ````
- > v1/decrypt
  ````
  curl -X POST localhost:8080/v1/crypto-service/decrypt \
  -H 'Content-Type:application/json' \
  -d '{"name":"Soumyabrata09","value":"VGltZSBpcyBzb21ldGhpbmcgdGhleSBzYXksIHdlIG5ldmVyIHVuZGVyc3RhbmQgdW50aWwgaXQgc2xpcHMgYXdheQ"}'
  ````
 **Swagger Implementation**
 Include the following dependencies in the pom file
````
  <dependency>
    <groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>3.0.0</version>
  </dependency>
  <dependency>
  	<groupId>io.springfox</groupId>
  	<artifactId>springfox-swagger-ui</artifactId>
  	<version>2.9.2</version>
  </dependency>
```` 

After running the application goto 
> `http://localhost:8080/swagger-ui.html` 

_**Actuator Shutdown endpoint has been turned off and in the place a custom shutdown endpoint has been provided for a graceful shutdown hook**_
> curl -X POST localhost:8080/v1/shutdown

**Jfrog Integration**
````
<!--Jfrog artifactory integration-->
	<distributionManagement>
		<repository>
			<id>central</id>
			<name>a0guqxkvavcvp-artifactory-primary-0-releases</name>
			<url>https://soumyabrata09.jfrog.io/artifactory/sam09-libs-release</url>
		</repository>
		<snapshotRepository>
			<id>snapshots</id>
			<name>a0guqxkvavcvp-artifactory-primary-0-snapshots</name>
			<url>https://soumyabrata09.jfrog.io/artifactory/sam09-libs-snapshot</url>
		</snapshotRepository>
	</distributionManagement>
````

**To publish artifact to jfrog**
> mvn clean install deploy 
> Snapshots will be published to (  https://soumyabrata09.jfrog.io/artifactory/sam09-libs-snapshot/com/sam09/cryptography/reference-app/


_Action Item_
 - [x] Create a Generic SLF4J logger which can be inject to generic bean generator and can be used across the project 
 - [x] Implement Swagger
 - [x] A custom starter can be referred from jfrog artifactory directly
 - [ ] Onboard the application to Jenkins
 - [ ] Dockerized this application
 - [x] Jfrog Integration Done
 - [x] Provide an endpoint for a graceful shutdown
 - [ ] Enable Prometheus Monitoring
 
[Guidance to write well formatted readme file](https://docs.github.com/en/github/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)