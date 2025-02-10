package Mecanico;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Inicio.ConexionMySQL;
import Inicio.InicioDeSesion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class UpdateMisOrdenes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPieza;
	private JTable tblPieza;
	private ConexionMySQL con = new ConexionMySQL();
	private Statement stm = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMisOrdenes frame = new UpdateMisOrdenes(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public UpdateMisOrdenes(String MisOrdenes, HomeMecanico frame) throws ClassNotFoundException, SQLException {
		setBackground(new Color(192, 192, 192));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 383);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(133, 133, 133));
		panel.setBounds(0, 0, 434, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblimgFlecha_Volver = new JLabel("");
		lblimgFlecha_Volver.addMouseListener(new MouseAdapter() {
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
                    
                  
				
                }
			}
		});
		lblimgFlecha_Volver.setBounds(10, 11, 46, 42);
		panel.add(lblimgFlecha_Volver);
		
		JLabel lblNewLabel = new JLabel("Nº Pieza");
		lblNewLabel.setBounds(33, 98, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtPieza = new JTextField();
		txtPieza.setBounds(33, 122, 86, 20);
		contentPane.add(txtPieza);
		txtPieza.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(146, 86, 278, 246);
		contentPane.add(scrollPane);
		
		tblPieza = new JTable();
		scrollPane.setViewportView(tblPieza);
		
		setIcono(lblimgFlecha_Volver, "flecha_volver");
		String consulta = "SELECT * FROM repuesto";
		String [] cabecera= {"Codigo","Precio","Cantidad","Codigo_Proveedor"};
		frame.mostrarSelect(consulta, tblPieza, cabecera);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(33, 200, 86, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblUpdateStockOrdenes = new JLabel("Aceptar");
		lblUpdateStockOrdenes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
						con.conectar();
						int funciona=con.updateStockOrdenes(MisOrdenes, txtPieza.getText());
						frame.UpdateTablaMisOrdenes(frame.dniMecanico);
						
						if (funciona > 0) {
			                 JOptionPane.showMessageDialog(null, "Orden actualizada correctamente");
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
		lblUpdateStockOrdenes.setForeground(new Color(255, 255, 255));
		lblUpdateStockOrdenes.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblUpdateStockOrdenes);
		
	}
	private void setIcono(JLabel label, String img) {
	    try {
	        // Cargar la imagen desde el paquete img
	        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/img/"+img+".png"));

	        // Escalar la imagen
	        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);

	        // Crear un nuevo ImageIcon con la imagen escalada
	        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

	        // Establecer el icono en el JLabel
	        label.setIcon(iconoEscalado);
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error: La imagen no se pudo cargar o asignar al JLabel.");
	    }
	}
}
