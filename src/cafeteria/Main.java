package cafeteria;

import cafeteria.cocina.Cocina;
import cafeteria.command.CafeCommand;
import cafeteria.command.JugoCommand;
import cafeteria.command.TostadaCommand;
import cafeteria.pedidos.Pedido;
import cafeteria.personal.Mesero;
import cafeteria.receptores.Cafetera;
import cafeteria.receptores.Exprimidor;
import cafeteria.receptores.Tostadora;

public class Main {
    public static void main(String[] args) {
        Cafetera cafetera = new Cafetera();
        Tostadora tostadora = new Tostadora();
        Exprimidor exprimidor = new Exprimidor();

        Cocina cocina = new Cocina();
        Mesero mesero = new Mesero("Oscar", cocina);

        Pedido p1 = mesero.tomarPedido(1, new CafeCommand(cafetera, "americano"), new TostadaCommand(tostadora));
        Pedido p2 = mesero.tomarPedido(2, new JugoCommand(exprimidor));
        Pedido p3 = mesero.tomarPedido(3, new CafeCommand(cafetera, "capuchino"));

        mesero.enviarACocina(p1);
        mesero.enviarACocina(p2);
        mesero.enviarACocina(p3);

        System.out.println("\n Modificacion durante la preparacion ");
        cocina.avanzarPaso();
        mesero.modificar(p1, new CafeCommand(cafetera, "latte"), new TostadaCommand(tostadora));

        System.out.println("\n Cancelacion durante la preparacion ");
        cocina.avanzarPaso();
        mesero.cancelar(p1);

        System.out.println("\n Cancelacion antes de preparar ");
        mesero.cancelar(p2);

        System.out.println("\n Cocina continua con el siguiente pedido ");
        cocina.prepararPedidos();

        System.out.println("\n Pedido ya preparado ");
        mesero.cancelar(p3);
    }
}
