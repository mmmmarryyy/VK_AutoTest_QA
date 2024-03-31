package pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogout extends BaseTest {
    private LoginPage loginPage;
    private MainPage mainPage;

    private final static String loginButtonText = "Войти в Одноклассники";

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage();
        loginPage.checkUsername();
        loginPage.setUsername(username);
        loginPage.checkPassword();
        loginPage.setPassword(password);
        loginPage.checkLoginButton();
        mainPage = loginPage.loginButtonClick();
    }

    @Test
    public void testCheckLogout() {
        mainPage.checkPage();
        mainPage.checkUserDropdownButton();
        mainPage.userDropdownButtonClick();
        loginPage = mainPage.logout();
        loginPage.checkPage();
        loginPage.checkLoginButton();
        assertEquals(loginButtonText, loginPage.getLoginButton().val());
    }
}

