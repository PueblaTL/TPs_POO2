package tp8.ejercicio3_strategy;

public class MEDICINA implements TipoProducto {
    private double precio;

    public MEDICINA (double precio){
        this.precio = precio;
    }
    @Override
    public double impuestos() {
        return 0;
    }

    @Override
    public double descuentos() {
        double descuentos = 0;
        if (precio > 50){
            descuentos = 0.1; }
        return descuentos;
    }

    @Override
    public boolean envioGratis() {
        return precio > 100;
    }
}