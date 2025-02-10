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
	
	public Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
		
	String precio;
	
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
                    if (storedPassword.equals(contra)) {
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
    // Metodo updatear
    public void update(String consulta) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(consulta);
        pstmt.executeUpdate();
    }
    
	//metodo para obtener el nombre del usuario
	public String getNombre(String usuario2) throws SQLException {
		String nombre="";
		
		String consulta="SELECT usuario from Usuarios WHERE ID_Usuario = ?" ;
		 PreparedStatement pstmt = con.prepareStatement(consulta);
		 pstmt.setString(1, usuario2);
		 try (ResultSet rs = pstmt.executeQuery()) {
		 if(rs.next()) {
			 nombre=rs.getString("Usuario");
		 }
		 }
		return nombre;
}
    
    //metodo para insertar clientes
    public int insetarClientes(String dni,String nombre, String apellido, String telefono) throws SQLException {
        
        String consulta = "INSERT INTO "+ "Cliente" +"(DNI, Nombre, Apellido, Tlf) VALUES (?, ?, ?, ?)";
        
         PreparedStatement pstmt = con.prepareStatement(consulta);
        //le paso los parametros a la consulta sustituyendo los ?
           pstmt.setString(1, dni);
           pstmt.setString(2, nombre);
           pstmt.setString(3, apellido);
           pstmt.setString(4, telefono);
           //ejecuto el insert
            int insert = pstmt.executeUpdate();
            //devuelvo las columnas que han sido afectadas con el insert
           return  insert;
    	
    }
    
  //metodo para insertar Mecanico
    public int insetarMecanico(String dni,String nombre, String apellido, String telefono) throws SQLException {
        
        String consulta = "INSERT INTO "+ "Mecanico" +"(DNI, Nombre, Apellido, Tlf, Estado) VALUES (?, ?, ?, ?, ?)";
        
         PreparedStatement pstmt = con.prepareStatement(consulta);
        //le paso los parametros a la consulta sustituyendo los ?
           pstmt.setString(1, dni);
           pstmt.setString(2, nombre);
           pstmt.setString(3, apellido);
           pstmt.setString(4, telefono);
           pstmt.setString(5, "Disponible");
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
    
    public int ejecutarUpdateCliente(String dni,String nombre, String apellido, String telefono) throws SQLException{
        String consulta = "UPDATE Cliente SET Nombre = ?, Apellido = ?, Tlf = ? WHERE dni = ?;";
        PreparedStatement pstmt = con.prepareStatement(consulta);
        pstmt.setString(4, dni);
        pstmt.setString(1, nombre);
        pstmt.setString(2, apellido);
        pstmt.setString(3, telefono);
         int update = pstmt.executeUpdate();
        return update;
     } 
    public int ejecutarUpdateMecanico(String n_empleado,String nombre, String apellido, String telefono, String dni) throws SQLException{
        String consulta = "UPDATE Mecanico SET Nombre = ?, Apellido = ?, Tlf = ?, dni = ? WHERE N_empleado = ?;";
        PreparedStatement pstmt = con.prepareStatement(consulta);
        pstmt.setString(5, n_empleado);
        pstmt.setString(1, nombre);
        pstmt.setString(2, apellido);
        pstmt.setString(3, telefono);
        pstmt.setString(4, dni);
         int update = pstmt.executeUpdate();
        return update;
     }
    public int ejecutarDeleteMecanico(String n_empleado) throws SQLException{
    	String baja= "Baja";
        String consulta = "Update Mecanico Set Estado = ? WHERE N_Empleado = ?;";
        PreparedStatement pstmt = con.prepareStatement(consulta);
        pstmt.setString(1, baja);
        pstmt.setString(2, n_empleado);
         int update = pstmt.executeUpdate();
        return update;
     }
    


    //metodo para insertar Vehiculo
    public int insertarVehiculo(String matricula,String marca, String modelo, String color, String Fecha_Entrada, String fecha_salida,String clienteDNI,String ReparacionCodigoReparacion) throws SQLException {
        
        String consulta = "INSERT INTO "+ "Vehiculo" +"(Matricula, marca, modelo, color, Fecha_Entrada, Fecha_Salida, cliente_DNI, Reparacion_Codigo_Reparacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
         PreparedStatement pstmt = con.prepareStatement(consulta);
        //le paso los parametros a la consulta sustituyendo los ?
           pstmt.setString(1, matricula);
           pstmt.setString(2, marca);
           pstmt.setString(3, modelo);
           pstmt.setString(4, color);
           pstmt.setString(5, Fecha_Entrada);
           pstmt.setString(6, fecha_salida);
           pstmt.setString(7, clienteDNI);
           pstmt.setString(8, ReparacionCodigoReparacion);
           //ejecuto el insert
            int insert = pstmt.executeUpdate();
            //devuelvo las columnas que han sido afectadas con el insert
           return  insert;
    	
    }
    
    
public int ejecutarUpdateVehiculo(String dNI_Cliente, String matricula, String marca, String modelo, String color, String fecha_Entrada, String fecha_Salida, String reparacion) throws SQLException {
    String consulta = "UPDATE Vehiculo SET Marca = ?, Modelo = ?, Color = ?, Fecha_Entrada = ?, Fecha_Salida = ?, Reparacion_Codigo_Reparacion = ?, cliente_DNI = ? WHERE Matricula = ?;";
    PreparedStatement pstmt = con.prepareStatement(consulta);
    pstmt.setString(1, marca);
    pstmt.setString(2, modelo);
    pstmt.setString(3, color);
    pstmt.setString(4, fecha_Entrada);
    pstmt.setString(5, fecha_Salida);
    pstmt.setString(6, reparacion);
    pstmt.setString(8, matricula);
    pstmt.setString(7, dNI_Cliente);
    int update = pstmt.executeUpdate();
    return update;
}


public int UpdateStock(String Id, String precio) throws SQLException{
    String consulta = "Update Repuesto Set Precio = ? WHERE Codigo_Repuesto = ?;";
    PreparedStatement pstmt = con.prepareStatement(consulta);
    pstmt.setString(1, precio);
    pstmt.setString(2, Id);
     int update = pstmt.executeUpdate();
    return update;
 }

public int insertStock(String Codigo, String Precio, String Cantidad, String Proveedor) throws SQLException {
	
	String consulta = "	INSERT INTO repuesto (Codigo_Repuesto, Precio, Cantidad, Proveedor_codigo) VALUES (?, ?, ?, ?);";
    PreparedStatement pstmt = con.prepareStatement(consulta);
    pstmt.setString(1, Codigo);
    pstmt.setString(2, Precio);
    pstmt.setString(3, Cantidad);
    pstmt.setString(4, Proveedor);
     int update = pstmt.executeUpdate();
    return update;
    
}


public int insertOrdenes(String Matricula, String Mano_de_obra, String tiempo  ) throws SQLException {
    
    String consulta = "	INSERT INTO Ordenes (Mano_de_obra, tiempo, Estado, Mecanico_No_Empleado, Factura_ID_Factura, Repuesto_Codigo_Repuesto, vehiculo_Matricula, Fecha) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    PreparedStatement pstmt = con.prepareStatement(consulta);
    pstmt.setString(1, Mano_de_obra);
    pstmt.setString(2, tiempo);
    pstmt.setString(3, "Pendiente");
    pstmt.setString(4, null );
    pstmt.setString(5, null);
    pstmt.setString(6, null);
    pstmt.setString(7, Matricula);
    pstmt.setString(8, null);
     int update = pstmt.executeUpdate();
    return update;
    
}
public int updateOrdenes(String Matricula, String Mano_de_obra, String tiempo) throws SQLException {
    String consulta = "UPDATE Ordenes SET Mano_de_obra = ?, tiempo = ? WHERE vehiculo_Matricula = ?;";
    PreparedStatement pstmt = con.prepareStatement(consulta);
    pstmt.setString(1, Mano_de_obra);
    pstmt.setString(2, tiempo);
    pstmt.setString(3, Matricula);
    int update = pstmt.executeUpdate();
    return update;
}

public int deleteOrdenes(String Matricula)throws SQLException {
	
	String consulta ="DELETE FROM ORDENES WHERE VEHICULO_MATRICULA = ?";
	PreparedStatement pstmt = con.prepareStatement(consulta);
	pstmt.setString(1, Matricula);
	
	int update = pstmt.executeUpdate();
    return update;
	
}


public int updateStockOrdenes(String Codigo_Reparacion, String Repuesto_Codigo_Repuesto) throws SQLException {
    String consulta = "UPDATE Ordenes SET Repuesto_Codigo_Repuesto = ?WHERE Codigo_Reparacion = ?;";
    PreparedStatement pstmt = con.prepareStatement(consulta);
    pstmt.setString(1, Repuesto_Codigo_Repuesto);
    pstmt.setString(2, Codigo_Reparacion);
    int update = pstmt.executeUpdate();
    return update;
}
  
public int insertFacturas(String Matricula, String Precio_sin_IVA) throws SQLException {
    // Primero: Obtener el precio del repuesto asociado a la orden
    String codigoStock = "SELECT r.Codigo_Repuesto, r.Precio " +
                         "FROM ordenes o " +
                         "JOIN repuesto r ON o.Repuesto_Codigo_Repuesto = r.Codigo_Repuesto " +
                         "WHERE o.vehiculo_Matricula = ?";
    PreparedStatement stmt = con.prepareStatement(codigoStock);
    stmt.setString(1, Matricula);
    ResultSet rs = stmt.executeQuery();

    double precio = 0;
    if (rs.next()) {
        // Puedes obtener el código del repuesto si lo necesitas
        String codigoRepuesto = rs.getString("Codigo_Repuesto");
        precio = rs.getDouble("Precio");
    }
    rs.close();
    stmt.close();

    // Convertir el parámetro Precio_sin_IVA a double
    double precioSinIVA = Double.parseDouble(Precio_sin_IVA);
    
    // Sumar el precio obtenido y el Precio_sin_IVA
    double sumaPrecios = precio + precioSinIVA;
    double precioIVA = sumaPrecios * 1.21;

    // Segundo: Insertar en la tabla factura y recuperar el ID generado
    String consulta = "INSERT INTO factura (IVA, Precio_sin_IVA, Precio_Total) VALUES (?,?,?)";
    // Indicamos que queremos recuperar la clave generada
    PreparedStatement pstmt = con.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
    pstmt.setString(1, "21");
    pstmt.setDouble(2, sumaPrecios);
    pstmt.setDouble(3, precioIVA);
    
    int update = pstmt.executeUpdate();

    // Recuperar el ID autogenerado
    int facturaId = 0;
    ResultSet generatedKeys = pstmt.getGeneratedKeys();
    if (generatedKeys.next()) {
        facturaId = generatedKeys.getInt(1);
    }
    generatedKeys.close();
    pstmt.close();

    // Tercero: Actualizar la orden con el ID de factura recién creado
    updateFacturaOrden(facturaId, Matricula);

    return update;
}

public int updateFacturaOrden(int facturaId, String Matricula) throws SQLException {
    // Actualizamos la tabla ordenes para la orden que corresponde a la Matricula
    String updateQuery = "UPDATE ordenes SET Factura_ID_Factura = ? WHERE vehiculo_Matricula = ?";
    PreparedStatement updateStmt = con.prepareStatement(updateQuery);
    updateStmt.setInt(1, facturaId);
    updateStmt.setString(2, Matricula);
    int rowsUpdated = updateStmt.executeUpdate();
    updateStmt.close();
    return rowsUpdated;
}


}






    

    


