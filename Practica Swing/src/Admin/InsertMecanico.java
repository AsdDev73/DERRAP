package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inicio.ConexionMySQL;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InsertMecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtDNI;
	
	private ConexionMySQL con = new ConexionMySQL();
	private Statement stm = null;
	
	private String select=" ";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertMecanico frame = new InsertMecanico("   ", 1, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertMecanico(String frase, int i, HomeAdmin frame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImgVolver = new JLabel("<--");
		lblImgVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		lblImgVolver.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblImgVolver.setBounds(10, 11, 59, 34);
		contentPane.add(lblImgVolver);
		
		frame.setIcono(lblImgVolver, "flecha_volver");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(130, 130, 130));
		panel.setBounds(0, 0, 475, 81);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPrincipal = new JLabel("Mecánico");
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblPrincipal.setForeground(new Color(255, 255, 255));
		lblPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPrincipal, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombre.setBounds(10, 104, 84, 34);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(104, 108, 239, 33);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblApellido.setBounds(10, 166, 84, 34);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(104, 165, 239, 31);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefono.setBounds(10, 229, 84, 34);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(104, 228, 239, 31);
		contentPane.add(txtTelefono);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDNI.setBounds(10, 294, 84, 34);
		contentPane.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(104, 293, 239, 31);
		contentPane.add(txtDNI);
		
		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int controlFuncion=i;
				
				String DNI= txtDNI.getText();
				String Nombre = txtNombre.getText();
				String Apellido = txtApellido.getText();
				String Telefono = txtTelefono.getText();
				
				if(i==1) {//1 es para que haga el insert

					if (!DNI.isEmpty() && !Nombre.isEmpty() && !Apellido.isEmpty() && !Telefono.isEmpty()) {
						try {
							con.conectar();					
						int funciona=con.insetarMecanico(DNI, Nombre, Apellido, Telefono);
						
						if (funciona > 0) {
			                 JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
			                     dispose();		
			                     frame.UpdateTablaMecanico();
			            	}
						} 
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						limpiarCampos();
					}
					else {
						JOptionPane.showMessageDialog(null, "Error al insertar los datos, revise si hay algun campo vacio");
					}
				}
				
				if(i==2) { 
					
					if (!DNI.isEmpty() && !Nombre.isEmpty() && !Apellido.isEmpty() && !Telefono.isEmpty()) {
						try {
							con.conectar();					
						int funciona=con.ejecutarUpdateMecanico(frase, Nombre, Apellido, Telefono, DNI);
						
						if (funciona > 0) {
			                 JOptionPane.showMessageDialog(null, "Mecánico actualizado correctamente");
			                     dispose();
			                     frame.UpdateTablaMecanico();
			            	}
						} 
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						limpiarCampos();
					}
					else {
						JOptionPane.showMessageDialog(null, "Error al insertar los datos, revise si hay algun campo vacio");
					}
				}
				
				
			}
		});
		
		if(i==2) {
			lblPrincipal.setText("Update");
			txtDNI.setText(frase);
			txtDNI.setEnabled(false);
			mostrarDatosMecanico(frase);
		}
		else {
			lblPrincipal.setText("Insert");
		}
		btnAñadir.setForeground(new Color(255, 255, 255));
		btnAñadir.setBackground(new Color(130, 130, 130));
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAñadir.setBounds(164, 402, 128, 42);
		contentPane.add(btnAñadir);
		

		
	}

	private void mostrarDatosMecanico (String frase) {
		try {
			con.conectar();
            select = "SELECT * FROM Mecanico WHERE N_Empleado = '"+frase+"';";
			ResultSet rs = con.ejecutarSelect(select);
			while(rs.next()) {
            String DNI = rs.getString("DNI");
            txtDNI.setText(DNI);
            String nombre = rs.getString("nombre");
            txtNombre.setText(nombre);
            String apellido = rs.getString("apellido");
            txtApellido.setText(apellido);
            String telefono = rs.getString("tlf");
            txtTelefono.setText(telefono);
           
			}
            

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		

	private void limpiarCampos() {
		txtDNI.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
	}
}
