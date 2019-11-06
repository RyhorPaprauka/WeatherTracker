package by.paprauka.weathertracker.service;

import by.paprauka.weathertracker.document.WeatherDocument;
import by.paprauka.weathertracker.repository.WeatherRepository;
import com.mongodb.BasicDBObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WeatherService {

    private final RestTemplate restTemplate;
    private final WeatherRepository weatherRepository;

    @Value("${api.request.url}")
    private String apiUrl;
    @Value("${api.key}")
    private String apiKey;

    @Scheduled(cron = "${schedule.cron}")
    public void getMinskWeather() {
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class, apiKey);

        WeatherDocument weatherDocument = WeatherDocument.builder()
                .responseDate(new Date(response.getHeaders().getDate()))
                .responseStatus(response.getStatusCodeValue())
                .responseBody(BasicDBObject.parse(response.getBody()))
                .build();

        weatherRepository.save(weatherDocument);
    }
}
