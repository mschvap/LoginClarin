package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;


import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.apache.commons.io.FileUtils.waitFor;
import static userinterfaces.ListaMailPage.*;
import static userinterfaces.MailPage.*;

public class ActivarMail implements Task {

    private String correo;

    public ActivarMail(String correo){
        this.correo=correo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Enter.theValue(correo).into(INPUT_CORREO),
                Click.on(BUTTON_CORREO)
        );

        int size = getDriver().findElements(By.tagName("iframe")).size();
        System.out.println("Frames:" + size);
        getDriver().switchTo().frame(2);

        actor.attemptsTo(
                Click.on(BUTTON_VER_IMAGENES),
                Click.on(BUTTON_ACTIVAR_CUENTA)
        );



    }

    public static ActivarMail conCorreo(String s) {
        return instrumented(ActivarMail.class, s);
    }
}
