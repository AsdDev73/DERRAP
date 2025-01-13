package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Inicio.ConexionMySQL;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarConsulta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable ResultadosConsuta;
	JLabel lblSentencia;
	
	private ConexionMySQL con = new ConexionMySQL();
	private Statement stm = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarConsulta frame = new MostrarConsulta("");
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
	 * @param i 
	 * @throws SQLException 
	 * @throws ClassNotFoundException `+
	 */
	public MostrarConsulta(String frase) throws SQLException, ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTextoDefault = new JLabel("Consulta:\r\n");
		lblTextoDefault.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTextoDefault.setBounds(10, 24, 133, 41);
		contentPane.add(lblTextoDefault);
		
		lblSentencia = new JLabel("");
		lblSentencia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSentencia.setBounds(105, 14, 681, 67);
		contentPane.add(lblSentencia);
		
		ResultadosConsuta = new JTable();
		ResultadosConsuta.setBounds(20, 80, 800, 328);
		contentPane.add(ResultadosConsuta);
		
		JButton btnVolver = new JButton("Volver\r\n");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnVolver.setBounds(614, 419, 172, 48);
		contentPane.add(btnVolver);
		
		mostrarSelect(frase,ResultadosConsuta);

		
	}
	
	private void mostrarSelect(String consulta, JTable jtDatos) throws SQLException, ClassNotFoundException {
	      try {
	    	  con.conectar();	
	        ResultSet rs = con.ejecutarSelect(consulta);
	        DefaultTableModel modelo = new DefaultTableModel();
	        
	        // Obtener los metadatos para obtener el nombre y el numero de consultas
	        int columnCount = rs.getMetaData().getColumnCount();
	        
	        // Agregar columnas al modelo de la tabla
	        for (int i = 1; i <= columnCount; i++) {
	            modelo.addColumn(rs.getMetaData().getColumnName(i));
	        }

	        // Agregar filas al modelo de la tabla
	        while (rs.next()) {
	            Object[] fila = new Object[columnCount];
	            for (int i = 0; i < columnCount; i++) {
	                fila[i] = rs.getObject(i + 1);
	            }
	            modelo.addRow(fila);
	        }

	        // Establecer el modelo en la tabla y cambiar de panel
	       
	        jtDatos.setModel(modelo);
	        lblSentencia.setText(consulta);
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(this, "Error al ejecutar la consulta: " + e.getMessage());
	    }
	      
	    }
}
