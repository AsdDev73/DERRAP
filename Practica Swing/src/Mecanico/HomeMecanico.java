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
import javax.swing.table.DefaultTableModel;

import Admin.HomeAdmin;
import Inicio.ConexionMySQL;
import Inicio.InicioDeSesion;

import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class HomeMecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMatriculaVehiculo;
	JPanel PanelCardPrinci;
	static CardLayout cardLayout;
	private JLabel lblFacturas;
	private JTable tblStock;
	
	private ConexionMySQL con = new ConexionMySQL();
	private Statement stm = null;
	
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
		
		JLabel lblPrincipal = new JLabel("");
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
		lblPrincipal.setBounds(372, -174, 544, 542);
		panelTextoPricipal.add(lblPrincipal);
		setIcono(lblPrincipal, "LetrasDerrap");
		
		JLabel lblBuscarVehiculo = new JLabel("Buscar un vehiculo");
		lblBuscarVehiculo.setForeground(new Color(255, 255, 255));
		lblBuscarVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarVehiculo.setBounds(72, 29, 160, 28);
		panelTextoPricipal.add(lblBuscarVehiculo);
		
		txtMatriculaVehiculo = new JTextField();
		txtMatriculaVehiculo.setBounds(72, 57, 201, 39);
		panelTextoPricipal.add(txtMatriculaVehiculo);
		txtMatriculaVehiculo.setColumns(10);
		
		JButton btbBuscarMatricula = new JButton("OK");
		btbBuscarMatricula.setBounds(72, 100, 89, 23);
		panelTextoPricipal.add(btbBuscarMatricula);
		
		JLabel lblUsuario = new JLabel("Mecánico\r\n");
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
		
		JLabel lblImgMisOrdenes = new JLabel("");
		lblImgMisOrdenes.setBounds(22, 165, 46, 43);
		PanelOpciones.add(lblImgMisOrdenes);
		setIcono(lblImgMisOrdenes, "MisOrdenes");
		
		JLabel lblImgOrdenesDispo = new JLabel("");
		lblImgOrdenesDispo.setBounds(25, 37, 46, 38);
		PanelOpciones.add(lblImgOrdenesDispo);
		setIcono(lblImgOrdenesDispo, "OrdenesReparacion");
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 112, 218, 2);
		PanelOpciones.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 258, 218, 2);
		PanelOpciones.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(0, 418, 218, 2);
		PanelOpciones.add(separator_2);

				
		 lblImgOrdenesDispo = new JLabel("");
		lblImgOrdenesDispo.setBounds(25, 37, 46, 38);
		PanelOpciones.add(lblImgOrdenesDispo);
		
		JLabel lblMisOrdenes = new JLabel("Mis Ordenes");
		lblMisOrdenes.setForeground(new Color(255, 255, 255));
		lblMisOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMisOrdenes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "panelModificarEstadoOrden");
			}
		});
		lblMisOrdenes.setBounds(78, 176, 109, 14);
		PanelOpciones.add(lblMisOrdenes);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(133, 133, 133));
		panel.setBounds(0, 0, 96, 89);
		panelTextoPricipal.add(panel);
		
		JLabel lblImgFlecha_Volver = new JLabel("");
		lblImgFlecha_Volver.addMouseListener(new MouseAdapter() {
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
		lblImgFlecha_Volver.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblImgFlecha_Volver.setBounds(0, 0, 63, 55);
		panel.add(lblImgFlecha_Volver);
		
		JLabel lblPerfilMecanico = new JLabel("");
		lblPerfilMecanico.setBounds(1072, 26, 89, 89);
		panelTextoPricipal.add(lblPerfilMecanico);
		
		JPanel PanelCardPrinci = new JPanel();
		PanelCardPrinci.setBounds(217, 189, 1017, 572);
		contentPane.add(PanelCardPrinci);
		PanelCardPrinci.setLayout(new CardLayout(0, 0));
		
		JPanel panelPricipal = new JPanel();
		panelPricipal.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelPricipal.setBackground(new Color(192, 192, 192));
		PanelCardPrinci.add(panelPricipal, "panelPricipal");
		panelPricipal.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(134, 78, 776, 403);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setForeground(new Color(255, 255, 255));
		panelPricipal.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 5, 756, 46);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Reparaciones pendientes a asignacion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 11, 401, 24);
		panel_2.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 756, 330);
		panel_1.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		scrollPane.setViewportView(panel_3);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cambio de aceite");
		lblNewLabel_2.setBounds(10, 24, 399, 14);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_1 = new JLabel("Cambio de Rueda");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(10, 55, 399, 14);
		panel_3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Revision anual");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(10, 80, 399, 14);
		panel_3.add(lblNewLabel_2_2);
		
	
		
		JPanel panelConsultarStock = new JPanel();
		panelConsultarStock.setBackground(new Color(192, 192, 192));
		PanelCardPrinci.add(panelConsultarStock, "panelConsultarStock");
		panelConsultarStock.setLayout(null);
		
		JScrollPane scrollPaneStock = new JScrollPane();
		scrollPaneStock.setBounds(21, 5, 986, 556);
		panelConsultarStock.add(scrollPaneStock);
		
		tblStock = new JTable();
		scrollPaneStock.setViewportView(tblStock);
		
		JPanel panelModificarEstadoOrden = new JPanel();
		PanelCardPrinci.add(panelModificarEstadoOrden, "panelModificarEstadoOrden");
		
		JPanel panelSolicitarPiezas = new JPanel();
		PanelCardPrinci.add(panelSolicitarPiezas, "panelSolicitarPiezas");
		
		JPanel panelModificarOrdenVehiculo = new JPanel();
		PanelCardPrinci.add(panelModificarOrdenVehiculo, "panelModificarOrdenVehiculo");
		
		
		JLabel lblOrdenesDisponibles = new JLabel("Ordenes");
		lblOrdenesDisponibles.setBounds(81, 48, 82, 14);
		PanelOpciones.add(lblOrdenesDisponibles);
		lblOrdenesDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOrdenesDisponibles.setForeground(new Color(255, 255, 255));
		lblOrdenesDisponibles.setBackground(new Color(240, 240, 240));
		
		JLabel lblImgStock = new JLabel("");
		lblImgStock.setBounds(22, 313, 46, 43);
		PanelOpciones.add(lblImgStock);
		lblOrdenesDisponibles.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "panelModificarOrdenVehiculo");
			}
		});
		
		lblFacturas = new JLabel("Facturas");
		lblFacturas.setForeground(new Color(255, 255, 255));
		lblFacturas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFacturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "panelSolicitarPiezas");
			}
		});
		lblFacturas.setBounds(78, 488, 118, 14);
		PanelOpciones.add(lblFacturas);



		JLabel lblStock = new JLabel("Stock");
		lblStock.setForeground(new Color(255, 255, 255));
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UpdateTablaStock();
				cardLayout.show(PanelCardPrinci, "panelConsultarStock");
			}
		});
		lblStock.setBounds(78, 328, 46, 14);
		PanelOpciones.add(lblStock);
		
		
		 lblMisOrdenes = new JLabel("Mis Ordenes");
		lblMisOrdenes.setForeground(new Color(255, 255, 255));
		lblMisOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMisOrdenes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "panelModificarEstadoOrden");
			}
		});
		lblMisOrdenes.setBounds(78, 176, 109, 14);
		PanelOpciones.add(lblMisOrdenes);
		
		setIcono(lblImgOrdenesDispo, "OrdenesReparacion");
		setIcono(lblImgMisOrdenes, "MisOrdenes");
		setIcono(lblPerfilMecanico, "IconoMecanico");
		
	
		cardLayout= (CardLayout) PanelCardPrinci.getLayout();

		setIcono(lblPerfilMecanico, "IconoMecanico");
		setIcono(lblImgStock, "Stock");
		
		JLabel lblImgFacturas = new JLabel("");
		lblImgFacturas.setBounds(22, 475, 46, 43);
		PanelOpciones.add(lblImgFacturas);
		
		setIcono(lblImgFacturas, "Factura");
		setIcono(lblImgFlecha_Volver, "flecha_volver");

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
	
	private void mostrarSelect(String consulta, JTable jtDatos, String cabezera[]) throws SQLException, ClassNotFoundException {
	    try {
	        con.conectar();	
	        ResultSet rs = con.ejecutarSelect(consulta);
	        DefaultTableModel modelo = new DefaultTableModel(cabezera, 0);

	        // Validar que el número de cabeceras coincida con el número de columnas en el ResultSet
	        int columnCount = rs.getMetaData().getColumnCount();
	        if (cabezera != null && cabezera.length == columnCount) {
	            // Usar las cabeceras proporcionadas
	            modelo.setColumnIdentifiers(cabezera);
	        } else {
	            // Usar las cabeceras del ResultSet si las proporcionadas no coinciden
	            for (int i = 1; i <= columnCount; i++) {
	                modelo.addColumn(rs.getMetaData().getColumnName(i));
	            }
	        }

	        // Agregar filas al modelo de la tabla
	        while (rs.next()) {
	            Object[] fila = new Object[columnCount];
	            for (int i = 0; i < columnCount; i++) {
	                fila[i] = rs.getObject(i + 1);
	            }
	            modelo.addRow(fila);
	        }
	      

	        // Establecer el modelo en la tabla
	        jtDatos.setModel(modelo);
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage());
	    }
	}
	
	public void UpdateTablaStock() {
		try {
			String [] cabezera= {"Codiego_Repuesto","Precio","Cantidad","Proveedor_Codigo"};
			mostrarSelect("Select * FROM repuesto", tblStock,cabezera);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
