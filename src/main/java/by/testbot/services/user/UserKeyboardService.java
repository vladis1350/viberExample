package by.testbot.services.user;

import by.testbot.bot.user.UserKeyboardSource;
import by.testbot.models.Sender;
import by.testbot.payload.requests.message.SendTextMessageRequest;
import by.testbot.services.ViberService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserKeyboardService {

    @Autowired
    private ViberService viberService;

    @SneakyThrows
    public void sendStartUserMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Здравствуте, меня зовут Ульяна. Я виртуальный помощник.\nДобро пожаловать в " +
                "MEGALIFE.BY");
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
        Thread.sleep(5000);
        sendTextMessageRequest.setText("Давайте знакомиться, как вас зовут? ");
        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendUserMainMenuKeyboard(String viberId, String userAnswer) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText(userAnswer + ", я могу помощь со следующими вопросами");
        sendTextMessageRequest.setKeyboard(UserKeyboardSource.getUserMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }
}
