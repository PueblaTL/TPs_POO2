package tp3.ejercicio4;

import org.jdbi.v3.core.Jdbi;

public class Main {

    public static void main(String[] args) {

        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");

        new SetUpDatabase(jdbi).setUp();

        var repo = new PersonaRepository(jdbi);
        var personasOpt = repo.buscarPorNombre("Vla");

        personasOpt.ifPresent(personas -> {
            for (Persona persona : personas) {
                System.out.println(persona.nombre() + " " + persona.apellido());
            }
        });

        var personaOpt = repo.buscarId(1L);
        personaOpt.ifPresent(persona -> {
            System.out.println(persona.nombre() + " " + persona.apellido());
        });
    }
}
