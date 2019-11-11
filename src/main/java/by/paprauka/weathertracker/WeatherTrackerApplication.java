package by.paprauka.weathertracker;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherTrackerApplication {

    private static final String PROPERTY_PATH = "..\\application.properties";

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(WeatherTrackerApplication.class)
                .properties(PROPERTY_PATH)
                .build().run(args);
    }
}
