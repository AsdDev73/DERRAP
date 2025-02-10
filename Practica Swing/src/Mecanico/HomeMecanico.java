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
import Admin.InsertCliente;
import Inicio.ConexionMySQL;
import Inicio.InicioDeSesion;

import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
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
import java.awt.GridLayout;

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
	private JTable tblOrdenes;
	
	HomeMecanico frame;
	String dniMecanico;
	private JTable tblMisOrdenes;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeMecanico frame = new HomeMecanico(null,null);
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
	public HomeMecanico(String user,String dni) {
		frame=this;
		dniMecanico=dni;
		
		
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
		
		JLabel lblUsuario = new JLabel(user);
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(1080, 107, 96, 39);
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
		

		
		JPanel panelConsultarStock = new JPanel();
		panelConsultarStock.setBackground(new Color(192, 192, 192));
		PanelCardPrinci.add(panelConsultarStock, "panelConsultarStock");
		panelConsultarStock.setLayout(null);
		
		JScrollPane scrollPaneStock = new JScrollPane();
		scrollPaneStock.setBounds(21, 5, 986, 556);
		panelConsultarStock.add(scrollPaneStock);
		
		tblStock = new JTable();
		tblStock.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPaneStock.setViewportView(tblStock);
		
		JPanel panelMisOrdenes = new JPanel();
		panelMisOrdenes.setBackground(new Color(192, 192, 192));
		PanelCardPrinci.add(panelMisOrdenes, "panelMisOrdenes");
		panelMisOrdenes.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 808, 550);
		panelMisOrdenes.add(scrollPane);
		
		tblMisOrdenes = new JTable();
		scrollPane.setViewportView(tblMisOrdenes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(854, 88, 137, 75);
		panelMisOrdenes.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAsignarPiezas = new JLabel("Piezas");
		lblAsignarPiezas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					int fila = tblMisOrdenes.getSelectedRow();
					String Id_MisOrdenes = String.valueOf(tblMisOrdenes.getValueAt(fila, 0));
					if(fila != -1) {
						UpdateMisOrdenes um = new UpdateMisOrdenes(Id_MisOrdenes, frame);
						um.setVisible(true);
						um.setLocationRelativeTo(null);
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecciona una orden de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}
				catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Selecciona una orden de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblAsignarPiezas.setForeground(new Color(255, 255, 255));
		lblAsignarPiezas.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAsignarPiezas.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblAsignarPiezas);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(854, 205, 137, 75);
		panelMisOrdenes.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblCancelar = new JLabel("Cancelar");
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					cancelarMisOrdenes();
					UpdateTablaMisOrdenes(frame.dniMecanico);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setForeground(new Color(255, 255, 255));
		lblCancelar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblCancelar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(new Color(128, 128, 128));
		panel_3.setBounds(854, 315, 137, 75);
		panelMisOrdenes.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblTerminar = new JLabel("Terminar");
		lblTerminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					finalizarMisOrdenes();
					UpdateTablaMisOrdenes(frame.dniMecanico);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblTerminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerminar.setForeground(new Color(255, 255, 255));
		lblTerminar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(lblTerminar);
		
		JPanel panelOrdenes = new JPanel();
		panelOrdenes.setBackground(new Color(192, 192, 192));
		PanelCardPrinci.add(panelOrdenes, "panelOrdenes");
		panelOrdenes.setLayout(null);
		
		JScrollPane scrollPaneOrdenes = new JScrollPane();
		scrollPaneOrdenes.setBounds(10, 11, 771, 550);
		panelOrdenes.add(scrollPaneOrdenes);
		
		tblOrdenes = new JTable();
		tblOrdenes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPaneOrdenes.setViewportView(tblOrdenes);
		
		JPanel panelAsignar = new JPanel();
		panelAsignar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelAsignar.setBackground(new Color(128, 128, 128));
		panelAsignar.setBounds(833, 153, 147, 69);
		panelOrdenes.add(panelAsignar);
		panelAsignar.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAsignar = new JLabel("Asignar");
		lblAsignar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					asignarOrden(frame.dniMecanico);
				} catch (ArrayIndexOutOfBoundsException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Selecciona una orden de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblAsignar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsignar.setForeground(new Color(255, 255, 255));
		panelAsignar.add(lblAsignar);
		lblAsignar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panelFacturas = new JPanel();
		PanelCardPrinci.add(panelFacturas, "panelFacturas");
		
		JLabel lblNewLabel_1 = new JLabel("wdewadadw");
		panelFacturas.add(lblNewLabel_1);
		
		
		JLabel lblOrdenesDisponibles = new JLabel("Ordenes");
		lblOrdenesDisponibles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblOrdenesDisponibles.setBounds(81, 11, 127, 90);
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
				UpdateTablaOrdenes();
				cardLayout.show(PanelCardPrinci, "panelOrdenes");
			}
		});
		
		lblFacturas = new JLabel("Facturas");
		lblFacturas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFacturas.setForeground(new Color(255, 255, 255));
		lblFacturas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFacturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cardLayout.show(PanelCardPrinci, "panelFacturas");
			}
		});
		lblFacturas.setBounds(78, 431, 118, 130);
		PanelOpciones.add(lblFacturas);



		JLabel lblStock = new JLabel("Stock");
		lblStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblStock.setForeground(new Color(255, 255, 255));
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UpdateTablaStock();
				cardLayout.show(PanelCardPrinci, "panelConsultarStock");
			}
		});
		lblStock.setBounds(78, 271, 118, 122);
		PanelOpciones.add(lblStock);
		
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

		JLabel lblMisOrdenes = new JLabel("Mis Ordenes");
		lblMisOrdenes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMisOrdenes.setForeground(new Color(255, 255, 255));
		lblMisOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMisOrdenes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UpdateTablaMisOrdenes(dni);
				cardLayout.show(PanelCardPrinci, "panelMisOrdenes");
			}
		});
		lblMisOrdenes.setBounds(78, 125, 118, 122);
		PanelOpciones.add(lblMisOrdenes);
		
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
	
	public void mostrarSelect(String consulta, JTable jtDatos, String cabezera[]) throws SQLException, ClassNotFoundException {
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
			String [] cabezera= {"Codigo_Repuesto","Precio","Cantidad","Proveedor_Codigo"};
			mostrarSelect("Select * FROM repuesto", tblStock,cabezera);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void UpdateTablaOrdenes() {
		try {
			String [] cabezera= {"Codido_Reparacion","Mano_de_obra","Tiempo","Matricula","Fecha"};
			mostrarSelect("Select Codigo_Reparacion, Mano_de_Obra, tiempo, vehiculo_Matricula, fecha FROM ordenes WHERE Mecanico_No_Empleado IS null AND Estado = 'Pendiente'", tblOrdenes,cabezera);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void UpdateTablaMisOrdenes(String dni) {
		try {
			String [] cabezera= {"Codido_Reparacion","Mano_de_obra","Tiempo","Estado","Nº_Empleado", "Id_Factura","Cº_Repuesto", "Matrícula","Fecha"};
			mostrarSelect("Select * FROM ordenes WHERE Mecanico_No_Empleado = "+dni+" AND Estado = 'Pendiente'", tblMisOrdenes,cabezera);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void asignarOrden(String dni) throws SQLException {
        int filaSeleccionada = tblOrdenes.getSelectedRow();
        String codigoReparacion = tblOrdenes.getValueAt(filaSeleccionada, 0).toString();
		if(filaSeleccionada!=-1) {
	        String sentenciaUpdate = "UPDATE ordenes SET Mecanico_No_Empleado = "+dni+" WHERE codigo_reparacion = "+codigoReparacion+";";
	        con.update(sentenciaUpdate);
	        JOptionPane.showMessageDialog(null, "Orden asignada correctamente");
	        UpdateTablaOrdenes();
		}else {
			JOptionPane.showMessageDialog(null, "Selecciona una orden de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}

	}
	private void cancelarMisOrdenes() throws SQLException {
        int filaSeleccionada = tblMisOrdenes.getSelectedRow();
        String codigoReparacion = tblMisOrdenes.getValueAt(filaSeleccionada, 0).toString();
		if(filaSeleccionada!=-1) {
	        String sentenciaUpdate = "UPDATE ordenes SET Mecanico_No_Empleado = null WHERE codigo_reparacion = "+codigoReparacion+";";
	        con.update(sentenciaUpdate);
	        JOptionPane.showMessageDialog(null, "Orden cancelada correctamente");
	        UpdateTablaOrdenes();
		}else {
			JOptionPane.showMessageDialog(null, "Selecciona una orden de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}

	}
	private void finalizarMisOrdenes() throws SQLException {
        int filaSeleccionada = tblMisOrdenes.getSelectedRow();
        String codigoReparacion = tblMisOrdenes.getValueAt(filaSeleccionada, 0).toString();
		if(filaSeleccionada!=-1) {
	        String sentenciaUpdate = "UPDATE ordenes SET Estado = 'Terminado' WHERE codigo_reparacion = "+codigoReparacion+";";
	        con.update(sentenciaUpdate);
	        JOptionPane.showMessageDialog(null, "Orden terminada correctamente");
	        UpdateTablaOrdenes();
		}else {
			JOptionPane.showMessageDialog(null, "Selecciona una orden de la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}

	}
}
