The simple application that receiving data from external service (in my case "OpenWeatherMap") and saving it in MongoDB by schedule.

To work with it using maven you should:

1. $ mvn install
2. Set your own properties in application.properties file.
3. $ mvn spring-boot:run 

* if properties was changed, you should only rerun app
