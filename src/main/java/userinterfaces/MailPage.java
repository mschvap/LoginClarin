package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://yopmail.com/es/")
public class MailPage extends PageObject {

    /*--TASK--*/
    public static final Target INPUT_CORREO = Target.the("Input de mail a activar").located(By.id("login"));
    public static final Target BUTTON_CORREO = Target.the("Boton de buscar correo").located(By.id("refreshbut"));

    /*--QUESTION--*/
    public static final Target TEXT_CUENTA_ACTIVA = Target.the("Texto de cuenta activada").locatedBy("//h1[contains(text(),'¡Ya activaste tu cuenta!')]");
}