package by.testbot.bot.user;

import by.testbot.models.TrialLesson;
import by.testbot.regex.RegexHandler;
import lombok.SneakyThrows;

public enum UserBotState {

    CONVERSATION_STARTED(true) {
        @SneakyThrows
        @Override
        public void enter(UserBotContext userBotContext) {
            String viberId = userBotContext
                    .getConversationStartedCallback()
                    .getUser()
                    .getViberId();
            userBotContext.getUserKeyboardService()
                    .sendStartUserMessage(viberId);
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {

        }

        @Override
        public UserBotState nextState() {
            return START_MENU;
        }
    },

    SUBSCRIBED(true) {
        @SneakyThrows
        @Override
        public void enter(UserBotContext userBotContext) {
            String viberId = userBotContext
                    .getSubscribedCallback()
                    .getUser()
                    .getViberId();
            userBotContext.getUserKeyboardService()
                    .sendStartUserMessage(viberId);
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {

        }

        @Override
        public UserBotState nextState() {
            return START_MENU;
        }
    },

    START_MENU(true) {
        UserBotState userBotState;

        @Override
        public void enter(UserBotContext userBotContext) {
            String userAnswer = userBotContext.getMessageCallback().getMessage().getText();
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            userBotContext.getUserKeyboardService()
                    .sendUserMainMenuKeyboard(viberId, userAnswer);
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {
            String text = userBotContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "Пробное занятие":
                    userBotState = TRIAL_LESSON;
                    break;
                case "Купить книгу":
                    userBotState = BUY_BOOK;
                    break;
                case "Сколько стоит обучение":
                    userBotState = PRICE_STUDYING;
                    break;
                case "Подробнее о курсах":
                    userBotState = MORE_ABOUT_COURSES;
                    break;
                case "Расписание и время занятий":
                    userBotState = TIME_CLASSES;
                    break;
                case "Информация по преподавателям":
                    userBotState = INFORMATION_TEACHER;
                    break;
                case "Как проходят занятия":
                    userBotState = HOW_ARE_CLASSES;
                    break;
                case "Связаться с менеджером":
                    userBotState = CONTACT_MANAGER;
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

    MAIN_MENU(true) {
        UserBotState userBotState;

        @Override
        public void enter(UserBotContext userBotContext) {
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            userBotContext.getUserKeyboardService()
                    .sendMainMenuKeyboard(viberId);
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {
            String text = userBotContext.getMessageCallback().getMessage().getText();

            switch (text) {
                case "Пробное занятие":
                    userBotState = TRIAL_LESSON;
                    break;
                case "Купить книгу":
                    userBotState = BUY_BOOK;
                    break;
                case "Сколько стоит обучение":
                    userBotState = PRICE_STUDYING;
                    break;
                case "Подробнее о курсах":
                    userBotState = MORE_ABOUT_COURSES;
                    break;
                case "Расписание и время занятий":
                    userBotState = TIME_CLASSES;
                    break;
                case "Информация по преподавателям":
                    userBotState = INFORMATION_TEACHER;
                    break;
                case "Как проходят занятия":
                    userBotState = HOW_ARE_CLASSES;
                    break;
                case "Связаться с менеджером":
                    userBotState = CONTACT_MANAGER;
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

    CONTACT_MANAGER(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            userBotContext.getUserKeyboardService()
                    .sendContactManagerMessage(userBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {

        }

        @Override
        public UserBotState nextState() {
            return MAIN_MENU;
        }
    },

    INFORMATION_TEACHER(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            userBotContext.getUserKeyboardService()
                    .sendInformationTeachersMessage(userBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {

        }

        @Override
        public UserBotState nextState() {
            return MAIN_MENU;
        }
    },

    HOW_ARE_CLASSES(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            userBotContext.getUserKeyboardService()
                    .sendHowAreClassesMessage(userBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {

        }

        @Override
        public UserBotState nextState() {
            return MAIN_MENU;
        }
    },

    TIME_CLASSES(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            userBotContext.getUserKeyboardService()
                    .sendScheduleAndTimeOfClassesMessage(userBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {

        }

        @Override
        public UserBotState nextState() {
            return MAIN_MENU;
        }
    },

    MORE_ABOUT_COURSES(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            userBotContext.getUserKeyboardService()
                    .sendMoreAboutCoursesMessage(userBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {

        }

        @Override
        public UserBotState nextState() {
            return MAIN_MENU;
        }
    },

    PRICE_STUDYING(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            userBotContext.getUserKeyboardService()
                    .sendWhatTheCostOfStudyingMessage(userBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {

        }

        @Override
        public UserBotState nextState() {
            return MAIN_MENU;
        }
    },

    BUY_BOOK(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            userBotContext.getUserKeyboardService()
                    .sendLinkOnBuyBookMessage(userBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {

        }

        @Override
        public UserBotState nextState() {
            return MAIN_MENU;
        }
    },

    TRIAL_LESSON(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            userBotContext.getUserKeyboardService()
                    .sendSingUpForATrialLesson(userBotContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {
            String userAnswer = userBotContext.getMessageCallback().getMessage().getText();
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            TrialLesson trialLesson = TrialLesson.builder()
                    .childName(userAnswer)
                    .viberId(viberId)
                    .build();
            userBotContext.getTrialLessonService().save(trialLesson);
        }

        @Override
        public UserBotState nextState() {
            return ASK_CHILD_AGE;
        }
    },

    ASK_CHILD_AGE(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            userBotContext.getUserKeyboardService().sendAskChildAgeMessage(viberId);

        }

        @Override
        public void handleInput(UserBotContext userBotContext) {
            String userAnswer = userBotContext.getMessageCallback().getMessage().getText();
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            TrialLesson trialLesson = userBotContext.getTrialLessonService().findTrialLessonById(viberId);
            if (trialLesson != null) {
                trialLesson.setChildAge(userAnswer);
                userBotContext.getTrialLessonService().save(trialLesson);
            }
        }

        @Override
        public UserBotState nextState() {
            return ASK_PHONE_NUMBER;
        }
    },

    ASK_PHONE_NUMBER(true) {
        boolean numberSuccess = false;
        @Override
        public void enter(UserBotContext userBotContext) {
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            userBotContext.getUserKeyboardService().sendAskPhoneNumberMessage(viberId);
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            String userAnswer = userBotContext.getMessageCallback().getMessage().getText();
            if (RegexHandler.checkPhoneNumber(userAnswer)) {
                TrialLesson trialLesson = userBotContext.getTrialLessonService().findTrialLessonById(viberId);
                if (trialLesson != null) {
                    trialLesson.setPhoneNumber(userAnswer);
                    userBotContext.getTrialLessonService().save(trialLesson);
                }
                numberSuccess = true;
            }
        }

        @Override
        public UserBotState nextState() {
            if (numberSuccess) {
                return ASK_LESSON_TYPE;
            }
            return INVALID_PHONE_NUMBER;
        }
    },

    INVALID_PHONE_NUMBER(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            userBotContext.getUserKeyboardService().sendInvalidInputPhoneNumber(viberId);
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {

        }

        @Override
        public UserBotState nextState() {
            return ASK_PHONE_NUMBER;
        }
    },

    ASK_LESSON_TYPE(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            userBotContext.getUserKeyboardService().sendAskTypeLessonMessage(viberId);
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            String userAnswer = userBotContext.getMessageCallback().getMessage().getText();
            TrialLesson trialLesson = userBotContext.getTrialLessonService().findTrialLessonById(viberId);
            if (trialLesson != null) {
                trialLesson.setTypeLesson(userAnswer);
                userBotContext.getTrialLessonService().save(trialLesson);
            }
        }

        @Override
        public UserBotState nextState() {
            return SELECT_DATE;
        }
    },

    SELECT_DATE(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            userBotContext.getUserKeyboardService().sendSelectDateMessage(viberId);
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {
            String userAnswer = userBotContext.getMessageCallback().getMessage().getText();
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            TrialLesson trialLesson = userBotContext.getTrialLessonService().findTrialLessonById(viberId);
            if (trialLesson != null) {
                trialLesson.setDateTime(userAnswer);
                userBotContext.getTrialLessonService().save(trialLesson);
            }
        }

        @Override
        public UserBotState nextState() {
            return LINK_TO_PAY_LESSON;
        }
    },

    EMPTY(true) {
        @Override
        public void enter(UserBotContext userBotContext) {

        }

        @Override
        public void handleInput(UserBotContext userBotContext) {

        }

        @Override
        public UserBotState nextState() {
            return EMPTY;
        }
    },

    LINK_TO_PAY_LESSON(true) {
        @Override
        public void enter(UserBotContext userBotContext) {
            String viberId = userBotContext.getMessageCallback().getSender().getId();
            userBotContext.getUserKeyboardService().sendLinkToPayLessonMessage(viberId);
        }

        @Override
        public void handleInput(UserBotContext userBotContext) {

        }

        @Override
        public UserBotState nextState() {
            return MAIN_MENU;
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
