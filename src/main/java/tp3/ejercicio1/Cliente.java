package tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static final double COEFICIENTE_DIAS_ALQUILADOS_REGULARES = 1.5;
    public static final int COEFICIENTE_DIAS_ALQUILADOS_NUEVO_LANZAMIENTO = 3;
    public static final double COEFICIENTE_DIAS_ALQUILADOS_INFANTILES = 1.5;
    public static final double COEFICIENTE_MONTO_BASE_INFANTILES = 1.5;
    public static final int COEFICIENTE_MONTO_BASE_NUEVO_LANZAMIENTO = 0;
    public static final int COEFICIENTE_MONTO_BASE_REGULARES = 2;
    private List<Alquiler> alquileres = new ArrayList<Alquiler>();
    private String name;

    public Cliente(String nombre) {
        this.name = nombre;
    }

    public double calcularDeuda() {
        double deuda = 0;
        for (Alquiler alquiler : alquileres) {
            double monto = 0;
            // determine amounts for each line
            switch (alquiler.copia().obtenerCopiaLibro().codigoPrecio()) {
                case Libro.REGULARES:
                    monto += COEFICIENTE_MONTO_BASE_REGULARES;
                    if (alquiler.diasAlquilados() > 2)
                        monto += (alquiler.diasAlquilados() - 2) * COEFICIENTE_DIAS_ALQUILADOS_REGULARES;
                    break;
                case Libro.NUEVO_LANZAMIENTO:
                    monto += COEFICIENTE_MONTO_BASE_NUEVO_LANZAMIENTO;
                    monto += alquiler.diasAlquilados() * COEFICIENTE_DIAS_ALQUILADOS_NUEVO_LANZAMIENTO;
                    break;
                case Libro.INFANTILES:
                    monto += COEFICIENTE_MONTO_BASE_INFANTILES;
                    if (alquiler.diasAlquilados() > 3)
                        monto += (alquiler.diasAlquilados() - 3) * COEFICIENTE_DIAS_ALQUILADOS_INFANTILES;
                    break;
            }
            deuda += monto;
        }
        return deuda;
    }

    public int calcularPuntosObtenidos() {
        int puntosAlquilerFrecuente = 0;
        // sumo puntos por alquiler
        // bonus por dos días de alquiler de un nuevo lanzamiento
        for (Alquiler alquiler : alquileres) {
            puntosAlquilerFrecuente ++;
            if ((alquiler.copia().obtenerCopiaLibro().codigoPrecio() == Libro.NUEVO_LANZAMIENTO)
                    && alquiler.diasAlquilados() > 1) {
                puntosAlquilerFrecuente++;
            }
        }
        return puntosAlquilerFrecuente;
    }

    public void alquilar(Alquiler rental) {
        alquileres.add(rental);
    }
}