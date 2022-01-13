package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import tasks.LoginToEriBank;
import userinterface.HomePageElements;

public class BackgroundSteps {

    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName= "ipek";
    public Actor actor = Actor.named(actorName);

    @Given("I have logged in")
    public void i_have_logged_in() {
        actor.can(BrowseTheWeb.with(herMobileDevice));
        actor.attemptsTo(
                LoginToEriBank.loginToEriBank("company","company"));
    }

    @When("I choose make a payment option")
    public void i_choose_make_a_payment_option() {
        actor.attemptsTo(
                Click.on(HomePageElements.MAKE_PAYMENT_BUTTON));

    }
}
