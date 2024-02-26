import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Owner("Kiras0")
@Tags({@Tag("mobile"), @Tag("introduction")})
@Severity(SeverityLevel.BLOCKER)
@DisplayName("Testing of Introduction screens of app use.")
public class IntroductionTests extends TestBase{

    @DisplayName("Testing screens for user base app launch.")
    @Test
    void introductionFirstLoadTest() {
        introductionScreen.introOpen()
                .continueClk()
                .checkIntroTwo()
                .continueClk()
                .checkIntroThree()
                .continueClk()
                .checkIntroLast()
                .getStarted();
        mainScreen.checkMainImg();
    }
}
