package pages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckWrongParamsLoginPage extends BaseLoginPageTest {
    private static final String errorMessage = "Неправильно указан логин и/или пароль";
    private static final String usernameErrorMessage = "Введите логин";
    private static final String passwordErrorMessage = "Введите пароль";

    private enum LoginWrongParams {
        WRONG_USERNAME_CORRECT_PASSWORD("1" + username, password, errorMessage),
        CORRECT_USERNAME_WRONG_PASSWORD(username, "1" + password, errorMessage),
        WRONG_USERNAME_WRONG_PASSWORD("1" + username, "1" + password, errorMessage),
        NULL_USERNAME_CORRECT_PASSWORD(null, password, usernameErrorMessage),
        EMPTY_USERNAME_CORRECT_PASSWORD("", password, usernameErrorMessage),
        NULL_PASSWORD_CORRECT_PASSWORD(username, null, passwordErrorMessage),
        EMPTY_PASSWORD_CORRECT_PASSWORD(username, "", passwordErrorMessage);

        private final String usernameInput;
        private final String passwordInput;
        private final String expectedErrorMessage;

        LoginWrongParams(String usernameInput, String passwordInput, String expectedErrorMessage) {
            this.usernameInput = usernameInput;
            this.passwordInput = passwordInput;
            this.expectedErrorMessage = expectedErrorMessage;
        }

        public String getUsernameInput() {
            return usernameInput;
        }

        public String getPasswordInput() {
            return passwordInput;
        }

        public String getExpectedErrorMessage() {
            return expectedErrorMessage;
        }
    }

    @ParameterizedTest(name = "{index} - test case: {0}")
    @EnumSource(LoginWrongParams.class)
    @Tag("LoginPageTest")
    @DisplayName("Check can't login with incorrect data")
    public void testCheckWrongLogin(LoginWrongParams params) {
        loginPage.checkUsername();
        loginPage.setUsername(params.getUsernameInput());
        loginPage.checkPassword();
        loginPage.setPassword(params.getPasswordInput());
        loginPage.checkLoginButton();
        loginPage.loginButtonClick();
        loginPage.checkErrorMessage();
        assertEquals(params.getExpectedErrorMessage(), loginPage.getErrorMessage(), "Error messages didn't match!");
    }
}
