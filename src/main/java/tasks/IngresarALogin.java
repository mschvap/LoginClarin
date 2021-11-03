package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.HomePage.BUTTON_INGRESAR;

public class IngresarALogin implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_INGRESAR)
        );
    }

    public static IngresarALogin conClick() {
        return instrumented(IngresarALogin.class);
    }
}
