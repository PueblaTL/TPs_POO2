package composite2;

public class FakePrintConsola implements PrintConsola {
    private String salida = "";

    @Override
    public void println(String mensaje) {
        salida += mensaje + System.lineSeparator();
    }

    String salida() {
        return this.salida;
    }
}
