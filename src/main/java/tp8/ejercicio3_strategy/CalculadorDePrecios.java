package tp8.ejercicio3_strategy;

class CalculadorDePrecios {
    public TipoProducto tipo;


    public CalculadorDePrecios(TipoProducto tipo) {
        this.tipo = tipo;
    }
    public double precioFinal() {
        double precio = tipo.precio();
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
