package by.testbot.bot.admin;

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

public enum AdminBotState {

    MAIN_MENU(true) {
        AdminBotState adminBotState;

        @Override
        public void enter(AdminBotContext adminBotContext) {
            adminBotContext.getAdminKeyboardService().sendAdminMainMenuKeyboard(adminBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {
            String text = adminBotContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "editTextMessage":
                    adminBotState = EDIT_TEXT_MESSAGE;
                    break;
                case "autopost":
                    adminBotState = AUTO_POSTING;
                    break;
                case "privateMessage":
                    adminBotState = PRIVATE_MESSAGE;
                    break;
                case "managerList":
                    adminBotState = MANAGERS;
                    break;
                case "botRequest":
                    adminBotState = BOT_REQUEST;
                    break;
                default:
                    adminBotState = MAIN_MENU;
                    break;
            }
        }

        @Override
        public AdminBotState nextState() {
            return adminBotState;
        }
    },

    PRIVATE_MESSAGE(true) {
        @Override
        public void enter(AdminBotContext adminBotContext) {

        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {

        }

        @Override
        public AdminBotState nextState() {
            return MAIN_MENU;
        }
    },

    BOT_REQUEST(true) {
        @Override
        public void enter(AdminBotContext adminBotContext) {

        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {

        }

        @Override
        public AdminBotState nextState() {
            return MAIN_MENU;
        }
    },

    EMPTY(true) {
        @Override
        public void enter(AdminBotContext adminBotContext) {

        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {

        }

        @Override
        public AdminBotState nextState() {
            return MAIN_MENU;
        }
    },

    AUTO_POSTING(true) {
        @Override
        public void enter(AdminBotContext adminBotContext) {

        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {

        }

        @Override
        public AdminBotState nextState() {
            return MAIN_MENU;
        }
    },

    ADD_NEW_MESSAGE(true) {
        @Override
        public void enter(AdminBotContext adminBotContext) {
            adminBotContext.getAdminKeyboardService().addMessageMenuKeyboard(adminBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {
            LocalDateTime currentTime = LocalDateTime.now();
            String userAnswer = adminBotContext.getMessageCallback().getMessage().getText();
            BotMessage botMessage = BotMessage.builder()
                    .messageText(userAnswer)
                    .timeStamp(currentTime)
                    .build();
            adminBotContext.getBotMessageService().save(botMessage);
            adminBotContext.getAdminKeyboardService().sendMessageAdded(adminBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public AdminBotState nextState() {
            return EMPTY;
        }
    },

    DELETE_MESSAGE(true) {
        @Override
        public void enter(AdminBotContext adminBotContext) {
            adminBotContext.getBotMessageService().deleteMessage(BotMessageService.botMessageId);
            adminBotContext.getAdminKeyboardService().sendDeleteMessage(adminBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {

        }

        @Override
        public AdminBotState nextState() {
            return EDIT_TEXT_MESSAGE;
        }
    },

    VIEW_MESSAGE(true) {
        AdminBotState adminBotState;

        @Override
        public void enter(AdminBotContext adminBotContext) {
        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {
            String text = adminBotContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "editMessage":
                    adminBotState = EDIT_MESSAGE;
                    break;
                case "deleteMessage":
                    adminBotState = DELETE_MESSAGE;
                    break;
                case "cancelToMainMenu":
                    adminBotState = MAIN_MENU;
                    break;
                default:
                    adminBotState = EDIT_TEXT_MESSAGE;
                    break;
            }
        }

        @Override
        public AdminBotState nextState() {
            return adminBotState;
        }
    },

    EDIT_MESSAGE(true) {
        AdminBotState adminBotState;

        @Override
        public void enter(AdminBotContext adminBotContext) {
            adminBotContext.getAdminKeyboardService().sendEditMessage(adminBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {
            String userAnswer = adminBotContext.getMessageCallback().getMessage().getText();
            String viberId = adminBotContext.getMessageCallback().getSender().getId();
            adminBotContext.getAdminKeyboardService().sendInputEditedMessage(viberId, userAnswer);
        }

        @Override
        public AdminBotState nextState() {
            return EMPTY;
        }
    },

    EDIT_TEXT_MESSAGE(true) {
        AdminBotState adminBotState;

        @Override
        public void enter(AdminBotContext adminBotContext) {
            adminBotContext.getAdminKeyboardService().sendListMessages(adminBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {
            String text = adminBotContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "addNewMessage":
                    adminBotState = ADD_NEW_MESSAGE;
                    break;
                case "openMessage":
                    adminBotState = OPEN_MESSAGE;
                    break;
                case "cancelToMainMenu":
                    adminBotState = MAIN_MENU;
                    break;
                default:
                    adminBotState = EDIT_TEXT_MESSAGE;
                    break;
            }
        }

        @Override
        public AdminBotState nextState() {
            return adminBotState;
        }
    },

    MANAGERS(true) {
        AdminBotState adminBotState;

        @Override
        public void enter(AdminBotContext adminBotContext) {
            adminBotContext.getAdminKeyboardService().sendListOfManagersMenuKeyboard(adminBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {
            String text = adminBotContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "getListManagers":
                    adminBotState = LIST_OF_MANAGERS;
                    break;
                case "addManager":
                    adminBotState = ADD_MANAGER;
                    break;
                case "deleteManager":
                    adminBotState = DELETE_MANAGER;
                    break;
                case "cancelToMainMenu":
                    adminBotState = MAIN_MENU;
                    break;
                default:
                    adminBotState = MANAGERS;
                    break;
            }
        }

        @Override
        public AdminBotState nextState() {
            return adminBotState;
        }
    },

    OPEN_MESSAGE(true) {
        AdminBotState adminBotState;

        @Override
        public void enter(AdminBotContext adminBotContext) {
            adminBotContext.getAdminKeyboardService().sendOpenMessage(adminBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {
            String userAnswer = adminBotContext.getMessageCallback().getMessage().getText();
            String viberId = adminBotContext.getMessageCallback().getSender().getId();
            adminBotContext.getAdminKeyboardService().sendSelectedMessage(viberId, userAnswer);
        }

        @Override
        public AdminBotState nextState() {
            return VIEW_MESSAGE;
        }
    },

    LIST_OF_MANAGERS(false) {
        @Override
        public void enter(AdminBotContext adminBotContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            String viberId = adminBotContext.getMessageCallback().getSender().getId();
            sender.setName("AutoCapitalBot");

            String list = "Менеджеры: \n\n";
            list = list.concat(adminBotContext.getUserService().getListManagerToString());
            sendTextMessageRequest.setText(list);
            sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getListOfManagersMenuKeyboard());
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);

            adminBotContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {

        }

        @Override
        public AdminBotState nextState() {
            return MANAGERS;
        }
    },

    ADD_MANAGER(true) {
        @Override
        public void enter(AdminBotContext adminBotContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            String viberId = adminBotContext.getMessageCallback().getSender().getId();
            sender.setName("AutoCapitalBot");

            String list = "Выберите человека из списка контактов, которого хотите сделать менеджером: ";

            sendTextMessageRequest.setText(list);
            sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getListOfManagersMenuKeyboard());
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);

            adminBotContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            String viberId = adminBotContext.getMessageCallback().getSender().getId();
            sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getListOfManagersMenuKeyboard());
            Sender sender = new Sender();
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);
            String name = adminBotContext.getMessageCallback().getMessage().getContact().getName();
            List<User> users = adminBotContext.getUserService().getUserByName(name);
            sender.setName("AutoCapitalBot");
            if (!users.isEmpty() && users.size() > 1) {
                SendPictureMessageRequest sendPictureMessageRequest = new SendPictureMessageRequest();

                String list = "Найдено несколько совпадений по имени: ";
                for (int i = 0; i < users.size(); i++) {
                    list = list.concat(i + 1 + ". " + users.get(i).getName());

                    sendPictureMessageRequest.setMediaUrl(users.get(i).getAvatar());
                    sendPictureMessageRequest.setKeyboard(AdminKeyboardSource.getListOfManagersMenuKeyboard());
                    sendPictureMessageRequest.setText(list);
                    sendPictureMessageRequest.setUserId(viberId);

                    adminBotContext.getViberService().sendPictureMessage(sendPictureMessageRequest);
                    list = "";
                }
            } else if (users.size() == 1) {
                User user = users.get(0);
                user.setRole(Roles.MANAGER.getRole());
                adminBotContext.getUserService().update(user);
                sendTextMessageRequest.setText(name + " теперь менеджер!");
            } else {
                sendTextMessageRequest.setText(name + " не подписан на бота!");
            }
            adminBotContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public AdminBotState nextState() {
            return MANAGERS;
        }
    },

    DELETE_MANAGER(true) {
        @Override
        public void enter(AdminBotContext adminBotContext) {
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            String viberId = adminBotContext.getMessageCallback().getSender().getId();
            sender.setName("AutoCapitalBot");

            String list = "Менеджеры: \n\n";
            list = list.concat(adminBotContext.getUserService().getListManagerToString());
            list = list.concat("\n\nВведите номер менеджера в списке чтобы снять роль менеджера:");
            sendTextMessageRequest.setText(list);
            sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getListOfManagersMenuKeyboard());
            sendTextMessageRequest.setSender(sender);
            sendTextMessageRequest.setUserId(viberId);

            adminBotContext.getViberService().sendTextMessage(sendTextMessageRequest);
        }

        @Override
        public void handleInput(AdminBotContext adminBotContext) {
            String userAnswer = adminBotContext.getMessageCallback().getMessage().getText();
            SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
            Sender sender = new Sender();
            String viberId = adminBotContext.getMessageCallback().getSender().getId();
            if (RegexHandler.checkUserAnswerOnDigit(userAnswer)) {
                int managerNumber = Integer.parseInt(userAnswer);
                if (adminBotContext.getUserService().editRoleOnUser(managerNumber) != null) {
                    String message = "Роль менеджера с " + adminBotContext.getUserService().editRoleOnUser(managerNumber).getName() + " снята!";
                    sendTextMessageRequest.setText(message);
                    sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getListOfManagersMenuKeyboard());
                    sendTextMessageRequest.setSender(sender);
                    sendTextMessageRequest.setUserId(viberId);

                    adminBotContext.getViberService().sendTextMessage(sendTextMessageRequest);
                }
            } else {
                String message = "Введите номер менеджера в списке чтобы снять роль менеджера:";
                sendTextMessageRequest.setText(message);
                sendTextMessageRequest.setKeyboard(AdminKeyboardSource.getListOfManagersMenuKeyboard());
                sendTextMessageRequest.setSender(sender);
                sendTextMessageRequest.setUserId(viberId);

                adminBotContext.getViberService().sendTextMessage(sendTextMessageRequest);
            }
        }

        @Override
        public AdminBotState nextState() {
            return MANAGERS;
        }
    };


    private final Boolean isInputNeeded;

    AdminBotState(Boolean isInputNeeded) {
        this.isInputNeeded = isInputNeeded;
    }

    public static AdminBotState getInitialState() {
        return MAIN_MENU;
    }

    public Boolean getIsInputNeeded() {
        return isInputNeeded;
    }

    public void handleInput(AdminBotContext adminBotContext) {
    }

    public abstract void enter(AdminBotContext adminBotContext);

    public abstract AdminBotState nextState();
}
