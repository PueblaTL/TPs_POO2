package tp4.ejercicio1.model;

import tp7.ejercicio4_observer.ParticipanteObserver;

import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private RegistroParticipante registroParticipante;
    private List<ParticipanteObserver> observadores = new ArrayList<>();

    public Concurso(RegistroParticipante registroParticipante) {
        this.registroParticipante = registroParticipante;
    }

    public void registrarParticipante(String nombre, String telefono, String region, String email) {
        Participante participante = new Participante(nombre, telefono, region, email);
        this.registroParticipante.registrarParticipante(participante);
        notificarObservadores(participante);
    }

    public void agregarObservador(ParticipanteObserver observer) {
        observadores.add(observer);
    }

    private void notificarObservadores(Participante participante) {
        for (ParticipanteObserver observer : observadores) {
            observer.notificar(participante);
        }
    }
}
