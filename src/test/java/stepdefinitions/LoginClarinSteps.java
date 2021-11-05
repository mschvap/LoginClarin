package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Visibility;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tasks.ActivarMail;
import tasks.IngresarALogin;
import tasks.IngresarARegistro;
import tasks.IngresarUserYPass;
import userinterfaces.HomePage;
import userinterfaces.MailPage;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static userinterfaces.AuthCeroPage.TEXT_ERROR_MAIL;
import static userinterfaces.HomePage.*;
import static userinterfaces.MailPage.TEXT_CUENTA_ACTIVA;

public class LoginClarinSteps {

    //@Managed()
    private Actor actor = Actor.named("User");
    private HomePage homePage = new HomePage();
    private MailPage mailPage = new MailPage();

    @Given("^usuario registrado$")
    public void usuario_registrado() {
        actor.can(BrowseTheWeb.with(getDriver()));
        actor.wasAbleTo(Open.browserOn(homePage));
        //navegador().manage().window().maximize();
        getDriver().manage().window().setSize(new Dimension(1280,1024));
        System.out.println("Navegador: " + System.getProperty("webdriver.driver"));
    }

    @When("^ingresa usuario y contraseña$")
    public void ingresa_usuario_y_contraseña(List<String> datos) {
        if(Visibility.of(BUTTON_CERRAR_PUBLICIDAD).viewedBy(actor).asBoolean())
            actor.attemptsTo(Click.on(BUTTON_CERRAR_PUBLICIDAD));
        actor.wasAbleTo(
                IngresarALogin.conClick(),
                IngresarUserYPass.conDatos(datos.get(0),datos.get(1))
        );
    }

    @Then("^se ve mensaje de bienvenida$")
    public void se_ve_mensaje_de_bienvenida() {
        if(Visibility.of(BUTTON_CERRAR_PUBLICIDAD).viewedBy(actor).asBoolean())
            actor.attemptsTo(Click.on(BUTTON_CERRAR_PUBLICIDAD));
        actor.should(seeThat(the(TEXT_BIENVENIDA),isPresent()));
    }

    @Then("^se ve mensaje de error de mail$")
    public void se_ve_mensaje_de_error_de_mail() {
        actor.should(seeThat(the(TEXT_ERROR_MAIL),isPresent()));
    }

    @Given("^usuario no registrado$")
    public void usuario_no_registrado() {
        actor.can(BrowseTheWeb.with(getDriver()));
        actor.wasAbleTo(Open.browserOn(homePage));
        getDriver().manage().window().maximize();
        //getDriver().manage().window().setSize(new Dimension(1280,1024));
        System.out.println("Navegador: " + System.getProperty("webdriver.driver"));
    }

    @When("^ingresa usuario y contraseña nueva$")
    public void ingresa_usuario_y_contraseña_nueva(List<String> datos) {
       if(Visibility.of(BUTTON_CERRAR_PUBLICIDAD).viewedBy(actor).asBoolean())
            actor.attemptsTo(Click.on(BUTTON_CERRAR_PUBLICIDAD));

        actor.wasAbleTo(
                IngresarALogin.conClick(),
                IngresarARegistro.conClick(),
                IngresarUserYPass.conDatos(datos.get(0),datos.get(1))
        );

        actor.should(seeThat(the(TEXT_BIENVENIDA),isPresent()));

        ((JavascriptExecutor)getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        getDriver().get("https://yopmail.com/es/");

        actor.wasAbleTo(ActivarMail.conCorreo(datos.get(0)));

    }

    @Then("^se activa cuenta por mail$")
    public void se_activa_cuenta_por_mail() {
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }
        actor.should(seeThat(the(TEXT_CUENTA_ACTIVA),isPresent()));
    }

}
