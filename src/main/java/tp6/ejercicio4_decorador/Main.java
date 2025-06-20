package tp6.ejercicio4_decorador;

public class Main {
    public static void main(String[] args) {
        Combo pedido = new ComboBasico();
        pedido = new Queso(pedido);
        pedido = new Tomate(pedido);
        pedido = new Carne(pedido);

        Combo pedido2 = new ComboFamiliar();
        pedido2 = new Queso(pedido2);
        pedido2 = new Papas(pedido2);
        pedido2 = new Papas(pedido2);

        System.out.println("Detalle del pedido:");
        System.out.println(pedido.getDescripcion());
        System.out.println("Precio total: $" + pedido.getPrecio());
        System.out.println(pedido2.getDescripcion());
        System.out.println("Precio total: $" + pedido2.getPrecio());



    }
}
