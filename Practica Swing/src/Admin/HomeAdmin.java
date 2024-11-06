package Admin;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;

public class HomeAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel labelLogoPanel;
	private JTextField txtBusquedaMatricula;
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
		
		pantallaCompleta(this);
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
		panelTextoPricipal.setBounds(0, 0, 1904, 288);
		contentPane.add(panelTextoPricipal);
		panelTextoPricipal.setLayout(null);
		
		labelLogoPanel = new JLabel("New label");
		labelLogoPanel.setBounds(76, 43, 199, 189);
		panelTextoPricipal.add(labelLogoPanel);
		
		JLabel lblPrincipal = new JLabel("DASHBOARD");
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipal.setForeground(new Color(255, 255, 255));
		lblPrincipal.setBounds(566, 25, 975, 207);
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
		
		JTextPane lblGestionClientes = new JTextPane();
		lblGestionClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGestionClientes.setForeground(new Color(255, 255, 255));
		lblGestionClientes.setEditable(false);
		lblGestionClientes.setBackground(new Color(133, 133, 133));
		lblGestionClientes.setText("Modelo de gestion \r\nde clientes");
		lblGestionClientes.setBounds(81, 11, 127, 42);
		PanelOpciones.add(lblGestionClientes);
		
		JTextPane lblGestionMaterial = new JTextPane();
		lblGestionMaterial.setText("Modelo de gestion \r\nde material");
		lblGestionMaterial.setForeground(Color.WHITE);
		lblGestionMaterial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGestionMaterial.setEditable(false);
		lblGestionMaterial.setBackground(new Color(133, 133, 133));
		lblGestionMaterial.setBounds(81, 129, 127, 42);
		PanelOpciones.add(lblGestionMaterial);
		
		JTextPane lblGestionEconomiaTaller = new JTextPane();
		lblGestionEconomiaTaller.setText("Modelo de gestion \r\neconomia del taller");
		lblGestionEconomiaTaller.setForeground(Color.WHITE);
		lblGestionEconomiaTaller.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGestionEconomiaTaller.setEditable(false);
		lblGestionEconomiaTaller.setBackground(new Color(133, 133, 133));
		lblGestionEconomiaTaller.setBounds(81, 359, 127, 42);
		PanelOpciones.add(lblGestionEconomiaTaller);
		
		JTextPane lblGestionServicios = new JTextPane();
		lblGestionServicios.setText("Modelo de gestion \r\nde servicios");
		lblGestionServicios.setForeground(Color.WHITE);
		lblGestionServicios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGestionServicios.setEditable(false);
		lblGestionServicios.setBackground(new Color(133, 133, 133));
		lblGestionServicios.setBounds(81, 245, 127, 42);
		PanelOpciones.add(lblGestionServicios);
		
		JTextPane lblGestionarFacturas = new JTextPane();
		lblGestionarFacturas.setBackground(new Color(133, 133, 133));
		lblGestionarFacturas.setText("Gestionar Facturas");
		lblGestionarFacturas.setForeground(Color.WHITE);
		lblGestionarFacturas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGestionarFacturas.setEditable(false);
		lblGestionarFacturas.setBackground(new Color(133, 133, 133));
		lblGestionarFacturas.setBounds(81, 482, 127, 23);
		PanelOpciones.add(lblGestionarFacturas);
		
		JTextPane lblGestionInformes = new JTextPane();
		lblGestionInformes.setText("Modelo de gestion \r\nde informes");
		lblGestionInformes.setForeground(Color.WHITE);
		lblGestionInformes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGestionInformes.setEditable(false);
		lblGestionInformes.setBackground(new Color(133, 133, 133));
		lblGestionInformes.setBounds(81, 612, 127, 42);
		PanelOpciones.add(lblGestionInformes);
		setLogo(labelLogoPanel);
		
		JLabel lblBuquedaVehiculo = new JLabel("Busqueda de vehiculo");
		lblBuquedaVehiculo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuquedaVehiculo.setBounds(454, 347, 227, 77);
		contentPane.add(lblBuquedaVehiculo);
		
		txtBusquedaMatricula = new JTextField();
		txtBusquedaMatricula.setBounds(680, 354, 274, 66);
		contentPane.add(txtBusquedaMatricula);
		txtBusquedaMatricula.setColumns(10);
		
		JButton btnBuscarMatricula = new JButton("Buscar Matricula\r\n");
		btnBuscarMatricula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscarMatricula.setBounds(680, 445, 274, 88);
		contentPane.add(btnBuscarMatricula);
		
		JLabel lblBusquedaDeCliente = new JLabel("Busqueda de Cliente\r\n");
		lblBusquedaDeCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBusquedaDeCliente.setBounds(1217, 347, 227, 77);
		contentPane.add(lblBusquedaDeCliente);
		
		txtBusquedaCliente = new JTextField();
		txtBusquedaCliente.setColumns(10);
		txtBusquedaCliente.setBounds(1443, 354, 274, 66);
		contentPane.add(txtBusquedaCliente);
		
		JButton btnBuscarClinte = new JButton("Buscar Cliente\r\n\r\n");
		btnBuscarClinte.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscarClinte.setBounds(1443, 445, 274, 88);
		contentPane.add(btnBuscarClinte);
		
		JPanel panelContadorClientes = new JPanel();
		panelContadorClientes.setBounds(534, 782, 227, 191);
		contentPane.add(panelContadorClientes);
		panelContadorClientes.setLayout(null);
		
		JLabel lblContadorClientes = new JLabel("17");
		lblContadorClientes.setBounds(117, 5, 100, 175);
		lblContadorClientes.setFont(new Font("Tahoma", Font.PLAIN, 68));
		panelContadorClientes.add(lblContadorClientes);
		
		JPanel panelContadorVehiculos = new JPanel();
		panelContadorVehiculos.setBounds(1036, 782, 227, 191);
		contentPane.add(panelContadorVehiculos);
		panelContadorVehiculos.setLayout(null);
		
		JLabel lblContadorVehiculos = new JLabel("11");
		lblContadorVehiculos.setBounds(129, 5, 88, 175);
		lblContadorVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 68));
		panelContadorVehiculos.add(lblContadorVehiculos);
		
		JPanel panelContadorMecanicos = new JPanel();
		panelContadorMecanicos.setBounds(1563, 782, 227, 191);
		contentPane.add(panelContadorMecanicos);
		panelContadorMecanicos.setLayout(null);
		
		JLabel lblContadorMecanicos = new JLabel("8");
		lblContadorMecanicos.setFont(new Font("Tahoma", Font.PLAIN, 68));
		lblContadorMecanicos.setBounds(122, 5, 95, 175);
		panelContadorMecanicos.add(lblContadorMecanicos);
		
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
