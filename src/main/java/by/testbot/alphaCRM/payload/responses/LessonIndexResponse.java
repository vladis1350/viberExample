package by.testbot.alphaCRM.payload.responses;

import by.testbot.alphaCRM.models.Lesson;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class LessonIndexResponse {

    @JsonProperty("total")
    private String total;

    @JsonProperty("count")
    private String count;

    @JsonProperty("page")
    private String page;

    @JsonProperty("items")
    private List<Lesson> lessonList;


}
