package by.testbot.alphaCRM.payload.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class AuthorizationRequest {
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("api_key")
    private String api_key;

}
