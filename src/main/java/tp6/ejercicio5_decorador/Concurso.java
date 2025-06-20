package tp6.ejercicio5_decorador;

public class Concurso implements RegistroDeInscripcion {
    private String id;


    public Concurso(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public void inscribirParticipante(Participante participante) {
        // Lógica base de inscripción (en memoria, etc.)
        System.out.println("Inscribiendo al participante " + participante.getId() + " en el concurso " + id);
    }
}

