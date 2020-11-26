package by.testbot.bot;

import by.testbot.models.BotMessage;
import by.testbot.models.Sender;
import by.testbot.models.User;
import by.testbot.models.enums.Roles;
import by.testbot.payload.requests.message.SendPictureMessageRequest;
import by.testbot.payload.requests.message.SendTextMessageRequest;
import by.testbot.regex.RegexHandler;
import by.testbot.services.BotMessageService;

import java.time.LocalDateTime;
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

    ADD_NEW_MESSAGE(true) {
        @Override
        public void enter(BotContext botContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            String viberId = botContext.getMessageCallback().getSender().getId();
            sender.setName("AutoCapitalBot");

            String list = "Ведите сообщение: \n";
            sendTextMessageRequest.setText(list);
            sendTextMessageRequest.setKeyboard(KeyboardSource.getEditTextMessageMenuKeyboard());
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);

            botContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public void handleInput(BotContext botContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            String viberId = botContext.getMessageCallback().getSender().getId();
            Sender sender = new Sender();
            sender.setName("AutoCapitalBot");

            LocalDateTime currentTime = LocalDateTime.now();
            String userAnswer = botContext.getMessageCallback().getMessage().getText();
            BotMessage botMessage = BotMessage.builder()
                    .messageText(userAnswer)
                    .timeStamp(currentTime)
                    .build();
            botContext.getBotMessageService().save(botMessage);

            String list = "Сообщение добавленно!\n";
            sendTextMessageRequest.setText(list);
            sendTextMessageRequest.setKeyboard(KeyboardSource.getEditTextMessageMenuKeyboard());
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);

            botContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public BotState nextState() {
            return EMPTY;
        }
    },

    DELETE_MESSAGE(true) {

        @Override
        public void enter(BotContext botContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            String viberId = botContext.getMessageCallback().getSender().getId();
            sender.setName("AutoCapitalBot");

            String list = "Сообщение удалено";
            sendTextMessageRequest.setText(list);
            sendTextMessageRequest.setKeyboard(KeyboardSource.getEditTextMessageMenuKeyboard());
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);
            botContext.getBotMessageService().deleteMessage(BotMessageService.botMessageId);
            botContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return EDIT_TEXT_MESSAGE;
        }
    },

    VIEW_MESSAGE(true) {
        BotState botState;

        @Override
        public void enter(BotContext botContext) {
        }

        @Override
        public void handleInput(BotContext botContext) {
            String text = botContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "editMessage":
                    botState = EDIT_MESSAGE;
                    break;
                case "deleteMessage":
                    botState = DELETE_MESSAGE;
                    break;
                case "cancelToMainMenu":
                    botState = MAIN_MENU;
                    break;
                default:
                    botState = EDIT_TEXT_MESSAGE;
                    break;
            }
        }

        @Override
        public BotState nextState() {
            return botState;
        }
    },

    EDIT_MESSAGE(true) {
        BotState botState;

        @Override
        public void enter(BotContext botContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            String viberId = botContext.getMessageCallback().getSender().getId();
            sender.setName("AutoCapitalBot");

            String list = "В разработке";
            sendTextMessageRequest.setText(list);
            sendTextMessageRequest.setKeyboard(KeyboardSource.getEditTextMessageMenuKeyboard());
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

    EDIT_TEXT_MESSAGE(true) {
        BotState botState;
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        @Override
        public void enter(BotContext botContext) {
            String viberId = botContext.getMessageCallback().getSender().getId();
            String list = "Список сообщений: \n\n";
            list = list.concat(botContext.getBotMessageService().getStartAllMessagesToString());
            sender.setName("AutoCapitalBot");
            sendTextMessageRequest.setKeyboard(KeyboardSource.getEditTextMessageMenuKeyboard());
            sendTextMessageRequest.setText(list);
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);

            botContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public void handleInput(BotContext botContext) {
            String text = botContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "addNewMessage":
                    botState = ADD_NEW_MESSAGE;
                    break;
                case "openMessage":
                    botState = OPEN_MESSAGE;
                    break;
                case "cancelToMainMenu":
                    botState = MAIN_MENU;
                    break;
                default:
                    botState = EDIT_TEXT_MESSAGE;
                    break;
            }
        }

        @Override
        public BotState nextState() {
            return botState;
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

    OPEN_MESSAGE(true) {
        BotState botState;
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        @Override
        public void enter(BotContext botContext) {
            List<BotMessage> botMessages = botContext.getBotMessageService().getAllMessages();
            String viberId = botContext.getMessageCallback().getSender().getId();
            sender.setName("AutoCapitalBot");
            if (!botMessages.isEmpty()) {
                sendTextMessageRequest.setKeyboard(KeyboardSource.getButtonsOpenMessage(botMessages.size()));
                sendTextMessageRequest.setText("Выберите или введите номер сообщения которое хотите открыть");
            } else {
                sendTextMessageRequest.setText("Сообщений нет");
            }
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);
            botContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }


        @Override
        public void handleInput(BotContext botContext) {
            String userAnswer = botContext.getMessageCallback().getMessage().getText();
            String viberId = botContext.getMessageCallback().getSender().getId();
            if (RegexHandler.checkUserAnswerOnDigit(userAnswer)) {
                int numberMessage = Integer.parseInt(userAnswer);
                List<BotMessage> botMessages = botContext.getBotMessageService().getAllMessages();
                if (numberMessage <= botMessages.size()) {
                    sender.setName("AutoCapitalBot");
                    sendTextMessageRequest.setKeyboard(KeyboardSource.getMenuKeyboardWithButtonsEditAndDeleteMessage());
                    sendTextMessageRequest.setText(botMessages.get(numberMessage - 1).getMessageText());
                    BotMessageService.botMessageId = botMessages.get(numberMessage - 1).getId();
                    sendTextMessageRequest.setSender(sender);
                    sendTextMessageRequest.setUserId(viberId);
                    botContext.getViberService().sendTextMessage(sendTextMessageRequest);
                }
            }
        }

        @Override
        public BotState nextState() {
            return VIEW_MESSAGE;
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
            sendTextMessageRequest.setKeyboard(KeyboardSource.getListOfManagersMenuKeyboard());
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);

            botContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public void handleInput(BotContext botContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            String name = botContext.getMessageCallback().getMessage().getContact().getName();
            String viberId = botContext.getMessageCallback().getSender().getId();
            List<User> users = botContext.getUserService().getUserByName(name);
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
            return MANAGERS;
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
                if (botContext.getUserService().editRoleOnUser(managerNumber) != null) {
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
