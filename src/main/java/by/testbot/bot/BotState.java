package by.testbot.bot;

import java.util.Arrays;

public enum BotState {
    CONVERSATION_STARTED(0, true) {
        @Override
        public void enter(BotContext botContext) {
            botContext.getKeyboardService().sendAdminMainMenuKeyboard(botContext.getConversationStartedCallback().getUser());
        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return CONVERSATION_STARTED;
        }
    },

    ADDING_MANAGER(0, true) {
        @Override
        public void enter(BotContext botContext) {
//            botContext.getKeyboardService().sendAdminMainMenuKeyboard(botContext.getMessageCallback().getSender());
            botContext.getMessageService().askUserNumberForPrivilegeManager(botContext.getMessageCallback().getSender().getId());
        }

        @Override
        public void handleInput(BotContext botContext) {

        }

        @Override
        public BotState nextState() {
            return ADDING_MANAGER;
        }
    };

    private final Boolean isInputNeeded;
    private final Integer id;

    BotState(Integer id, Boolean isInputNeeded) {
        this.id = id;
        this.isInputNeeded = isInputNeeded;
    } 

    public static BotState getInitialState() {
        return byId(0);
    }

    public Integer getId() {
        return id;
    }

    public static BotState byId(Integer id) {
        return Arrays.asList(BotState.values()).stream().filter(b -> b.getId().equals(id)).findFirst().orElse(CONVERSATION_STARTED);
    }

    public Boolean getIsInputNeeded() { return isInputNeeded; }

    public void handleInput(BotContext botContext) {}

    public abstract void enter(BotContext botContext);
    public abstract BotState nextState();
}
