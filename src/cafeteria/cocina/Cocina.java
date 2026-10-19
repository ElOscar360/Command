package cafeteria.cocina;

import cafeteria.pedidos.EstadoPedido;
import cafeteria.pedidos.Pedido;
import java.util.LinkedList;
import java.util.Queue;

public class Cocina {
    private final Queue<Pedido> cola = new LinkedList<>();

    public void recibir(Pedido pedido) {
        cola.add(pedido);
        System.out.println("Cocina recibio: " + pedido);
    }

    public boolean hayPedidos() {
        while (!cola.isEmpty() && cola.peek().getEstado() == EstadoPedido.CANCELADO) {
            cola.poll();
        }
        return !cola.isEmpty();
    }

    public void avanzarPaso() {
        if (!hayPedidos()) {
            System.out.println("Cocina: sin pedidos");
            return;
        }
        Pedido actual = cola.peek();
        actual.siguientePaso();
        if (actual.getEstado() == EstadoPedido.PREPARADO) {
            cola.poll();
        }
    }

    public void prepararPedidos() {
        while (hayPedidos()) {
            avanzarPaso();
        }
    }
}
