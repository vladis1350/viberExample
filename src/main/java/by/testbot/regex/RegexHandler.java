package by.testbot.regex;

public class RegexHandler {
    public static boolean checkUserAnswerOnDigit(String userAnswer) {
        return userAnswer.matches("[0-9]+");
    }

    public static boolean checkPhoneNumber(String number){
        return number.matches("^(\\+375)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$") ||
                number.matches("^(\\+375)(29|25|44|33)-(\\d{3})-(\\d{2})-(\\d{2})$");
    }
}
