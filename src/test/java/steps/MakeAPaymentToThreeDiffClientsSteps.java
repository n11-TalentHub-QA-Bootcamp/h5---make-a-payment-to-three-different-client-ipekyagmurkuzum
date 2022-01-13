
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


public class MakeAPaymentToThreeDiffClientsSteps {

    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName = "ipek";
    Actor actor = Actor.named(actorName);

    @Given("I have logged in on Eribank")
    public void i_have_logged_in() {
        actor.can(BrowseTheWeb.with(herMobileDevice));
        actor.attemptsTo(
                LoginToEriBank.loginToEriBank("company", "company"));
    }

    @When("I choose make a payment option for the first client")
    public void i_choose_make_a_payment_option_for_the_first_client() {
        actor.attemptsTo(
                Click.on(HomePageElements.MAKE_PAYMENT_BUTTON));
    }

    @And("I enter phone, name, country and amount info of the first client")
    public void i_enter_phone_name_country_and_amount_info_of_the_first_client() {
        actor.attemptsTo(
                MakingAPayment.makeAPayment("11111", "John Smith", "India", "15")
        );
    }

    @Then("I should see my remaining balance after first payment")
    public void i_should_see_my_remaining_balance_first() {
        actor.attemptsTo(
                Ensure.that(HomePageElements.BALANCE_CHECK).attribute("content-desc")
                        .isEqualTo("Your balance is: 85.00$")
        );
    }

    @When("I choose make a payment option for the second client")
    public void i_choose_make_a_payment_option_for_the_second_client() {
        actor.attemptsTo(
                Click.on(HomePageElements.MAKE_PAYMENT_BUTTON));
    }

    @And("I enter phone, name, country and amount info of the second client")
    public void i_enter_phone_name_country_and_amount_info_of_the_second_client() {
        actor.attemptsTo(
                MakingAPayment.makeAPayment("22222", "Mary Jane", "China", "30")
        );
    }

    @Then("I should see my remaining balance after second payment")
    public void i_should_see_my_remaining_balance_second() {

        actor.attemptsTo(
                Ensure.that(HomePageElements.BALANCE_CHECK).attribute("content-desc")
                        .isEqualTo("Your balance is: 55.00$")
        );
    }

    @When("I choose make a payment option for the third client")
    public void i_choose_make_a_payment_option_for_the_third_client() {
        actor.attemptsTo(
                Click.on(HomePageElements.MAKE_PAYMENT_BUTTON));
    }

    @And("I enter phone, name, country and amount info of the third client")
    public void i_enter_phone_name_country_and_amount_info_of_the_third_client() {
        actor.attemptsTo(
                MakingAPayment.makeAPayment("33333", "Anastasia Dostoyevski", "Ukraine", "50")
        );
    }

    @Then("I should see my remaining balance after third payment")
    public void i_should_see_my_remaining_balance_third() {

        actor.attemptsTo(
                Ensure.that(HomePageElements.BALANCE_CHECK).attribute("content-desc")
                        .isEqualTo("Your balance is: 5.00$")
        );
    }
}
