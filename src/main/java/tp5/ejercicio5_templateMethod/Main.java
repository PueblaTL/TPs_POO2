package tp5.ejercicio5_templateMethod;

public class Main {
    public static void main(String[] args) {
        Remera remera1 = new RemeraImportada(9000);
        Remera remera2 = new RemeraNacional(7500);

        System.out.println("Precio remera Importada: " + remera1.calcularPrecio());
        System.out.println("Precio remera Nacional: " + remera2.calcularPrecio());
    }
}