package by.testbot.bot.user;

import by.testbot.alphaCRM.models.Lesson;
import by.testbot.alphaCRM.payload.responses.LessonIndexResponse;
import by.testbot.alphaCRM.service.CrmService;
import by.testbot.models.Button;
import by.testbot.models.Keyboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserKeyboardSource {

    @Autowired
    private CrmService crmService;

    public Keyboard getDateSelectionButtons() {
        Keyboard keyboard = new Keyboard();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        List<Lesson> groupLessons = crmService.getGroupLessons();
        List<Button> buttons = new ArrayList<>();
        if (groupLessons != null) {
            for (Lesson lesson : groupLessons) {
                int number = crmService.getListParticipantGroup(lesson.getGroup_ids().get(0));
                if (number != -1 && number < 8) {
                    String[] strings1 = lesson.getTime_from().split(" ");
                    String[] strings2 = lesson.getTime_to().split(" ");
                    String buttonText = formatter.format(lesson.getDate()) + "\n" + strings1[1].substring(0, 5) + " - " + strings2[1].substring(0, 5);
                    Button selectionButton = new Button();
                    selectionButton.setText(buttonText);
                    selectionButton.setActionBody(buttonText);
                    selectionButton.setColumns(2);
                    selectionButton.setRows(1);
                    buttons.add(selectionButton);
                }
            }
        }
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public static Keyboard getUserMainMenuKeyboard() {
        Keyboard keyboard = new Keyboard();
        List<Button> buttons = new ArrayList<>();

        Button trailLesson = new Button();
        trailLesson.setText("Пробное занятие");
        trailLesson.setActionBody("Пробное занятие");
        trailLesson.setColumns(3);
        trailLesson.setRows(1);
        buttons.add(trailLesson);

        Button buyBook = new Button();
        buyBook.setText("Купить книгу");
        buyBook.setActionBody("Купить книгу");
        buyBook.setColumns(3);
        buyBook.setRows(1);
        buttons.add(buyBook);

        Button whatPriceStudying = new Button();
        whatPriceStudying.setText("Сколько стоит обучение");
        whatPriceStudying.setActionBody("Сколько стоит обучение");
        whatPriceStudying.setColumns(3);
        whatPriceStudying.setRows(1);
        buttons.add(whatPriceStudying);

        Button moreAboutCources = new Button();
        moreAboutCources.setText("Подробнее о курсах");
        moreAboutCources.setActionBody("Подробнее о курсах");
        moreAboutCources.setColumns(3);
        moreAboutCources.setRows(1);
        buttons.add(moreAboutCources);

        Button scheduleAndTimeLessons = new Button();
        scheduleAndTimeLessons.setText("Расписание и время занятий");
        scheduleAndTimeLessons.setActionBody("Расписание и время занятий");
        scheduleAndTimeLessons.setColumns(3);
        scheduleAndTimeLessons.setRows(1);
        buttons.add(scheduleAndTimeLessons);

        Button informationTeachers = new Button();
        informationTeachers.setText("Информация по преподавателям");
        informationTeachers.setActionBody("Информация по преподавателям");
        informationTeachers.setColumns(3);
        informationTeachers.setRows(1);
        buttons.add(informationTeachers);

        Button howManyClassesTakePlace = new Button();
        howManyClassesTakePlace.setText("Как проходят занятия");
        howManyClassesTakePlace.setActionBody("Как проходят занятия");
        howManyClassesTakePlace.setColumns(3);
        howManyClassesTakePlace.setRows(1);
        buttons.add(howManyClassesTakePlace);

        Button contactManager = new Button();
        contactManager.setText("Связаться с менеджером");
        contactManager.setActionBody("Связаться с менеджером");
        contactManager.setColumns(3);
        contactManager.setRows(1);
        buttons.add(contactManager);

        keyboard.setButtons(buttons);
        return keyboard;
    }

    public static Keyboard getTypeLessonMainMenuKeyboard() {
        Keyboard keyboard = new Keyboard();
        List<Button> buttons = new ArrayList<>();

        Button trailLesson = new Button();
        trailLesson.setText("Онлайн");
        trailLesson.setActionBody("online");
        trailLesson.setColumns(3);
        trailLesson.setRows(1);
        buttons.add(trailLesson);

        Button buyBook = new Button();
        buyBook.setText("Офлайн");
        buyBook.setActionBody("offline");
        buyBook.setColumns(3);
        buyBook.setRows(1);
        buttons.add(buyBook);

        keyboard.setButtons(buttons);
        return keyboard;
    }
}
