import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
@Owner("Kiras0")
@Tag("browserstack")
@DisplayName("Remote tests with BrowserStack on Wiki app on Android device.")
public class BrowserstackDeviceRemoteTests extends TestBase{
    final SelenideElement
            searchBarContainer = $(accessibilityId("Search Wikipedia"));

    @DisplayName("Checking successful main page load")
    @Story("Testing of title present on successful app launch")
    @Test
    void checkNewsHeaderTest() {
        step("Checking title should be present", () ->
            $(id("org.wikipedia.alpha:id/view_card_header_title"))
                    .shouldHave(text("In the news")));
    }

    @DisplayName("Checking that search result has description")
    @Story("Testing of description present in results in apps search technology")
    @Test
    void checkResultDescriptionTest() {
        step("Pressing on search bar and searching for 'JavaScript'", () -> {
            searchBarContainer.click();
            $(id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("JavaScript");
        });
        step("Checking that first result has description", () ->
                $(id("org.wikipedia.alpha:id/page_list_item_description"))
                        .shouldHave(text("High-level programming language")));
    }

    @DisplayName("Testing for error message in article after successful search")
    @Story("Testing of error message present after performing search functionality")
    @Test
    void successfulSearchTest(){
        step("Pressing on search bar and searching for 'Java'", () -> {
            searchBarContainer.click();
            $(id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("Java");
        });
        step("Check that result is not empty", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
        step("Click on first result", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click());
        step("Checking that Error is displayed", () ->
                $(id("org.wikipedia.alpha:id/view_wiki_error_text"))
                        .shouldBe(visible));
    }
}
