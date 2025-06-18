package tp6.ejercicio1_adapter;

public class AdapterMotorElectrico implements Motor {
    private MotorElectrico motor;

    public AdapterMotorElectrico (MotorElectrico motor){
        this.motor = motor;
    }
    @Override
    public void arrancar() {
        motor.activar();
        motor.conectar();
    }

    @Override
    public void acelerar() {
        motor.moverMasRapido();
    }

    @Override
    public void apagar() {
        motor.detener();
        motor.desconectar();
    }
}
