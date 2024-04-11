package pages;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMainPage extends BaseMainPageTest {
    private final static String toolBarText = "Сервисы VK";

    @DisplayName("Check can open and see toolbar text")
    @Test
    @Tag("MainPageTest")
    public void testCheckToolBar() {
        mainPage.checkPage();
        mainPage.checkToolBarButton();
        mainPage.toolBarButtonClick();
        assertTrue(MainPage.getToolBarText().contains(toolBarText), "Wrong toolbar text");
    }
}
