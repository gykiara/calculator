# Microservice Calculator
Implement a microservice "Calculator" using maven + spring-boot.

This microservice exposes an API that is able, from some input parameters, to perform arithmetic operations. As it is a POC version, it is only capable of performing additions and subtractions of 2 elements (a,b), although it is foreseen that in future versions there will be other types of operations and of greater complexity. A library has been included that contains an API for tracing operations that is invoked from the microservice to trace the result of the operation.

# Requirements
Project created with:
1. Maven 4.0.0
2. JAVA OpenJDK 11
3. Spring-boot 2.7.14

In the pom, the dependency has been added to the provided library:
```
<dependency>
    <groupId>io.corp.calculator</groupId>
    <artifactId>tracer</artifactId>
    <version>1.0.0</version>
</dependency>
```
In order to use it, you need to run the maven command:

`mvn install:install-file -Dfile=lib/tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar`

To create the folder `/target`, which will contain the application JAR ([calculator-0.0.1-SNAPSHOT.jar](target%2Fcalculator-0.0.1-SNAPSHOT.jar)), run the command `mvn clean install`.

# Steps
At this point we are ready to start the application using the command:

`mvn spring-boot:run`

Or by running the .jar:

`java -jar calculadora-0.0.1-SNAPSHOT.jar`

Once the application is up, Swagger can be used for testing and documentation:

http://localhost:8080/swagger-ui/index.html