package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import tasks.LoginToEriBank;
import userinterface.HomePageElements;
import net.serenitybdd.screenplay.ensure.Ensure;

public class LoginSteps {

    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName="ipek";
    Actor actor = Actor.named(actorName);

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("I am on the application main page")
    public void i_am_on_the_application_main_page() {
        actor.can(BrowseTheWeb.with(herMobileDevice));
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        actor.attemptsTo(
                LoginToEriBank.loginToEriBank("company","company"));
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actor.attemptsTo(
                Ensure.that(HomePageElements.MAKE_PAYMENT_BUTTON).isDisplayed(),
                Ensure.that(HomePageElements.BALANCE_CHECK).isDisplayed()
        );
    }
}
