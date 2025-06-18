package tp5.ejercicio3_composite;

import java.util.ArrayList;
import java.util.List;

public class paqueteSeguros implements Seguro {
    private List<Seguro> seguros = new ArrayList<>();

    public void agregarSeguro(Seguro seguro) {
        seguros.add(seguro);
    }

    @Override
    public int getCosto() {
        int total = 0;
        int cantidadSeguros = 0;

        for (Seguro s : seguros) {
            total += s.getCosto();
            cantidadSeguros++;
        }

        // 5% de descuento por cada seguro (acumulativo)
        double descuento = 1 - (0.05 * cantidadSeguros);
        return (int) Math.round(total * descuento);
    }

    @Override
    public String toString() {
        return "Paquete con " + seguros.size() + " seguros";
    }
}
