package by.testbot.services;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.testbot.models.enums.Status;
import by.testbot.payload.requests.SetWebhookRequest;
import by.testbot.payload.responses.SetWebhookResponse;
import by.testbot.proxy.ViberProxy;
import by.testbot.utils.Utils;

@Service
public class ViberService {
    private static final Logger logger = LoggerFactory.getLogger(ViberService.class);
    
    @Autowired
    private ViberProxy viberProxy;

    public void setWeebhook(String authenticationToken, String url) {
        if (authenticationToken == null || authenticationToken.isEmpty() || authenticationToken.isBlank()) {
            logger.error("AuthenticationToken is invalid");
            return;
        }

        SetWebhookRequest setWebhookRequest = new SetWebhookRequest();

        setWebhookRequest.setUrl(url);
        setWebhookRequest.setEventTypes(Utils.getAllEventTypes());
        setWebhookRequest.setSendName(true);
        setWebhookRequest.setSendPhoto(true);

        SetWebhookResponse setWebhookResponse = viberProxy.setWebhook(authenticationToken, setWebhookRequest);

        if (setWebhookResponse.getStatus() == Status.OK) {
            logger.info("Webhook setted with response: " + setWebhookResponse.getStatusMessage());
        }
        else {
            logger.warn("Webhook not setted with code: " + setWebhookResponse.getStatus() + ", with message: " + setWebhookResponse.getStatusMessage());
        }
    }

}
