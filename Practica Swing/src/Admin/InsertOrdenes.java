package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Cursor;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Inicio.ConexionMySQL;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InsertOrdenes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtTiempo;
	private JTextField txtManoDeObra;
	
	String selectTableSQL = "";
	private ConexionMySQL con = new ConexionMySQL();
	private Statement stm = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertOrdenes frame = new InsertOrdenes("   ", 1, null);
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
	public InsertOrdenes(String frase, int i, HomeAdmin frame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricula.setBounds(31, 88, 86, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblTiempo = new JLabel("Tiempo");
		lblTiempo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTiempo.setBounds(31, 158, 46, 14);
		contentPane.add(lblTiempo);
		
		JLabel lblManoDeObra = new JLabel("Mano de Obra");
		lblManoDeObra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblManoDeObra.setBounds(31, 229, 86, 14);
		contentPane.add(lblManoDeObra);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(31, 113, 121, 34);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtTiempo = new JTextField();
		txtTiempo.setBounds(31, 183, 121, 35);
		contentPane.add(txtTiempo);
		txtTiempo.setColumns(10);
		
		txtManoDeObra = new JTextField();
		txtManoDeObra.setBounds(31, 254, 121, 34);
		contentPane.add(txtManoDeObra);
		txtManoDeObra.setColumns(10);
		
		JPanel panelTXT = new JPanel();
		panelTXT.setLayout(null);
		panelTXT.setBackground(new Color(133, 133, 133));
		panelTXT.setBounds(0, 0, 349, 65);
		contentPane.add(panelTXT);
		
		JLabel lblImgVolver = new JLabel("");
		lblImgVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		lblImgVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblImgVolver.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblImgVolver.setBounds(0, 0, 41, 35);
		panelTXT.add(lblImgVolver);
		frame.setIcono(lblImgVolver, "flecha_volver");
		
		JLabel lblPrincipal = new JLabel("Ordenes");
		lblPrincipal.setBackground(new Color(240, 240, 240));
		lblPrincipal.setForeground(Color.WHITE);
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPrincipal.setBounds(121, 11, 126, 39);
		panelTXT.add(lblPrincipal);
		
		JPanel panelInsertarOrden = new JPanel();
		panelInsertarOrden.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelInsertarOrden.setBackground(new Color(133, 133, 133));
		panelInsertarOrden.setBounds(218, 381, 121, 49);
		contentPane.add(panelInsertarOrden);
		panelInsertarOrden.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInsertarOrden = new JLabel("Insertar");
		lblInsertarOrden.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int controlFuncion=i;
				
				String Matricula= txtMatricula.getText();
				String ManoDeObra = txtManoDeObra.getText();
				String Tiempo = txtTiempo.getText();
				
				if(i==1) {//1 es para que haga el insert

					if (!Matricula.isEmpty() && !ManoDeObra.isEmpty() && !Tiempo.isEmpty()) {
						try {
							con.conectar();					
						int funciona=con.insertOrdenes(Matricula, ManoDeObra, Tiempo);
						
						if (funciona > 0) {
			                 JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
			                     dispose();		
			                     frame.UpdateTablaOrdenes();
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
					
					if (!Matricula.isEmpty() && !ManoDeObra.isEmpty() && !Tiempo.isEmpty()) {
						try {
							con.conectar();					
						int funciona=con.updateOrdenes(Matricula, ManoDeObra, Tiempo);
						
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
		lblInsertarOrden.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInsertarOrden.setForeground(new Color(255, 255, 255));
		lblInsertarOrden.setHorizontalAlignment(SwingConstants.CENTER);
		panelInsertarOrden.add(lblInsertarOrden, BorderLayout.CENTER);
		
		if(i==2) {
			lblPrincipal.setText("Update");
			txtMatricula.setText(frase);
			txtMatricula.setEnabled(false);
			mostrarDatosOrden(frase);
		}
		else {
			lblPrincipal.setText("Insert");
		}
	}
	
	private void mostrarDatosOrden (String frase) {
		try {
			con.conectar();
            selectTableSQL = "SELECT * FROM cliente WHERE dni = '"+frase+"';";
			ResultSet rs = con.ejecutarSelect(selectTableSQL);
			while(rs.next()) {
				 String Matricula = rs.getString("vehiculo_Matricula");
			     String ManoDeObra = rs.getString("Mano_de_obra");
			     String Tiempo = rs.getString("tiempo");
			     txtMatricula.setText(Matricula);
			     txtManoDeObra.setText(ManoDeObra);
			     txtTiempo.setText(Tiempo);
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
		txtMatricula.setText("");
		txtManoDeObra.setText("");
		txtTiempo.setText("");
	}
}
	
	 
