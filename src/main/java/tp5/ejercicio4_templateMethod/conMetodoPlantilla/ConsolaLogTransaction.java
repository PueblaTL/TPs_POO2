package tp5.ejercicio4_templateMethod.conMetodoPlantilla;

public class ConsolaLogTransaction implements LogTransaction {
    @Override
    public void log(String nombreClase) {
        System.out.println("Transacción registrada desde: " + nombreClase);
    }
}
