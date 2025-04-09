package tp2.restaurante.persistance;

import tp2.DbController;
import tp2.restaurante.Almacenamiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlmacenamientoBaseDatosRestaurante extends DbController implements Almacenamiento {
    @Override
    public void guardarDetalle(String contenido) {
        try (Connection conn = connect()) {
            // Dividir el contenido en base al formato proporcionado
            String[] datos = contenido.split("\n");
            int idMesa = Integer.parseInt(datos[0].split(":")[1].trim().replace("Pago realizado para la mesa ", ""));
            String fechaPago = datos[1].split(":")[1].trim();                                   // "Fecha de Pago: dd/MM/yyyy"
            double totalAntesDescuento = Double.parseDouble(datos[2].split("\\$")[1].trim().replace(",", "."));
            // "Total antes del descuento: $X.XX"
            double descuentoAplicado = Double.parseDouble(datos[3].split("\\$")[1].trim().replace(",", "."));     // "Descuento aplicado: $X.XX"
            double propina = Double.parseDouble(datos[4].split("\\$")[1].trim().replace(",", "."));               // "Propina (X%): $X.XX"
            double totalFinal = Double.parseDouble(datos[5].split("\\$")[1].trim().replace(",", "."));            // "Total final: $X.XX"

            // Query para insertar los datos
            String sql = "INSERT INTO pagos (id_mesa, fecha_pago, total_antes_descuento, descuento_aplicado, propina, total_final) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idMesa);
                stmt.setDate(2, java.sql.Date.valueOf(LocalDate.parse(fechaPago, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                stmt.setDouble(3, totalAntesDescuento);
                stmt.setDouble(4, descuentoAplicado);
                stmt.setDouble(5, propina);
                stmt.setDouble(6, totalFinal);

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar el pago en la base de datos: " + e.getMessage());
        }
    }
}

/*
CREATE DATABASE IF NOT EXISTS poo2_db;
Use poo2_db;
CREATE TABLE pagos (
        id_pago INT AUTO_INCREMENT PRIMARY KEY, -- ID único del pago
               id_mesa INT NOT NULL, -- ID de la mesa
               fecha_pago DATE NOT NULL, -- Fecha del pago
              total_antes_descuento DOUBLE NOT NULL, -- Total antes del descuento
               descuento_aplicado DOUBLE NOT NULL, -- Descuento aplicado
    propina DOUBLE NOT NULL, -- Propina aplicada
    total_final DOUBLE NOT NULL -- Total final después de descuento y propina
);

SELECT * FROM pagos;

TRUNCATE TABLE pagos;
 */