package Admin;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Inicio.InicioDeSesion;

import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import java.awt.GridLayout;

public class HomeAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel labelLogoPanel;
	JPanel PanelCardPrinci;
	static CardLayout cardLayout;
	private JTextField txtBusquedaVehiculo;
	private JTextField txtBusquedaCliente;

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

	/**
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
		lblGestionClientes.setBackground(new Color(240, 240, 240));
		lblGestionClientes.setBounds(0, 11, 238, 82);
		PanelOpciones.add(lblGestionClientes);
		lblGestionClientes.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Modelo de gestion \r\nde clientes");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "GestionClientes");
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGestionClientes.add(lblNewLabel_2);
		
		JPanel lblGestionMateriales = new JPanel();
		lblGestionMateriales.setBackground(UIManager.getColor("Button.background"));
		lblGestionMateriales.setBounds(0, 118, 238, 71);
		PanelOpciones.add(lblGestionMateriales);
		lblGestionMateriales.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Modelo de gestion \r\nde material");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "GestionMateriales");
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionMateriales.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JPanel lblGestionServicios = new JPanel();
		lblGestionServicios.setBackground(UIManager.getColor("Button.background"));
		lblGestionServicios.setBounds(1, 211, 237, 71);
		PanelOpciones.add(lblGestionServicios);
		lblGestionServicios.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Modelo de gestion \r\nde servicios");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "GestionServicios");
			}
		});
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGestionServicios.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JPanel lblGestionEconomia = new JPanel();
		lblGestionEconomia.setBackground(UIManager.getColor("Button.background"));
		lblGestionEconomia.setBounds(0, 303, 238, 71);
		PanelOpciones.add(lblGestionEconomia);
		lblGestionEconomia.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Modelo de gestion \r\neconomia del taller\r\n");
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
		lblGestionFacturas.setBackground(UIManager.getColor("Button.background"));
		lblGestionFacturas.setBounds(0, 395, 238, 71);
		PanelOpciones.add(lblGestionFacturas);
		lblGestionFacturas.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Gestionar Facturas");
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
		lblGestionFacturas_1.setBackground(UIManager.getColor("Button.background"));
		lblGestionFacturas_1.setBounds(0, 488, 238, 71);
		PanelOpciones.add(lblGestionFacturas_1);
		lblGestionFacturas_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("Modelo de gestion \r\nde informes");
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
		
		PanelCardPrinci = new JPanel(cardLayout);
		PanelCardPrinci.setBounds(237, 193, 997, 568);
		contentPane.add(PanelCardPrinci);
		PanelCardPrinci.setLayout(new CardLayout(0, 0));
		
		JPanel PanelGestionCliente = new JPanel();
		PanelGestionCliente.setBackground(new Color(255, 255, 255));
		PanelCardPrinci.add(PanelGestionCliente, "GestionClientes");
		PanelGestionCliente.setLayout(null);
		
		JPanel PanelCliente = new JPanel();
		PanelCliente.setBounds(29, 29, 286, 518);
		PanelGestionCliente.add(PanelCliente);
		PanelCliente.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(133, 133, 133));
		panel_2.setBounds(0, 0, 286, 59);
		PanelCliente.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_1);
		
		JLabel lblInsertarCliente = new JLabel("Insertar\r\n");
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
		lblInsertarCliente.setBounds(10, 70, 272, 117);
		PanelCliente.add(lblInsertarCliente);
		
		JLabel lblConsultaCliente = new JLabel("Consultar");
		lblConsultaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 // Mostrar JOptionPane para ingresar una frase
	            String frase = JOptionPane.showInputDialog(null, "Por favor, introduce una frase:", "Entrada de texto", JOptionPane.QUESTION_MESSAGE);
	            
	            // Verificar si el usuario ingresó algo
	            if (frase != null && !frase.trim().isEmpty()) {
	                // Abrir un nuevo JFrame con la frase ingresada
	                MostrarConsulta mc = null;
					try {
						mc = new MostrarConsulta(frase);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                mc.setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(null, "No ingresaste ninguna frase.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            }
				
			}
		});
		lblConsultaCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblConsultaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaCliente.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblConsultaCliente.setBounds(10, 219, 272, 117);
		PanelCliente.add(lblConsultaCliente);
		
		JLabel lblUpdate = new JLabel("Update\r\n");
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
		lblUpdate.setBounds(10, 366, 272, 117);
		PanelCliente.add(lblUpdate);
		
		JPanel PanelTrabajadores = new JPanel();
		PanelTrabajadores.setLayout(null);
		PanelTrabajadores.setBounds(354, 29, 292, 518);
		PanelGestionCliente.add(PanelTrabajadores);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(133, 133, 133));
		panel_2_1.setBounds(0, 0, 292, 59);
		PanelTrabajadores.add(panel_2_1);
		panel_2_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Mecanicos\r\n");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_2_1.add(lblNewLabel_1_1);
		
		JLabel lblInsertarMecanico = new JLabel("Insertar\r\n");
		lblInsertarMecanico.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				InsertMecanico frame = new InsertMecanico("  ", 1);
				frame.setVisible(true);
			}
		});
		lblInsertarMecanico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInsertarMecanico.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarMecanico.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInsertarMecanico.setBounds(10, 70, 272, 96);
		PanelTrabajadores.add(lblInsertarMecanico);
		
		JLabel lblConsultaMecanica = new JLabel("Consulta\r\n");
		lblConsultaMecanica.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 // Mostrar JOptionPane para ingresar una frase
	            String frase = JOptionPane.showInputDialog(null, "Por favor, introduce una frase:", "Entrada de texto", JOptionPane.QUESTION_MESSAGE);
	            
	            // Verificar si el usuario ingresó algo
	            if (frase != null && !frase.trim().isEmpty()) {
	                // Abrir un nuevo JFrame con la frase ingresada
	                MostrarConsulta mc = null;
					try {
						mc = new MostrarConsulta(frase);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                mc.setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(null, "No ingresaste ninguna frase.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            }
			}
		});
		lblConsultaMecanica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblConsultaMecanica.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaMecanica.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblConsultaMecanica.setBounds(10, 172, 272, 96);
		PanelTrabajadores.add(lblConsultaMecanica);
		
		JLabel lblDarDeBaja = new JLabel("Dar de Baja\r\n");
		lblDarDeBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
	            String frase = JOptionPane.showInputDialog(null, "Por favor, introduce una frase:", "Entrada de texto", JOptionPane.QUESTION_MESSAGE);
	            if (frase != null && !frase.trim().isEmpty()) {
	                // Abrir un nuevo JFrame con la frase ingresada
	            	
					DeleteMecanico dc = new DeleteMecanico(frase);
					dc.setVisible(true);
					
					
	            } else {
	                JOptionPane.showMessageDialog(null, "No ingresaste ningun DNI.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            
	            }
			}
		});
		lblDarDeBaja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDarDeBaja.setHorizontalAlignment(SwingConstants.CENTER);
		lblDarDeBaja.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDarDeBaja.setBounds(10, 279, 272, 96);
		PanelTrabajadores.add(lblDarDeBaja);
		
		JLabel lblUpdate_1 = new JLabel("Update\r\n");
		lblUpdate_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 // Mostrar JOptionPane para ingresar una frase
	            String frase = JOptionPane.showInputDialog(null, "Por favor, introduce el DNI:", "Entrada de texto", JOptionPane.QUESTION_MESSAGE);
	            
	            // Verificar si el usuario ingresó algo
	            if (frase != null && !frase.trim().isEmpty()) {
	                // Abrir un nuevo JFrame con la frase ingresada
	      
					InsertMecanico ic = new InsertMecanico(frase,2);
					ic.setVisible(true);
					
					
	            } else {
	                JOptionPane.showMessageDialog(null, "No ingresaste ningun DNI.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            }
				
			}
		});
		lblUpdate_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUpdate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUpdate_1.setBounds(10, 399, 272, 96);
		PanelTrabajadores.add(lblUpdate_1);
		
		JPanel PanelVehiculos = new JPanel();
		PanelVehiculos.setLayout(null);
		PanelVehiculos.setBounds(684, 29, 292, 518);
		PanelGestionCliente.add(PanelVehiculos);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(133, 133, 133));
		panel_2_2.setBounds(0, 0, 292, 59);
		PanelVehiculos.add(panel_2_2);
		panel_2_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_2 = new JLabel("Vehiculos\r\n");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_2_2.add(lblNewLabel_1_2);
		
		JLabel lblInsertarVehiculo = new JLabel("Insertar\r\n");
		lblInsertarVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInsertarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInsertarVehiculo.setBounds(10, 71, 272, 117);
		PanelVehiculos.add(lblInsertarVehiculo);
		
		JLabel lblConsultaVehiculo = new JLabel("Consultar");
		lblConsultaVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblConsultaVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblConsultaVehiculo.setBounds(10, 220, 272, 117);
		PanelVehiculos.add(lblConsultaVehiculo);
		
		JLabel lblUpdateVehiculo = new JLabel("Update\r\n");
		lblUpdateVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUpdateVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUpdateVehiculo.setBounds(10, 367, 272, 117);
		PanelVehiculos.add(lblUpdateVehiculo);
		
		JPanel PanelGestionMateriales = new JPanel();
		PanelGestionMateriales.setBackground(new Color(255, 255, 255));
		PanelGestionMateriales.setBounds(785, 5, 10, 10);
		PanelCardPrinci.add(PanelGestionMateriales, "GestionMateriales");
		PanelGestionMateriales.setLayout(null);
		
		JPanel PanelProveedores_1_1 = new JPanel();
		PanelProveedores_1_1.setLayout(null);
		PanelProveedores_1_1.setBounds(1050, 108, 292, 518);
		PanelGestionMateriales.add(PanelProveedores_1_1);
		
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
		
		JPanel PanelGestionServicios = new JPanel();
		PanelCardPrinci.add(PanelGestionServicios, "GestionServicios");
		
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
