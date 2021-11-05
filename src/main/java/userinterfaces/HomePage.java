package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://prepro.int.clarin.com/")
public class HomePage extends PageObject {

    /*--TASK--*/
    public static final Target BUTTON_CERRAR_PUBLICIDAD = Target.the("Boton cerrar publicidad").located(By.id("close"));
    public static final Target BUTTON_INGRESAR = Target.the("Boton ingresar").located(By.id("loginLogout"));
    public static final Target LINK_REGISTRATE = Target.the("Link Registrate gratis").locatedBy("//a[contains(text(),'Registrate GRATIS')]");

    /*--QUESTION--*/
    public static final Target TEXT_BIENVENIDA = Target.the("Texto de bienvenida").locatedBy("//p[contains(text(),'Hola')]");
}
