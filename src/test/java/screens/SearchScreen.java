package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.className;

public class SearchScreen {
    private final SelenideElement
            searchContainer = $(AppiumBy.id("org.wikipedia.alpha:id/search_card")),
            searchInput = $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"));
    private final ElementsCollection
            searchResult = $(AppiumBy.id("org.wikipedia.alpha:id/search_results_list")).$$(className("android.widget.TextView"));

    @Step("Pressing on search container")
    public SearchScreen openSearch() {
        searchContainer.click();
        return this;
    }
    @Step("Setting search request")
    public SearchScreen searchFor(String request) {
        searchInput.sendKeys(request);
        return this;
    }
    @Step("Asserting search result is not empty")
    public SearchScreen searchNotEmpty() {
        List<WebElement> result = new ArrayList<>(searchResult);
        for(WebElement list : result){
            assertThat(list.getText()).doesNotContain("No results");
        }
        return this;
    }
    @Step("Pressing on first search result")
    public SearchScreen firstResult() {
        $(AppiumBy.id("org.wikipedia.alpha:id/search_results_list")).$(AppiumBy.className("android.widget.TextView")).click();
        return this;
    }
}
