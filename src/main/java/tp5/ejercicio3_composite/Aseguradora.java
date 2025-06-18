package tp5.ejercicio3_composite;

public class Aseguradora{
    public static void main(String[] args) {
        // Seguros individuales
        Seguro seguroHogar = new seguroIndividual(5000);
        Seguro seguroAuto = new seguroIndividual(10000);
        Seguro seguroVida = new seguroIndividual(8000);
        Seguro seguroMedico = new seguroIndividual(4000);

        paqueteSeguros paqueteSeguro1 = new paqueteSeguros();

        paqueteSeguro1.agregarSeguro(seguroHogar);
        paqueteSeguro1.agregarSeguro(seguroAuto);
        System.out.println("Costo del Paquete 1: " + paqueteSeguro1.getCosto());

        paqueteSeguros paqueteSeguro2 = new paqueteSeguros();

        paqueteSeguro2.agregarSeguro(seguroHogar);
        paqueteSeguro2.agregarSeguro(seguroAuto);
        paqueteSeguro2.agregarSeguro(seguroVida);
        paqueteSeguro2.agregarSeguro(seguroMedico);
        System.out.println("Costo del Paquete 2: " + paqueteSeguro2.getCosto());
    }
}
