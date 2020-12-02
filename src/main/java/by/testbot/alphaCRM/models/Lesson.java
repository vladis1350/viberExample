package by.testbot.alphaCRM.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lesson {

    @JsonProperty("id")
    private String id;

    @JsonProperty("branch_id")
    private String branch_id;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("time_from")
    private String time_from;

    @JsonProperty("time_to")
    private String time_to;

    @JsonProperty("lesson_type_id")
    private String lesson_type_id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("subject_id")
    private String subject_id;

    @JsonProperty("room_id")
    private String room_id;

    @JsonProperty("teacher_ids")
    private List<Integer> teacher_ids;

    @JsonProperty("group_ids")
    private List<Integer> group_ids;

}
