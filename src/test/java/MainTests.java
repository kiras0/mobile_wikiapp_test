import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Owner("Kiras0")
@Tag("emulator")
@Severity(SeverityLevel.BLOCKER)
@DisplayName("Testing main functionality of the app.")
public class MainTests extends TestBase {

    @DisplayName("Changing feed customization to hide all to display an empty feed")
    @Test
    void emptyFeedCustomizeTest() {
        introductionScreen.itroBack();
        mainScreen.openCustomizePrompt();
        feedCustomizationScreen.feedCustomOpen()
                .feedMoreOpt()
                .moreOptHideAll()
                .feedCustomBack();
        mainScreen.emptyMain();
    }

    @DisplayName("Testing of save article functionality")
    @Test
    void saveArticleFunctionalityTest() {
        introductionScreen.itroBack();
        mainScreen.closeCustomizePrompt()
                .openFeatured();
        String savedTitle = articleScreen.saveClk()
                .saveArticleTitle();
        articleScreen.pressReturn();
        mainScreen.openSave();
        saveScreen.openSavedCollection()
                .gotItBtn()
                .checkSaved(savedTitle);
    }

    @DisplayName("Testing for successful Main search functionality operation")
    @Test
    void successfulMainSearchTest() {
        introductionScreen.itroBack();
        mainScreen.checkMainImg()
                .openSearchContainer();
        searchScreen.searchFor(testData.setMainRequest)
                .searchNotEmpty();
    }
}
