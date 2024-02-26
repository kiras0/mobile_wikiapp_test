package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.assertj.core.api.Assertions.assertThat;

public class ArticleScreen {
    private final SelenideElement
            saveBtn = $(AppiumBy.id("org.wikipedia.alpha:id/page_save")),
            titleContainer = $(AppiumBy.className("android.widget.TextView")),
            popUp = $(AppiumBy.id("org.wikipedia.alpha:id/action_bar_root")),
            returnBtn = $(accessibilityId("Navigate up"));
    @Step("Saving current article")
    public ArticleScreen saveClk() {
        saveBtn.click();
        return this;
    }
    @Step("Saving article Title")
    public String saveArticleTitle() {
        String title = titleContainer.getText();
        return title;
    }
    @Step("Checking article title matches search request")
    public ArticleScreen checkTitle(String request) {
        String title = titleContainer.getText();
        assertThat(title).contains(request);
        return this;
    }
    @Step("Closing 'Customize your tool bar' pop up")
    public ArticleScreen customizePopUp() {
        popUp.click();
        return this;
    }
    @Step("Pressing Return on article screen")
    public ArticleScreen pressReturn() {
        returnBtn.click();
        return this;
    }
}
