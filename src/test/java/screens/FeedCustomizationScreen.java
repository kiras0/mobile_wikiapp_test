package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class FeedCustomizationScreen {
    private final SelenideElement
            moreOptionsBtn = $(accessibilityId("More options")),
            textTitle = $(AppiumBy.className("android.widget.TextView")),
            hideAll = $(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia.alpha:id/title\" and @text=\"Hide all\"]"));
    @Step("Feed Customization page open")
    public FeedCustomizationScreen feedCustomOpen() {
        textTitle.shouldHave(text("Customize the feed"));
        return this;
    }
    @Step("Press More options menu button")
    public FeedCustomizationScreen feedMoreOpt() {
        moreOptionsBtn.click();
        return this;
    }
    @Step("Select 'Hide all' option")
    public FeedCustomizationScreen moreOptHideAll() {
        hideAll.click();
        return this;
    }
    @Step("Pressing Back on Feed Customization Screen")
    public FeedCustomizationScreen feedCustomBack() {
        back();
        return this;
    }
}
