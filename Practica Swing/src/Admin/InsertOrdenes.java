package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;

public class InsertOrdenes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMatricula;
	private JTextField textTiempo;
	private JTextField txtManoDeObra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertOrdenes frame = new InsertOrdenes(null);
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
	public InsertOrdenes(HomeAdmin frame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricula.setBounds(31, 88, 86, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblTiempo = new JLabel("Tiempo");
		lblTiempo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTiempo.setBounds(31, 158, 46, 14);
		contentPane.add(lblTiempo);
		
		JLabel lblManoDeObra = new JLabel("Mano de Obra");
		lblManoDeObra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblManoDeObra.setBounds(31, 229, 86, 14);
		contentPane.add(lblManoDeObra);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(31, 113, 121, 34);
		contentPane.add(textMatricula);
		textMatricula.setColumns(10);
		
		textTiempo = new JTextField();
		textTiempo.setBounds(31, 183, 121, 35);
		contentPane.add(textTiempo);
		textTiempo.setColumns(10);
		
		txtManoDeObra = new JTextField();
		txtManoDeObra.setBounds(31, 254, 121, 34);
		contentPane.add(txtManoDeObra);
		txtManoDeObra.setColumns(10);
		
		JButton btnAgregarOrden = new JButton("Agrergar");
		btnAgregarOrden.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregarOrden.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarOrden.setBounds(228, 403, 96, 34);
		contentPane.add(btnAgregarOrden);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(133, 133, 133));
		panel.setBounds(0, 0, 349, 65);
		contentPane.add(panel);
		
		JLabel lblImgVolver = new JLabel("");
		lblImgVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblImgVolver.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblImgVolver.setBounds(0, 0, 41, 35);
		panel.add(lblImgVolver);
		frame.setIcono(lblImgVolver, "flecha_volver");
		
		JLabel lblOrdenes = new JLabel("");
		lblOrdenes.setForeground(Color.WHITE);
		lblOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOrdenes.setBounds(121, 11, 101, 39);
		panel.add(lblOrdenes);
	}
}
