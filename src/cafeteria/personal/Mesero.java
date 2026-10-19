package cafeteria.personal;

import cafeteria.cocina.Cocina;
import cafeteria.command.Command;
import cafeteria.pedidos.Pedido;
import java.util.Arrays;

public class Mesero {
    private final String nombre;
    private final Cocina cocina;

    public Mesero(String nombre, Cocina cocina) {
        this.nombre = nombre;
        this.cocina = cocina;
    }

    public Pedido tomarPedido(int mesa, Command... items) {
        Pedido pedido = new Pedido(mesa, Arrays.asList(items));
        System.out.println(nombre + " tomo " + pedido);
        return pedido;
    }

    public void enviarACocina(Pedido pedido) {
        cocina.recibir(pedido);
    }

    public void cancelar(Pedido pedido) {
        System.out.println(nombre + " cancela el pedido #" + pedido.getId());
        if (!pedido.cancelar()) {
            System.out.println("El pedido #" + pedido.getId() + " ya esta " + pedido.getEstado());
        }
    }

    public void modificar(Pedido pedido, Command... nuevosItems) {
        System.out.println(nombre + " modifica el pedido #" + pedido.getId());
        if (pedido.modificar(Arrays.asList(nuevosItems))) {
            System.out.println("Ahora: " + pedido);
        } else {
            System.out.println("El pedido #" + pedido.getId() + " ya esta " + pedido.getEstado());
        }
    }
}
