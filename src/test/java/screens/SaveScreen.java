package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class SaveScreen {
    private final SelenideElement
            collection = $(AppiumBy.id("org.wikipedia.alpha:id/item_title")),
            promptBtn = $(AppiumBy.id("org.wikipedia.alpha:id/buttonView")),
            titleContainer = $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Opening saved collection")
    public SaveScreen openSavedCollection() {
        collection.click();
        return this;
    }
    @Step("Press 'Got It' on prompt")
    public SaveScreen gotItBtn() {
        promptBtn.click();
        return this;
    }
    @Step("Asserting that correct article is saved")
    public SaveScreen checkSaved(String articleTitle) {
        String collectionArticleTitle= titleContainer.getText();
        assertThat(articleTitle).isEqualTo(collectionArticleTitle);
        return this;
    }
}
