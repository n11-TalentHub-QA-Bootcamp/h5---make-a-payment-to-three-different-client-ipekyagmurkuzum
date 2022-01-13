package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentPageElements {

    public static Target PHONE_FIELD =
            Target.the("phone field")
                    .located(By.id("phoneTextField"));

    public static Target NAME_FIELD =
            Target.the("name field")
                    .located(By.id("nameTextField"));

    public static Target COUNTRY_FIELD =
            Target.the("country field")
                    .located(By.id("countryTextField"));

    public static Target AMOUNT_SLIDE =
            Target.the("amount")
                    .located(By.id("amount"));

    public static Target SEND_PAYMENT_BUTTON =
            Target.the("send payment button")
                    .located(By.id("sendPaymentButton"));

    public static Target YES_BUTTON =
            Target.the("i am sure button")
                    .located(By.id("android:id/button1"));

    public static Target SELECT_BUTTON =
            Target.the("select country button")
                    .located(By.id("countryButton"));

    public static Target SELECT_COUNTRY_LIST =
            Target.the("select country list")
                    .locatedBy("android.widget.TextView");


}

