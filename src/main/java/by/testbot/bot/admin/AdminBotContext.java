package by.testbot.bot.admin;

import by.testbot.payload.callbacks.ConversationStartedCallback;
import by.testbot.payload.callbacks.DeliveredCallback;
import by.testbot.payload.callbacks.FailedCallback;
import by.testbot.payload.callbacks.MessageCallback;
import by.testbot.payload.callbacks.SeenCallback;
import by.testbot.payload.callbacks.SubscribedCallback;
import by.testbot.payload.callbacks.UnsubscribedCallback;
import by.testbot.payload.callbacks.WebhookCallback;
import by.testbot.services.*;
import by.testbot.services.admin.AdminKeyboardService;
import lombok.Getter;

@Getter
public class AdminBotContext {
    private final ViberService viberService;
    private final UserService userService;
    private final BotMessageService botMessageService;
    private final MessageService messageService;
    private final by.testbot.services.admin.AdminKeyboardService AdminKeyboardService;
    private final ConversationStartedCallback conversationStartedCallback;
    private final DeliveredCallback deliveredCallback;
    private final FailedCallback failedCallback;
    private final MessageCallback messageCallback;
    private final SeenCallback seenCallback;
    private final SubscribedCallback subscribedCallback;
    private final UnsubscribedCallback unsubscribedCallback;
    private final WebhookCallback webhookCallback;

    private AdminBotContext(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, ConversationStartedCallback conversationStartedCallback) {
        this.viberService = viberService;
        this.userService = userService;
        this.botMessageService = botMessageService;
        this.messageService = messageService;
        this.AdminKeyboardService = adminKeyboardService;
        this.conversationStartedCallback = conversationStartedCallback;
        this.deliveredCallback = null;
        this.failedCallback = null;
        this.messageCallback = null;
        this.seenCallback = null;
        this.subscribedCallback = null;
        this.unsubscribedCallback = null;
        this.webhookCallback = null;
    }

    private AdminBotContext(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, DeliveredCallback deliveredCallback) {
        this.viberService = viberService;
        this.userService = userService;
        this.botMessageService = botMessageService;
        this.messageService = messageService;
        this.AdminKeyboardService = adminKeyboardService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = deliveredCallback;
        this.failedCallback = null;
        this.messageCallback = null;
        this.seenCallback = null;
        this.subscribedCallback = null;
        this.unsubscribedCallback = null;
        this.webhookCallback = null;
    }

    private AdminBotContext(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, FailedCallback failedCallback) {
        this.viberService = viberService;
        this.userService = userService;
        this.botMessageService = botMessageService;
        this.messageService = messageService;
        this.AdminKeyboardService = adminKeyboardService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = null;
        this.failedCallback = failedCallback;
        this.messageCallback = null;
        this.seenCallback = null;
        this.subscribedCallback = null;
        this.unsubscribedCallback = null;
        this.webhookCallback = null;
    }

    private AdminBotContext(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, MessageCallback messageCallback) {
        this.viberService = viberService;
        this.userService = userService;
        this.botMessageService = botMessageService;
        this.messageService = messageService;
        this.AdminKeyboardService = adminKeyboardService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = null;
        this.failedCallback = null;
        this.messageCallback = messageCallback;
        this.seenCallback = null;
        this.subscribedCallback = null;
        this.unsubscribedCallback = null;
        this.webhookCallback = null;
    }

    private AdminBotContext(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, SeenCallback seenCallback) {
        this.viberService = viberService;
        this.userService = userService;
        this.botMessageService = botMessageService;
        this.messageService = messageService;
        this.AdminKeyboardService = adminKeyboardService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = null;
        this.failedCallback = null;
        this.messageCallback = null;
        this.seenCallback = seenCallback;
        this.subscribedCallback = null;
        this.unsubscribedCallback = null;
        this.webhookCallback = null;
    }

    private AdminBotContext(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, SubscribedCallback subscribedCallback) {
        this.viberService = viberService;
        this.userService = userService;
        this.botMessageService = botMessageService;
        this.messageService = messageService;
        this.AdminKeyboardService = adminKeyboardService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = null;
        this.failedCallback = null;
        this.messageCallback = null;
        this.seenCallback = null;
        this.subscribedCallback = subscribedCallback;
        this.unsubscribedCallback = null;
        this.webhookCallback = null;
    }

    private AdminBotContext(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, UnsubscribedCallback unsubscribedCallback) {
        this.viberService = viberService;
        this.userService = userService;
        this.botMessageService = botMessageService;
        this.messageService = messageService;
        this.AdminKeyboardService = adminKeyboardService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = null;
        this.failedCallback = null;
        this.messageCallback = null;
        this.seenCallback = null;
        this.subscribedCallback = null;
        this.unsubscribedCallback = unsubscribedCallback;
        this.webhookCallback = null;
    }

    private AdminBotContext(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, WebhookCallback webhookCallback) {
        this.viberService = viberService;
        this.userService = userService;
        this.botMessageService = botMessageService;
        this.messageService = messageService;
        this.AdminKeyboardService = adminKeyboardService;
        this.conversationStartedCallback = null;
        this.deliveredCallback = null;
        this.failedCallback = null;
        this.messageCallback = null;
        this.seenCallback = null;
        this.subscribedCallback = null;
        this.unsubscribedCallback = null;
        this.webhookCallback = webhookCallback;
    }

    public static AdminBotContext of(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, ConversationStartedCallback conversationStartedCallback) {
        return new AdminBotContext(viberService, userService, botMessageService, messageService, adminKeyboardService, conversationStartedCallback);
    }

    public static AdminBotContext of(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, DeliveredCallback deliveredCallback) {
        return new AdminBotContext(viberService, userService, botMessageService, messageService, adminKeyboardService, deliveredCallback);
    }

    public static AdminBotContext of(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, FailedCallback failedCallback) {
        return new AdminBotContext(viberService, userService, botMessageService, messageService, adminKeyboardService, failedCallback);
    }

    public static AdminBotContext of(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, MessageCallback messageCallback) {
        return new AdminBotContext(viberService, userService, botMessageService, messageService, adminKeyboardService, messageCallback);
    }

    public static AdminBotContext of(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, SeenCallback seenCallback) {
        return new AdminBotContext(viberService, userService, botMessageService, messageService, adminKeyboardService, seenCallback);
    }

    public static AdminBotContext of(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, SubscribedCallback subscribedCallback) {
        return new AdminBotContext(viberService, userService, botMessageService, messageService, adminKeyboardService, subscribedCallback);
    }

    public static AdminBotContext of(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, UnsubscribedCallback unsubscribedCallback) {
        return new AdminBotContext(viberService, userService, botMessageService, messageService, adminKeyboardService, unsubscribedCallback);
    }

    public static AdminBotContext of(ViberService viberService, UserService userService, BotMessageService botMessageService, MessageService messageService, AdminKeyboardService adminKeyboardService, WebhookCallback webhookCallback) {
        return new AdminBotContext(viberService, userService, botMessageService, messageService, adminKeyboardService, webhookCallback);
    }
}
