package tp5.ejercicio4_templateMethod.conMetodoPlantilla;


public abstract class Calculador {
    LogTransaction log;
    int mesEnPromocion;

    public Calculador(LogTransaction log, int mes) {
        this.log = log;
        this.mesEnPromocion = mes;
    }

    public final double calcularPrecio(double precioProducto){
        double precioTotal = precioProducto + (precioProducto * calcularVariantePrecio());
        log.log(this.getClass().getName() + " | Precio: " + precioTotal);
        return precioTotal;
    }

    abstract double calcularVariantePrecio(); //Retorna un coeficiente de la variación del precio según si es Mes de Promoción
}