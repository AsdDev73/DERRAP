package Mecanico;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Admin.HomeAdmin;
import Inicio.InicioDeSesion;

import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeMecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel labelLogoPanel;
	private JTextField txtMatriculaVehiculo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeMecanico frame = new HomeMecanico(null);
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
	 */
	public HomeMecanico(String user) {

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
		labelLogoPanel.setBounds(76, 43, 199, 189);
		panelTextoPricipal.add(labelLogoPanel);
		
		JLabel lblBuscarVehiculo = new JLabel("Buscar un vehiculo");
		lblBuscarVehiculo.setForeground(new Color(255, 255, 255));
		lblBuscarVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarVehiculo.setBounds(343, 43, 160, 28);
		panelTextoPricipal.add(lblBuscarVehiculo);
		
		txtMatriculaVehiculo = new JTextField();
		txtMatriculaVehiculo.setBounds(343, 71, 160, 39);
		panelTextoPricipal.add(txtMatriculaVehiculo);
		txtMatriculaVehiculo.setColumns(10);
		
		JButton btbBuscarMatricula = new JButton("OK");
		btbBuscarMatricula.setBounds(341, 121, 89, 23);
		panelTextoPricipal.add(btbBuscarMatricula);
		
		JLabel lblPrincipal = new JLabel("DASHBOARD");
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipal.setForeground(new Color(255, 255, 255));
		lblPrincipal.setBounds(566, 25, 975, 207);
		panelTextoPricipal.add(lblPrincipal);
		
		JLabel lblUsuario = new JLabel("Mecanico\r\n");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(1753, 141, 66, 39);
		panelTextoPricipal.add(lblUsuario);
		
		JPanel PanelOpciones = new JPanel();
		PanelOpciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		PanelOpciones.setBackground(new Color(133, 133, 133));
		PanelOpciones.setBounds(0, 288, 323, 813);
		contentPane.add(PanelOpciones);
		PanelOpciones.setLayout(null);
		
		JTextPane lblModificarOrdenVehiculo = new JTextPane();
		lblModificarOrdenVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModificarOrdenVehiculo.setForeground(new Color(255, 255, 255));
		lblModificarOrdenVehiculo.setText("Modificar una orden de reparación de un vehículo asignado");
		lblModificarOrdenVehiculo.setBackground(new Color(133, 133, 133));
		lblModificarOrdenVehiculo.setBounds(74, 11, 164, 71);
		PanelOpciones.add(lblModificarOrdenVehiculo);
		
		JTextPane lblConsultarStock = new JTextPane();
		lblConsultarStock.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsultarStock.setText("Consultar el stock disponiblede piezas en el almacen");
		lblConsultarStock.setForeground(Color.WHITE);
		lblConsultarStock.setBackground(new Color(133, 133, 133));
		lblConsultarStock.setBounds(74, 189, 164, 71);
		PanelOpciones.add(lblConsultarStock);
		
		JTextPane lblModificarEstadoOrden = new JTextPane();
		lblModificarEstadoOrden.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModificarEstadoOrden.setText("Modificar el estado de una orden de reparación para si mismo");
		lblModificarEstadoOrden.setForeground(Color.WHITE);
		lblModificarEstadoOrden.setBackground(new Color(133, 133, 133));
		lblModificarEstadoOrden.setBounds(61, 375, 168, 86);
		PanelOpciones.add(lblModificarEstadoOrden);
		
		JTextPane lblSolicitarPiezas = new JTextPane();
		lblSolicitarPiezas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSolicitarPiezas.setText("Solicitar piezas de sustitución");
		lblSolicitarPiezas.setForeground(Color.WHITE);
		lblSolicitarPiezas.setBackground(new Color(133, 133, 133));
		lblSolicitarPiezas.setBounds(74, 569, 133, 51);
		PanelOpciones.add(lblSolicitarPiezas);
		setLogo(labelLogoPanel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(133, 133, 133));
		panel.setBounds(0, 0, 96, 89);
		panelTextoPricipal.add(panel);
		
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
		lblNewLabel.setBounds(0, 0, 86, 78);
		panel.add(lblNewLabel);
		
		JPanel panelValoracion = new JPanel();
		panelValoracion.setBackground(new Color(133, 133, 133));
		panelValoracion.setBounds(402, 348, 280, 224);
		contentPane.add(panelValoracion);
		panelValoracion.setLayout(null);
		
		JLabel lblValoracion = new JLabel("4.8");
		lblValoracion.setFont(new Font("Tahoma", Font.PLAIN, 59));
		lblValoracion.setBounds(104, 11, 166, 190);
		panelValoracion.add(lblValoracion);
		
		JPanel panelClientes = new JPanel();
		panelClientes.setLayout(null);
		panelClientes.setBackground(new Color(133, 133, 133));
		panelClientes.setBounds(786, 348, 280, 224);
		contentPane.add(panelClientes);
		
		JLabel lblClientes = new JLabel("21");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 72));
		lblClientes.setBounds(139, 11, 131, 190);
		panelClientes.add(lblClientes);
		
		JPanel panelVehiculos = new JPanel();
		panelVehiculos.setLayout(null);
		panelVehiculos.setBackground(new Color(133, 133, 133));
		panelVehiculos.setBounds(1171, 348, 280, 224);
		contentPane.add(panelVehiculos);
		
		JLabel lblVehiculos = new JLabel("10");
		lblVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 82));
		lblVehiculos.setBounds(119, 11, 151, 190);
		panelVehiculos.add(lblVehiculos);
		
		JPanel panelMecanicos = new JPanel();
		panelMecanicos.setLayout(null);
		panelMecanicos.setBackground(new Color(133, 133, 133));
		panelMecanicos.setBounds(1563, 348, 280, 224);
		contentPane.add(panelMecanicos);
		
		JLabel lblMecanicos = new JLabel("7");
		lblMecanicos.setFont(new Font("Tahoma", Font.PLAIN, 84));
		lblMecanicos.setBounds(127, 11, 143, 190);
		panelMecanicos.add(lblMecanicos);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		list.setFont(new Font("Tahoma", Font.PLAIN, 24));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"- Cambio de aceite rutinario"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(477, 723, 1187, 327);
		contentPane.add(list);
		
		JLabel lblReparacionesPendientes = new JLabel("Reparaciones pendientes");
		lblReparacionesPendientes.setBackground(new Color(133, 133, 133));
		lblReparacionesPendientes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblReparacionesPendientes.setBounds(477, 696, 1187, 26);
		contentPane.add(lblReparacionesPendientes);
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

	private void pantallaCompleta(HomeMecanico homeMecanico) {
		// Obtener el tamaño de la pantalla
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gs = ge.getDefaultScreenDevice();

        // Hacer la ventana de pantalla completa
        homeMecanico.setUndecorated(true); // Elimina los bordes y la barra de título
        gs.setFullScreenWindow(homeMecanico);

        // Asegurarse de que la ventana se cierre correctamente
        homeMecanico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
