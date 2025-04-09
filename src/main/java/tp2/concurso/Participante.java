package tp2.concurso;

public class Participante {
    private int dni;
    private String email;
    private String nombre;
    private int puntos;

    public Participante(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.puntos = 0;
    }
    public Participante(int dni, String nombre, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.puntos = 0;
        this.email = email;
    }

    public void addPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
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
