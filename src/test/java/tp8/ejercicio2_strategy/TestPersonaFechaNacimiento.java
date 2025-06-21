package tp8.ejercicio2_strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonaFechaNacimiento {

    private Persona persona;
    private LocalDate fechaEjemplo;

    @BeforeEach
    public void setUp() {
        fechaEjemplo = LocalDate.of(1986, 6, 3);
        persona = new Persona(fechaEjemplo, new fechaLarga());
    }

    @Test
    public void testFormatoCorto() {
        // Arrange
        persona.setFormatoFecha(new fechaCorta());

        // Act
        String fechaFormateada = persona.fechaNacimiento();

        // Assert
        assertEquals("03/06/1986", fechaFormateada,
                "El formato corto debe ser día-mes-año con mes en 2 dígitos");
    }

    @Test
    public void testFormatoLargo() {
        // Arrange
        persona.setFormatoFecha(new fechaLarga());

        // Act
        String fechaFormateada = persona.fechaNacimiento();

        // Assert
        assertEquals("3 de junio de 1986", fechaFormateada,
                "El formato largo debe incluir el nombre del mes en español");
    }

}