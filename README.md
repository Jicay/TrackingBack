# Tracking-back

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `fr.jicay.tracking.TrackingApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Database

The default database is hosted by Heroku. It can be changed in `application.yml` file.
The database is a PostgreSQL instance.
The default database has a limited number of lines, due to Heroku limitations. 
To clean the database, you can use the following command : 
``` shell
curl -X DELETE \
  https://tracking-mouse-back.herokuapp.com/sessions \
  -H 'Postman-Token: 40d06e09-f77b-41c6-bfc6-fda15b170c9c' \
  -H 'cache-control: no-cache'
```

## Hosting

The application is hosted at the following address : https://tracking-mouse-back.herokuapp.com