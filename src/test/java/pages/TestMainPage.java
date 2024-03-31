package pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMainPage extends BaseTest {
    private LoginPage loginPage;
    private MainPage mainPage;

    private final String toolBarText = "Сервисы VK";

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
    public void testCheckToolBar() {
        mainPage.checkPage();
        mainPage.checkToolBarButton();
        mainPage.toolBarButtonClick();
        assertTrue(mainPage.getToolBar().getText().contains(toolBarText));
    }
}
