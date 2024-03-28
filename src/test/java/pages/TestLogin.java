package pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLogin extends BaseTest {
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage();
    }

    @Test
    public void testCheckLogin() {
        loginPage.checkPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        mainPage = loginPage.loginButtonClick();
        mainPage.checkPage();
    }

    @Test
    public void testCheckWrongUsernameLogin() {
        loginPage.checkPage();
        loginPage.setUsername("1" + username);
        loginPage.setPassword(password);
        loginPage.loginButtonClick();
        loginPage.checkErrorMessage();
    }
}