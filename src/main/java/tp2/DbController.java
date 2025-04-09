package tp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class DbController {
    protected Connection conn = null;
    protected static Properties prop = null;

	private static Properties getProperties() throws RuntimeException {
		Properties prop = new Properties();
		try {
			ResourceBundle infoDataBase = ResourceBundle.getBundle("database");
			prop.setProperty("connection", infoDataBase.getString("db.url"));
			prop.setProperty("username", infoDataBase.getString("db.user"));
			prop.setProperty("password", infoDataBase.getString("db.password"));
		} catch (Exception e1) {
			throw new RuntimeException("Ocurrio un error al leer la configuracion desde el archivo "+ e1.getMessage());
		}
		return prop;
	}
    
    protected Connection connect() throws SQLException {
        try {
        	prop = getProperties();
            conn = DriverManager.getConnection(prop.getProperty("connection"), prop.getProperty("username"),
					prop.getProperty("password"));
            if (conn == null) {throw new SQLException("Error al conectar con la base de datos");}
            conn.setAutoCommit(true);
            return conn;
        } catch (SQLException e) {
            throw new SQLException("Error al conectar con base de datos: "+ e.getMessage());
        }
    }
    
    public void disconnect() throws SQLException{
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar la sesion");
            }
        }
    }
}
