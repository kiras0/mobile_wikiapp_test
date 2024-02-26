package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class MainScreen {
    private final SelenideElement
            mainToolbarImg = $(AppiumBy.id("org.wikipedia.alpha:id/main_toolbar_wordmark")),
            customizePrompt = $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_text")),
            customizePromptBtn = $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_action_positive")),
            closePromptBtn = $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_action_negative")),
            emptyContainer = $(AppiumBy.id("org.wikipedia.alpha:id/empty_container")),
            emptyDescription = emptyContainer.$(AppiumBy.className("android.widget.TextView")),
            articleTitle = $(AppiumBy.id("org.wikipedia.alpha:id/articleTitle")),
            saveBtn =  $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_reading_lists")),
            searchContainer =  $(AppiumBy.id("org.wikipedia.alpha:id/search_container")),
            searchBtn =  $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_search"));
    @Step("Successfully loading main page, checking that WIKIPEDIA image is visible")
    public MainScreen checkMainImg() {
        mainToolbarImg.shouldBe(visible);
        return this;
    }
    @Step("Pressing 'Customize' button on feed customization prompt")
    public MainScreen openCustomizePrompt() {
        customizePrompt.shouldHave(text("Customize your Explore feed"));
        customizePromptBtn.click();
        return this;
    }
    @Step("Pressing 'Customize' button on feed customization prompt")
    public MainScreen closeCustomizePrompt() {
        customizePrompt.shouldHave(text("Customize your Explore feed"));
        closePromptBtn.click();
        return this;
    }
    @Step("Checking that the main feed is empty")
    public MainScreen emptyMain() {
        emptyContainer.shouldBe(enabled);
        emptyDescription.shouldHave(text("There's nothing on your Explore feed"));
        return this;
    }
    @Step("Opening Featured Article")
    public MainScreen openFeatured() {
        articleTitle.click();
        return this;
    }
    @Step("Opening 'Save' screen")
    public MainScreen openSave() {
        saveBtn.click();
        return this;
    }
    @Step("Opening 'Search' screen")
    public MainScreen openSearch() {
        searchBtn.click();
        return this;
    }
    @Step("Pressing on search container")
    public MainScreen openSearchContainer() {
        searchContainer.click();
        return this;
    }
}
