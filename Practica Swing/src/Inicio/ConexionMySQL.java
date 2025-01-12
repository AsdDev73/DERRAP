package Inicio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class ConexionMySQL {
	
	//variables base de datos 
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/derrap";
	private static final String Usuario="root";
	private static final String psw="Medac123";
	
	Connection con=null;
	PreparedStatement pstmt = null;
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
    
    public int logIn(String user, String contra) throws SQLException {
        int rol = 0;

        // Convertir el usuario a un ID numérico solo si es un número
        int id;
        try {
            id = Integer.parseInt(user);
        } catch (NumberFormatException e) {
            return 3; // Usuario no encontrado, ya que el ID no es un número
        }

        String consulta = "SELECT * FROM Usuarios WHERE ID_Usuario = ?";
        
        try (PreparedStatement pstmt = con.prepareStatement(consulta)) {
            pstmt.setInt(1, id);  
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("Contraseña");
                    if (storedPassword.equalsIgnoreCase(contra)) {
                        rol = rs.getInt("Rol"); 
                    } else {
                        rol = 4; // Contraseña incorrecta
                    }
                } else {
                    rol = 3; // Usuario no encontrado
                }
            }
        }
        return rol;
    }

    
    //metodo para insertar clientes
    public int insetarClientes(String dni,String nombre, String apellido, String telefono) throws SQLException {
        
        String consulta = "INSERT INTO "+ "Cliente" +"(DNI, Nombre, Apellido, Tlf) VALUES (?, ?, ?, ?)";
        
         PreparedStatement pstmt = con.prepareStatement(consulta);
        //le paso los parametros a la consulta sustityendo los ?
           pstmt.setString(1, dni);
           pstmt.setString(2, nombre);
           pstmt.setString(3, apellido);
           pstmt.setString(4, telefono);
           //ejecuto el insert
            int insert = pstmt.executeUpdate();
            //devuelvo las columnas que han sido afectadas con el insert
           return  insert;
    	
    }
    
    //metodo que pasandole la consulta devuelve el cunrsor con los datos 
    public ResultSet ejecutarSelect( String Consulta) throws SQLException {
       Statement stmt =  con.createStatement();
       ResultSet rset = stmt.executeQuery(Consulta);
       return rset;
   }
    }

    


