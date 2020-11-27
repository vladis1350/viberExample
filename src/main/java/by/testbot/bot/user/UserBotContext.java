package by.testbot.bot.user;

import by.testbot.payload.callbacks.*;
import by.testbot.services.MessageService;
import by.testbot.services.ViberService;
import by.testbot.services.user.UserKeyboardService;
import lombok.Getter;

@Getter
public class UserBotContext {
    private final ViberService viberService;
    private final MessageService messageService;
    private final UserKeyboardService userKeyboardService;
    private final ConversationStartedCallback conversationStartedCallback;
    private final DeliveredCallback deliveredCallback;
    private final FailedCallback failedCallback;
    private final MessageCallback messageCallback;
    private final SeenCallback seenCallback;
    private final SubscribedCallback subscribedCallback;
    private final UnsubscribedCallback unsubscribedCallback;
    private final WebhookCallback webhookCallback;

    private UserBotContext(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, ConversationStartedCallback conversationStartedCallback) {
        this.viberService = viberService;
        this.userKeyboardService = userKeyboardService;
        this.messageService = messageService;
        this.conversationStartedCallback = conversationStartedCallback;
        this.deliveredCallback = null;
        this.failedCallback = null;
        this.messageCallback = null;
        this.seenCallback = null;
        this.subscribedCallback = null;
        this.unsubscribedCallback = null;
        this.webhookCallback = null;
    }

    private UserBotContext(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, DeliveredCallback deliveredCallback) {
        this.viberService = viberService;
        this.userKeyboardService = userKeyboardService;
        this.messageService = messageService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = deliveredCallback;
        this.failedCallback = null;
        this.messageCallback = null;
        this.seenCallback = null;
        this.subscribedCallback = null;
        this.unsubscribedCallback = null;
        this.webhookCallback = null;
    }

    private UserBotContext(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, FailedCallback failedCallback) {
        this.viberService = viberService;
        this.userKeyboardService = userKeyboardService;
        this.messageService = messageService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = null;
        this.failedCallback = failedCallback;
        this.messageCallback = null;
        this.seenCallback = null;
        this.subscribedCallback = null;
        this.unsubscribedCallback = null;
        this.webhookCallback = null;
    }

    private UserBotContext(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, MessageCallback messageCallback) {
        this.viberService = viberService;
        this.userKeyboardService = userKeyboardService;
        this.messageService = messageService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = null;
        this.failedCallback = null;
        this.messageCallback = messageCallback;
        this.seenCallback = null;
        this.subscribedCallback = null;
        this.unsubscribedCallback = null;
        this.webhookCallback = null;
    }

    private UserBotContext(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, SeenCallback seenCallback) {
        this.viberService = viberService;
        this.userKeyboardService = userKeyboardService;
        this.messageService = messageService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = null;
        this.failedCallback = null;
        this.messageCallback = null;
        this.seenCallback = seenCallback;
        this.subscribedCallback = null;
        this.unsubscribedCallback = null;
        this.webhookCallback = null;
    }

    private UserBotContext(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, SubscribedCallback subscribedCallback) {
        this.viberService = viberService;
        this.userKeyboardService = userKeyboardService;
        this.messageService = messageService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = null;
        this.failedCallback = null;
        this.messageCallback = null;
        this.seenCallback = null;
        this.subscribedCallback = subscribedCallback;
        this.unsubscribedCallback = null;
        this.webhookCallback = null;
    }

    private UserBotContext(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, UnsubscribedCallback unsubscribedCallback) {
        this.viberService = viberService;
        this.userKeyboardService = userKeyboardService;
        this.messageService = messageService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = null;
        this.failedCallback = null;
        this.messageCallback = null;
        this.seenCallback = null;
        this.subscribedCallback = null;
        this.unsubscribedCallback = unsubscribedCallback;
        this.webhookCallback = null;
    }

    private UserBotContext(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, WebhookCallback webhookCallback) {
        this.viberService = viberService;
        this.userKeyboardService = userKeyboardService;
        this.messageService = messageService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = null;
        this.failedCallback = null;
        this.messageCallback = null;
        this.seenCallback = null;
        this.subscribedCallback = null;
        this.unsubscribedCallback = null;
        this.webhookCallback = webhookCallback;
    }

    public static UserBotContext of(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, ConversationStartedCallback conversationStartedCallback) {
        return new UserBotContext(viberService, userKeyboardService, messageService, conversationStartedCallback);
    }

    public static UserBotContext of(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, DeliveredCallback deliveredCallback) {
        return new UserBotContext(viberService, userKeyboardService, messageService, deliveredCallback);
    }

    public static UserBotContext of(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, FailedCallback failedCallback) {
        return new UserBotContext(viberService, userKeyboardService, messageService, failedCallback);
    }

    public static UserBotContext of(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, MessageCallback messageCallback) {
        return new UserBotContext(viberService, userKeyboardService, messageService, messageCallback);
    }

    public static UserBotContext of(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, SeenCallback seenCallback) {
        return new UserBotContext(viberService, userKeyboardService, messageService, seenCallback);
    }

    public static UserBotContext of(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, SubscribedCallback subscribedCallback) {
        return new UserBotContext(viberService, userKeyboardService, messageService, subscribedCallback);
    }

    public static UserBotContext of(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, UnsubscribedCallback unsubscribedCallback) {
        return new UserBotContext(viberService, userKeyboardService, messageService, unsubscribedCallback);
    }

    public static UserBotContext of(ViberService viberService, UserKeyboardService userKeyboardService, MessageService messageService, WebhookCallback webhookCallback) {
        return new UserBotContext(viberService, userKeyboardService, messageService, webhookCallback);
    }
}
