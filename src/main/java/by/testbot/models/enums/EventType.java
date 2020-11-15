package by.testbot.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EventType {
    @JsonProperty("delivered")
    DELIVERED,

    @JsonProperty("seen")
    SEEN,

    @JsonProperty("failed")
    FAILED,

    @JsonProperty("subscribed")
    SUBSCRIBED,

    @JsonProperty("unsubscribed")
    UNSUBSCRIBED,

    @JsonProperty("conversation_started")
    CONVERSATION_STARTED
}
