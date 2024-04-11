package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Browsers;

import static com.codeborne.selenide.Selenide.closeWebDriver;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    private final static String baseUrl = "https://ok.ru/";
    protected final static String username = "technopol36";
    protected final static String password = "technopolisPassword";

    @BeforeEach
    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.baseUrl = baseUrl;
        Selenide.open("/");
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}