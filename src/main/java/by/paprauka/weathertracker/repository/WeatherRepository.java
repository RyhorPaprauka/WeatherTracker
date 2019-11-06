package by.paprauka.weathertracker.repository;

import by.paprauka.weathertracker.document.WeatherDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeatherRepository extends MongoRepository<WeatherDocument, String> {
}
