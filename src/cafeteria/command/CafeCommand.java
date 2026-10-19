package cafeteria.command;

import cafeteria.receptores.Cafetera;

public class CafeCommand implements Command {
    private final Cafetera cafetera;
    private final String tipo;

    public CafeCommand(Cafetera cafetera, String tipo) {
        this.cafetera = cafetera;
        this.tipo = tipo;
    }

    @Override
    public void execute() {
        cafetera.prepararCafe(tipo);
    }

    @Override
    public void undo() {
        cafetera.reiniciar();
    }

    @Override
    public String toString() {
        return "Cafe " + tipo;
    }
}
