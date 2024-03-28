package pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLogout extends BaseTest {
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        mainPage = loginPage.loginButtonClick();
    }

    @Test
    public void testCheckLogout() {
        mainPage.checkPage();
        mainPage.userDropdownButtonClick();
        loginPage = mainPage.logout();
        loginPage.checkPage();
    }
}

