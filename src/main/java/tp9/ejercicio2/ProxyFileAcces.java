package tp9.ejercicio2;
import java.io.IOException;

public class ProxyFileAcces implements AccesoArchivos {
    private FileAccess fileAccess;
    private Usuario usuario;


    public ProxyFileAcces(FileAccess file, Usuario usuario) {
        this.fileAccess = file;
        this.usuario = usuario;

    }

    @Override
    public String readFile() throws IOException {
        try {
            if (!esArchivoRestringido()) {
                return this.fileAccess.readFile();
            } else if (tienePermisoModerado() || tienePermisoAdmin()) {
                return this.fileAccess.readFile();
            } else {
                throw new RuntimeException("El usuario: " + usuario.obtenerNombre() + " no tiene permisos para leer el archivo");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean esArchivoRestringido() {
        return this.fileAccess.empiezaCon("m") || fileAccess.empiezaCon("i");
    }

    private boolean tienePermisoModerado() {
        return fileAccess.empiezaCon("m") && (usuario.poseePermiso(Permiso.ADMIN) || usuario.poseePermiso(Permiso.INTERMEDIO));
    }

    private boolean tienePermisoAdmin() {
        return fileAccess.empiezaCon("i") && usuario.poseePermiso(Permiso.ADMIN);
    }
}
