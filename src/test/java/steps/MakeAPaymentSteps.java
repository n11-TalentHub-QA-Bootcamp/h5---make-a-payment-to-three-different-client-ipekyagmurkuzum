package steps;

import net.serenitybdd.screenplay.Actor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.MakingAPayment;
import userinterface.HomePageElements;

public class MakeAPaymentSteps {

    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName = "ipek";
    public Actor actor = Actor.named(actorName);

    @And("I enter phone, name, country and amount info")
    public void i_enter_phone_name_country_and_amount_info() {
        actor.can(BrowseTheWeb.with(herMobileDevice));
        actor.attemptsTo(
                MakingAPayment.makeAPayment("12345","John Smith","Turkey","15")
        );
    }

    @Then("I should see my remaining balance on home page")
    public void i_should_see_my_remaining_balance(){
        actor.attemptsTo(
            Ensure.that(HomePageElements.BALANCE_CHECK).attribute("content-desc")
                    .isEqualTo("Your balance is: 85.00$")
        );
    }



}
