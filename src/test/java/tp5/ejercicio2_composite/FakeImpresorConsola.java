package tp5.ejercicio2_composite;

import java.util.ArrayList;
import java.util.List;

public class FakeImpresorConsola implements ImpresorConsola {
    private final List<String> mensajes = new ArrayList<>();

    @Override
    public void println(String mensaje) {
        mensajes.add(mensaje);
    }

    public List<String> getMensajes() {
        return mensajes;
    }
}
