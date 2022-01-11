package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import steps.MakePaymentSteps;
import userinterface.PaymentPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class MakingAPayment implements Task {

    private final String phone;
    private final String name;
    private final String country;
    private final String amount;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PaymentPageElements.AMOUNT_SLIDE, isClickable()).forNoMoreThan(10).seconds(),
                Enter.theValue(this.phone).into(PaymentPageElements.PHONE_FIELD),
                Enter.theValue(this.name).into(PaymentPageElements.NAME_FIELD),
                Enter.theValue(this.country).into(PaymentPageElements.COUNTRY_FIELD),
                Enter.theValue(this.amount).into((PaymentPageElements.AMOUNT_SLIDE)),
                Click.on(PaymentPageElements.SEND_PAYMENT_BUTTON),
                WaitUntil.the(PaymentPageElements.YES_BUTTON, isClickable()).forNoMoreThan(3).seconds(),
                Click.on(PaymentPageElements.YES_BUTTON)
        );
    }

    public MakingAPayment(String phone, String name, String country, String amount) {
        this.phone = phone;
        this.name = name;
        this.country = country;
        this.amount = amount;
    }

    public static MakingAPayment makeAPayment(String phone, String name, String country, String amount) {
        return instrumented(MakingAPayment.class
                , phone, name, country, amount);
    }
}


