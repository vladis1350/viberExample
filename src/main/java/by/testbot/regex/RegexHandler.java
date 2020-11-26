package by.testbot.regex;

public class RegexHandler {
    public static boolean checkUserAnswerOnDigit(String userAnswer) {
        return userAnswer.matches("[0-9]+");
    }
}
