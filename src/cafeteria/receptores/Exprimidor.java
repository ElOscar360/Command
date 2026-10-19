package cafeteria.receptores;

public class Exprimidor {
    private boolean exprimiendo;

    public void exprimirNaranja() {
        exprimiendo = true;
        System.out.println("Exprimidor: exprimiendo naranjas");
    }

    public void reiniciar() {
        if (exprimiendo) {
            System.out.println("Exprimidor: jugo descartado, limpiando exprimidor");
            exprimiendo = false;
        }
    }
}
