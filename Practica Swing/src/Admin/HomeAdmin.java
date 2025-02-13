package Admin;

import java.awt.EventQueue;
import java.awt.Image;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Inicio.ConexionMySQL;
import Inicio.InicioDeSesion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class HomeAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel PanelCardPrinci;
	static CardLayout cardLayout;
	private JTextField txtBusquedaVehiculo;
	private JTextField txtBusquedaCliente;
	private JTable tblMecanico;
	
	private ConexionMySQL con = new ConexionMySQL();
	private Statement stm = null;
	private JTable tblCliente;
	private JTable tblVehiculo;
	private JTable tblStock;
	
	private static HomeAdmin frame;
	private JTable tblFactura;
	private JTable tblOrdenes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new HomeAdmin(null);
			        
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**-
	 * Create the frame.
	 * @param string 
	 */

	public HomeAdmin(String admin) {
		
		frame = this;
		//pantallaCompleta(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTextoPricipal = new JPanel();
		panelTextoPricipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTextoPricipal.setBackground(new Color(133, 133, 133));
		panelTextoPricipal.setBounds(0, 0, 1920, 191);
		contentPane.add(panelTextoPricipal);
		panelTextoPricipal.setLayout(null);
		
		JLabel lblPrincipal = new JLabel("");
		lblPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "PanelDashBoard");
			}
		});
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipal.setForeground(new Color(255, 255, 255));
		lblPrincipal.setBounds(372, -174, 544, 542);
		panelTextoPricipal.add(lblPrincipal);
		setIcono(lblPrincipal, "LetrasDerrap");
		
		JLabel lblUsuario = new JLabel("Admin\r\n");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(1057, 120, 66, 39);
		panelTextoPricipal.add(lblUsuario);
		
		JPanel PanelOpciones = new JPanel();
		PanelOpciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		PanelOpciones.setBackground(new Color(133, 133, 133));
		PanelOpciones.setBounds(0, 191, 238, 570);
		contentPane.add(PanelOpciones);
		PanelOpciones.setLayout(null);
		
		JLabel lblImgInformes = new JLabel("");
		lblImgInformes.setBounds(24, 501, 46, 44);
		PanelOpciones.add(lblImgInformes);
		
		JLabel lblImgMecanicos = new JLabel("");
		lblImgMecanicos.setBounds(24, 131, 46, 45);
		PanelOpciones.add(lblImgMecanicos);
		setIcono(lblImgMecanicos, "mecanico");
		
		JLabel lblImgVehiculos = new JLabel("");
		lblImgVehiculos.setBounds(24, 223, 46, 43);
		PanelOpciones.add(lblImgVehiculos);
		setIcono(lblImgVehiculos, "coche");
		
		JLabel lblImgEconomia = new JLabel("");
		lblImgEconomia.setBounds(24, 317, 46, 43);
		PanelOpciones.add(lblImgEconomia);
		setIcono(lblImgEconomia, "economia");
		
		JLabel lblImgFacturas = new JLabel("");
		lblImgFacturas.setBounds(24, 406, 46, 43);
		PanelOpciones.add(lblImgFacturas);
		setIcono(lblImgFacturas, "Factura");
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 105, 238, 2);
		PanelOpciones.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 200, 238, 2);
		PanelOpciones.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(0, 293, 238, 2);
		PanelOpciones.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(0, 385, 238, 2);
		PanelOpciones.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(0, 475, 238, 2);
		PanelOpciones.add(separator_4);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(76, 11, 152, 82);
		PanelOpciones.add(lblClientes);
		lblClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClientes.setForeground(new Color(255, 255, 255));
		lblClientes.setBackground(new Color(133, 133, 133));
		lblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "GestionClientes");
				UpdateTablaCliente();		
			}

		});
		lblClientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblMecanicos = new JLabel("Mecanicos\r\n");
		lblMecanicos.setBounds(80, 118, 148, 71);
		PanelOpciones.add(lblMecanicos);
		lblMecanicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMecanicos.setForeground(new Color(255, 255, 255));
		lblMecanicos.setBackground(new Color(133, 133, 133));
		lblMecanicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UpdateTablaMecanico();

				cardLayout.show(PanelCardPrinci, "Mecanicos");
			}

		});
		lblMecanicos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMecanicos.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblVehiculos = new JLabel("Vehículos");
		lblVehiculos.setBounds(81, 213, 147, 71);
		PanelOpciones.add(lblVehiculos);
		lblVehiculos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblVehiculos.setForeground(new Color(255, 255, 255));
		lblVehiculos.setBackground(new Color(133, 133, 133));
		lblVehiculos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UpdateTablaVehiculo();

				cardLayout.show(PanelCardPrinci, "Vehiculo");
			}

		});
		lblVehiculos.setHorizontalAlignment(SwingConstants.LEFT);
		lblVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(80, 307, 148, 67);
		PanelOpciones.add(lblStock);
		lblStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblStock.setForeground(new Color(255, 255, 255));
		lblStock.setBackground(new Color(133, 133, 133));
		lblStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UpdateTablaStock();
				cardLayout.show(PanelCardPrinci, "GestionEconomia");
			}

		
		});
		lblStock.setHorizontalAlignment(SwingConstants.LEFT);
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblFacturas = new JLabel("Facturas");
		lblFacturas.setBounds(80, 393, 148, 71);
		PanelOpciones.add(lblFacturas);
		lblFacturas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFacturas.setForeground(new Color(255, 255, 255));
		lblFacturas.setBackground(new Color(133, 133, 133));
		lblFacturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "GetionFacturas");
				UpdateTablaFactura();
			}
		});
		lblFacturas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFacturas.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblOrdenes = new JLabel("Ordenes");
		lblOrdenes.setBounds(80, 488, 148, 71);
		PanelOpciones.add(lblOrdenes);
		lblOrdenes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblOrdenes.setForeground(new Color(255, 255, 255));
		lblOrdenes.setBackground(new Color(133, 133, 133));
		lblOrdenes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				cardLayout.show(PanelCardPrinci, "GestionOrdenes");
				UpdateTablaOrdenes();

			}

			
		});
		lblOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblImgClientes = new JLabel("");
		lblImgClientes.setBounds(24, 33, 46, 43);
		PanelOpciones.add(lblImgClientes);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(133, 133, 133));
		panel.setBounds(0, 0, 82, 79);
		panelTextoPricipal.add(panel);
		panel.setLayout(null);
		
		JLabel lblImgFlechaVolver = new JLabel("");
		lblImgFlechaVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
                // Mostrar el JOptionPane con las opciones "Sí" y "No"
                int option = JOptionPane.showConfirmDialog(null, 
                        "¿Quieres salir?", "Confirmar Salida", 
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                // Verificar la opción seleccionada
                if (option == JOptionPane.YES_OPTION) {
                    // Si el usuario elige "Sí", cerrar la ventana principal
                    dispose();
                    
                    // Abrir la ventana de login
                	InicioDeSesion frame = new InicioDeSesion();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
                  
                }
			}
		});
		lblImgFlechaVolver.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblImgFlechaVolver.setBounds(0, 0, 72, 68);
		panel.add(lblImgFlechaVolver);
		
		JLabel lblLogoUser = new JLabel("");
		lblLogoUser.setBounds(1028, 11, 111, 112);
		panelTextoPricipal.add(lblLogoUser);
		
		PanelCardPrinci = new JPanel(cardLayout);
		PanelCardPrinci.setBackground(new Color(192, 192, 192));
		PanelCardPrinci.setBounds(237, 193, 997, 568);
		contentPane.add(PanelCardPrinci);
		PanelCardPrinci.setLayout(new CardLayout(0, 0));
		
		JPanel PanelClientes = new JPanel();
		PanelClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PanelClientes.setBackground(new Color(192, 192, 192));
		PanelCardPrinci.add(PanelClientes, "GestionClientes");
		PanelClientes.setLayout(null);
		
		JPanel panelDiseño1Cliente = new JPanel();
		panelDiseño1Cliente.setBackground(new Color(133, 133, 133));
		panelDiseño1Cliente.setBounds(813, 91, 162, 86);
		PanelClientes.add(panelDiseño1Cliente);
		panelDiseño1Cliente.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInsertarCliente = new JLabel("Insertar\r\n");
		lblInsertarCliente.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblInsertarCliente.setForeground(new Color(255, 255, 255));
		panelDiseño1Cliente.add(lblInsertarCliente, BorderLayout.CENTER);
		lblInsertarCliente.setBackground(new Color(133, 133, 133));
		lblInsertarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInsertarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				InsertCliente ic = new InsertCliente("  ", 1, frame);
				ic.setVisible(true);
				ic.setLocationRelativeTo(null);
				
			}
		});
		lblInsertarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarCliente.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JPanel panelDiseño2Cliente = new JPanel();
		panelDiseño2Cliente.setBackground(new Color(133, 133, 133));
		panelDiseño2Cliente.setForeground(new Color(255, 255, 255));
		panelDiseño2Cliente.setBounds(813, 228, 162, 86);
		PanelClientes.add(panelDiseño2Cliente);
		panelDiseño2Cliente.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUpdate = new JLabel("Update\r\n");
		lblUpdate.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblUpdate.setForeground(new Color(255, 255, 255));
		panelDiseño2Cliente.add(lblUpdate, BorderLayout.CENTER);
		lblUpdate.setBackground(new Color(133, 133, 133));
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					int fila = tblCliente.getSelectedRow();
					String DNICliente = String.valueOf(tblCliente.getValueAt(fila, 0));
					if(fila != -1) {
						InsertCliente ic = new InsertCliente(DNICliente,2, frame);
						ic.setVisible(true);
						ic.setLocationRelativeTo(null);
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecciona un cliente de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}
				catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Selecciona un cliente de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			
			}
		});
		lblUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 775, 546);
		PanelClientes.add(scrollPane);
		
		tblCliente = new JTable();
		scrollPane.setViewportView(tblCliente);
		tblCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JPanel PanelMecanico = new JPanel();
		PanelMecanico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PanelMecanico.setBackground(new Color(192, 192, 192));
		PanelMecanico.setBounds(785, 5, 10, 10);
		PanelCardPrinci.add(PanelMecanico, "Mecanicos");
		PanelMecanico.setLayout(null);
		
		JPanel PanelProveedores_1_1 = new JPanel();
		PanelProveedores_1_1.setLayout(null);
		PanelProveedores_1_1.setBounds(1050, 108, 292, 518);
		PanelMecanico.add(PanelProveedores_1_1);
		
		JPanel panel_2_2_1_1 = new JPanel();
		panel_2_2_1_1.setLayout(null);
		panel_2_2_1_1.setBackground(new Color(133, 133, 133));
		panel_2_2_1_1.setBounds(0, 0, 292, 59);
		PanelProveedores_1_1.add(panel_2_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Proveedores\r\n");
		lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2_1_1.setBounds(80, 11, 174, 31);
		panel_2_2_1_1.add(lblNewLabel_1_2_1_1);
		
		JLabel lblInsertarMecanico_1_1 = new JLabel("Insetar\r\n");
		lblInsertarMecanico_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarMecanico_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInsertarMecanico_1_1.setBounds(10, 70, 272, 96);
		PanelProveedores_1_1.add(lblInsertarMecanico_1_1);
		
		JLabel lblConsultaMecanica_1_1 = new JLabel("Consulta\r\n");
		lblConsultaMecanica_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaMecanica_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblConsultaMecanica_1_1.setBounds(10, 172, 272, 96);
		PanelProveedores_1_1.add(lblConsultaMecanica_1_1);
		
		JLabel lblEliminarProveedor_1 = new JLabel("Dar de Baja\r\n");
		lblEliminarProveedor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarProveedor_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEliminarProveedor_1.setBounds(10, 279, 272, 96);
		PanelProveedores_1_1.add(lblEliminarProveedor_1);
		
		JLabel lblUpdate_1_1_1 = new JLabel("Update");
		lblUpdate_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUpdate_1_1_1.setBounds(10, 399, 272, 96);
		PanelProveedores_1_1.add(lblUpdate_1_1_1);
		
		JPanel panelInsertarMecanico = new JPanel();
		panelInsertarMecanico.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelInsertarMecanico.setBackground(new Color(133, 133, 133));
		panelInsertarMecanico.setBounds(813, 91, 162, 86);
		PanelMecanico.add(panelInsertarMecanico);
		panelInsertarMecanico.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInsertarMecanico = new JLabel("Insertar\r\n");
		lblInsertarMecanico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInsertarMecanico.setForeground(new Color(255, 255, 255));
		panelInsertarMecanico.add(lblInsertarMecanico, BorderLayout.CENTER);
		lblInsertarMecanico.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				InsertMecanico im = new InsertMecanico("  ", 1,frame);
				im.setVisible(true);
				im.setLocationRelativeTo(null);
			}
		});
		lblInsertarMecanico.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarMecanico.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JPanel panelDeleteMecanico = new JPanel();
		panelDeleteMecanico.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelDeleteMecanico.setBackground(new Color(133, 133, 133));
		panelDeleteMecanico.setBounds(813, 365, 162, 86);
		PanelMecanico.add(panelDeleteMecanico);
		panelDeleteMecanico.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDarDeBaja = new JLabel("Dar de Baja\r\n");
		lblDarDeBaja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDarDeBaja.setForeground(new Color(255, 255, 255));
		panelDeleteMecanico.add(lblDarDeBaja, BorderLayout.CENTER);
		lblDarDeBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					int fila = tblMecanico.getSelectedRow();
					String DNIMecanico = String.valueOf(tblMecanico.getValueAt(fila, 0));
					if(fila != -1) {
						  	DeleteMecanico dc = new DeleteMecanico(DNIMecanico);
							dc.setVisible(true);
							dc.setLocationRelativeTo(null);
					}
						
					else {
						JOptionPane.showMessageDialog(null, "Selecciona un mecanico de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
						
				}catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Selecciona un mecanico de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
		            
		          
			}
		});
		lblDarDeBaja.setHorizontalAlignment(SwingConstants.CENTER);
		lblDarDeBaja.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JPanel panelUpdateMecanico = new JPanel();
		panelUpdateMecanico.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelUpdateMecanico.setBackground(new Color(133, 133, 133));
		panelUpdateMecanico.setBounds(813, 228, 162, 86);
		PanelMecanico.add(panelUpdateMecanico);
		panelUpdateMecanico.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUpdate_1 = new JLabel("Update\r\n");
		lblUpdate_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUpdate_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
					int fila = tblMecanico.getSelectedRow();
					String DNIMecanico = String.valueOf(tblMecanico.getValueAt(fila, 0));
					if(fila != -1) {
						InsertMecanico im = new InsertMecanico(DNIMecanico, 2,frame);
						im.setVisible(true);
						im.setLocationRelativeTo(null);
					}
						
					else {
						JOptionPane.showMessageDialog(null, "Selecciona un mecanico de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
						
				}catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Selecciona un mecanico de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		lblUpdate_1.setForeground(new Color(255, 255, 255));
		panelUpdateMecanico.add(lblUpdate_1, BorderLayout.CENTER);
		lblUpdate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 775, 546);
		PanelMecanico.add(scrollPane_1);
		
		tblMecanico = new JTable();
		scrollPane_1.setViewportView(tblMecanico);
		
		JPanel PanelVehiculo = new JPanel();
		PanelVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PanelVehiculo.setBackground(new Color(192, 192, 192));
		PanelCardPrinci.add(PanelVehiculo, "Vehiculo");
		PanelVehiculo.setLayout(null);
		
		JPanel panelInsertarVehiculo = new JPanel();
		panelInsertarVehiculo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelInsertarVehiculo.setBackground(new Color(133, 133, 133));
		panelInsertarVehiculo.setBounds(813, 91, 162, 86);
		PanelVehiculo.add(panelInsertarVehiculo);
		panelInsertarVehiculo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInsertarVehiculo = new JLabel("Insertar\r\n");
		lblInsertarVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInsertarVehiculo.setForeground(new Color(255, 255, 255));
		panelInsertarVehiculo.add(lblInsertarVehiculo, BorderLayout.CENTER);
		lblInsertarVehiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				InsertVehiculo iv = new InsertVehiculo(" ",1,frame);
				iv.setVisible(true);
				iv.setLocationRelativeTo(null);
				
			}
		});
		lblInsertarVehiculo.setBackground(new Color(133, 133, 133));
		lblInsertarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JPanel panelUpdateVehiculo = new JPanel();
		panelUpdateVehiculo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelUpdateVehiculo.setBackground(new Color(133, 133, 133));
		panelUpdateVehiculo.setBounds(813, 228, 162, 86);
		PanelVehiculo.add(panelUpdateVehiculo);
		panelUpdateVehiculo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUpdateVehiculo = new JLabel("Update\r\n");
		lblUpdateVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUpdateVehiculo.setForeground(new Color(255, 255, 255));
		panelUpdateVehiculo.add(lblUpdateVehiculo, BorderLayout.CENTER);
		lblUpdateVehiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					int fila = tblVehiculo.getSelectedRow();
					String Matricula = String.valueOf(tblVehiculo.getValueAt(fila, 0));
					if(fila != -1) {
						InsertVehiculo iv = new InsertVehiculo(Matricula ,2,frame);
						iv.setVisible(true);
						iv.setLocationRelativeTo(null);
					}
						
					else {
						JOptionPane.showMessageDialog(null, "Selecciona un vehiculo de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
						
				}catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Selecciona un vehiculo de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		lblUpdateVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 775, 546);
		PanelVehiculo.add(scrollPane_2);
		
		tblVehiculo = new JTable();
		scrollPane_2.setViewportView(tblVehiculo);
		
		JPanel PanelStock = new JPanel();
		PanelStock.setBackground(new Color(192, 192, 192));
		PanelCardPrinci.add(PanelStock, "GestionEconomia");
		PanelStock.setLayout(null);
		
		JScrollPane scrollPaneStock = new JScrollPane();
		scrollPaneStock.setBounds(10, 11, 775, 546);
		PanelStock.add(scrollPaneStock);
		
		tblStock = new JTable();
		scrollPaneStock.setViewportView(tblStock);
		
		JPanel PnlInserStock = new JPanel();
		PnlInserStock.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		PnlInserStock.setForeground(new Color(255, 255, 255));
		PnlInserStock.setBackground(new Color(133, 133, 133));
		PnlInserStock.setBounds(813, 91, 162, 86);
		PanelStock.add(PnlInserStock);
		PnlInserStock.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInsertarStock = new JLabel("Insertar");
		lblInsertarStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInsertarStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				InsertStock is = new InsertStock(frame);
				is.setVisible(true);
				is.setLocationRelativeTo(null);
			}
		});
		lblInsertarStock.setForeground(new Color(255, 255, 255));
		lblInsertarStock.setBackground(new Color(133, 133, 133));
		lblInsertarStock.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInsertarStock.setHorizontalAlignment(SwingConstants.CENTER);
		PnlInserStock.add(lblInsertarStock, BorderLayout.CENTER);
		
		JPanel PnlUpdateStock = new JPanel();
		PnlUpdateStock.setForeground(Color.WHITE);
		PnlUpdateStock.setBackground(new Color(133, 133, 133));
		PnlUpdateStock.setBounds(813, 228, 162, 86);
		PanelStock.add(PnlUpdateStock);
		PnlUpdateStock.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUPdateStock = new JLabel("Update");
		lblUPdateStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUPdateStock.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblUPdateStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				//update de precio en un respuesto 
				int fila = tblStock.getSelectedRow(); // Obtiene el índice de la fila seleccionada
				if(fila != -1) {	
				String dato1 = String.valueOf(tblStock.getValueAt(fila, 0));
				 String frase = JOptionPane.showInputDialog(null, "Por favor, introduce el nuevo precio: ", "Entrada de texto", JOptionPane.QUESTION_MESSAGE);
		            if (frase != null && !frase.trim().isEmpty()) {
		            	try {
		            		String FraseAux=frase;
		                    Integer.parseInt(frase); // Trata de convertir el String a un número (entero)                   
		                    con.conectar();
		                   int funciona= con.UpdateStock(dato1, FraseAux);
		                   if (funciona > 0) {
				                 JOptionPane.showMessageDialog(null, "Repuesto Updateado");
				                 UpdateTablaStock();
				            	}
		                   else {
		                	   JOptionPane.showMessageDialog(null, "Error al Updatear el repuesto");
		                   }
		                } catch (NumberFormatException exx) {
		                    //significa que no es un número
		                	JOptionPane.showMessageDialog(null, "Tienen que ser numeros ");
		                } catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            }
		            else {
		            	JOptionPane.showMessageDialog(null, "No has metido mingun precio");
		            }
			
			}else {
				JOptionPane.showMessageDialog(null, "Selecciona el dato de la tabla");
			}
			}
		});
		lblUPdateStock.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUPdateStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblUPdateStock.setForeground(new Color(255, 255, 255));
		PnlUpdateStock.add(lblUPdateStock, BorderLayout.CENTER);
		
		JPanel PanelGestionFacturas = new JPanel();
		PanelGestionFacturas.setBackground(new Color(192, 192, 192));
		PanelCardPrinci.add(PanelGestionFacturas, "GetionFacturas");
		PanelGestionFacturas.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 775, 546);
		PanelGestionFacturas.add(scrollPane_3);
		
		tblFactura = new JTable();
		scrollPane_3.setViewportView(tblFactura);
		
		JPanel PanelObtenerFactura = new JPanel();
		PanelObtenerFactura.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		PanelObtenerFactura.setBackground(new Color(133, 133, 133));
		PanelObtenerFactura.setBounds(813, 91, 162, 86);
		PanelGestionFacturas.add(PanelObtenerFactura);
		PanelObtenerFactura.setLayout(new BorderLayout(0, 0));
		
		JLabel lblObtenerFactura = new JLabel("Obterner Factura");
		lblObtenerFactura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblObtenerFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int fila = tblFactura.getSelectedRow();
					String Matricula = String.valueOf(tblFactura.getValueAt(fila, 4));
					if(fila != -1) {
						FacturaInfo fi = new FacturaInfo(Matricula);
						fi.setVisible(true);
						fi.setLocationRelativeTo(null);
						//FacturaPDF fact = new FacturaPDF(Matricula);
						//fact.generarFactura();
					}
						
					else {
						JOptionPane.showMessageDialog(null, "Selecciona un mecanico de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				
				}
					
			catch(ArrayIndexOutOfBoundsException ex) {
				JOptionPane.showMessageDialog(null, "Selecciona un mecanico de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
			}
				
		});
		lblObtenerFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblObtenerFactura.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblObtenerFactura.setForeground(new Color(255, 255, 255));
		PanelObtenerFactura.add(lblObtenerFactura, BorderLayout.CENTER);
		
		JPanel PanelGestionOrdenes = new JPanel();
		PanelGestionOrdenes.setBackground(new Color(192, 192, 192));
		PanelCardPrinci.add(PanelGestionOrdenes, "GestionOrdenes");
		PanelGestionOrdenes.setLayout(null);
		
		JScrollPane scrollPaneOrdenes = new JScrollPane();
		scrollPaneOrdenes.setBounds(10, 11, 775, 546);
		PanelGestionOrdenes.add(scrollPaneOrdenes);
		
		tblOrdenes = new JTable();
		scrollPaneOrdenes.setViewportView(tblOrdenes);
		
		
		
		JPanel panelInsertar = new JPanel();
		panelInsertar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelInsertar.setBackground(new Color(133, 133, 133));
		panelInsertar.setBounds(813, 91, 162, 86);
		PanelGestionOrdenes.add(panelInsertar);
		panelInsertar.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInsertarOrdenes = new JLabel("Insertar");
		lblInsertarOrdenes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInsertarOrdenes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				InsertOrdenes io = new InsertOrdenes(" ",1,frame);
				io.setVisible(true);
				io.setLocationRelativeTo(null);
				
			}
		});
		lblInsertarOrdenes.setForeground(new Color(255, 255, 255));
		lblInsertarOrdenes.setBackground(new Color(192, 192, 192));
		lblInsertarOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInsertarOrdenes.setHorizontalAlignment(SwingConstants.CENTER);
		panelInsertar.add(lblInsertarOrdenes, BorderLayout.CENTER);
		
		JPanel panelUpdate = new JPanel();
		panelUpdate.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelUpdate.setBackground(new Color(133, 133, 133));
		panelUpdate.setBounds(813, 228, 162, 86);
		PanelGestionOrdenes.add(panelUpdate);
		panelUpdate.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUpdateOrdenes = new JLabel("Update");
		lblUpdateOrdenes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					int fila = tblOrdenes.getSelectedRow();
					String MatriculaCoche = String.valueOf(tblOrdenes.getValueAt(fila, 7));
					if(fila != -1) {
						InsertOrdenes io = new InsertOrdenes(MatriculaCoche,2,frame);
						io.setVisible(true);
						io.setLocationRelativeTo(null);
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecciona un cliente de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}
				catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Selecciona un cliente de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		lblUpdateOrdenes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUpdateOrdenes.setForeground(new Color(255, 255, 255));
		lblUpdateOrdenes.setBackground(new Color(133, 133, 133));
		lblUpdateOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUpdateOrdenes.setHorizontalAlignment(SwingConstants.CENTER);
		panelUpdate.add(lblUpdateOrdenes, BorderLayout.CENTER);
		
		JPanel panelEliminar = new JPanel();
		panelEliminar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelEliminar.setBackground(new Color(133, 133, 133));
		panelEliminar.setBounds(813, 365, 162, 86);
		PanelGestionOrdenes.add(panelEliminar);
		panelEliminar.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEliminarOrdenes = new JLabel("Eliminar");
		lblEliminarOrdenes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				try {
					int fila = tblOrdenes.getSelectedRow();
					String Matricula = String.valueOf(tblOrdenes.getValueAt(fila, 7));
					if(fila != -1) {
						DeleteOrdenes dof = new DeleteOrdenes(Matricula,frame);
						dof.setVisible(true);
						dof.setLocationRelativeTo(null);
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecciona una Matricula de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}
				catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Selecciona una Matricula de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			
			}
				
			
		});
		lblEliminarOrdenes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEliminarOrdenes.setForeground(new Color(255, 255, 255));
		lblEliminarOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEliminarOrdenes.setHorizontalAlignment(SwingConstants.CENTER);
		panelEliminar.add(lblEliminarOrdenes, BorderLayout.CENTER);
		
		cardLayout= (CardLayout) PanelCardPrinci.getLayout();
		
		JPanel PanelDashBoard = new JPanel();
		PanelDashBoard.setBackground(new Color(192, 192, 192));
		PanelCardPrinci.add(PanelDashBoard, "PanelDashBoard");
		PanelDashBoard.setLayout(null);
		
		JLabel lblBusquedVehiculo = new JLabel("Busqueda de Vehiculo\r\n");
		lblBusquedVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBusquedVehiculo.setBounds(25, 27, 202, 64);
		PanelDashBoard.add(lblBusquedVehiculo);
		
		txtBusquedaVehiculo = new JTextField();
		txtBusquedaVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtBusquedaVehiculo.setBounds(237, 29, 258, 64);
		PanelDashBoard.add(txtBusquedaVehiculo);
		txtBusquedaVehiculo.setColumns(10);
		
		JLabel lblBusquedCliente = new JLabel("Busqueda de Cliente\r\n");
		lblBusquedCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBusquedCliente.setBounds(541, 31, 258, 64);
		PanelDashBoard.add(lblBusquedCliente);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente\r\n");
		btnBuscarCliente.setBounds(668, 106, 121, 43);
		PanelDashBoard.add(btnBuscarCliente);
		
		JButton btnBusquedaVehiculo = new JButton("Buscar Vehiculo");
		btnBusquedaVehiculo.setBounds(142, 106, 121, 43);
		PanelDashBoard.add(btnBusquedaVehiculo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(133, 133, 133));
		panel_1.setBounds(65, 348, 195, 174);
		PanelDashBoard.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(133, 133, 133));
		panel_1_1.setBounds(386, 348, 195, 174);
		PanelDashBoard.add(panel_1_1);
		
		txtBusquedaCliente = new JTextField();
		txtBusquedaCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtBusquedaCliente.setColumns(10);
		txtBusquedaCliente.setBounds(736, 34, 154, 54);
		PanelDashBoard.add(txtBusquedaCliente);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(133, 133, 133));
		panel_1_1_1.setBounds(715, 348, 195, 174);
		PanelDashBoard.add(panel_1_1_1);
		
		dashBoard();
		setIcono(lblImgClientes, "cliente");
		setIcono(lblImgFlechaVolver, "flecha_volver");
		setIcono(lblImgInformes, "informe");
		setIcono(lblLogoUser, "admin");
		
		//final del main
	}

	private void dashBoard() {
		cardLayout.show(PanelCardPrinci, "PanelDashBoard");
		
	}

	
	public void setIcono(JLabel label, String img) {
	    try {
	        // Cargar la imagen desde el paquete img
	        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/img/"+img+".png"));

	        // Escalar la imagen
	        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);

	        // Crear un nuevo ImageIcon con la imagen escalada
	        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

	        // Establecer el icono en el JLabel
	        label.setIcon(iconoEscalado);
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error: La imagen no se pudo cargar o asignar al JLabel.");
	    }
	}

	private void mostrarSelect(String consulta, JTable jtDatos, String cabezera[]) throws SQLException, ClassNotFoundException {
	    try {
	        con.conectar();	
	        ResultSet rs = con.ejecutarSelect(consulta);
	        DefaultTableModel modelo = new DefaultTableModel(cabezera, 0);

	        // Validar que el número de cabeceras coincida con el número de columnas en el ResultSet
	        int columnCount = rs.getMetaData().getColumnCount();
	        if (cabezera != null && cabezera.length == columnCount) {
	            // Usar las cabeceras proporcionadas
	            modelo.setColumnIdentifiers(cabezera);
	        } else {
	            // Usar las cabeceras del ResultSet si las proporcionadas no coinciden
	            for (int i = 1; i <= columnCount; i++) {
	                modelo.addColumn(rs.getMetaData().getColumnName(i));
	            }
	        }

	        // Agregar filas al modelo de la tabla
	        while (rs.next()) {
	            Object[] fila = new Object[columnCount];
	            for (int i = 0; i < columnCount; i++) {
	                fila[i] = rs.getObject(i + 1);
	            }
	            modelo.addRow(fila);
	        }
	      
	        // Establecer el modelo en la tabla
	        jtDatos.setModel(modelo);
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage());
	    }
	}
	
	public void UpdateTablaCliente() {
		try {
		String [] cabezera= {"DNI","Nombre","Apellido","Telefono"};
		mostrarSelect("Select * FROM Cliente", tblCliente,cabezera);
	} catch (ClassNotFoundException | SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
	}

	public void UpdateTablaMecanico() {
		try {
			String cabezera[]= {"N_Empleado","DNI","Nombre","Apellido","Telefono","Estado"};
			mostrarSelect("Select * FROM Mecanico", tblMecanico,cabezera);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

	public void UpdateTablaVehiculo() {
		// TODO Auto-generated method stub
		try {
			String cabezera[]= {"Matricula","Marca","Modelo","Color","Fecha_Estrada","Fecha_Salida","Cliente_DNI","Codigo_Reparacion"};
			mostrarSelect("Select * FROM Vehiculo", tblVehiculo,cabezera);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void UpdateTablaStock() {
		try {
			String [] cabezera= {"Codiego_Repuesto","Precio","Cantidad","Proveedor_Codigo"};
			mostrarSelect("Select * FROM repuesto", tblStock,cabezera);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
	public void UpdateTablaFactura(){
		String consulta = "SELECT f.ID_Factura, f.IVA, f.Precio_sin_IVA, f.Precio_Total, " +
                "v.Matricula, c.DNI, c.Nombre " +
                "FROM factura f " +
                "JOIN Ordenes o ON f.ID_Factura = o.Factura_ID_Factura " +
                "JOIN vehiculo v ON o.vehiculo_Matricula = v.Matricula " +
                "JOIN cliente c ON v.Cliente_DNI = c.DNI";
			
			String[] cabecera = {"ID Factura", "IVA", "Precio sin IVA", "Precio Total", "Matrícula", "DNI Cliente", "Nombre Cliente"};
			
			try {
			  mostrarSelect(consulta, tblFactura, cabecera);
			} catch (SQLException | ClassNotFoundException e) {
			  e.printStackTrace();
		}

	}

	public void UpdateTablaOrdenes() {
		try {
            String [] cabezera= {"Codigo reparacion","Mano de Obra","Tiempo","Estado","Nº Mecanico","Id de la factura","Codigo repuesto","Matricula Vehiculo","Fecha"};
            mostrarSelect("Select * FROM Ordenes", tblOrdenes,cabezera);
        } catch (ClassNotFoundException | SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
		
		}
	}
	
	
	
	
	
	}