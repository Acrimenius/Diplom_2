import io.qameta.allure.Step;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserGenerator {
    @Step("New valid user data")
    public static User getNewValidUser() {
        return new User("daivz88@gmail.com", "samurai4321", "samurai");
    }

    @Step("New user without email")
    public static User getUserWithoutEmail() {
        return new User(null, "samurai4321", "samurai");
    }

    @Step("New user without password")
    public static User getUserWithoutPassword() {
        return new User("daivz88@gmail.com", null, "samurai");
    }

    @Step("New user without name")
    public static User getUserWithoutName() {
        return new User("daivz88@gmail.com", "samurai4321", null);
    }

    @Step("User with changed email")
    public static User getChangedEmailUser() {
        return new User(DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss").format(LocalDateTime.now()) + "daivz88@gmail.com", "samurai4321", "samurai");
    }

    @Step("User with changed password")
    public static User getChangedPasswordUser() {
        return new User("daivz88@gmail.com", "samurai4321" + DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss").format(LocalDateTime.now()), "samurai");
    }

    @Step("User with changed name")
    public static User getChangedNameUser() {
        return new User("daivz88@gmail.com", "samurai4321", "samurai" + DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss").format(LocalDateTime.now()));
    }
}
