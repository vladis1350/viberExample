package by.testbot.bot;

import by.testbot.models.Sender;
import by.testbot.models.User;
import by.testbot.models.enums.Roles;
import by.testbot.payload.requests.message.SendPictureMessageRequest;
import by.testbot.payload.requests.message.SendTextMessageRequest;
import by.testbot.regex.RegexHandler;

import java.util.List;

public enum BotState {

    MAIN_MENU(true) {
        BotState botState;

        @Override
        public void enter(BotContext botContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();

            sender.setName("AutoCapitalBot");

            sendTextMessageRequest.setText("Привет я бот MEGA LIFE");
            sendTextMessageRequest.setKeyboard(KeyboardSource.getAdminMainMenuKeyboard());
            sendTextMessageRequest.setUserId(botContext.getMessageCallback().getSender().getId());
            sendTextMessageRequest.setSender(sender);
            botContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public void handleInput(BotContext botContext) {
            String text = botContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "editTextMessage":
                    botState = EDIT_TEXT_MESSAGE;
                    break;
                case "autopost":
                    botState = AUTO_POSTING;
                    break;
                case "privateMessage":
                    botState = PRIVATE_MESSAGE;
                    break;
                case "managerList":
                    botState = MANAGERS;
                    break;
                case "botRequest":
                    botState = BOT_REQUEST;
                    break;
                default:
                    botState = MAIN_MENU;
                    break;
            }
        }

        @Override
        public BotState nextState() {
            return botState;
        }
    },

    PRIVATE_MESSAGE(true) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return MAIN_MENU;
        }
    },

    BOT_REQUEST(true) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return MAIN_MENU;
        }
    },

    AUTO_POSTING(true) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return MAIN_MENU;
        }
    },

    EMPTY(true) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return MAIN_MENU;
        }
    },

    EDIT_TEXT_MESSAGE(true) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return MAIN_MENU;
        }
    },

    MANAGERS(true) {
        BotState botState;

        @Override
        public void enter(BotContext botContext) {
            botContext.getKeyboardService().sendListOfManagersMenuKeyboard(botContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(BotContext botContext) {
            String text = botContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "getListManagers":
                    botState = LIST_OF_MANAGERS;
                    break;
                case "addManager":
                    botState = ADD_MANAGER;
                    break;
                case "deleteManager":
                    botState = DELETE_MANAGER;
                    break;
                case "cancelToMainMenu":
                    botState = MAIN_MENU;
                    break;
                default:
                    botState = MANAGERS;
                    break;
            }
        }

        @Override
        public BotState nextState() {
            return botState;
        }
    },

    LIST_OF_MANAGERS(false) {
        @Override
        public void enter(BotContext botContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            String viberId = botContext.getMessageCallback().getSender().getId();
            sender.setName("AutoCapitalBot");

            String list = "Менеджеры: \n\n";
            list = list.concat(botContext.getUserService().getListManagerToString());
            sendTextMessageRequest.setText(list);
            sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);

            botContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return EMPTY;
        }
    },

    ADD_MANAGER(true) {
        @Override
        public void enter(BotContext botContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            String viberId = botContext.getMessageCallback().getSender().getId();
            sender.setName("AutoCapitalBot");

            String list = "Выберите человека из списка контактов, которого хотите сделать менеджером: ";

            sendTextMessageRequest.setText(list);
            sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);

            botContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public void handleInput(BotContext botContext) {
            String name = botContext.getMessageCallback().getMessage().getContact().getName();
            String viberId = botContext.getMessageCallback().getSender().getId();
            List<User> users = botContext.getUserService().getUserByName(name);
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            sender.setName("AutoCapitalBot");
            if (!users.isEmpty() && users.size() > 1) {
                SendPictureMessageRequest sendPictureMessageRequest = new SendPictureMessageRequest();

                String list = "Найдено несколько совпадений по имени: ";
                for (int i = 0; i < users.size(); i++) {
                    list = list.concat(i + 1 + ". " + users.get(i).getName());

                    sendPictureMessageRequest.setMediaUrl(users.get(i).getAvatar());
                    sendPictureMessageRequest.setText(list);
                    sendPictureMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
                    sendPictureMessageRequest.setUserId(viberId);

                    botContext.getViberService().sendPictureMessage(sendPictureMessageRequest);
                    list = "";
                }
            } else if (users.size() == 1) {
                User user = users.get(0);
                user.setRole(Roles.MANAGER.getRole());
                botContext.getUserService().update(user);
                sendTextMessageRequest.setText(name + " теперь менеджер!");
                sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
                sendTextMessageRequest.setSender(sender);
                sendTextMessageRequest.setUserId(viberId);
                botContext.getViberService().sendTextMessage(sendTextMessageRequest);
            } else {
                sendTextMessageRequest.setText(name + " не подписан на бота!");
                sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
                sendTextMessageRequest.setSender(sender);
                sendTextMessageRequest.setUserId(viberId);
                botContext.getViberService().sendTextMessage(sendTextMessageRequest);
            }
        }

        @Override
        public BotState nextState() {
            return EMPTY;
        }
    },

    DELETE_MANAGER(true) {
        @Override
        public void enter(BotContext botContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            String viberId = botContext.getMessageCallback().getSender().getId();
            sender.setName("AutoCapitalBot");

            String list = "Менеджеры: \n\n";
            list = list.concat(botContext.getUserService().getListManagerToString());
            list = list.concat("\n\nВведите номер менеджера в списке чтобы снять роль менеджера:");
            sendTextMessageRequest.setText(list);
            sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);

            botContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public void handleInput(BotContext botContext) {
            String userAnswer = botContext.getMessageCallback().getMessage().getText();
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            String viberId = botContext.getMessageCallback().getSender().getId();
            if (RegexHandler.checkUserAnswerOnDigit(userAnswer)) {
                int managerNumber = Integer.parseInt(userAnswer);
                if(botContext.getUserService().editRoleOnUser(managerNumber) != null) {
                    String message = "Роль менеджера с " + botContext.getUserService().editRoleOnUser(managerNumber).getName() + " снята!";
                    sendTextMessageRequest.setText(message);
                    sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
                    sendTextMessageRequest.setSender(sender);
                    sendTextMessageRequest.setUserId(viberId);

                    botContext.getViberService().sendTextMessage(sendTextMessageRequest);
                }
            } else {
                String message = "Введите номер менеджера в списке чтобы снять роль менеджера:";
                sendTextMessageRequest.setText(message);
                sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
                sendTextMessageRequest.setSender(sender);
                sendTextMessageRequest.setUserId(viberId);

                botContext.getViberService().sendTextMessage(sendTextMessageRequest);
            }
        }

        @Override
        public BotState nextState() {
            return EMPTY;
        }
    };


    private final Boolean isInputNeeded;

    BotState(Boolean isInputNeeded) {
        this.isInputNeeded = isInputNeeded;
    }

    public static BotState getInitialState() {
        return MAIN_MENU;
    }

    public Boolean getIsInputNeeded() {
        return isInputNeeded;
    }

    public void handleInput(BotContext botContext) {
    }

    public abstract void enter(BotContext botContext);

    public abstract BotState nextState();
}
