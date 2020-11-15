package by.testbot.utils;

import java.util.Arrays;
import java.util.List;

import by.testbot.models.enums.EventType;

public class Utils {
    public static List<EventType> getAllEventTypes() {
        return Arrays.asList(EventType.values());
    }
}
