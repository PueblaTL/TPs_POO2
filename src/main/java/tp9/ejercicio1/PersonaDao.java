package tp9.ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PersonaDao {
    
    private Connection obtenerConexion() {
        return ConnectionManager.getConnection();
    }

    public Persona personaPorId(int id) {
        String sql = "SELECT p.nombre FROM Personas p WHERE p.id = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String nombrePersona = result.getString("nombre");
                return new Persona(id, nombrePersona, new ProxySet(this, id));
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Set<Telefono> personaTelefono(int id) {
        String sql = "select t.numero "
                + "from personas p, Telefonos t "
                + "where p.id = t.idPersona and p.id = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement =
                     conn.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Set<Telefono> telefonos = new HashSet<>();

            while (result.next()) {
                telefonos.add(new Telefono(result.getString(1)));
            }
            return telefonos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

