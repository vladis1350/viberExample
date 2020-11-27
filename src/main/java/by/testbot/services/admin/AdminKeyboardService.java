package by.testbot.services.admin;

import by.testbot.bot.admin.AdminKeyboardSource;
import by.testbot.models.BotMessage;
import by.testbot.models.Sender;
import by.testbot.payload.requests.message.SendTextMessageRequest;
import by.testbot.regex.RegexHandler;
import by.testbot.services.BotMessageService;
import by.testbot.services.ViberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminKeyboardService {
    @Autowired
    private ViberService viberService;

    @Autowired
    private BotMessageService botMessageService;

    public void sendAdminMainMenuKeyboard(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Привет я бот MEGA LIFE");
        sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getAdminMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendListOfManagersMenuKeyboard(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Управление менеджерами");
        sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getListOfManagersMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendSelectedMessage(String viberId, String userAnswer) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");
        sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getMenuKeyboardWithButtonsEditAndDeleteMessage());
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);
        if (RegexHandler.checkUserAnswerOnDigit(userAnswer)) {
            int numberMessage = Integer.parseInt(userAnswer);
            List<BotMessage> botMessages = botMessageService.getAllMessages();
            if (numberMessage <= botMessages.size()) {
                sendTextMessageRequest.setText(botMessages.get(numberMessage - 1).getMessageText());
                BotMessageService.botMessageId = botMessages.get(numberMessage - 1).getId();
            } else {
                sendTextMessageRequest.setText("Не верный ввод");
            }
        } else {
            sendTextMessageRequest.setText("Не верный ввод");
        }
        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendOpenMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        List<BotMessage> botMessages = botMessageService.getAllMessages();
        sender.setName("AutoCapitalBot");
        if (!botMessages.isEmpty()) {
            sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getButtonsOpenMessage(botMessages.size()));
            sendTextMessageRequest.setText("Выберите или введите номер сообщения которое хотите открыть");
        } else {
            sendTextMessageRequest.setText("Сообщений нет");
        }
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendInputEditedMessage(String viberId, String editedMessage) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");
        BotMessage botMessage = botMessageService.getBotMessageById(BotMessageService.botMessageId);
        if (botMessage != null) {
            botMessage.setMessageText(editedMessage);
            botMessageService.update(botMessage);
            sendTextMessageRequest.setText("Изменения сохранены успешно!");
        } else {
            sendTextMessageRequest.setText("Что то пошло не так, изменения не сохранены.");
        }
        sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getAdminMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendEditMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        String list = "В разработке";
        sendTextMessageRequest.setText(list);
        sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getEditTextMessageMenuKeyboard());
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendListMessages(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");
        String list = "Список сообщений: \n\n";
        list = list.concat(botMessageService.getStartAllMessagesToString());
        sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getEditTextMessageMenuKeyboard());
        sendTextMessageRequest.setText(list);
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);
        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendDeleteMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        String list = "Сообщение удалено";
        sendTextMessageRequest.setText(list);
        sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getEditTextMessageMenuKeyboard());
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);
        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendMessageAdded(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");
        String list = "Сообщение добавленно!\n";
        sendTextMessageRequest.setText(list);
        sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getEditTextMessageMenuKeyboard());
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);
        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void addMessageMenuKeyboard(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        String list = "Ведите сообщение: \n";
        sendTextMessageRequest.setText(list);
        sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getEditTextMessageMenuKeyboard());
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);
        viberService.sendTextMessage(sendTextMessageRequest);
    }

}
