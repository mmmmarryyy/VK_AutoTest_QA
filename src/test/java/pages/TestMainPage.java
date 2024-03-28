package pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMainPage extends BaseTest {
    private LoginPage loginPage;
    private MainPage mainPage;

    private final String toolBarText = "Сервисы VK";

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
    public void testCheckToolBar() {
        mainPage.checkPage();
        mainPage.toolBarButtonClick();
        mainPage.checkTextVisibleOnPage(toolBarText);
    }
}
