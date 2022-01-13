package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.MakingAPayment;
import userinterface.HomePageElements;

public class PaymentForEachCountrySteps {

    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName = "ipek";
    public Actor actor = Actor.named(actorName);

    @And("I enter phone, name, {string} and amount info")
    public void ıEnterPhoneNameAndAmountInfo(String country) {
        actor.can(BrowseTheWeb.with(herMobileDevice));
        actor.attemptsTo(MakingAPayment.makeAPayment("90555", "John", country, "20"));
    }

    @Then("I should see my remaining balance")
    public void ıShouldSeeMyRemainingBalance() {
        actor.attemptsTo(Ensure.that(HomePageElements.BALANCE_CHECK)
                .attribute("content-desc")
                .isEqualTo("Your balance is: 80.00$"));
    }
}
