package Ejercicios_Repaso_Parcial2.Ejercicio_Patrones;


public class Main {
    public static void main(String[] args) {
        Ataque a1 = new AtaqueFuego(100, true, 30);
        Ataque a2 = new AtaqueAgua(90, false, 20);
        Ataque a3 = new AtaquePlanta(80, true, 10);
        Ataque a4 = new AtaqueElectrico(95, true, 25);

        System.out.println(a1.calcularDanio());
        System.out.println(a2.calcularDanio());
        System.out.println(a3.calcularDanio());
        System.out.println(a4.calcularDanio());
    }
}
