package tp7.ejercicio2_observer;

import tp7.ejercicio1_observer.Observer;

import java.time.LocalDateTime;

public class ConsolaObserver implements Observer {

    @Override
    public void notificar(String temperatura, LocalDateTime fecha) {
        try {
            // 1) Reemplazo coma por punto
            String num = temperatura.replace(',', '.').split(" ")[0];
            double valor = Double.parseDouble(num);

            if (valor < 12) {
                System.out.println("Hace frío, se encenderá la caldera");
            } else if (valor > 17) {
                System.out.println("Hace calor, se encenderá el aire acondicionado");
            } else {
                System.out.println("Temperatura agradable: " + temperatura);
            }
        } catch (NumberFormatException e) {
            System.out.println("No se pudo interpretar la temperatura: " + temperatura);
        }
    }
}
