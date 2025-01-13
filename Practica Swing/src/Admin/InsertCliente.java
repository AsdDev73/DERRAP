package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inicio.ConexionMySQL;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class InsertCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	
	private ConexionMySQL con = new ConexionMySQL();
	private Statement stm = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertCliente frame = new InsertCliente("", 1);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param frase 
	 * @param i 
	 */
	public InsertCliente(String frase, int i) {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(133, 133, 133));
		panel.setBounds(0, 0, 349, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<--");
		lblNewLabel.setBounds(0, 0, 41, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JLabel lblPrincipal = new JLabel("New label");
		lblPrincipal.setForeground(new Color(255, 255, 255));
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrincipal.setBounds(103, 15, 101, 39);
		panel.add(lblPrincipal);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDNI.setBounds(32, 76, 55, 23);
		contentPane.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(32, 99, 159, 28);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(32, 159, 55, 23);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(32, 182, 159, 28);
		contentPane.add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(32, 241, 55, 23);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(32, 264, 159, 28);
		contentPane.add(txtApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(32, 323, 55, 23);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(32, 346, 159, 28);
		contentPane.add(txtTelefono);
		
		JButton btnAgregarCliente = new JButton("Agregar");
		btnAgregarCliente.addActionListener(new ActionListener() {
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
						int funciona=con.insetarClientes(DNI, Nombre, Apellido, Telefono);
						
						if (funciona > 0) {
			                 JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
			                     dispose();		                    
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
				
				if(i==2) {//hace el update
					if (!DNI.isEmpty() && !Nombre.isEmpty() && !Apellido.isEmpty() && !Telefono.isEmpty()) {
						try {
							con.conectar();					
						int funciona=con.ejecutarUpdateCliente(DNI, Nombre, Apellido, Telefono);
						
						if (funciona > 0) {
			                 JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
			                     dispose();
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
		btnAgregarCliente.setBounds(210, 400, 110, 36);
		contentPane.add(btnAgregarCliente);
		
		if(i==2) {
			lblPrincipal.setText("Update");
			txtDNI.setText(frase);
			txtDNI.setEnabled(false);
		}
		else {
			lblPrincipal.setText("Insert");
		}
	}
	
	
	
	private void limpiarCampos() {
		txtDNI.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
	}
}
