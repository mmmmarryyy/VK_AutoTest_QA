package pages;

import org.junit.jupiter.api.BeforeEach;

public class BaseLoginPageTest extends BaseTest {
    protected LoginPage loginPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage();
    }
}