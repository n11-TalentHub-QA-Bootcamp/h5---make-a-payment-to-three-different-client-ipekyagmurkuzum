package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPageElements {

      public static Target USERNAME_FIELD =
              Target.the("username field")
                      .located(By.id("usernameTextField"));

      public static Target PASSWORD_FIELD =
              Target.the("password field")
                      .located(By.id("passwordTextField"));

      public static Target LOGIN_BUTTON =
              Target.the("login button")
                      .located(By.id("loginButton"));
}