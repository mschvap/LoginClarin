package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AuthCeroPage extends PageObject {

    /*--TASK--*/
    public static final Target INPUT_USUARIO = Target.the("Input de usuario").located(By.id("username"));
    public static final Target BUTTON_CONTINUAR = Target.the("Boton Continuar").locatedBy("//button[contains(text(),'Continuar')]");
    public static final Target INPUT_CONTRA = Target.the("Input de contraseña").located(By.id("password"));

    /*--QUESTION--*/
    public static final Target TEXT_ERROR_MAIL = Target.the("Texto de mail incorrecto").locatedBy("//span[contains(text(),'Correo electrónico o contraseña incorrecta')]");
}
