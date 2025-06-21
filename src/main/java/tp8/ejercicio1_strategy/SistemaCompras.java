package tp8.ejercicio1_strategy;

public class SistemaCompras {
    private CarritoCompras carrito;
    private CalculadorEnvio calculadorEnvio;
    
    public SistemaCompras() {
        this.carrito = new CarritoCompras();
    }
    
    public void agregarProducto(Producto producto) {
        carrito.agregarProducto(producto);
    }
    
    public void seleccionarFormaEnvio(EstrategiaEnvio estrategia) {
        this.calculadorEnvio = new CalculadorEnvio(estrategia);
    }
    
    public double calcularCostoTotal(String destino) {
        if (calculadorEnvio == null) {
            throw new IllegalStateException("Debe seleccionar una forma de envío");
        }
        
        double precioProductos = carrito.calcularPrecioTotal();
        double pesoTotal = carrito.calcularPesoTotal();
        double costoEnvio = calculadorEnvio.calcularCostoEnvio(destino, pesoTotal);
        
        return precioProductos + costoEnvio;
    }
    public double obtenerCostoEnvio(String destino) {
        if (calculadorEnvio == null) {
            throw new IllegalStateException("Debe seleccionar una forma de envío");
        }

        double pesoTotal = carrito.calcularPesoTotal();
        return calculadorEnvio.calcularCostoEnvio(destino, pesoTotal);
    }
}
    