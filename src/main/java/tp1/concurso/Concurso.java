package tp1.concurso;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    static String FUERA_DE_PLAZO = "La fecha de inscripción ya ha expirado. ";
    static int idConcurso=0;
    private int id;
    private LocalDate fechaApertura;
    private LocalDate fechaLimite;
    private ArrayList<Inscripcion> inscriptos;

    public Concurso(LocalDate fechaApertura, LocalDate fechaLimite) {
        this.id = idConcurso++;
        this.fechaApertura = fechaApertura;
        this.fechaLimite = fechaLimite;
        this.inscriptos=new ArrayList<>();
    }

    public void inscribirParticipante(Participante p){
        if (estaDentroDelPlazo(LocalDate.now())){
            agregarInscripcion(new Inscripcion(p,this));
            if (esFechaDeApertura())
                p.addPuntos(10);
        }else {
            throw new RuntimeException(FUERA_DE_PLAZO);
        }
    }

    void agregarInscripcion(Inscripcion i) {
        this.inscriptos.add(i);
    }

    public boolean estaDentroDelPlazo(LocalDate fecha) {
        return fecha.isBefore(fechaLimite);
    }

    public boolean esFechaDeApertura() {
        return LocalDate.now().isEqual(fechaApertura);
    }

    public boolean existParticipante(Participante p) {
        for (Inscripcion i: inscriptos)
            if (i.isInscripcionParticipante(p))
                return true;
        return false;
    }
}