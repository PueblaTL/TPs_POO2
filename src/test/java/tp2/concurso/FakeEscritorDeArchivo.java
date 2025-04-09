package tp2.concurso;

public class FakeEscritorDeArchivo implements EscritorArchivo{
    private String info;

    @Override
    public void guardarInscripcion(String info) {
        this.info = info;
    }

    public boolean startWith (String inicio) {
        return this.info.startsWith(inicio);
    }
}
