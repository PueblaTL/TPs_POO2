package tp6.ejercicio4_decorador;

public class Tomate extends Adicional {
    public Tomate(Combo combo) {
        super(combo);
    }

    @Override
    public String getDescripcion() {
        return combo.getDescripcion() + ", + Tomate";
    }

    @Override
    public double getPrecio() {
        return combo.getPrecio() + 300;
    }
}


