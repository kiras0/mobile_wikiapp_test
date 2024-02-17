import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserStackDriver;
import drivers.LocalDriver;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static String deviceHost = System.getProperty("deviceHost");
    @BeforeAll
    static void beforeAll(){
        if (deviceHost == null) {
            deviceHost = "browserstack";
        }
        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserStackDriver.class.getName();
                break;
            case "local":
                Configuration.browser = LocalDriver.class.getName();
                break;
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }
    @BeforeEach
    void beforeEach(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }
    @AfterEach
    void addAttachments() {
        Attachments.pageSource();
        if (deviceHost.equals("browserstack")) {
            String sessionId = sessionId().toString();
            Attachments.addVideo(sessionId);
        }
        else if(deviceHost.equals("local")) {
            Attachments.screenshotAs("Last screenshot");
        }
        closeWebDriver();
    }
}
