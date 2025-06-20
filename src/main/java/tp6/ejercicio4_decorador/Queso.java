package tp6.ejercicio4_decorador;

public class Queso extends Adicional {
    public Queso(Combo combo) {
        super(combo);
    }

    @Override
    public String getDescripcion() {
        return combo.getDescripcion() + ", + Queso";
    }

    @Override
    public double getPrecio() {
        return combo.getPrecio() + 450;
    }
}