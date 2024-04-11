package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage implements BasePage {
    private static final SelenideElement toolBarButton = $x(".//*[contains(@class, 'toolbar_nav_a__vk_ecosystem')]");
    private static final SelenideElement toolBar = $x(".//*[contains(@class, 'vk_ecosystem_toolbar')]");

    private static final SelenideElement userDropdownButton = $x(".//*[contains(@class, 'toolbar_ucard')]");
    private static final SelenideElement usernameInUserDropdown = $x(".//*[contains(@class, 'toolbar_accounts-user_name')]");
    private static final SelenideElement userLogout = $x(".//*[contains(@class, 'toolbar_accounts-user-delete-button')]");
    private static final SelenideElement confirmLogoutButton = $x(".//*[@id='hook_FormButton_logoff.confirm_not_decorate']");

    public void checkPage() {
        checkToolBarButton();
        checkUserDropdownButton();
    }

    public void checkToolBarButton() {
        toolBarButton.shouldBe(visible.because("toolbar button should be visible on main page"));
    }

    public void toolBarButtonClick() {
        toolBarButton.click();
    }

    public void checkUserDropdownButton() {
        userDropdownButton.shouldBe(visible.because("user dropdown button should be visible on main page"));
    }

    public void userDropdownButtonClick() {
        userDropdownButton.click();
    }

    public static String getToolBarText() {
        return toolBar.getText();
    }

    public void checkUsernameInUserDropdown() {
        usernameInUserDropdown.shouldBe(visible.because("we click on the userDropdown button before"));
    }

    public static String getUsernameInUserDropdown() {
        return usernameInUserDropdown.innerText();
    }

    public LoginPage logout() {
        userLogout.shouldBe(visible.because("logout button should be visible in user dropdown"));
        userLogout.click();
        confirmLogoutButton.shouldBe(visible.because("confirm logout button should appear after click on logout button"));
        confirmLogoutButton.click();
        return new LoginPage();
    }
}