package by.testbot.services;

import by.testbot.bot.KeyboardSource;
import by.testbot.models.ViberUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.testbot.models.Sender;
import by.testbot.payload.requests.message.SendTextMessageRequest;

@Service
public class MessageService {
    @Autowired
    private ViberService viberService;
    @Autowired
    private KeyboardService keyboardService;
    @Autowired
    private UserService userService;

    public void sendHelloWorldMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Привет ");
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendHelloWorldMessage(ViberUpdate viberUpdate) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Привет " + viberUpdate.getSubscribedCallback().getUser().getName());
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setKeyboard(KeyboardSource.getAdminMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberUpdate.getSubscribedCallback().getUser().getViberId());

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void askManagerNumberForPrivilegeUser(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        String list = "Менеджеры: \n";
        list = list.concat(userService.getListManagerToString());
        list = list.concat("\n Введите номер менеджера, с которого хотите снять привилегию: ");

        sendTextMessageRequest.setText(list);
        sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
//        sendTextMessageRequest.setTrackingData("addManager");
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void askUserNumberForPrivilegeManager(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        String list = "Пользователи: \n";
        list = list.concat(userService.getListUsersToString());
        list = list.concat("\n Введите номер пользователя, которого хотите сделать менеджером: ");

        sendTextMessageRequest.setText(list);
        sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
//        sendTextMessageRequest.setTrackingData("addManager");
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendAddPhotoMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Загрузите фото, которое будет отправлено");
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendSelectDateAndTimeMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Выберите день и время когда сообщение будет отправлено");
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendListOfManagersMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");
        String listManagers = userService.getListUsersToString();
        sendTextMessageRequest.setText(listManagers);
        sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendAddManagerMessage(String viberId) {
        //TODO: send add manager details messages
    }

    public void sendDeleteManagerMessage(String viberId) {
        //TODO: send delete manager details messages
    }

    public void changeManagerPrivilegiesMessage(String viberId) {
        //TODO: send change manager privilegies details message
    }

    public void sendListOfClientsMessage(String viberId) {
        //TODO: get and send list of clients
    }

    public void sendAdditionalOperationsWithClientsMessage(String viberId) {
        //TODO: send additional operations with clients details messages
    }

    public void sendGetReportAboutManagersWork(String viberId) {
        //TODO: create and send report about managers work
    }

    public void sendGetReportAboutBotWork(String viberId) {
        //TODO: create and send report about bot work
    }

    public void sendAddIntegrationMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Введите токен для добавления интеграции");
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendDeleteIntegrationMessage(String viberId) {
        //TODO: send delete integration details message
    }

    public void sendNewIntegrationsMessage(String viberId) {
        //TODO: get and send list of integrations ?????
    }

    public void sendListOfMessagesWhichBotSendMessage(String viberId) {
        //TODO: get and send list of messages which bot send
    }

    public void sendInChatBotWorkTimePeriodSettingsMessage(String viberId) {
        //TODO: send in chat bot work time period settings details
    }

    public void sendAtNightBotWorkTimePeriodSettingsMessage(String viberId) {
        //TODO: send at night bot work time period settings details
    }
}
