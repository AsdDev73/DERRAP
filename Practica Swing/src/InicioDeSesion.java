import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InicioDeSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioDeSesion frame = new InicioDeSesion();
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
	public InicioDeSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(185, 32, 288, 414);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogIn = new JButton("Iniciar Sesion");
		btnLogIn.setBounds(157, 380, 121, 23);
		panel.add(btnLogIn);
		
		JButton btnSalir = new JButton("Cancelar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
				
			}
		});
		btnSalir.setBounds(10, 380, 89, 23);
		panel.add(btnSalir);
		
		txtUser = new JTextField();
		txtUser.setForeground(new Color(192, 192, 192));
		txtUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 if (txtUser.getText().equals("Escriba su Usuario")) {
					 txtUser.setText("");
					 txtUser.setForeground(Color.black);
			        }
			        if (String.valueOf(txtContra.getPassword()).isEmpty()) {
			        	txtContra.setText("********");
			        	txtContra.setForeground(Color.gray);
			        }
			}
		});
		txtUser.setText("Escriba su Usuario");
		txtUser.setBounds(70, 232, 138, 22);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(70, 212, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(70, 261, 89, 14);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(85, 37, 120, 115);
		panel.add(panel_1);
		
		
	
		
		
		txtContra = new JPasswordField();
		txtContra.setForeground(new Color(192, 192, 192));
		txtContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 if (String.valueOf(txtContra.getPassword()).equals("********")) {
					 txtContra.setText("");
					 txtContra.setForeground(Color.black);
			        }
			        if (txtUser.getText().isEmpty()) {
			        	txtUser.setText("Escriba su Usuario");
			        	txtUser.setForeground(Color.gray);
			        }
			}
		});
		txtContra.setToolTipText("");
		txtContra.setBounds(70, 278, 139, 21);
		panel.add(txtContra);
	}
}
