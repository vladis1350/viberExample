package by.testbot.bot.admin;

import by.testbot.models.Button;
import by.testbot.models.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class AdminKeyboardSource {

    public static Keyboard getAdminMainMenuKeyboard() {
        Keyboard keyboard = new Keyboard();
        List<Button> buttons = new ArrayList<>();

        Button postponeMessageButton = new Button();
        postponeMessageButton.setText("Изменение текстовых ссобщений");
        postponeMessageButton.setActionBody("editTextMessage");
        postponeMessageButton.setColumns(3);
        postponeMessageButton.setRows(1);
        buttons.add(postponeMessageButton);

        Button listOfManagersButton = new Button();
        listOfManagersButton.setText("Автопостинг");
        listOfManagersButton.setActionBody("autopost");
        listOfManagersButton.setColumns(3);
        listOfManagersButton.setRows(1);
        buttons.add(listOfManagersButton);

        Button privateMessage = new Button();
        privateMessage.setText("Личное сообщение клиенту");
        privateMessage.setActionBody("privateMessage");
        privateMessage.setColumns(3);
        privateMessage.setRows(1);
        buttons.add(privateMessage);

        Button listOfClientsButton = new Button();
        listOfClientsButton.setText("Список менеджеров");
        listOfClientsButton.setActionBody("managerList");
        listOfClientsButton.setColumns(3);
        listOfClientsButton.setRows(1);
        buttons.add(listOfClientsButton);

        Button reportButton = new Button();
        reportButton.setText("Заявки из бота");
        reportButton.setActionBody("botRequest");
        reportButton.setColumns(3);
        reportButton.setRows(1);
        buttons.add(reportButton);

        keyboard.setButtons(buttons);
        return keyboard;
    }

    public static Keyboard getListOfManagersMenuKeyboard() {
        Keyboard keyboard = new Keyboard();
        List<Button> buttons = new ArrayList<>();

        Button cancelToMainMenu = new Button();
        cancelToMainMenu.setText("Главное меню");
        cancelToMainMenu.setActionBody("cancelToMainMenu");
        cancelToMainMenu.setColumns(6);
        cancelToMainMenu.setRows(1);
        buttons.add(cancelToMainMenu);

        Button getListOfManagersButton = new Button();
        getListOfManagersButton.setText("Список");
        getListOfManagersButton.setActionBody("getListManagers");
        getListOfManagersButton.setColumns(3);
        getListOfManagersButton.setRows(1);
        buttons.add(getListOfManagersButton);

        Button addManagerButton = new Button();
        addManagerButton.setText("Добавить менеджера");
        addManagerButton.setActionBody("addManager");
        addManagerButton.setColumns(3);
        addManagerButton.setRows(1);
        buttons.add(addManagerButton);

        Button deleteManagerButton = new Button();
        deleteManagerButton.setText("Удалить менеджера");
        deleteManagerButton.setActionBody("deleteManager");
        deleteManagerButton.setColumns(3);
        deleteManagerButton.setRows(1);
        buttons.add(deleteManagerButton);

        keyboard.setButtons(buttons);
        return keyboard;
    }

    public static Keyboard getEditTextMessageMenuKeyboard() {
        Keyboard keyboard = new Keyboard();
        List<Button> buttons = new ArrayList<>();

        Button cancelToMainMenu = new Button();
        cancelToMainMenu.setText("Главное меню");
        cancelToMainMenu.setActionBody("cancelToMainMenu");
        cancelToMainMenu.setColumns(6);
        cancelToMainMenu.setRows(1);
        buttons.add(cancelToMainMenu);

        Button addNewMessage = new Button();
        addNewMessage.setText("Добавить");
        addNewMessage.setActionBody("addNewMessage");
        addNewMessage.setColumns(6);
        addNewMessage.setRows(1);
        buttons.add(addNewMessage);

        Button openMessage = new Button();
        openMessage.setText("Открыть");
        openMessage.setActionBody("openMessage");
        openMessage.setColumns(6);
        openMessage.setRows(1);
        buttons.add(openMessage);

        keyboard.setButtons(buttons);
        return keyboard;
    }

    public static Keyboard getButtonsOpenMessage(int quantity) {
        Keyboard keyboard = new Keyboard();
        List<Button> buttons = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            Button cancelToMainMenu = new Button();
            cancelToMainMenu.setText((i + 1) + "");
            cancelToMainMenu.setActionBody((i + 1) + "");
            cancelToMainMenu.setColumns(1);
            cancelToMainMenu.setRows(1);
            buttons.add(cancelToMainMenu);
        }

        keyboard.setButtons(buttons);
        return keyboard;
    }

    public static Keyboard getMenuKeyboardWithButtonsEditAndDeleteMessage() {
        Keyboard keyboard = new Keyboard();
        List<Button> buttons = new ArrayList<>();

        Button cancelToMainMenu = new Button();
        cancelToMainMenu.setText("Главное меню");
        cancelToMainMenu.setActionBody("cancelToMainMenu");
        cancelToMainMenu.setColumns(6);
        cancelToMainMenu.setRows(1);
        buttons.add(cancelToMainMenu);

        Button editMessage = new Button();
        editMessage.setText("Изменить");
        editMessage.setActionBody("editMessage");
        editMessage.setColumns(3);
        editMessage.setRows(1);
        buttons.add(editMessage);

        Button deleteMessage = new Button();
        deleteMessage.setText("Удалить");
        deleteMessage.setActionBody("deleteMessage");
        deleteMessage.setColumns(3);
        deleteMessage.setRows(1);
        buttons.add(deleteMessage);

        keyboard.setButtons(buttons);
        return keyboard;
    }

}
