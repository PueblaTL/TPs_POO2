package tp6.ejercicio5_decorador;

public abstract class ConcursoDecorator implements RegistroDeInscripcion {
    protected RegistroDeInscripcion concurso;

    public ConcursoDecorator(RegistroDeInscripcion concurso) {
        this.concurso = concurso;
    }

    @Override
    public void inscribirParticipante(Participante participante) {
        concurso.inscribirParticipante(participante);
    }
}
