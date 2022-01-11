package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageElements {

    public static Target MAKE_PAYMENT_BUTTON =
            Target.the("make a payment button")
                    .located(By.id("makePaymentButton"));

    public static Target LOGOUT_BUTTON =
            Target.the("logout button")
                    .located(By.id("logoutButton"));

    public static Target BALANCE_CHECK =
            Target.the("balance check")
                    .located(By.xpath("//android.view.View[@content-desc]"));

}
