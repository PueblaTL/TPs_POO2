CREATE DATABASE IF NOT EXISTS POO2_TPS;
USE POO2_TPS;
 

CREATE TABLE Personas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Telefonos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(20) NOT NULL,
    idPersona INT,
    FOREIGN KEY (idPersona) REFERENCES Personas(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

INSERT INTO Personas (nombre) VALUES ('Juan Pérez');
INSERT INTO Telefonos (numero, idPersona) VALUES ('123456789', 1);
INSERT INTO Telefonos (numero, idPersona) VALUES ('987654321', 1);
INSERT INTO Telefonos (numero, idPersona) VALUES ('123456789', 1);
INSERT INTO Telefonos (numero, idPersona) VALUES ('987654321', 1);


SELECT * FROM Personas;
