package tp6.ejercicio4_decorador;

public class Carne extends Adicional {
    public Carne(Combo combo) {
        super(combo);
    }

    @Override
    public String getDescripcion() {
        return combo.getDescripcion() + ", + Carne";
    }

    @Override
    public double getPrecio() {
        return combo.getPrecio() + 300;
    }
}

