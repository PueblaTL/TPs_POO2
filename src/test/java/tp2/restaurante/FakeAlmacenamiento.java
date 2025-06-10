package tp2.restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class FakeAlmacenamiento implements Almacenamiento {
    private String ultimoDetalle;

    @Override
    public void guardarDetalle(String contenido) {
        this.ultimoDetalle = contenido;
    }

    public boolean contieneTexto(String texto) {
        return ultimoDetalle != null && ultimoDetalle.contains(texto);
    }

    public String getUltimoDetalle() {
        return ultimoDetalle;
    }
}