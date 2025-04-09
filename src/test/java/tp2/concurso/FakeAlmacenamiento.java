package tp2.concurso;
public class FakeAlmacenamiento implements Almacenamiento{
    private String info;

    @Override
    public void guardarInscripcion(String info) {
        this.info = info;
    }

    public boolean startWith (String inicio) {
        return this.info.startsWith(inicio);
    }
}