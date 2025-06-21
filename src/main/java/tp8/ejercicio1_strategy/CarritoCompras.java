package tp8.ejercicio1_strategy;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    private List<Producto> productos;
    
    public CarritoCompras() {
        this.productos = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    public double calcularPrecioTotal() {
        return productos.stream()
                       .mapToDouble(Producto::getPrecio)
                       .sum();
    }
    
    public double calcularPesoTotal() {
        return productos.stream()
                       .mapToDouble(Producto::getPeso)
                       .sum();
    }
    
    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }
}
