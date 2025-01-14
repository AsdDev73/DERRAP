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
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class HomeMecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel labelLogoPanel;
	private JTextField txtMatriculaVehiculo;
	JPanel PanelCardPrinci;
	static CardLayout cardLayout;
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
		setBounds(100, 100, 1250, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTextoPricipal = new JPanel();
		panelTextoPricipal.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTextoPricipal.setBackground(new Color(133, 133, 133));
		panelTextoPricipal.setBounds(0, 0, 1234, 189);
		contentPane.add(panelTextoPricipal);
		panelTextoPricipal.setLayout(null);
		
		labelLogoPanel = new JLabel("New label");
		labelLogoPanel.setBounds(76, 11, 168, 151);
		panelTextoPricipal.add(labelLogoPanel);
		
		JLabel lblBuscarVehiculo = new JLabel("Buscar un vehiculo");
		lblBuscarVehiculo.setForeground(new Color(255, 255, 255));
		lblBuscarVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarVehiculo.setBounds(269, 29, 160, 28);
		panelTextoPricipal.add(lblBuscarVehiculo);
		
		txtMatriculaVehiculo = new JTextField();
		txtMatriculaVehiculo.setBounds(269, 57, 160, 39);
		panelTextoPricipal.add(txtMatriculaVehiculo);
		txtMatriculaVehiculo.setColumns(10);
		
		JButton btbBuscarMatricula = new JButton("OK");
		btbBuscarMatricula.setBounds(267, 107, 89, 23);
		panelTextoPricipal.add(btbBuscarMatricula);
		
		JLabel lblPrincipal = new JLabel("DERRAP");
		lblPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "panelPricipal");
			}
		});
		lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 71));
		lblPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipal.setForeground(new Color(255, 255, 255));
		lblPrincipal.setBounds(552, 26, 365, 120);
		panelTextoPricipal.add(lblPrincipal);
		
		JLabel lblUsuario = new JLabel("Mecanico\r\n");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(1080, 107, 132, 39);
		panelTextoPricipal.add(lblUsuario);
		
		JPanel PanelOpciones = new JPanel();
		PanelOpciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		PanelOpciones.setBackground(new Color(133, 133, 133));
		PanelOpciones.setBounds(0, 189, 218, 572);
		contentPane.add(PanelOpciones);
		PanelOpciones.setLayout(null);
		
		JPanel lblSolicitarPiezas = new JPanel();
		lblSolicitarPiezas.setBounds(0, 424, 217, 86);
		PanelOpciones.add(lblSolicitarPiezas);
		lblSolicitarPiezas.setLayout(new BorderLayout(0, 0));
		
		JTextPane lblSolicitarPiezas2 = new JTextPane();
		lblSolicitarPiezas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "panelSolicitarPiezas");
			}
		});
		lblSolicitarPiezas2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSolicitarPiezas.add(lblSolicitarPiezas2);
		lblSolicitarPiezas2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSolicitarPiezas2.setText("Solicitar piezas de sustitución");
		lblSolicitarPiezas2.setForeground(new Color(255, 255, 255));
		lblSolicitarPiezas2.setBackground(new Color(133, 133, 133));
		
		JPanel lblModificarEstadoOrden = new JPanel();
		lblModificarEstadoOrden.setBounds(0, 283, 217, 86);
		PanelOpciones.add(lblModificarEstadoOrden);
		lblModificarEstadoOrden.setLayout(new BorderLayout(0, 0));
		
		JTextPane sdf21 = new JTextPane();
		sdf21.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "panelModificarEstadoOrden");
			}
		});
		sdf21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblModificarEstadoOrden.add(sdf21, BorderLayout.CENTER);
		sdf21.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sdf21.setText("Modificar el estado de una orden de reparación para si mismo");
		sdf21.setForeground(new Color(255, 255, 255));
		sdf21.setBackground(new Color(133, 133, 133));
		
		JPanel lblConsultarStock = new JPanel();
		lblConsultarStock.setBounds(0, 156, 217, 86);
		PanelOpciones.add(lblConsultarStock);
		lblConsultarStock.setLayout(new BorderLayout(0, 0));
		
		JTextPane lblConsultarStock2 = new JTextPane();
		lblConsultarStock2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "panelConsultarStock");
			}
		});
		lblConsultarStock2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblConsultarStock.add(lblConsultarStock2, BorderLayout.CENTER);
		lblConsultarStock2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsultarStock2.setText("Consultar el stock disponiblede piezas en el almacen");
		lblConsultarStock2.setForeground(new Color(255, 255, 255));
		lblConsultarStock2.setBackground(new Color(133, 133, 133));
		
		JPanel lblModificarOrdenVehiculo = new JPanel();
		lblModificarOrdenVehiculo.setBackground(new Color(133, 133, 133));
		lblModificarOrdenVehiculo.setBounds(0, 34, 217, 86);
		PanelOpciones.add(lblModificarOrdenVehiculo);
		lblModificarOrdenVehiculo.setLayout(new BorderLayout(0, 0));
		
		JTextPane lblModificarOrdenVehiculo2 = new JTextPane();
		lblModificarOrdenVehiculo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "panelModificarOrdenVehiculo");
			}
		});
		lblModificarOrdenVehiculo2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblModificarOrdenVehiculo.add(lblModificarOrdenVehiculo2, BorderLayout.CENTER);
		lblModificarOrdenVehiculo2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModificarOrdenVehiculo2.setForeground(new Color(255, 255, 255));
		lblModificarOrdenVehiculo2.setText("Modificar una orden de reparación de un vehículo asignado");
		lblModificarOrdenVehiculo2.setBackground(new Color(133, 133, 133));
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
		
		JPanel PanelCardPrinci = new JPanel();
		PanelCardPrinci.setBounds(217, 189, 1017, 572);
		contentPane.add(PanelCardPrinci);
		PanelCardPrinci.setLayout(new CardLayout(0, 0));
		
		JPanel panelPricipal = new JPanel();
		PanelCardPrinci.add(panelPricipal, "panelPricipal");
		panelPricipal.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBounds(134, 241, 776, 281);
		panelPricipal.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 5, 756, 46);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Reparaciones pendientes a asignacion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 11, 401, 24);
		panel_2.add(lblNewLabel_1);
		
		JPanel panelModificarOrdenVehiculo = new JPanel();
		PanelCardPrinci.add(panelModificarOrdenVehiculo, "panelModificarOrdenVehiculo");
		
		JPanel panelConsultarStock = new JPanel();
		PanelCardPrinci.add(panelConsultarStock, "panelConsultarStock");
		
		JPanel panelModificarEstadoOrden = new JPanel();
		PanelCardPrinci.add(panelModificarEstadoOrden, "panelModificarEstadoOrden");
		
		JPanel panelSolicitarPiezas = new JPanel();
		PanelCardPrinci.add(panelSolicitarPiezas, "panelSolicitarPiezas");
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
