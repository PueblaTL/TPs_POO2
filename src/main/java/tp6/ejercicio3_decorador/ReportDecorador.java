package tp6.ejercicio3_decorador;

import java.io.File;

public abstract class ReportDecorador implements Exportador {
    protected Exportador decorado;

    public ReportDecorador(Exportador decorated) {
        this.decorado = decorated;
    }

    @Override
    public abstract void exportar(File file);
}
