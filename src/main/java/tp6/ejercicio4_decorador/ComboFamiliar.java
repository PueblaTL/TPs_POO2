package tp6.ejercicio4_decorador;

public class ComboFamiliar implements Combo {
    @Override
    public String getDescripcion() {
        return "Combo Familiar: 4 Hamburguesas, 4 gaseosas y papas grandes";
    }

    @Override
    public double getPrecio() {
        return 12000;
    }
}