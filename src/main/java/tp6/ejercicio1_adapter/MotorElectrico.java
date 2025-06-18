package tp6.ejercicio1_adapter;

public class MotorElectrico {
    private boolean activo = false;
    private boolean encendido;
    private double velocidadActual = 0;

    public void conectar (){
        if (activo){
            encendido = true;
            System.out.println("El motor se ha conectado");
        }
    }
    public void activar(){
        activo = true;
        System.out.println("El motor se ha activado");
    }
    public void moverMasRapido (){
        velocidadActual += 30;
        System.out.println("El motor se ha va a " + velocidadActual + " kilometros por hora");
    }
    public void detener (){
        activo = false;
        System.out.println("El motor se ha desactivado");

    }
    public void desconectar (){
        encendido = false;
        System.out.println("El motor se ha desconectado");
    }

}
