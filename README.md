# springboot-reward-app

This is a retailer reward Java / Maven / Spring Boot (version 2.2.2) application.

## How to Run
There are several ways to run a Spring Boot application on your application on your local machine. One way to execute the `main` method in the 
'com.shop.RewardApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven Plugin] like so:

```shell
mvn spring-boot:run
```

## About the Service

The service is just Reward calculation REST services.
You can call  REST endpoint defined in ```com.shop.controller.RewardController``` on **port 8080**.
