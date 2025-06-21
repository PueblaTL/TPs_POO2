package tp8.ejercicio3_strategy;

public class LIBRO implements TipoProducto {
    private double precio;

    public LIBRO (double precio){
        this.precio = precio;
    }
    @Override
    public double impuestos() {
        return 0.1;
    }

    @Override
    public double descuentos() {
        return 0.1;
    }

    @Override
    public boolean envioGratis() {
        return precio > 100;
    }
    @Override
    public double precio() {
        return precio;
    }
}
