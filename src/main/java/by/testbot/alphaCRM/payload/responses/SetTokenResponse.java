package by.testbot.alphaCRM.payload.responses;

import by.testbot.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SetTokenResponse {
    @JsonProperty("status")
    private Status status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("token")
    private String token;

    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private int code;

    @JsonProperty("type")
    private int type;
}
