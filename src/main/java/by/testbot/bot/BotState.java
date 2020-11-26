package by.testbot.bot;

import by.testbot.models.Sender;
import by.testbot.models.User;
import by.testbot.models.enums.Roles;
import by.testbot.payload.requests.message.SendPictureMessageRequest;
import by.testbot.payload.requests.message.SendTextMessageRequest;

import java.util.List;

public enum BotState {

    MAIN_MENU(true) {
        BotState botState;

        @Override
        public void enter(BotContext botContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();

            sender.setName("AutoCapitalBot");

            sendTextMessageRequest.setText("Привет бот MEGA LIFE");
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

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return MANAGERS;
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
//            sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
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
                sendTextMessageRequest.setText(user.getName() + " теперь менеджер!");
                sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
                sendTextMessageRequest.setSender(sender);
                sendTextMessageRequest.setUserId(viberId);
                botContext.getViberService().sendTextMessage(sendTextMessageRequest);
            }
        }

        @Override
        public BotState nextState() {
            return MANAGERS;
        }
    },

    DELETE_MANAGER(true) {
        @Override
        public void enter(BotContext botContext) {

        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return MANAGERS;
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
