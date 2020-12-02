package by.testbot.services.user;

import by.testbot.alphaCRM.models.Lesson;
import by.testbot.alphaCRM.models.Teacher;
import by.testbot.alphaCRM.service.CrmService;
import by.testbot.bot.user.UserKeyboardSource;
import by.testbot.models.Sender;
import by.testbot.models.TrialLesson;
import by.testbot.payload.requests.message.SendTextMessageRequest;
import by.testbot.services.TrialLessonService;
import by.testbot.services.ViberService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserKeyboardService {

    @Autowired
    private ViberService viberService;

    @Autowired
    private CrmService crmService;

    @Autowired
    private UserKeyboardSource userKeyboardSource;

    @Autowired
    private TrialLessonService trialLessonService;

    @SneakyThrows
    public void sendStartUserMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Здравствуте, меня зовут Ульяна. Я виртуальный помощник.\nДобро пожаловать в " +
                "MEGALIFE.BY\n\nДавайте знакомиться, как вас зовут? ");
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    @SneakyThrows
    public void sendSingUpForATrialLesson(String viberId) {
        TrialLesson trialLesson = trialLessonService.findTrialLessonById(viberId);
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);


        if (trialLesson != null) {
            sendTextMessageRequest.setText("Вы уже записались: \n\n" +
                    "Имя ребенка: " + trialLesson.getChildName() + "\n" +
                    "Возраст ребенка: " + trialLesson.getChildAge() + "\n" +
                    "Номер телефона: " + trialLesson.getPhoneNumber() + "\n" +
                    "Вариант занятий: " + trialLesson.getTypeLesson() + "\n" +
                    "Дата: " + trialLesson.getDateTime());
            viberService.sendTextMessage(sendTextMessageRequest);
        } else {
            sendTextMessageRequest.setText("Чтобы записать на пробное занятие, укажите пожалуйста Ваши контактные данные.");
            viberService.sendTextMessage(sendTextMessageRequest);
            Thread.sleep(1000);
            sendTextMessageRequest.setText("Укажите пожалуйста имя ребенка: ");
            viberService.sendTextMessage(sendTextMessageRequest);
        }
    }

    public void sendMainMenuKeyboard(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Главное меню");
        sendTextMessageRequest.setKeyboard(UserKeyboardSource.getUserMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendUserMainMenuKeyboard(String viberId, String userAnswer) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();

        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText(userAnswer + ", я могу помощь со следующими вопросами");
        sendTextMessageRequest.setKeyboard(UserKeyboardSource.getUserMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendAskChildAgeMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Укажите пожалуйста возраст ребенка: ");
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendAskPhoneNumberMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Укажите пожалуйста Номер телефона в формате (+375(29,25,44,33)1112233 или +375(29,25,44,33)-111-22-33): ");
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendInvalidInputPhoneNumber(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Неверный формат ввода!");
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);

    }

    public void sendAskTypeLessonMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Выберите вариант занятий");
        sendTextMessageRequest.setKeyboard(UserKeyboardSource.getTypeLessonMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendSelectDateMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");
        sendTextMessageRequest.setText("Выберите удобную вам дату и время");

        sendTextMessageRequest.setKeyboard(userKeyboardSource.getDateSelectionButtons());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendLinkToPayLessonMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");
        sendTextMessageRequest.setText("Ссылка на оплату пробного занятия: https://platy-bablo.by");
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendLinkOnBuyBookMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Здесь будет ссылка на оплату книги");
        sendTextMessageRequest.setKeyboard(UserKeyboardSource.getUserMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendWhatTheCostOfStudyingMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Тут будет стоимость обучения");
        sendTextMessageRequest.setKeyboard(UserKeyboardSource.getUserMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendMoreAboutCoursesMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("12 презентаций по каждому курсу");
        sendTextMessageRequest.setKeyboard(UserKeyboardSource.getUserMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendScheduleAndTimeOfClassesMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Расписание и время занятий");
        sendTextMessageRequest.setKeyboard(UserKeyboardSource.getUserMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendInformationTeachersMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        List<Teacher> teacherList = crmService.getListTeacher();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Информация по проподавателям");
        String teachersString = "";
        if (teacherList != null) {
            for (int i = 0; i < teacherList.size(); i++) {
                teachersString = teachersString.concat((i + 1) + ". " + teacherList.get(i).getName() + "\n");
                teachersString = teachersString.concat("Деятельность: " + teacherList.get(i).getNote() + "\n");
            }
        } else {
            teachersString = "Список пуст";
        }
        sendTextMessageRequest.setText(teachersString);
        sendTextMessageRequest.setKeyboard(UserKeyboardSource.getUserMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendHowAreClassesMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Как проходят занятия");
        sendTextMessageRequest.setKeyboard(UserKeyboardSource.getUserMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }

    public void sendContactManagerMessage(String viberId) {
        SendTextMessageRequest sendTextMessageRequest = new SendTextMessageRequest();
        Sender sender = new Sender();
        sender.setName("AutoCapitalBot");

        sendTextMessageRequest.setText("Связаться с менеджером");
        sendTextMessageRequest.setKeyboard(UserKeyboardSource.getUserMainMenuKeyboard());
        sendTextMessageRequest.setUserId(viberId);
        sendTextMessageRequest.setSender(sender);

        viberService.sendTextMessage(sendTextMessageRequest);
    }
}
