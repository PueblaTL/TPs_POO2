package tp8.ejercicio3_strategy;

public class ALIMENTO implements TipoProducto {
    private double precio;

    public ALIMENTO (double precio){
        this.precio = precio;
    }

    @Override
    public double impuestos() {
        return 0.05;
    }

    @Override
    public double descuentos() {
        double descuentos = 0;
        if (precio > 100) {
            descuentos = 0.15;
        }
        return descuentos;
    }

    @Override
    public boolean envioGratis() {
        return precio > 200;
    }
    @Override
    public double precio() {
        return precio;
    }
}
