package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage implements BasePage {
    private static final SelenideElement toolBarButton = $(".vk_ecosystem_toolbar.h-mod > button");
    private static final SelenideElement toolBar = $(".vk_ecosystem_toolbar.h-mod");
    private static final SelenideElement userDropdownButton = $("#hook_Block_ToolbarUserDropdown > div > button");

    private static final SelenideElement usernameInUserDropdown = $(".toolbar_accounts-user_name");
    private static final SelenideElement userLogout = $(".toolbar_accounts-user-delete-button");
    private static final SelenideElement confirmLogoutButton =  $(By.xpath("//*[@id='hook_FormButton_logoff.confirm_not_decorate']"));

    public void checkPage() {
        checkToolBarButton();
        checkUserDropdownButton();
    }

    public void checkToolBarButton() {
        toolBarButton.shouldBe(visible);
    }

    public void toolBarButtonClick() {
        toolBarButton.click();
    }

    public void checkUserDropdownButton() {
        toolBarButton.shouldBe(visible);
    }

    public void userDropdownButtonClick() {
        userDropdownButton.click();
    }

    public static SelenideElement getToolBar() {
        return toolBar;
    }

    public static SelenideElement getUsernameInUserDropdown() {
        return usernameInUserDropdown;
    }

    public LoginPage logout() {
        userLogout.click();
        confirmLogoutButton.click();
        return new LoginPage();
    }
}