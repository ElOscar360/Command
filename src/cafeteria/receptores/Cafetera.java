package cafeteria.receptores;

public class Cafetera {
    private String enProceso;

    public void prepararCafe(String tipo) {
        enProceso = tipo;
        System.out.println("Cafetera: preparando " + tipo);
    }

    public void reiniciar() {
        if (enProceso != null) {
            System.out.println("Cafetera: " + enProceso + " descartado, limpiando cafetera");
            enProceso = null;
        }
    }
}
