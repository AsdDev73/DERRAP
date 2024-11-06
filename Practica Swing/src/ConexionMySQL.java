import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class ConexionMySQL {
	
	//variables base de datos 
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/derrap";
	private static final String Usuario="root";
	private static final String psw="Medac123";
	
	Connection con=null;
	Statement stm = null;
	ResultSet rs=null;
		
	
	
    //metodo para conectar a la base de datos 
    public void conectar() throws SQLException, ClassNotFoundException {
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,  Usuario, psw);   
    }
	
	//Metodo para cerrar la conexion 
    public void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //Metodo para hacer el login 
    
    public int LogIn(String user,String contra ) throws SQLException {
    	int rol=0;
    	String consulta ="Select * from Usuarios WHERE ID_Usuario = "+ user;
    	stm=con.createStatement();
    	if(rs!=null) {
    		if (rs.next()) {
        		String storedPassword = rs.getString("Contraseña");
        		if (storedPassword.equals(contra)) {
        			return rs.getInt("Rol");
        			} 
        		else {
        			rol= 4; // Contraseña incorrecta 
        			} 
        	} 	
    	}
    	else { 
    			rol= 3; // Usuario no encontrado
    			}
    	
    	stm.close();
		con.close();
    	
    	
    	return rol;
    		}
    	
		
    }

    


