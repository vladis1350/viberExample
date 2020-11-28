package by.testbot.models.enums;

public enum LessonType {
    ONLINE("online"),
    OFFLINE("offline");


    private String type;

    public String getType(){
        return type;
    }

    LessonType(String type) {
        this.type = type;
    }
}
