package by.testbot.alphaCRM.payload.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherRequest {

    @JsonProperty("group_id")
    private String groupId;
}
