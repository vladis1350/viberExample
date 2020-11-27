package by.testbot.bot.user;

public enum UserBotState {

    CONVERSATION_STARTED(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            userBotContext.getUserKeyboardService()
                    .sendStartUserMessage(userBotContext
                            .getConversationStartedCallback()
                            .getUser()
                            .getViberId());
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {
            String userAnswer = userBotContext.getMessageCallback().getMessage().getText();
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            userBotContext.getUserKeyboardService()
                    .sendUserMainMenuKeyboard(viberId, userAnswer);
        }

        @Override
        public UserBotState nextState() {
            return MAIN_MENU;
        }
    },

    MAIN_MENU(true) {
        UserBotState userBotState;

        @Override
        public void enter(UserBotContext userBotContext) {

        }

        @Override
        public void handleInput(UserBotContext userBotContext) {
            String text = userBotContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "Пробное занятие":
                    userBotState = TRIAL_LESSON;
                    break;
                case "Купить книгу":
//                    userBotState = AUTO_POSTING;
                    break;
                case "Сколько стоит обучение":
//                    userBotState = PRIVATE_MESSAGE;
                    break;
                case "Подробнее о курсах":
//                    userBotState = MANAGERS;
                    break;
                case "Расписание и время занятий":
//                    userBotState = BOT_REQUEST;
                    break;
                case "Информация по преподавателям":
//                    userBotState = BOT_REQUEST;
                    break;
                case "Как проходят занятия":
//                    userBotState = BOT_REQUEST;
                    break;
                case "Связаться с менеджером":
//                    userBotState = BOT_REQUEST;
                    break;
                default:
                    userBotState = MAIN_MENU;
                    break;
            }
        }

        @Override
        public UserBotState nextState() {
            return userBotState;
        }
    },

    TRIAL_LESSON(true) {
        @Override
        public void enter(UserBotContext userBotContext) {

        }
        @Override
        public void handleInput(UserBotContext userBotContext) {
        }

        @Override
        public UserBotState nextState() {
            return TRIAL_LESSON;
        }
    };

    private final Boolean isInputNeeded;

    UserBotState(Boolean isInputNeeded) {
        this.isInputNeeded = isInputNeeded;
    }

    public static UserBotState getInitialState() {
        return CONVERSATION_STARTED;
    }

    public Boolean getIsInputNeeded() {
        return isInputNeeded;
    }

    public void handleInput(UserBotContext userBotContext) {
    }

    public abstract void enter(UserBotContext userBotContext);

    public abstract UserBotState nextState();
}
