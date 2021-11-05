package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ListaMailPage extends PageObject {

    public static final Target BUTTON_ACTIVAR_CUENTA = Target.the("Boton activar cuenta").locatedBy("//a[contains(text(),'Activar mi cuenta')]");
    public static final Target BUTTON_VER_IMAGENES = Target.the("Boton ver imagenes").locatedBy("//span[contains(text(),'Ver las imágenes')]");
    public static final Target BUTTON_REFRESCO = Target.the("Boton de refresco").located(By.id("refresh"));
}
