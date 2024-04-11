package pages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckLoginPage extends BaseLoginPageTest {
    private MainPage mainPage;

    @DisplayName("Check can login with correct data")
    @Test
    @Tag("LoginPageTest")
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
        mainPage.checkUsernameInUserDropdown();
        assertEquals(username + ' ' + username, MainPage.getUsernameInUserDropdown(), "Usernames in user dropdown didn't match!");
    }
}