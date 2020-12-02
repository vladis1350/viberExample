package by.testbot.alphaCRM.payload.responses;

import by.testbot.alphaCRM.models.LessonType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class LessonTypeResponse {

    @JsonProperty("total")
    private int total;

    @JsonProperty("count")
    private int count;

    @JsonProperty("page")
    private int page;

    @JsonProperty("items")
    private List<LessonType> items;

}
