package tp7.ejercicio1_observer;


public interface Subject {
    void agregar(Observer o);
    void quitar(Observer o);
    void notificarObserver(String temperatura, java.time.LocalDateTime fecha);
}
