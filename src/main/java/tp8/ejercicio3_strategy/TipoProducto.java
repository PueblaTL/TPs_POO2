package tp8.ejercicio3_strategy;

public interface TipoProducto {
    double impuestos ();
    double descuentos ();
    boolean envioGratis ();
    double precio();
}
