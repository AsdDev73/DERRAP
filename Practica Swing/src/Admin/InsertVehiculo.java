
package Admin;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Inicio.ConexionMySQL;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InsertVehiculo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFecha_Entrada;
    private JTextField textFecha_Salida;
    private JTextField textColor;
    private JTextField textModelo;
    private JTextField textReparacion_Codigo_Reparacion;
    private JTextField textMarca;
    private JTextField textMatricula;
    private JTextField textDNI_Cliente;
    private ConexionMySQL con = new ConexionMySQL();
    private Statement stm = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsertVehiculo frame = new InsertVehiculo("", 1);
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
    public InsertVehiculo(String frase, int i) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 478, 637);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("<--");
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
            }
        });
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_1.setBounds(10, 11, 59, 34);
        contentPane.add(lblNewLabel_1);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(133, 133, 133));
        panel.setBounds(0, 0, 462, 76);
        contentPane.add(panel);

        JLabel lblPrincipal = new JLabel("Vehiculo");
        lblPrincipal.setForeground(Color.WHITE);
        lblPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPrincipal.setBounds(185, 11, 75, 39);
        panel.add(lblPrincipal);

        JLabel lblMatricula = new JLabel("Matricula");
        lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMatricula.setBounds(26, 97, 75, 14);
        contentPane.add(lblMatricula);

        JLabel lblMarca = new JLabel("Marca");
        lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMarca.setBounds(26, 153, 46, 14);
        contentPane.add(lblMarca);

        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblModelo.setBounds(26, 209, 46, 14);
        contentPane.add(lblModelo);

        JLabel lblColor = new JLabel("Color");
        lblColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblColor.setBounds(26, 265, 46, 14);
        contentPane.add(lblColor);

        JLabel lblFecha_Entrada = new JLabel("Fecha Entrada");
        lblFecha_Entrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFecha_Entrada.setBounds(26, 322, 115, 14);
        contentPane.add(lblFecha_Entrada);

        JLabel lblFecha_Salida = new JLabel("Fecha Salida");
        lblFecha_Salida.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFecha_Salida.setBounds(26, 378, 86, 14);
        contentPane.add(lblFecha_Salida);

        JLabel lblDNI_Cliente = new JLabel("DNI Cliente");
        lblDNI_Cliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDNI_Cliente.setBounds(26, 434, 86, 14);
        contentPane.add(lblDNI_Cliente);

        JLabel lblReparacion_Codigo_Reparacion = new JLabel("Codigo Reparacion");
        lblReparacion_Codigo_Reparacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblReparacion_Codigo_Reparacion.setBounds(26, 490, 115, 28);
        contentPane.add(lblReparacion_Codigo_Reparacion);

        textFecha_Entrada = new JTextField();
        textFecha_Entrada.setBounds(26, 347, 146, 28);
        contentPane.add(textFecha_Entrada);
        textFecha_Entrada.setColumns(10);

        textFecha_Salida = new JTextField();
        textFecha_Salida.setBounds(26, 403, 146, 28);
        contentPane.add(textFecha_Salida);
        textFecha_Salida.setColumns(10);

        textColor = new JTextField();
        textColor.setBounds(26, 290, 146, 28);
        contentPane.add(textColor);
        textColor.setColumns(10);

        textModelo = new JTextField();
        textModelo.setBounds(26, 234, 146, 28);
        contentPane.add(textModelo);
        textModelo.setColumns(10);

        textReparacion_Codigo_Reparacion = new JTextField();
        textReparacion_Codigo_Reparacion.setBounds(26, 515, 146, 28);
        contentPane.add(textReparacion_Codigo_Reparacion);
        textReparacion_Codigo_Reparacion.setColumns(10);

        textMarca = new JTextField();
        textMarca.setBounds(26, 178, 146, 28);
        contentPane.add(textMarca);
        textMarca.setColumns(10);

        textMatricula = new JTextField();
        textMatricula.setBounds(26, 122, 146, 28);
        contentPane.add(textMatricula);
        textMatricula.setColumns(10);

        textDNI_Cliente = new JTextField();
        textDNI_Cliente.setBounds(26, 459, 146, 28);
        contentPane.add(textDNI_Cliente);
        textDNI_Cliente.setColumns(10);

        JButton btnAgregarVehiculo = new JButton("Agregar");
        btnAgregarVehiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int controlFuncion = i;

                String DNI_Cliente = textDNI_Cliente.getText();
                String Matricula = textMatricula.getText();
                String Marca = textMarca.getText();
                String Reparacion = textReparacion_Codigo_Reparacion.getText();
                String Modelo = textModelo.getText();
                String Color = textColor.getText();
                String Fecha_Entrada = textFecha_Entrada.getText();
                String Fecha_Salida = textFecha_Salida.getText();


if(i == 1) { // 1 es para que haga el insert
    if (!DNI_Cliente.isEmpty() && !Matricula.isEmpty() && !Marca.isEmpty() && !Modelo.isEmpty() && !Color.isEmpty() && !Fecha_Entrada.isEmpty() && !Fecha_Salida.isEmpty() && !Reparacion.isEmpty()) {
        try {
            con.conectar();
            int funciona = con.insetarVehiculo(DNI_Cliente, Matricula, Marca, Modelo, Color, Fecha_Entrada, Fecha_Salida, Reparacion);

            if (funciona > 0) {
                JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
                dispose();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(null, "Error al insertar los datos, revise si hay algun campo vacio");
    }
}

if(i == 2) { // hace el update
    if (!DNI_Cliente.isEmpty() && !Matricula.isEmpty() && !Marca.isEmpty() && !Modelo.isEmpty() && !Color.isEmpty() && !Fecha_Entrada.isEmpty() && !Fecha_Salida.isEmpty() && !Reparacion.isEmpty()) {
        try {
            con.conectar();
            int funciona = con.ejecutarUpdateVehiculo(DNI_Cliente, Matricula, Marca, Modelo, Color, Fecha_Entrada, Fecha_Salida, Reparacion);

            if (funciona > 0) {
                JOptionPane.showMessageDialog(null, "Vehiculo actualizado correctamente");
                dispose();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        limpiarCampos();
    } else {
        JOptionPane.showMessageDialog(null, "Error al actualizar los datos, revise si hay algun campo vacio");
    }
}

				
				
				
			}
		});

        btnAgregarVehiculo.setBounds(210, 400, 110, 36);
        contentPane.add(btnAgregarVehiculo);

        if (i == 2) {
            lblPrincipal.setText("Update");
            textDNI_Cliente.setText(frase);
            textDNI_Cliente.setEnabled(false);
        } else {
            lblPrincipal.setText("Insert");
        }

        btnAgregarVehiculo.setBounds(26, 560, 146, 28);
        contentPane.add(btnAgregarVehiculo);
    }

    private void limpiarCampos() {
        textDNI_Cliente.setText("");
        textMatricula.setText("");
        textMarca.setText("");
        textModelo.setText("");
        textColor.setText("");
        textFecha_Entrada.setText("");
        textFecha_Salida.setText("");
        textReparacion_Codigo_Reparacion.setText("");
    }
}



		
		

	
