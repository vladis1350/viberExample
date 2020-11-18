package by.testbot.payload.callbacks;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import by.testbot.models.enums.EventType;
import lombok.Data;

@Data
public class UnsubscribedCallback {
    @JsonProperty("event")
    private EventType eventType;

    @JsonProperty("timestamp")
    private Timestamp timestamp;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("message_token")
    private Long messageToken;
}
