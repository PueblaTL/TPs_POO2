package tp8.ejercicio3_strategy;

class CalculadoraProducto {
    public TipoProducto tipo;
    public double precio;

    public CalculadoraProducto(TipoProducto tipo) {
        this.tipo = tipo;
    }
    public double precioFinal() {
        double impuestos = tipo.impuestos();
        double descuentos = tipo.descuentos();
        boolean envioGratis = tipo.envioGratis();


        double total = precio * (1 + impuestos) * (1 - descuentos);
        if (envioGratis) {
            total -= 10;
        }
        return total;
    }
}
