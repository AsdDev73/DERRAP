package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;

import Inicio.ConexionMySQL;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoRespuesto;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JTextField txtCodigoProveedor;
	
	private ConexionMySQL con = new ConexionMySQL();
	private Statement stm = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertStock frame = new InsertStock(null);
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
	public InsertStock(HomeAdmin frame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelArriba = new JPanel();
		panelArriba.setBackground(new Color(133, 133, 133));
		panelArriba.setBounds(0, 0, 475, 92);
		contentPane.add(panelArriba);
		panelArriba.setLayout(null);
		
		JLabel lblImgVolver = new JLabel("\r\n");
		lblImgVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				dispose();
				
			}
		});
		lblImgVolver.setBounds(0, 0, 64, 41);
		panelArriba.add(lblImgVolver);
		
		JLabel lblPanelPrinci = new JLabel("Insert Stock\r\n");
		lblPanelPrinci.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelPrinci.setForeground(new Color(255, 255, 255));
		lblPanelPrinci.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblPanelPrinci.setBounds(143, 13, 184, 56);
		panelArriba.add(lblPanelPrinci);
		
		JLabel lblCodigoRepuesto = new JLabel("Codigo Repuesto");
		lblCodigoRepuesto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCodigoRepuesto.setForeground(new Color(255, 255, 255));
		lblCodigoRepuesto.setBounds(24, 122, 125, 37);
		contentPane.add(lblCodigoRepuesto);
		
		txtCodigoRespuesto = new JTextField();
		txtCodigoRespuesto.setBounds(159, 122, 125, 37);
		contentPane.add(txtCodigoRespuesto);
		txtCodigoRespuesto.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrecio.setBounds(24, 192, 125, 37);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(159, 192, 125, 37);
		contentPane.add(txtPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCantidad.setBounds(24, 267, 125, 37);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(159, 267, 125, 37);
		contentPane.add(txtCantidad);
		
		JLabel lblCodigoProveedor = new JLabel("Codigo Proveedor");
		lblCodigoProveedor.setForeground(Color.WHITE);
		lblCodigoProveedor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCodigoProveedor.setBounds(24, 339, 136, 37);
		contentPane.add(lblCodigoProveedor);
		
		txtCodigoProveedor = new JTextField();
		txtCodigoProveedor.setColumns(10);
		txtCodigoProveedor.setBounds(159, 339, 125, 37);
		contentPane.add(txtCodigoProveedor);
		
		JPanel PanelInsertar = new JPanel();
		PanelInsertar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		PanelInsertar.setBackground(new Color(133, 133, 133));
		PanelInsertar.setBounds(312, 434, 136, 57);
		contentPane.add(PanelInsertar);
		PanelInsertar.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInsertar = new JLabel("Insertar");
		lblInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String codigo= txtCodigoRespuesto.getText();
				String precio= txtPrecio.getText();
				String cantidad= txtCantidad.getText();
				String preveedor= txtCodigoProveedor.getText();
				
				if (!codigo.isEmpty() && !precio.isEmpty() && !cantidad.isEmpty() && !preveedor.isEmpty()) {
					try {
						con.conectar();					
					int funciona=con.insertStock(codigo, precio, cantidad, preveedor);
					
					if (funciona > 0) {
		                 JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
		                 frame.UpdateTablaCliente();
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
				
				frame.UpdateTablaStock();
				dispose();
				limpiarCampos();
			}
		});
		lblInsertar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInsertar.setForeground(new Color(255, 255, 255));
		lblInsertar.setHorizontalAlignment(SwingConstants.CENTER);
		PanelInsertar.add(lblInsertar, BorderLayout.CENTER);
		
		frame.setIcono(lblImgVolver, "flecha_volver");
	}
	
	private void limpiarCampos(){
		txtCodigoRespuesto.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
		txtCodigoProveedor.setText("");
	}
	
}
