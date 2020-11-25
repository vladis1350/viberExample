package by.testbot.models.enums;

public enum  Roles {
    ADMIN("admin"),
    MANAGER("manager"),
    USER("user");

    private String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
