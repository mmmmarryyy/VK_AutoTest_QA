package pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogin extends BaseTest {
    private LoginPage loginPage;
    private MainPage mainPage;

    private static final String errorMessage = "Неправильно указан логин и/или пароль";

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage();
    }

    @Test
    public void testCheckLogin() {
        loginPage.checkUsername();
        loginPage.setUsername(username);
        loginPage.checkPassword();
        loginPage.setPassword(password);
        loginPage.checkLoginButton();
        mainPage = loginPage.loginButtonClick();
        mainPage.checkPage();
        mainPage.checkUserDropdownButton();
        mainPage.userDropdownButtonClick();
        mainPage.getUsernameInUserDropdown().shouldBe(visible);
        assertEquals(username + ' ' + username, mainPage.getUsernameInUserDropdown().innerText());
    }

    @Test
    public void testCheckWrongUsernameLogin() {
        loginPage.checkUsername();
        loginPage.setUsername("1" + username);
        loginPage.checkPassword();
        loginPage.setPassword(password);
        loginPage.checkLoginButton();
        loginPage.loginButtonClick();
        loginPage.checkErrorMessage();
        assertEquals(errorMessage, loginPage.getErrorMessage().innerText());
    }
}