package Inicio;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.HomeAdmin;
import Mecanico.HomeMecanico;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InicioDeSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtContra;
	private ConexionMySQL con = new ConexionMySQL();
	private Statement stm = null;
	private Image image;
	public JLabel LogoDerrap;
	public String contra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioDeSesion frame = new InicioDeSesion();
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
	public InicioDeSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 288, 414);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogIn = new JButton("Iniciar Sesion");
		btnLogIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyChar()==KeyEvent.VK_ENTER) {
					iniciarSesion();
				}
			}
		});
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setBackground(new Color(0, 0, 0));
		btnLogIn.addActionListener(new ActionListener() {
			//boton login
			public void actionPerformed(ActionEvent e) {	
				iniciarSesion();
			}
		});
		btnLogIn.setBounds(143, 341, 121, 23);
		panel.add(btnLogIn);
		
		JButton btnSalir = new JButton("Cancelar");
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(0, 0, 0));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
				
			}
		});
		btnSalir.setBounds(27, 341, 89, 23);
		panel.add(btnSalir);
		
		txtUser = new JTextField();
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
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
		
		
	
		
		
		txtContra = new JPasswordField();
		txtContra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar()==KeyEvent.VK_ENTER) {
					iniciarSesion();
				}
				
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
		txtContra.setForeground(new Color(192, 192, 192));
		txtContra.setText("********");
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
		
		 LogoDerrap = new JLabel("");
		
		LogoDerrap.setBounds(56, 23, 167, 164);
		panel.add(LogoDerrap);
		setLogo();
		
		
	}
	private void setLogo() {
	    try {
	        // Cargar la imagen desde el paquete img
	        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/img/logo_Derrap.png"));

	        // Escalar la imagen
	        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(LogoDerrap.getWidth(), LogoDerrap.getHeight(), Image.SCALE_SMOOTH);

	        // Crear un nuevo ImageIcon con la imagen escalada
	        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

	        // Establecer el icono en el JLabel
	        LogoDerrap.setIcon(iconoEscalado);
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error: La imagen no se pudo cargar o asignar al JLabel.");
	    }
	}

	private void iniciarSesion() {
		//recojemos las variables 
		String usuario = txtUser.getText();
		String contra = new String(txtContra.getPassword());
		try {
			//cpnectamos con la basede datos 
			con.conectar();
			//Controlamos que rol tiene y ejecutamos diferentes pestañas
		int ControlVentana=	con.logIn(usuario, contra);
		
		switch(ControlVentana) {
		
		case 1: //Ventana Admin
			
			HomeAdmin homeAdmin = new HomeAdmin(txtUser.getText());
			homeAdmin.setVisible(true);
			dispose();
			break;
			
		case 2: //Ventana mecanico 
			HomeMecanico homeMecanico = new HomeMecanico(txtUser.getText());
			homeMecanico.setVisible(true);
			dispose();
			break;
		
		case 3: //Error en el Usuario
			 JOptionPane.showMessageDialog(null, "No se ha encotrado ese usario en la base de datos");
			limpiarLogIn();
			break;
		case 4: //Error de contraseña
			 JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
			 limpiarLogIn();
			break;
		default: //error fatal
			 JOptionPane.showMessageDialog(null, "Problemas con la conexion al servidor");
			 limpiarLogIn();
		}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	//metodo para limpiar los campos si el login falla
	private void limpiarLogIn() {
		 txtUser.setText("Escriba su Usuario");
		 txtContra.setText("");
		 txtUser.setForeground(Color.gray);
	}
	
}
