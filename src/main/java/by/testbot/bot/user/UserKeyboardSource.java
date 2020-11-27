package by.testbot.bot.user;

import by.testbot.models.Button;
import by.testbot.models.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class UserKeyboardSource {

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
}
