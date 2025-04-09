package tp2.concurso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Concurso {
    static String FUERA_DE_PLAZO = "El plazo para inscribirse al concurso ya termino. ";
    static int idConcurso=0;
    private int id;
    private LocalDate fechaApertura;
    private LocalDate fechaLimite;
    private ArrayList<Inscripcion> inscriptos;

    private EscritorArchivo escritorArchivo; //Inyección de dependencia
    private Almacenamiento almacenamiento;

    public Concurso(LocalDate fechaApertura, LocalDate fechaLimite, EscritorArchivo escritorArchivo) {
        this.id = idConcurso++;
        this.fechaApertura = fechaApertura;
        this.fechaLimite = fechaLimite;
        this.inscriptos=new ArrayList<>();
        this.escritorArchivo = escritorArchivo; //Inyección de dependencia
    }
    public Concurso(LocalDate fechaApertura, LocalDate fechaLimite, Almacenamiento almacenamiento) {
        this.id = idConcurso++;
        this.fechaApertura = fechaApertura;
        this.fechaLimite = fechaLimite;
        this.inscriptos=new ArrayList<>();
        this.almacenamiento = almacenamiento; //Inyección de dependencia
    }

    public void inscribirParticipante(Participante p){
        if (estaDentroDelPlazo(LocalDate.now())){
            Inscripcion nuevaInscripcion = new Inscripcion(p,this);
            agregarInscripcion(nuevaInscripcion);
            guardarEnArchivo(nuevaInscripcion); // Uso de la abstracción para guardar en archivo
            if (esFechaDeApertura())
                p.addPuntos(10);
        }else {
            throw new RuntimeException(FUERA_DE_PLAZO);
        }
    }

    private void guardarEnArchivo(Inscripcion inscripcion) {
        String formatoFecha = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
        String fechaInscripcion = inscripcion.getFechaInscripcion().format(formatter);
        String linea = "Fecha de Inscripción: " + fechaInscripcion +
                "\nID Inscripción: " + inscripcion.getIdInscripcion() +
                "\nID Concurso: " + this.id+
                "\nFecha Límite: " + fechaLimite.format(formatter) +
                "\nFecha Apertura: "+fechaApertura.format(formatter)+"\n";

        //escritorArchivo.guardarInscripcion(linea); //Escribir en Disco
        almacenamiento.guardarInscripcion(linea); //Escribir en BD
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