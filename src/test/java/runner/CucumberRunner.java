package runner;


import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        //tags = "@login"
        //tags = "@payment"
        //tags = "@paymentforthree"
        tags = "@paymentforeachcountry"
)

public class CucumberRunner {
    static AppiumDriverLocalService appiumService = null;

    @BeforeClass
    public static void startAppiumServer() throws IOException {
        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
    }

    @AfterClass
    public static void stopAppiumServer() {
        appiumService.stop();
    }

}
