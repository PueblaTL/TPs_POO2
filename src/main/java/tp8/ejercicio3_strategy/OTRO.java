package tp8.ejercicio3_strategy;

public class OTRO implements TipoProducto {
    private double precio;

    public OTRO (double precio){
        this.precio = precio;
    }
    @Override
    public double impuestos() {
        return 0.15;
    }

    @Override
    public double descuentos() {
        if (precio > 50){
            return 0.05;
        }
        return 0;
    }

    @Override
    public boolean envioGratis() {
        return precio > 200;
    }
}
