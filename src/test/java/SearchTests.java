import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Owner("Kiras0")
@Tag("emulator")
@Severity(SeverityLevel.BLOCKER)
@DisplayName("Testing of Search functionality.")
public class SearchTests extends TestBase{

    @DisplayName("Testing successful search functionality is working")
    @Test
    void searchFunctionalityTest() {
        introductionScreen.itroBack();
        mainScreen.checkMainImg()
                .openSearch();
        searchScreen.openSearch()
                .searchFor(testData.setSearchRequest)
                .searchNotEmpty();
    }

    @DisplayName("Testing for successful search for an article")
    @Test
    void successfulSearchResultTest() {
        introductionScreen.itroBack();
        mainScreen.checkMainImg()
                .openSearch();
        searchScreen.openSearch()
                .searchFor(testData.setSearchRequest)
                .firstResult();
        articleScreen.customizePopUp()
                .checkTitle(testData.setMainRequest);
    }
}
