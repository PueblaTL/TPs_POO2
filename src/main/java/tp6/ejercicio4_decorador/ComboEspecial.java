package tp6.ejercicio4_decorador;

public class ComboEspecial implements Combo {
    @Override
    public String getDescripcion() {
        return "Combo Especial: Hamburguesa completa, gaseosa, papas y postre";
    }

    @Override
    public double getPrecio() {
        return 6000;
    }
}