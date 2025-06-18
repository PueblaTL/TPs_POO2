package tp6.ejercicio1_adapter;

public class MotorEconomico implements Motor {
    private double velocidadActual = 0;
    private boolean encendido;


    @Override
    public void arrancar() {
        this.encendido = true;
        System.out.println("El motor arranco");

    }

    @Override
    public void acelerar() {
        this.velocidadActual += 10;
        System.out.println("El motor se ha va a " + velocidadActual + " kilometros por hora");
    }

    @Override
    public void apagar() {
        this.encendido = false;
        System.out.println("El motor se apago");
    }
}
