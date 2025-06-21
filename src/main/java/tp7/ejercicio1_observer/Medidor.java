package tp7.ejercicio1_observer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Medidor implements Subject {
 private ClimaOnline clima;
 private final List<Observer> observers = new ArrayList<>();

 public Medidor(ClimaOnline clima) {
  this.clima = clima;
 }

 @Override
 public void agregar(Observer o) {
  observers.add(o);
 }

 @Override
 public void quitar(Observer o) {
  observers.remove(o);
 }

 @Override
 public void notificarObserver(String temp, LocalDateTime fecha) {
  for (Observer o : observers) {
   o.notificar(temp, fecha);
  }
 }

 public String leerTemperatura() {
  String temperatura = clima.temperatura();
  LocalDateTime ahora = LocalDateTime.now();
  notificarObserver(temperatura, ahora);
  return temperatura;
 }
}
