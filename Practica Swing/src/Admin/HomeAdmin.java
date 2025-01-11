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
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel labelLogoPanel;
	JPanel PanelCardPrinci;
	static CardLayout cardLayout;

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
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTextoPricipal = new JPanel();
		panelTextoPricipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTextoPricipal.setBackground(new Color(133, 133, 133));
		panelTextoPricipal.setBounds(0, 0, 1920, 288);
		contentPane.add(panelTextoPricipal);
		panelTextoPricipal.setLayout(null);
		
		labelLogoPanel = new JLabel("New label");
		labelLogoPanel.setBounds(77, 43, 199, 189);
		panelTextoPricipal.add(labelLogoPanel);
		
		JLabel lblPrincipal = new JLabel("DASHBOARD");
		lblPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "PanelDashBoard");
			}
		});
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipal.setForeground(new Color(255, 255, 255));
		lblPrincipal.setBounds(682, 25, 787, 207);
		panelTextoPricipal.add(lblPrincipal);
		
		JLabel lblUsuario = new JLabel("Admin\r\n");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(1753, 141, 66, 39);
		panelTextoPricipal.add(lblUsuario);
		
		JPanel PanelOpciones = new JPanel();
		PanelOpciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		PanelOpciones.setBackground(new Color(133, 133, 133));
		PanelOpciones.setBounds(0, 288, 323, 753);
		contentPane.add(PanelOpciones);
		PanelOpciones.setLayout(null);
		
		JButton btnGestionClientes = new JButton("Modelo de gestion \r\nde clientes");
		btnGestionClientes.setBackground(new Color(133, 133, 133));
		btnGestionClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(PanelCardPrinci, "GestionClientes");
			}
		});
		btnGestionClientes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGestionClientes.setBounds(0, 11, 323, 105);
		PanelOpciones.add(btnGestionClientes);
		
		JButton btnGestioMateriales = new JButton("Modelo de gestion \r\nde material");
		btnGestioMateriales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				cardLayout.show(PanelCardPrinci, "GestionMateriales");
			}
		});
		btnGestioMateriales.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGestioMateriales.setBounds(0, 143, 323, 105);
		PanelOpciones.add(btnGestioMateriales);
		
		JButton btnGEstionServicios = new JButton("Modelo de gestion \r\nde servicios");
		btnGEstionServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(PanelCardPrinci, "GestionServicios");
			}
		});
		btnGEstionServicios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGEstionServicios.setBounds(0, 264, 323, 105);
		PanelOpciones.add(btnGEstionServicios);
		
		JButton btnGestionDeTaller = new JButton("Modelo de gestion \r\neconomia del taller\r\n");
		btnGestionDeTaller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(PanelCardPrinci, "GestionEconomia");
			}
		});
		btnGestionDeTaller.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGestionDeTaller.setBounds(1, 389, 323, 105);
		PanelOpciones.add(btnGestionDeTaller);
		
		JButton btnGestionarFacturas = new JButton("Gestionar Facturas");
		btnGestionarFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(PanelCardPrinci, "GetionFacturas");
			}
		});
		btnGestionarFacturas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGestionarFacturas.setBounds(0, 515, 323, 105);
		PanelOpciones.add(btnGestionarFacturas);
		
		JButton btnGestionInformes = new JButton("Modelo de gestion \r\nde informes");
		btnGestionInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(PanelCardPrinci, "GestionInformes");
			}
		});
		btnGestionInformes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGestionInformes.setBounds(0, 637, 323, 105);
		PanelOpciones.add(btnGestionInformes);
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
		PanelCardPrinci.setBounds(324, 288, 1580, 753);
		contentPane.add(PanelCardPrinci);
		PanelCardPrinci.setLayout(new CardLayout(0, 0));
		
		JPanel PanelGestionCliente = new JPanel();
		PanelGestionCliente.setBackground(new Color(0, 255, 0));
		PanelCardPrinci.add(PanelGestionCliente, "GestionClientes");
		PanelGestionCliente.setLayout(null);
		
		JPanel PanelGestionMateriales = new JPanel();
		PanelGestionMateriales.setBackground(new Color(255, 255, 128));
		PanelGestionMateriales.setBounds(785, 5, 10, 10);
		PanelCardPrinci.add(PanelGestionMateriales, "GestionMateriales");
		PanelGestionMateriales.setLayout(null);
		
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
		PanelCardPrinci.add(PanelDashBoard, "PanelDashBoard");
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
