
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sesion {
    
	String idDB,nameDB,pswBD,rolDB;
    
    boolean inicioSesion(String idIngresado, String pswIngresada){
    	 try(Connection con = ConexionDB.conectar()){
    	        PreparedStatement ps = con.prepareStatement(
    	        """
    	        SELECT id,
    	        name,
    	        psw,
    	        rol
    	        FROM usuarios
    	        WHERE id = ?
    	        """
    	        );

    	        ps.setString(1,idIngresado);
    	        ResultSet rs =ps.executeQuery();
    	        if(rs.next()) {
    	        	idDB = rs.getString("id");
    	            pswBD = rs.getString("psw");
    	            if(pswBD.equals(pswIngresada)){
    	            	nameDB = rs.getString("name");
    	            	rolDB = rs.getString("rol"); 
    	                return true;
    	            }
    	            else {
    	            	System.out.println("Contraseña incorrecta");
    	            	return false;
    	            }	
    	        }
    	        else {
    	            System.out.println("Usuario no existe");
    	            return false;
    	        }	        
    	    }
    	    catch(SQLException ex){
    	        ex.printStackTrace();
    	        return false;
    	    }
    }   
    void cerrarSesion() {
    	
    }
    
}
   
    

    



