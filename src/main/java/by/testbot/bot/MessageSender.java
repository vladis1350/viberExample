package by.testbot.bot;

import by.testbot.models.Sender;
import by.testbot.payload.requests.message.SendTextMessageRequest;
import by.testbot.services.ViberService;

public class MessageSender {
    public static void sendAddTextMessage(ViberService viberService, String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Введите текст, который будет отправлен");
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public static void sendAddPhotoMessage(ViberService viberService, String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Загрузите фото, которое будет отправлено");
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public static void sendSelectDateAndTimeMessage(ViberService viberService, String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Выберите день и время когда сообщение будет отправлено");
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public static void sendListOfManagersMessage(ViberService viberService, String viberId) {
        //TODO: get and send list of managers
    }

    public static void sendAddManagerMessage(ViberService viberService, String viberId) {
        //TODO: send add manager details messages
    }

    public static void sendDeleteManagerMessage(ViberService viberService, String viberId) {
        //TODO: send delete manager details messages
    }

    public static void changeManagerPrivilegiesMessage(ViberService viberService, String viberId) {
        //TODO: send change manager privilegies details message
    }

    public static void sendListOfClientsMessage(ViberService viberService, String viberId) {
        //TODO: get and send list of clients
    }

    public static void sendAdditionalOperationsWithClientsMessage(ViberService viberService, String viberId) {
        //TODO: send additional operations with clients details messages
    }

    public static void sendGetReportAboutManagersWork(ViberService viberService, String viberId) {
        //TODO: create and send report about managers work
    }

    public static void sendGetReportAboutBotWork(ViberService viberService, String viberId) {
        //TODO: create and send report about bot work
    }

    public static void sendAddIntegrationMessage(ViberService viberService, String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Введите токен для добавления интеграции");
        sendTextMessageRequest.setSender(sender);
        sendTextMessageRequest.setUserId(viberId);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public static void sendDeleteIntegrationMessage(ViberService viberService, String viberId) {
        //TODO: send delete integration details message
    }

    public static void sendNewIntegrationsMessage(ViberService viberService, String viberId) {
        //TODO: get and send list of integrations ?????
    }

    public static void sendListOfMessagesWhichBotSendMessage(ViberService viberService, String viberId) {
        //TODO: get and send list of messages which bot send
    }

    public static void sendInChatBotWorkTimePeriodSettingsMessage(ViberService viberService, String viberId) {
        //TODO: send in chat bot work time period settings details
    }

    public static void sendAtNightBotWorkTimePeriodSettingsMessage(ViberService viberService, String viberId) {
        //TODO: send at night bot work time period settings details
    }
}
