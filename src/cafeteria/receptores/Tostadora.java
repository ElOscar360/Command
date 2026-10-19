package cafeteria.receptores;

public class Tostadora {
    private boolean tostando;

    public void tostarPan() {
        tostando = true;
        System.out.println("Tostadora: tostando pan");
    }

    public void reiniciar() {
        if (tostando) {
            System.out.println("Tostadora: pan retirado, limpiando tostadora");
            tostando = false;
        }
    }
}
