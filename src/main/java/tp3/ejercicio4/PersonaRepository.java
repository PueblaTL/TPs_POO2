package tp3.ejercicio4;

import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonaRepository {

    private Jdbi jdbi;

    public PersonaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    /**
     * Busca por nombre a parte
     */
    public Optional<List<Persona>> buscarPorNombre(String nombreOParte) {
        return jdbi.withHandle(handle -> {
            var rs = handle
                    .select("select nombre, apellido from persona where nombre like ?")
                    .bind(0, "%" + nombreOParte + "%")
                    .mapToMap(String.class)
                    .list();

            if (rs.isEmpty()) {
                return Optional.empty();
            }

            var personas = rs.stream()
                    .map(map -> new Persona(map.get("nombre"), map.get("apellido")))
                    .collect(Collectors.toList());

            return Optional.of(personas);
        });
    }

    /**
     * Dado un id, retorna:
     * - null si el id no se encuentra en la BD
     * - la instancia de Persona encontrada
     */
    public Optional<Persona> buscarId(Long id) {
        return jdbi.withHandle(handle -> {
            var rs = handle
                    .select("select nombre, apellido from persona where id_persona = ?")
                    .bind(0, id)
                    .mapToMap(String.class)
                    .list();

            return rs.stream()
                    .findFirst()
                    .map(map -> new Persona(map.get("nombre"), map.get("apellido")));
        });
    }


}
