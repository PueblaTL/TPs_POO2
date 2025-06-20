package tp6.ejercicio5_decorador;

public class Participante {
    private String id;
    private String email;

    public Participante(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
