package tp2.restaurante;

public class Comensal {
    private int dni;
    private String nombre;

    public Comensal(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public void seleccionarMesa(Mesa mesa) {
        mesa.sentarComensal(this);
    }
}
