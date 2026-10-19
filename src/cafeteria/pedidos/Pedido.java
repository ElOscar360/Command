package cafeteria.pedidos;

import cafeteria.command.Command;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Command {
    private static int contador = 1;

    private final int id;
    private final int mesa;
    private final List<Command> items;
    private int paso;
    private EstadoPedido estado;

    public Pedido(int mesa, List<Command> items) {
        this.id = contador++;
        this.mesa = mesa;
        this.items = new ArrayList<>(items);
        this.paso = 0;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public void siguientePaso() {
        if (estado == EstadoPedido.PREPARADO || estado == EstadoPedido.CANCELADO) {
            return;
        }
        if (estado == EstadoPedido.PENDIENTE) {
            System.out.println("Iniciando pedido #" + id + " (mesa " + mesa + ")");
            estado = EstadoPedido.EN_PREPARACION;
        }
        items.get(paso++).execute();
        if (paso == items.size()) {
            estado = EstadoPedido.PREPARADO;
            System.out.println("Pedido #" + id + " listo");
        }
    }

    @Override
    public void execute() {
        while (estado == EstadoPedido.PENDIENTE || estado == EstadoPedido.EN_PREPARACION) {
            siguientePaso();
        }
    }

    @Override
    public void undo() {
        for (int i = paso - 1; i >= 0; i--) {
            items.get(i).undo();
        }
        paso = 0;
    }

    public boolean cancelar() {
        if (estado == EstadoPedido.PREPARADO || estado == EstadoPedido.CANCELADO) {
            return false;
        }
        undo();
        estado = EstadoPedido.CANCELADO;
        return true;
    }

    public boolean modificar(List<Command> nuevosItems) {
        if (estado == EstadoPedido.PREPARADO || estado == EstadoPedido.CANCELADO) {
            return false;
        }
        undo();
        items.clear();
        items.addAll(nuevosItems);
        estado = EstadoPedido.PENDIENTE;
        return true;
    }

    public int getId() {
        return id;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " mesa " + mesa + " " + items + " [" + estado + "]";
    }
}
