package by.testbot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;

@Service
public class InitializationService {
    @Autowired
    private ViberService viberService;

    @Value("${testbot.authenticationToken}")
    private String authenticationToken;

    @Value("${testbot.webhookUrl}")
    private String webhookUrl;

    @SneakyThrows
    public void initalize() {
        viberService.setWeebhook(authenticationToken, webhookUrl);
    }
}
