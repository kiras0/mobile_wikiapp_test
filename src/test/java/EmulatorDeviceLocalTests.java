import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.className;

@Tag("emulator")
@DisplayName("Testing Wiki App functionality on local Android device.")
public class EmulatorDeviceLocalTests extends TestBase{
    final SelenideElement
            moreOptionsButton = $(accessibilityId("More options")),
            returnButton = $(accessibilityId("Navigate up")),
            continueButton = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            toolbarLogo = $(AppiumBy.id("org.wikipedia.alpha:id/main_toolbar_wordmark")),
            emptyContainer = $(AppiumBy.id("org.wikipedia.alpha:id/empty_container"));
    @DisplayName("Testing introduction pages for new user first launch.")
    @Test
    void introductionFirstLoadTest() {
        step("Confirming that landing page opened", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia\n" +
                            "…in over 300 languages"));
            step("Pressing Continue", () ->
                    continueButton.click());
        });
        step("Confirming second page loading with context present", () -> {
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
                $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldNotBe(text(String.valueOf(empty)));
            step("Pressing Continue", () ->
                    continueButton.click());
        });
        step("Confirming third page loading with image visible", () -> {
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
                $(AppiumBy.id("org.wikipedia.alpha:id/imageViewCentered"))
                    .shouldBe(visible);
            step("Pressing Continue", () ->
                    continueButton.click());
        });
        step("Confirming last page loading, getting started", () -> {
                $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Data & Privacy"));
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button"))
                    .shouldHave(text("Get started"))
                        .click();
        });
        step("Successfully loading main page, checking that WIKIPEDIA image is visible", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/main_toolbar_wordmark"))
                        .shouldBe(visible)
        );
    }

    @DisplayName("Setting feed customization to display empty feed")
    @Test
    void emptyFeedCustomizeTest(){
        step("Pressing Back, to exit introduction page", Selenide::back);
        step("Pressing 'Customize' button on apps first use, feed customization prompt", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_text"))
                    .shouldHave(text("Customize your Explore feed"));
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_action_positive"))
                    .click();
        });
        step("Feed Customization page open", () -> {
            $(AppiumBy.className("android.widget.TextView"))
                   .shouldHave(text("Customize the feed"));
            step("Press More options menu button", () ->
                moreOptionsButton.click());
            step("Select 'Hide all' option", () ->
                    $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia.alpha:id/title\" and @text=\"Hide all\"]"))
                    .click());
            step("Pressing Back, to exit Customization Feed page", Selenide::back);
        });
        step("Checking that the main feed is empty", () -> {
            emptyContainer.shouldBe(enabled);
            emptyContainer.$(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(text("There's nothing on your Explore feed"));
        });
    }

    @DisplayName("Testing successful search functionality is working")
    @Test
    void searchFunctionalityTest() {
        step("Pressing Back, to exit introduction page", Selenide::back
        );
        step("Confirming main page load, pressing on search tab", () -> {
            toolbarLogo.shouldBe(enabled);
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_search")).click();
        });
        step("Opening search and searching for 'Appium'", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_card")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Asserting search result is not empty", () -> {
            List<WebElement> result = new ArrayList<>($(AppiumBy.id("org.wikipedia.alpha:id/search_results_list")).$$(className("android.widget.TextView")));
            for(WebElement list : result){
                assertThat(list.getText()).doesNotContain("No results");
            }
        });
    }

    @DisplayName("Testing successful search result page")
    @Test
    void successfulSearchResultTest() {
        step("Pressing Back, to exit introduction page", Selenide::back
        );
        step("Confirming main page load, pressing on search bar", () -> {
            toolbarLogo.shouldBe(enabled);
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
        });
        step("Searching for 'Appium'", () ->
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                        .sendKeys("Appium")
        );
        step("Pressing on first result", () ->
            $(AppiumBy.id("org.wikipedia.alpha:id/search_results_list")).$(AppiumBy.className("android.widget.TextView")).click()
        );
        step("Confirming 'Customize your tool bar' pop up", () ->
            $(AppiumBy.id("android:id/navigationBarBackground")).click()
        );
        step("Checking successful search result", () -> {
            $(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(text("Appium"));
        });
    }

    @DisplayName("Testing save article functionality")
    @Test
    void saveArticleFunctionalityTest() {
        step("Pressing Back, to exit introduction page", Selenide::back
        );
        step("Closing customize option, opening Featured Article", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_text"))
                    .shouldHave(text("Customize your Explore feed"));
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_action_negative"))
                    .click();
            $(AppiumBy.id("org.wikipedia.alpha:id/articleTitle"))
                    .click();
        });
        String articleTitle = step("Saving article and returning to main page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_save"))
                    .click();
        String title = $(AppiumBy.className("android.widget.TextView")).getText();
            returnButton.click();
            return title;
         });
        step("Opening 'Save' page and opening collection", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_reading_lists"))
                    .click();
            $(AppiumBy.id("org.wikipedia.alpha:id/item_title"))
                    .click();
            $(AppiumBy.id("org.wikipedia.alpha:id/buttonView"))
                    .click();
        });
        step("Asserting that correct article is saved", () -> {
            String collectionArticleTitle= $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).getText();
            assertThat(articleTitle).isEqualTo(collectionArticleTitle);
        });
    }
}
