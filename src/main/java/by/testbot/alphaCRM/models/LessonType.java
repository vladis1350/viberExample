package by.testbot.alphaCRM.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LessonType {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("is_active")
    private String is_active;

    @JsonProperty("sort")
    private String sort;

}
