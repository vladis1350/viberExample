package by.testbot.payload.callbacks;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import by.testbot.models.User;
import by.testbot.models.enums.EventType;
import lombok.Data;

@Data
public class SubscribedCallback {
    @JsonProperty("event")
    private EventType eventType;

    @JsonProperty("timestamp")
    private Timestamp timestamp;

    @JsonProperty("user")
    private User user;

    @JsonProperty("message_token")
    private Long messageToken;
}
