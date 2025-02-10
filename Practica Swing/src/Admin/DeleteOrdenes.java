package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inicio.ConexionMySQL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Cursor;
import java.awt.Color;

public class DeleteOrdenes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ConexionMySQL con = new ConexionMySQL();
	private Statement stm = null;
	String selectTableSQL = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteOrdenes frame = new DeleteOrdenes(null,null);
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
	public DeleteOrdenes(String Matricula, HomeAdmin homeAdmin) {
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo_Reparacion = new JLabel("Codigo reparacio:");
		lblCodigo_Reparacion.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCodigo_Reparacion.setBounds(23, 79, 158, 14);
		contentPane.add(lblCodigo_Reparacion);
		
		JLabel lblManoDeObra = new JLabel("Mano de Obra:");
		lblManoDeObra.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblManoDeObra.setBounds(23, 128, 158, 14);
		contentPane.add(lblManoDeObra);
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTiempo.setBounds(23, 173, 110, 14);
		contentPane.add(lblTiempo);
		
		JLabel lblselectCodigoReparacion = new JLabel("");
		lblselectCodigoReparacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblselectCodigoReparacion.setBounds(222, 79, 122, 14);
		contentPane.add(lblselectCodigoReparacion);
		
		JLabel lblselectManoDeObra = new JLabel("");
		lblselectManoDeObra.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblselectManoDeObra.setBounds(221, 128, 123, 14);
		contentPane.add(lblselectManoDeObra);
		
		JLabel lblselectTiempo = new JLabel("");
		lblselectTiempo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblselectTiempo.setBounds(222, 173, 122, 14);
		contentPane.add(lblselectTiempo);
		
		JLabel lblMatricula_vehiculo = new JLabel("Matricula Vehiculo:");
		lblMatricula_vehiculo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMatricula_vehiculo.setBounds(23, 396, 176, 14);
		contentPane.add(lblMatricula_vehiculo);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFecha.setBounds(23, 445, 60, 14);
		contentPane.add(lblFecha);
		
		JLabel lblselectmatriculaVehiculo = new JLabel("");
		lblselectmatriculaVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblselectmatriculaVehiculo.setBounds(222, 396, 122, 14);
		contentPane.add(lblselectmatriculaVehiculo);
		
		JLabel lblselectFecha = new JLabel("");
		lblselectFecha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblselectFecha.setBounds(222, 445, 122, 14);
		contentPane.add(lblselectFecha);
		
		JLabel lblNMecanico = new JLabel("Estado:");
		lblNMecanico.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNMecanico.setBounds(23, 221, 110, 14);
		contentPane.add(lblNMecanico);
		
		JLabel lblselectEstado = new JLabel("");
		lblselectEstado.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblselectEstado.setBounds(222, 221, 122, 14);
		contentPane.add(lblselectEstado);
		
		JLabel lblNewLabel_14 = new JLabel("Nº Mecanico:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_14.setBounds(23, 260, 131, 14);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblselectNMecanico = new JLabel("");
		lblselectNMecanico.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblselectNMecanico.setBounds(222, 260, 122, 14);
		contentPane.add(lblselectNMecanico);
		
		JLabel lblselectCodigoRepuesto = new JLabel("");
		lblselectCodigoRepuesto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblselectCodigoRepuesto.setBounds(221, 348, 123, 14);
		contentPane.add(lblselectCodigoRepuesto);
		
		JLabel lblID_Factura = new JLabel("ID de la factura:");
		lblID_Factura.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblID_Factura.setBounds(23, 304, 158, 14);
		contentPane.add(lblID_Factura);
		
		JLabel lblCoddigo_Repuesto = new JLabel("Codigo Repuesto:");
		lblCoddigo_Repuesto.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCoddigo_Repuesto.setBounds(23, 348, 158, 14);
		contentPane.add(lblCoddigo_Repuesto);
		
		JLabel lblselectIdFactura = new JLabel("");
		lblselectIdFactura.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblselectIdFactura.setBounds(222, 304, 122, 14);
		contentPane.add(lblselectIdFactura);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(322, 439, 102, 33);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_8 = new JLabel("Eliminar");
		lblNewLabel_8.setBackground(new Color(128, 128, 128));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
					if (respuesta == JOptionPane.YES_OPTION) {
						con.conectar();
						int funciona=con.deleteOrdenes(Matricula);
						
						if (funciona > 0) {
			                 JOptionPane.showMessageDialog(null, "Matricula eliminado correctamente");
			                     dispose();
			                     homeAdmin.UpdateTablaOrdenes();
					}
			        } else if (respuesta == JOptionPane.NO_OPTION) {
			            
			        } else {
			            System.out.println("El usuario cerró el cuadro de diálogo.");
			        }

					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
				
			}
			
			
		});
		panel.add(lblNewLabel_8, BorderLayout.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(0, 0, 434, 68);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("<--");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_2.setBounds(0, 0, 32, 27);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_1.add(lblNewLabel_2);
		homeAdmin.setIcono(lblNewLabel_2, "flecha_volver");
		mostrarSelectDeleteOrdenes(Matricula, lblCodigo_Reparacion, lblManoDeObra, lblTiempo, lblNMecanico, lblselectCodigoReparacion, lblselectManoDeObra, lblselectTiempo, lblselectNMecanico, lblselectEstado, lblID_Factura, lblselectIdFactura, lblCoddigo_Repuesto, lblselectCodigoRepuesto, lblMatricula_vehiculo, lblselectmatriculaVehiculo, lblFecha, lblselectFecha);
		
		}

	
	
	private void mostrarSelectDeleteOrdenes( String vehiculo_Matricula, JLabel lblCodigo_Reparacion, JLabel lblManoDeObra, JLabel lblTiempo, JLabel lblNMecanico,
			JLabel lblselectCodigoReparacion, JLabel lblselectManoDeObra, JLabel lblselectTiempo, JLabel lblselectNMecanico, JLabel lblselectEstado, JLabel lblID_Factura, JLabel lblselectIdFactura, JLabel lblCoddigo_Repuesto, JLabel lblselectCodigoRepuesto, JLabel lblMatricula_vehiculo, JLabel lblselectmatriculaVehiculo, JLabel lblFecha, JLabel lblselectFecha) {
		try {
			con.conectar();
            selectTableSQL = "SELECT * FROM ordenes WHERE vehiculo_Matricula = '"+vehiculo_Matricula+"';";
			ResultSet rs = con.ejecutarSelect(selectTableSQL);
			while(rs.next()) {
               String codigo_reparacion = rs.getString("codigo_reparacion");
               String mano_de_obra = rs.getString("mano_de_obra");
               String tiempo = rs.getString("tiempo");
               String estado = rs.getString("estado");
               String Mecanico_No_Empleado = rs.getString("Mecanico_No_Empleado");
               String id_factura = rs.getString("Factura_ID_Factura");
               String codigo_repuesto = rs.getString("Repuesto_Codigo_Repuesto");
               String matricula_vehiculo = rs.getString("vehiculo_Matricula");
               String fecha = rs.getString("fecha");
               lblselectCodigoReparacion.setText(codigo_reparacion);
               lblselectManoDeObra.setText(mano_de_obra);
               lblselectTiempo.setText(tiempo);
               lblselectEstado.setText(estado);
               lblselectNMecanico.setText(Mecanico_No_Empleado);
               lblselectIdFactura.setText(id_factura);
               lblselectCodigoRepuesto.setText(codigo_repuesto);
               lblselectmatriculaVehiculo.setText(matricula_vehiculo);
               lblselectFecha.setText(fecha);
               
               
               
			}
        } catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: La imagen no se pudo cargar o asignar al JLabel.");
	}
	}
	}
		


	





