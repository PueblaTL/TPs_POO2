package tp6.ejercicio4_decorador;

public class Papas extends Adicional {
    public Papas(Combo combo) {
        super(combo);
    }

    @Override
    public String getDescripcion() {
        return combo.getDescripcion() + ", + Papas";
    }

    @Override
    public double getPrecio() {
        return combo.getPrecio() + 600;
    }
}
