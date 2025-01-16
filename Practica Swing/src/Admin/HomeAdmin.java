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
	public JLabel labelLogoPanel;
	JPanel PanelCardPrinci;
	static CardLayout cardLayout;
	private JTextField txtBusquedaVehiculo;
	private JTextField txtBusquedaCliente;
	private JTable tblMecanico;
	
	private ConexionMySQL con = new ConexionMySQL();
	private Statement stm = null;
	private JTable tblCliente;
	private JTable tblVehiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAdmin frame = new HomeAdmin(null);
			        
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
		
		
		//pantallaCompleta(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTextoPricipal = new JPanel();
		panelTextoPricipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTextoPricipal.setBackground(new Color(133, 133, 133));
		panelTextoPricipal.setBounds(0, 0, 1920, 191);
		contentPane.add(panelTextoPricipal);
		panelTextoPricipal.setLayout(null);
		
		labelLogoPanel = new JLabel("New label");
		labelLogoPanel.setBounds(92, 11, 167, 158);
		panelTextoPricipal.add(labelLogoPanel);
		
		JLabel lblPrincipal = new JLabel("DERRAP");
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
		lblPrincipal.setBounds(454, 35, 454, 112);
		panelTextoPricipal.add(lblPrincipal);
		
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
		
		JPanel lblGestionClientes = new JPanel();
		lblGestionClientes.setBackground(new Color(133, 133, 133));
		lblGestionClientes.setBounds(0, 11, 238, 82);
		PanelOpciones.add(lblGestionClientes);
		lblGestionClientes.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Clientes");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(133, 133, 133));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					String cabezera[]= {"DNI","Nombre","Apellido","Telefono"};
					mostrarSelect("Select * FROM Cliente", tblCliente,cabezera);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cardLayout.show(PanelCardPrinci, "GestionClientes");
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGestionClientes.add(lblNewLabel_2);
		
		JPanel lblMecanicos = new JPanel();
		lblMecanicos.setBackground(new Color(133, 133, 133));
		lblMecanicos.setBounds(0, 118, 238, 71);
		PanelOpciones.add(lblMecanicos);
		lblMecanicos.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Mecanicos\r\n");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(133, 133, 133));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					String cabezera[]= {"N_Empleado","DNI","Nombre","Apellido","Telefono","Estado"};
					mostrarSelect("Select * FROM Mecanico", tblMecanico,cabezera);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cardLayout.show(PanelCardPrinci, "Mecanicos");
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMecanicos.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JPanel lblVehiculos = new JPanel();
		lblVehiculos.setBackground(new Color(133, 133, 133));
		lblVehiculos.setBounds(1, 211, 237, 71);
		PanelOpciones.add(lblVehiculos);
		lblVehiculos.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Vehiculos");
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(133, 133, 133));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					String cabezera[]= {"Matricula","Marca","Modelo","Color","Fecha_Estrada","Fecha_Salida","Cliente_DNI","Codigo_Reparacion"};
					mostrarSelect("Select * FROM Vehiculo", tblVehiculo,cabezera);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cardLayout.show(PanelCardPrinci, "Vehiculo");
			}
		});
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVehiculos.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JPanel lblGestionEconomia = new JPanel();
		lblGestionEconomia.setBackground(new Color(133, 133, 133));
		lblGestionEconomia.setBounds(0, 303, 238, 71);
		PanelOpciones.add(lblGestionEconomia);
		lblGestionEconomia.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Modelo de gestion \r\neconomia del taller\r\n");
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBackground(new Color(133, 133, 133));
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "GestionEconomia");
			}
		});
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGestionEconomia.add(lblNewLabel_5, BorderLayout.CENTER);
		
		JPanel lblGestionFacturas = new JPanel();
		lblGestionFacturas.setBackground(new Color(133, 133, 133));
		lblGestionFacturas.setBounds(0, 395, 238, 71);
		PanelOpciones.add(lblGestionFacturas);
		lblGestionFacturas.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Gestionar Facturas");
		lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBackground(new Color(133, 133, 133));
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "GetionFacturas");
			}
		});
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionFacturas.add(lblNewLabel_6, BorderLayout.CENTER);
		
		JPanel lblGestionFacturas_1 = new JPanel();
		lblGestionFacturas_1.setBackground(new Color(133, 133, 133));
		lblGestionFacturas_1.setBounds(0, 488, 238, 71);
		PanelOpciones.add(lblGestionFacturas_1);
		lblGestionFacturas_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("Modelo de gestion \r\nde informes");
		lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBackground(new Color(133, 133, 133));
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "GestionInformes");
			}
		});
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionFacturas_1.add(lblNewLabel_7, BorderLayout.CENTER);
		setLogo(labelLogoPanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(133, 133, 133));
		panel.setBounds(0, 0, 82, 79);
		panelTextoPricipal.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<--");
		lblNewLabel.addMouseListener(new MouseAdapter() {
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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(0, 0, 72, 68);
		panel.add(lblNewLabel);
		
		JLabel lblLogoUser = new JLabel("");
		lblLogoUser.setBounds(1033, 21, 101, 99);
		panelTextoPricipal.add(lblLogoUser);
		
		PanelCardPrinci = new JPanel(cardLayout);
		PanelCardPrinci.setBounds(237, 193, 997, 568);
		contentPane.add(PanelCardPrinci);
		PanelCardPrinci.setLayout(new CardLayout(0, 0));
		
		JPanel PanelClientes = new JPanel();
		PanelClientes.setBackground(new Color(255, 255, 255));
		PanelCardPrinci.add(PanelClientes, "GestionClientes");
		PanelClientes.setLayout(null);
		
		tblCliente = new JTable();
		tblCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombre", "Apellido", "Telefono"
			}
		));
		tblCliente.setBounds(20, 24, 755, 533);
		PanelClientes.add(tblCliente);
		
		JPanel panelDiseño1Cliente = new JPanel();
		panelDiseño1Cliente.setBackground(new Color(133, 133, 133));
		panelDiseño1Cliente.setBounds(813, 36, 162, 86);
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
				InsertCliente ic = new InsertCliente("  ",1);
				ic.setVisible(true);
				
			}
		});
		lblInsertarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarCliente.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JPanel panelDiseño2Cliente = new JPanel();
		panelDiseño2Cliente.setBackground(new Color(133, 133, 133));
		panelDiseño2Cliente.setForeground(new Color(255, 255, 255));
		panelDiseño2Cliente.setBounds(813, 174, 162, 86);
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
				
				 // Mostrar JOptionPane para ingresar una frase
	            String frase = JOptionPane.showInputDialog(null, "Por favor, introduce el DNI:", "Entrada de texto", JOptionPane.QUESTION_MESSAGE);
	            
	            // Verificar si el usuario ingresó algo
	            if (frase != null && !frase.trim().isEmpty()) {
	                // Abrir un nuevo JFrame con la frase ingresada
	      
					InsertCliente ic = new InsertCliente(frase,2);
					ic.setVisible(true);
					setEnabled(false);
					
	            } else {
	                JOptionPane.showMessageDialog(null, "No ingresaste ningun DNI.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            }
				
			}
		});
		lblUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JPanel PanelMecanico = new JPanel();
		PanelMecanico.setBackground(new Color(255, 255, 255));
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
		
		tblMecanico = new JTable();
		tblMecanico.setBounds(25, 11, 668, 534);
		PanelMecanico.add(tblMecanico);
		
		JLabel lblInsertarMecanico = new JLabel("Insertar\r\n");
		lblInsertarMecanico.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				InsertMecanico frame = new InsertMecanico("  ", 1);
				frame.setVisible(true);
			}
		});
		lblInsertarMecanico.setBounds(703, 28, 272, 96);
		PanelMecanico.add(lblInsertarMecanico);
		lblInsertarMecanico.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarMecanico.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblConsultaMecanica = new JLabel("Consulta\r\n");
		lblConsultaMecanica.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
		});
		lblConsultaMecanica.setBounds(713, 135, 272, 96);
		PanelMecanico.add(lblConsultaMecanica);
		lblConsultaMecanica.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaMecanica.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblDarDeBaja = new JLabel("Dar de Baja\r\n");
		lblDarDeBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				  String frase = JOptionPane.showInputDialog(null, "Por favor, introduce la id:", "Entrada de texto", JOptionPane.QUESTION_MESSAGE);
		            if (frase != null && !frase.trim().isEmpty()) {
		                // Abrir un nuevo JFrame con la frase ingresada
		            	
						DeleteMecanico dc = new DeleteMecanico(frase);
						dc.setVisible(true);
		            }
		            else {
		            	JOptionPane.showMessageDialog(null, "No has ,etido ningun ID");
		            }
			}
		});
		lblDarDeBaja.setBounds(703, 242, 272, 96);
		PanelMecanico.add(lblDarDeBaja);
		lblDarDeBaja.setHorizontalAlignment(SwingConstants.CENTER);
		lblDarDeBaja.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblUpdate_1 = new JLabel("Update\r\n");
		lblUpdate_1.setBounds(713, 366, 272, 96);
		PanelMecanico.add(lblUpdate_1);
		lblUpdate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JPanel PanelVehiculo = new JPanel();
		PanelCardPrinci.add(PanelVehiculo, "Vehiculo");
		PanelVehiculo.setLayout(null);
		
		JLabel lblInsertarVehiculo = new JLabel("Insertar\r\n");
		lblInsertarVehiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				InsertVehiculo iv = new InsertVehiculo(" ",1);
				iv.setVisible(true);
				
			}
		});
		lblInsertarVehiculo.setBackground(new Color(133, 133, 133));
		lblInsertarVehiculo.setBounds(715, 11, 272, 117);
		PanelVehiculo.add(lblInsertarVehiculo);
		lblInsertarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblUpdateVehiculo = new JLabel("Update\r\n");
		lblUpdateVehiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				  String frase = JOptionPane.showInputDialog(null, "Por favor, introduce una matricula:", "Entrada de texto", JOptionPane.QUESTION_MESSAGE);
		            if (frase != null && !frase.trim().isEmpty()) {
		            	InsertVehiculo iv = new InsertVehiculo(frase ,1);
						iv.setVisible(true);
		            }
		            else {
		            	JOptionPane.showMessageDialog(null, "No has ,etido ninguna matricula");
		            }
			}
		});
		lblUpdateVehiculo.setBounds(715, 283, 272, 117);
		PanelVehiculo.add(lblUpdateVehiculo);
		lblUpdateVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblConsultaVehiculo = new JLabel("Consultar");
		lblConsultaVehiculo.setBounds(715, 139, 272, 117);
		PanelVehiculo.add(lblConsultaVehiculo);
		lblConsultaVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		tblVehiculo = new JTable();
		tblVehiculo.setBounds(23, 11, 753, 516);
		PanelVehiculo.add(tblVehiculo);
		
		JPanel PanelGestionEconomia = new JPanel();
		PanelCardPrinci.add(PanelGestionEconomia, "GestionEconomia");
		
		JPanel PanelGestionFacturas = new JPanel();
		PanelCardPrinci.add(PanelGestionFacturas, "GetionFacturas");
		
		JPanel PanelGestionInformes = new JPanel();
		PanelCardPrinci.add(PanelGestionInformes, "GestionInformes");
		
		cardLayout= (CardLayout) PanelCardPrinci.getLayout();
		
		JPanel PanelDashBoard = new JPanel();
		PanelDashBoard.setBackground(new Color(255, 255, 255));
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
		setLogo(labelLogoPanel);
		setIcono(lblLogoUser);
	}
	

	private void dashBoard() {
		cardLayout.show(PanelCardPrinci, "PanelDashBoard");
		
	}

	private void setLogo(JLabel labelLogoPanel2) {
	    try {
	        // Cargar la imagen desde el paquete img
	        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/img/logo_Derrap.png"));

	        // Escalar la imagen
	        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(labelLogoPanel.getWidth(), labelLogoPanel.getHeight(), Image.SCALE_SMOOTH);

	        // Crear un nuevo ImageIcon con la imagen escalada
	        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

	        // Establecer el icono en el JLabel
	        labelLogoPanel.setIcon(iconoEscalado);
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error: La imagen no se pudo cargar o asignar al JLabel.");
	    }
	}
	
	private void setIcono(JLabel label) {
	    try {
	        // Cargar la imagen desde el paquete img
	        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/img/IconoAdminMecanico.png"));

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
	
	private void mostrarSelect(String consulta, JTable jtDatos,String cabezera[]) throws SQLException, ClassNotFoundException {
	      try {
	    	  con.conectar();	
	        ResultSet rs = con.ejecutarSelect(consulta);
	        DefaultTableModel modelo = new DefaultTableModel();
	        
	        //	 modelo.setColumnIdentifiers(cabezera);
	        
	       
	        // Obtener los metadatos para obtener el nombre y el numero de consultas
	        int columnCount = rs.getMetaData().getColumnCount();
	        
	        // Agregar columnas al modelo de la tabla
	        for (int i = 1; i <= columnCount; i++) {
	            modelo.addColumn(rs.getMetaData().getColumnName(i));
	        }

	        // Agregar filas al modelo de la tabla
	        while (rs.next()) {
	            Object[] fila = new Object[columnCount];
	            for (int i = 0; i < columnCount; i++) {
	                fila[i] = rs.getObject(i + 1);
	            }
	            modelo.addRow(fila);
	        }

	        // Establecer el modelo en la tabla y cambiar de panel
	       
	        jtDatos.setModel(modelo);
	       
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(this, "Error al ejecutar la consulta: " + e.getMessage());
	    }
	      
	    }
	private void pantallaCompleta(HomeAdmin frame) {
		// Obtener el tamaño de la pantalla
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gs = ge.getDefaultScreenDevice();

        // Hacer la ventana de pantalla completa
        frame.setUndecorated(true); // Elimina los bordes y la barra de título
        gs.setFullScreenWindow(frame);

        // Asegurarse de que la ventana se cierre correctamente
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
