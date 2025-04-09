package tp1.restaurante;

public class TarjetaCredito {
    private String titular;
    private String numeroTarjeta;
    private String fechaVencimiento;
    private String tipo;
    private int codigoSeguridad;

    public TarjetaCredito(String titular, String numeroTarjeta, String fechaVencimiento, String tipo, int codigoSeguridad) {
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.tipo = tipo;
        this.codigoSeguridad = codigoSeguridad;
    }

    public boolean esTipo(String tipo) {
        return (this.tipo==tipo);
    }
}