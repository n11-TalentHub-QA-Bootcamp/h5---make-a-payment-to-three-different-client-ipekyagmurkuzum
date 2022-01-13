package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterface.HomePageElements;
import userinterface.PaymentPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class MakeAPaymentForEachCountry implements Task {

    private final String phone;
    private final String name;
    private final String amount;
    private final String country;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaymentPageElements.AMOUNT_SLIDE, isClickable()).forNoMoreThan(10).seconds(),
                Enter.theValue(this.phone).into(PaymentPageElements.PHONE_FIELD),
                Enter.theValue(this.name).into(PaymentPageElements.NAME_FIELD),
                Enter.theValue(this.amount).into((PaymentPageElements.AMOUNT_SLIDE)),
                Click.on(PaymentPageElements.SELECT_BUTTON),
                Click.on(PaymentPageElements.SELECT_COUNTRY_LIST),
                SelectFromOptions.byVisibleText(country).from(PaymentPageElements.SELECT_COUNTRY_LIST),
                Click.on(PaymentPageElements.SEND_PAYMENT_BUTTON),
                WaitUntil.the(PaymentPageElements.YES_BUTTON, isClickable()).forNoMoreThan(3).seconds(),
                Click.on(PaymentPageElements.YES_BUTTON),
                WaitUntil.the(HomePageElements.BALANCE_CHECK, isCurrentlyVisible()).forNoMoreThan(5).seconds()
        );
    }

    public MakeAPaymentForEachCountry(String phone, String name, String country, String amount) {
        this.phone = phone;
        this.name = name;
        this.amount = amount;
        this.country = country;
    }

    public static MakingAPayment makeAPayment(String phone, String name, String amount, String country) {
        return instrumented(MakingAPayment.class
                , phone, name, amount, country);
    }
}
