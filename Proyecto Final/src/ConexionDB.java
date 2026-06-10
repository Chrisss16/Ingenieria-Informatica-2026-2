import java.sql.*;

public class ConexionDB {
	
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:almacen.db");
    }
}
