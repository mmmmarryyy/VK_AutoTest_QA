package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage implements BasePage {
    private static SelenideElement toolBarButton = $(".vk_ecosystem_toolbar.h-mod > button");
    private static SelenideElement userDropdownButton = $("#hook_Block_ToolbarUserDropdown > div > button");
    private static SelenideElement userLogout = $(".toolbar_accounts-user-delete-button");
    private static SelenideElement confirmLogoutButton =  $(By.xpath("//*[@id='hook_FormButton_logoff.confirm_not_decorate']"));

    public void checkTextVisibleOnPage(String text) {
        $(byText(text)).shouldBe(visible);
    }

    public void checkPage() {
        toolBarButton.shouldBe(visible);
        userDropdownButton.shouldBe(visible);
    }

    public void toolBarButtonClick() {
        toolBarButton.click();
    }

    public void userDropdownButtonClick() {
        userDropdownButton.click();
    }

    public LoginPage logout() {
        userLogout.click();
        confirmLogoutButton.click();
        return new LoginPage();
    }
}