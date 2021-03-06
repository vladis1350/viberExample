package by.testbot.bot.user;

import by.testbot.alphaCRM.service.CrmService;
import by.testbot.payload.callbacks.*;
import by.testbot.services.MessageService;
import by.testbot.services.TrialLessonService;
import by.testbot.services.ViberService;
import by.testbot.services.user.UserKeyboardService;
import lombok.Getter;

@Getter
public class UserBotContext {
    private final ViberService viberService;
    private final CrmService crmService;
    private final MessageService messageService;
    private final TrialLessonService trialLessonService;
    private final UserKeyboardService userKeyboardService;
    private final ConversationStartedCallback conversationStartedCallback;
    private final DeliveredCallback deliveredCallback;
    private final FailedCallback failedCallback;
    private final MessageCallback messageCallback;
    private final SeenCallback seenCallback;
    private final SubscribedCallback subscribedCallback;
    private final UnsubscribedCallback unsubscribedCallback;
    private final WebhookCallback webhookCallback;

    private UserBotContext(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, ConversationStartedCallback conversationStartedCallback) {
        this.viberService = viberService;
        this.crmService = crmService;
        this.userKeyboardService = userKeyboardService;
        this.trialLessonService = trialLessonService;
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

    private UserBotContext(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, DeliveredCallback deliveredCallback) {
        this.viberService = viberService;
        this.crmService = crmService;
        this.userKeyboardService = userKeyboardService;
        this.trialLessonService = trialLessonService;
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

    private UserBotContext(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, FailedCallback failedCallback) {
        this.viberService = viberService;
        this.crmService = crmService;
        this.userKeyboardService = userKeyboardService;
        this.trialLessonService = trialLessonService;
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

    private UserBotContext(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, MessageCallback messageCallback) {
        this.viberService = viberService;
        this.crmService = crmService;
        this.userKeyboardService = userKeyboardService;
        this.trialLessonService = trialLessonService;
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

    private UserBotContext(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, SeenCallback seenCallback) {
        this.viberService = viberService;
        this.crmService = crmService;
        this.userKeyboardService = userKeyboardService;
        this.trialLessonService = trialLessonService;
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

    private UserBotContext(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, SubscribedCallback subscribedCallback) {
        this.viberService = viberService;
        this.crmService = crmService;
        this.userKeyboardService = userKeyboardService;
        this.trialLessonService = trialLessonService;
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

    private UserBotContext(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, UnsubscribedCallback unsubscribedCallback) {
        this.viberService = viberService;
        this.crmService = crmService;
        this.userKeyboardService = userKeyboardService;
        this.trialLessonService = trialLessonService;
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

    private UserBotContext(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, WebhookCallback webhookCallback) {
        this.viberService = viberService;
        this.crmService = crmService;
        this.userKeyboardService = userKeyboardService;
        this.trialLessonService = trialLessonService;
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

    public static UserBotContext of(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, ConversationStartedCallback conversationStartedCallback) {
        return new UserBotContext(viberService, crmService, userKeyboardService, trialLessonService, messageService, conversationStartedCallback);
    }

    public static UserBotContext of(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, DeliveredCallback deliveredCallback) {
        return new UserBotContext(viberService, crmService, userKeyboardService, trialLessonService, messageService, deliveredCallback);
    }

    public static UserBotContext of(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, FailedCallback failedCallback) {
        return new UserBotContext(viberService, crmService, userKeyboardService, trialLessonService, messageService, failedCallback);
    }

    public static UserBotContext of(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, MessageCallback messageCallback) {
        return new UserBotContext(viberService, crmService, userKeyboardService, trialLessonService, messageService, messageCallback);
    }

    public static UserBotContext of(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, SeenCallback seenCallback) {
        return new UserBotContext(viberService, crmService, userKeyboardService, trialLessonService, messageService, seenCallback);
    }

    public static UserBotContext of(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, SubscribedCallback subscribedCallback) {
        return new UserBotContext(viberService, crmService, userKeyboardService, trialLessonService, messageService, subscribedCallback);
    }

    public static UserBotContext of(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, UnsubscribedCallback unsubscribedCallback) {
        return new UserBotContext(viberService, crmService, userKeyboardService, trialLessonService, messageService, unsubscribedCallback);
    }

    public static UserBotContext of(ViberService viberService, CrmService crmService, UserKeyboardService userKeyboardService, TrialLessonService trialLessonService, MessageService messageService, WebhookCallback webhookCallback) {
        return new UserBotContext(viberService, crmService, userKeyboardService, trialLessonService, messageService, webhookCallback);
    }
}
