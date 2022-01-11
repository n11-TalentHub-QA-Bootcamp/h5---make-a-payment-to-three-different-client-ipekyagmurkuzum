package steps;

import net.serenitybdd.screenplay.Actor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.LoginToEriBank;
import tasks.MakingAPayment;
import userinterface.HomePageElements;

public class MakePaymentSteps {

    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName = "ipek";
    Actor actor = Actor.named(actorName);

    @Given("I have logged in")
    public void ı_have_logged_in() {
        actor.can(BrowseTheWeb.with(herMobileDevice));
        actor.attemptsTo(
                LoginToEriBank.loginToEriBank("company","company"));
    }

    @When("I click on make a payment button")
    public void ı_click_on_make_a_payment_button() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actor.attemptsTo(
                Click.on(HomePageElements.MAKE_PAYMENT_BUTTON));

    }

    @And("I enter phone, name, country and amount info")
    public void ı_enter_phone_name_country_and_amount_info() {
        actor.attemptsTo(
                MakingAPayment.makeAPayment("12345","John Smith","Turkey","15")
        );
    }

    @Then("I should see my balance")
    public void ı_should_see_my_balance(){

        actor.attemptsTo(
            Ensure.that(HomePageElements.BALANCE_CHECK).attribute("content-desc").isEqualTo("Your balance is: 85.00$")
        );
    }



}
