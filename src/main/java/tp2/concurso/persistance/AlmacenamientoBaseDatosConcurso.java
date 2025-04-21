package tp2.concurso.persistance;

import tp2.DbController;
import tp2.concurso.Almacenamiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlmacenamientoBaseDatosConcurso extends DbController implements Almacenamiento {
    @Override
    public void guardarInscripcion(String contenido) {
        try (Connection conn = connect()) {
            // Dividir el contenido en base al formato proporcionado
            String[] datos = contenido.split("\n");
            String fechaInscripcion = datos[0].split(":")[1].trim();                // "Fecha de Inscripción: dd/MM/yyyy"
            int idInscripcion = Integer.parseInt(datos[1].split(":")[1].trim());    // "ID Inscripción: ID"
            int idConcurso = Integer.parseInt(datos[2].split(":")[1].trim());       // "ID Concurso: ID"
            String fechaLimite = datos[3].split(":")[1].trim();                     // "Fecha Límite: dd/MM/yyyy"
            String fechaApertura = datos[4].split(":")[1].trim();                   // "Fecha Apertura: dd/MM/yyyy"

            // Query para insertar los datos
            String sql = "INSERT INTO inscripciones (id_inscripcion, fecha_inscripcion, id_concurso, fecha_limite, fecha_apertura) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idInscripcion);
                stmt.setDate(2, java.sql.Date.valueOf(LocalDate.parse(fechaInscripcion, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                stmt.setInt(3, idConcurso);
                stmt.setDate(4, java.sql.Date.valueOf(LocalDate.parse(fechaLimite, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                stmt.setDate(5, java.sql.Date.valueOf(LocalDate.parse(fechaApertura, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar la inscripción en la base de datos: " + e.getMessage());
        }
    }

}

/*
USE poo2_db;
CREATE TABLE inscripciones (
			  id_inscripcion INT AUTO_INCREMENT PRIMARY KEY , -- ID único de la inscripción
               fecha_inscripcion DATE NOT NULL, -- Fecha de inscripción
              id_concurso INT NOT NULL, -- ID del concurso
                fecha_limite DATE NOT NULL, -- Fecha límite del concurso
              fecha_apertura DATE NOT NULL -- Fecha de apertura del concurso
);
SELECT * FROM inscripciones;
TRUNCATE TABLE inscripciones;
 */