package by.testbot.alphaCRM.payload.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendLessonTypeRequest {

    @JsonProperty("status")
    private String status;

    @JsonProperty("page")
    private String page;

    @JsonProperty("group_id")
    private String group_id;

    @JsonProperty("lesson_date")
    private String lesson_date;

    @JsonProperty("subject_id")
    private String subjectId;

    @JsonProperty("room_id")
    private String roomId;

    @JsonProperty("teacher_ids")
    private String teacher_ids;
}
