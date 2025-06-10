package tp5.ejercicio_adicional_templateMethod;

public class Main {
        public static void main(String[] args) {
            Producto p1 = new Libro(30);
            Producto p2 = new Medicina(330);
            Producto p3 = new Alimento(130);
            Producto p4 = new OtroProducto(130);

            System.out.println(p1.precioFinal());
            System.out.println(p2.precioFinal());
            System.out.println(p3.precioFinal());
            System.out.println(p4.precioFinal());
        }
}
