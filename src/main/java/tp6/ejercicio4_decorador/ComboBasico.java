package tp6.ejercicio4_decorador;

import java.util.ArrayList;
import java.util.List;

public class ComboBasico implements Combo {
    @Override
    public String getDescripcion() {
        return "Combo Básico: Hamburguesa simple y gaseosa";
    }

    @Override
    public double getPrecio() {
        return 4500;
    }
}