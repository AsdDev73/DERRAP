package Mecanico;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
		setLogo(labelLogoPanel);
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

}
