package cafeteria.command;

import cafeteria.receptores.Exprimidor;

public class JugoCommand implements Command {
    private final Exprimidor exprimidor;

    public JugoCommand(Exprimidor exprimidor) {
        this.exprimidor = exprimidor;
    }

    @Override
    public void execute() {
        exprimidor.exprimirNaranja();
    }

    @Override
    public void undo() {
        exprimidor.reiniciar();
    }

    @Override
    public String toString() {
        return "Jugo de naranja";
    }
}
