import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LoginInvalidDataTest {
    private UserClient userClient;

    @Before
    @Step("Prepare data to login valid user")
    public void setUp() {
        userClient = new UserClient();
    }

    @Test
    @DisplayName("Login invalid email user")
    public void userCanNotLoginWithNotValidEmail() {
        User user = UserGenerator.getChangedEmailUser();
        ValidatableResponse responseLogin = userClient.login(UserAccountData.from(user));
        int actualStatusCodeCreate = responseLogin.extract().statusCode();
        boolean isSuccessInMessageFalse = responseLogin.extract().path("success");
        String message = responseLogin.extract().path("message");
        assertEquals(401, actualStatusCodeCreate);
        assertFalse(isSuccessInMessageFalse);
        assertEquals("email or password are incorrect", message);
    }

    @Test
    @DisplayName("Login invalid password user")
    public void userCanNotLoginWithNotValidPassword() {
        User user = UserGenerator.getChangedPasswordUser();
        ValidatableResponse responseLogin = userClient.login(UserAccountData.from(user));
        int actualStatusCodeCreate = responseLogin.extract().statusCode();
        boolean isSuccessInMessageFalse = responseLogin.extract().path("success");
        String message = responseLogin.extract().path("message");
        assertEquals(401, actualStatusCodeCreate);
        assertFalse(isSuccessInMessageFalse);
        assertEquals("email or password are incorrect", message);
    }
}
