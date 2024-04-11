package pages;

import org.junit.jupiter.api.BeforeEach;

public class BaseMainPageTest extends BaseTest {
    protected LoginPage loginPage;
    protected MainPage mainPage;

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
}