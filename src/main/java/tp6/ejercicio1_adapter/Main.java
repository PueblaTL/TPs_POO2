package tp6.ejercicio1_adapter;

public class Main {
    public static void main(String[] args) {
     MotorElectrico motorElectrico = new MotorElectrico();
     AdapterMotorElectrico adaptadorMotorElectrico = new AdapterMotorElectrico(motorElectrico);
     adaptadorMotorElectrico.arrancar();
     adaptadorMotorElectrico.acelerar();
     adaptadorMotorElectrico.apagar();
     adaptadorMotorElectrico.acelerar();
     adaptadorMotorElectrico.acelerar();
    }
}
