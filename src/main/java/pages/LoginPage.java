package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage implements BasePage {
    private static final SelenideElement usernameField = $("#field_email");
    private static final SelenideElement passwordField = $("#field_password");
    private static final SelenideElement loginButton = $("input[type=submit]");
    private static final SelenideElement errorMessage = $(".input-e.login_error");

    public LoginPage() {
        checkPage();
    }

    public void checkPage() {
        checkUsername();
        checkPassword();
    }

    public void checkUsername() {
        usernameField.shouldBe(visible);
    }

    public void setUsername(String username) {
        usernameField.setValue(username);
    }

    public void checkPassword() {
        usernameField.shouldBe(visible);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void checkLoginButton() {
        loginButton.shouldBe(visible);
    }

    public MainPage loginButtonClick() {
        loginButton.click();
        return new MainPage();
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }

    public void checkErrorMessage()  {
        errorMessage.shouldBe(visible);
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }
}