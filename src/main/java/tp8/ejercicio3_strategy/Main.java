package tp8.ejercicio3_strategy;

public class Main {
    public static void main(String[] args) {
        var p1 = new CalculadorDePrecios(new ALIMENTO(300));
        var p2 = new CalculadorDePrecios(new MEDICINA(150));
        var p3 = new CalculadorDePrecios(new LIBRO(200));
        var p4 = new CalculadorDePrecios(new OTRO(130));
        System.out.println(p1.precioFinal());
        System.out.println(p2.precioFinal());
        System.out.println(p3.precioFinal());
        System.out.println(p4.precioFinal());
    }
}