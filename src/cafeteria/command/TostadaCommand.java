package cafeteria.command;

import cafeteria.receptores.Tostadora;

public class TostadaCommand implements Command {
    private final Tostadora tostadora;

    public TostadaCommand(Tostadora tostadora) {
        this.tostadora = tostadora;
    }

    @Override
    public void execute() {
        tostadora.tostarPan();
    }

    @Override
    public void undo() {
        tostadora.reiniciar();
    }

    @Override
    public String toString() {
        return "Tostada";
    }
}
