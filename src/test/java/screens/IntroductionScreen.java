package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;

public class IntroductionScreen {
    private final SelenideElement
            continueBtn = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            textContainer = $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")),
            imageContainer = $(AppiumBy.id("org.wikipedia.alpha:id/imageViewCentered")),
            descriptContainer = $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")),
            startBtn = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    @Step("Pressing Back on introduction page")
    public IntroductionScreen itroBack() {
        back();
        return this;
    }
    @Step("Confirming that landing page opened")
    public IntroductionScreen introOpen() {
        textContainer.shouldHave(text("The Free Encyclopedia\n" +
                        "…in over 300 languages"));
        return this;
    }
    @Step("Pressing Continue")
    public IntroductionScreen continueClk() {
        continueBtn.click();
        return this;
    }
    @Step("Confirming second page loading with context present")
    public IntroductionScreen checkIntroTwo() {
        textContainer.shouldHave(text("New ways to explore"));
        descriptContainer.shouldNotBe(text(String.valueOf(empty)));
        return this;
    }
    @Step("Confirming third page loading with image visible")
    public IntroductionScreen checkIntroThree() {
        textContainer.shouldHave(text("Reading lists with sync"));
        imageContainer.shouldBe(visible);
        return this;
    }
    @Step("Confirming last page loading, getting started")
    public IntroductionScreen checkIntroLast() {
        textContainer.shouldHave(text("Data & Privacy"));
        return this;
    }
    @Step("Pressing getting started")
    public IntroductionScreen getStarted() {
        startBtn.shouldHave(text("Get started")).click();
        return this;
    }
}
