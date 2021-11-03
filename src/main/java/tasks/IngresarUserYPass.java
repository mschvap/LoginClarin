package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.AuthCeroPage.*;

public class IngresarUserYPass implements Task {

    private String usuario;
    private String contra;

    public IngresarUserYPass(String user, String pass){
        this.usuario=user;
        this.contra=pass;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(INPUT_USUARIO),
                Click.on(BUTTON_CONTINUAR),
                Enter.theValue(contra).into(INPUT_CONTRA),
                Click.on(BUTTON_CONTINUAR)
        );
    }

    public static IngresarUserYPass conDatos(String s, String s1) {
        return instrumented(IngresarUserYPass.class, s, s1);
    }
}
