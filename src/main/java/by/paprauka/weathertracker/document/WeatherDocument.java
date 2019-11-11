package by.paprauka.weathertracker.document;

import com.mongodb.DBObject;
import lombok.Builder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Builder
@Document(collection = "openweathermap")
public class WeatherDocument {

    @Id
    private ObjectId id;

    @Indexed
    @Field("response_date")
    private Date responseDate;

    @Field("response_status")
    private Integer responseStatus;

    @Field("response_body")
    private DBObject responseBody;
}
