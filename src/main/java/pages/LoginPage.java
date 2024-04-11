package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage implements BasePage {
    private static final SelenideElement usernameField = $x(".//*[@id='field_email']");
    private static final SelenideElement passwordField = $x(".//*[@id='field_password']");
    private static final SelenideElement loginButton = $x(".//input[@type='submit']");
    private static final SelenideElement errorMessage = $x(".//*[contains(@class,'login_error')]");

    public LoginPage() {
        checkPage();
    }

    public void checkPage() {
        checkUsername();
        checkPassword();
    }

    public void checkUsername() {
        usernameField.shouldBe(visible.because("username should be visible on login page"));
    }

    public void setUsername(String username) {
        usernameField.setValue(username);
    }

    public void checkPassword() {
        passwordField.shouldBe(visible.because("password should be visible on login page"));
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void checkLoginButton() {
        loginButton.shouldBe(visible.because("login button should be visible on login page"));
    }

    public MainPage loginButtonClick() {
        loginButton.click();
        return new MainPage();
    }

    public String getLoginButtonText() {
        return loginButton.val();
    }

    public void checkErrorMessage() {
        errorMessage.shouldBe(visible.because("we entered incorrect data"));
    }

    public String getErrorMessage() {
        return errorMessage.innerText();
    }
}