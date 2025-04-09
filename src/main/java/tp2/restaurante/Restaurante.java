package tp2.restaurante;

import java.util.ArrayList;

public class Restaurante {
    static String CAPACIDAD_MESAS_COMPLETA = "Capacidad de mesas completa";
    private int capacidad = 10;
    private ArrayList<Mesa> mesas = new ArrayList(capacidad);

    public void agregarMesa(Mesa mesa) {
        if (estaDentroCapacidad()) {
            mesas.add(mesa);
        } else {
            throw new RuntimeException(CAPACIDAD_MESAS_COMPLETA);
        }
    }

    private boolean estaDentroCapacidad() {
        return mesas.size() <= capacidad;
    }

}
