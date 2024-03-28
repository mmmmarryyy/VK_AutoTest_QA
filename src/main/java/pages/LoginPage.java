package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage implements BasePage {
    private static SelenideElement usernameField = $("#field_email");
    private static SelenideElement passwordField = $("#field_password");
    private static SelenideElement loginButton = $("input[type=submit]");
    private static SelenideElement errorMessage = $(".input-e.login_error");

    public void checkPage() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
    }

    public void setUsername(String username) {
        usernameField.setValue(username);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public MainPage loginButtonClick() {
        loginButton.click();
        return new MainPage();
    }

    public void checkErrorMessage()  {
        errorMessage.shouldBe(visible);
    }
}