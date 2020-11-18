package by.testbot.payload.callbacks;

import java.security.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import by.testbot.models.enums.EventType;
import lombok.Data;

@Data
public class DeliveredCallback {
    @JsonProperty("event")
    private EventType eventType;

    @JsonProperty("timestamp")
    private Timestamp timestamp;

    @JsonProperty("message_token")
    private Long messageToken;

    @JsonProperty("user_id")
    private String userId;
}
