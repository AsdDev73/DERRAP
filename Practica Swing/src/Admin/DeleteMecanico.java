package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inicio.ConexionMySQL;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DeleteMecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ConexionMySQL con = new ConexionMySQL();
	private Statement stm = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteMecanico frame = new DeleteMecanico("  ");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param frase 
	 */
	public DeleteMecanico(String frase) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 434, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eliminar");
		lblNewLabel.setBounds(179, 21, 77, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dni:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(23, 130, 79, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDNI = new JLabel("");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDNI.setBounds(112, 130, 79, 29);
		contentPane.add(lblDNI);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nombre:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(23, 184, 79, 29);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(112, 184, 79, 29);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel_1_4 = new JLabel("Apellido:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(23, 236, 79, 29);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblApellido = new JLabel("");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellido.setBounds(112, 236, 79, 29);
		contentPane.add(lblApellido);
		
		JLabel lblNewLabel_1_6 = new JLabel("Tlf:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_6.setBounds(23, 278, 79, 29);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblTlf = new JLabel("");
		lblTlf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTlf.setBounds(112, 276, 79, 29);
		contentPane.add(lblTlf);
		
		JButton Eliminar = new JButton("Eliminar");
		Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.conectar();
					int funciona=con.ejecutarDeleteMecanico(frase);

					if (funciona > 0) {
		                 JOptionPane.showMessageDialog(null, "Mecánico eliminado correctamente");
		                     dispose();
				}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}					

			}
		});
		Eliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Eliminar.setBounds(149, 329, 119, 42);
		contentPane.add(Eliminar);
	}
}
