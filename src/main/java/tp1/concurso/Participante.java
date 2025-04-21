package tp1.concurso;

import java.util.Objects;

public class Participante {
    private int dni;
    private String nombre;
    private int puntos;

    public Participante(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.puntos = 0;
    }

    public void addPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getPuntos() {
        return puntos;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Participante that = (Participante) obj;
        return dni == that.dni;
    }

}
