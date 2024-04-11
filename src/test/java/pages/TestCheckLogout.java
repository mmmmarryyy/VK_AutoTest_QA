package pages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckLogout extends BaseMainPageTest {
    private final static String loginButtonText = "Войти в Одноклассники";

    @DisplayName("Check can logout from main page")
    @Test
    @Tag("MainPageTest")
    public void testCheckLogout() {
        mainPage.checkPage();
        mainPage.checkUserDropdownButton();
        mainPage.userDropdownButtonClick();
        loginPage = mainPage.logout();
        loginPage.checkPage();
        loginPage.checkLoginButton();
        assertEquals(loginButtonText, loginPage.getLoginButtonText(), "Login button text didn't match!");
    }
}

