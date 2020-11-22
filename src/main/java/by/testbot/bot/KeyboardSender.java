package by.testbot.bot;

import by.testbot.models.Sender;
import by.testbot.payload.requests.message.SendTextMessageRequest;
import by.testbot.services.ViberService;

public class KeyboardSender {
    public static void sendAdminMainMenuKeyboard(ViberService viberService, String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Главное меню");
        sendTextMessageRequest.setKeyboard(KeyboardSource.getAdminMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    } 

    public static void sendListOfManagersMenuKeyboard(ViberService viberService, String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Список менеджеров");
        sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public static void sendListOfClientsMenuKeyboard(ViberService viberService, String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Список клиентов");
        sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public static void sendReportMenuKeyboard(ViberService viberService, String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Отчет");
        sendTextMessageRequest.setKeyboard(KeyboardSource.getReportMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public static void sendIntegrationsMenuKeyboard(ViberService viberService, String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Интеграции");
        sendTextMessageRequest.setKeyboard(KeyboardSource.getIntegrationsMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public static void sendSettingsMenuKeyboard(ViberService viberService, String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Настройки");
        sendTextMessageRequest.setKeyboard(KeyboardSource.getSettingsMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public static void sendBotUsagePeriodMenuKeyboard(ViberService viberService, String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Настройка периода временного использования бота");
        sendTextMessageRequest.setKeyboard(KeyboardSource.getSetBotUsagePeriodMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public static void sendConfirmPostponeMessageKeyboard(ViberService viberService, String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Подтвердите отправку отложенного сообщения");
        sendTextMessageRequest.setKeyboard(KeyboardSource.getConfirmPostponeMessageKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

}
