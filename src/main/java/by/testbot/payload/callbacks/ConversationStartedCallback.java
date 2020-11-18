package by.testbot.payload.callbacks;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import by.testbot.models.User;
import by.testbot.models.enums.EventType;
import lombok.Data;

@Data
public class ConversationStartedCallback {
    @JsonProperty("event")
    private EventType eventType;

    @JsonProperty("timestamp")
    private Timestamp timestamp;

    @JsonProperty("message_token")
    private Long messageToken;

    @JsonProperty("type")
    private String type;

    @JsonProperty("context")
    private String context;

    @JsonProperty("user")
    private User user;

    @JsonProperty("subscribed")
    private Boolean subscribed;
}
