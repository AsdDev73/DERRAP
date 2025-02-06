package Admin;

import java.awt.EventQueue;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.VerticalAlignment;

public class FacturaInfo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/derrap";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String OUTPUT_FILE = "Ordenes_Report.pdf";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	FacturaInfo frame = new FacturaInfo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FacturaInfo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JButton btnGeneratePdf = new JButton("Crear informe");
        btnGeneratePdf.addActionListener(e -> createReport());
        contentPane.add(btnGeneratePdf);
    }
    
    public void createReport() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ordenes")) {
            
            PdfWriter writer = new PdfWriter(OUTPUT_FILE);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4);
            
            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            Color darkGrey = new DeviceRgb(80, 80, 80);
            Color clearWhite = new DeviceRgb(220, 220, 220);
            
            document.add(new Paragraph("Reporte de Órdenes").setFont(boldFont).setFontSize(16));
            
            float[] columnWidths = {60, 80, 60, 100, 80, 80, 80, 80, 80};
            Table table = new Table(columnWidths);
            table.addCell(createColoredTextCell("Código", boldFont, 12, clearWhite));
            table.addCell(createColoredTextCell("Mano de Obra", boldFont, 12, clearWhite));
            table.addCell(createColoredTextCell("Tiempo", boldFont, 12, clearWhite));
            table.addCell(createColoredTextCell("Estado", boldFont, 12, clearWhite));
            table.addCell(createColoredTextCell("Fecha", boldFont, 12, clearWhite));
            table.addCell(createColoredTextCell("Mecánico", boldFont, 12, clearWhite));
            table.addCell(createColoredTextCell("Factura", boldFont, 12, clearWhite));
            table.addCell(createColoredTextCell("Repuesto", boldFont, 12, clearWhite));
            table.addCell(createColoredTextCell("Matrícula", boldFont, 12, clearWhite));
            
            while (rs.next()) {
                table.addCell(createTextCell(String.valueOf(rs.getInt("Codigo_Reparacion")), font, 10));
                table.addCell(createTextCell(String.valueOf(rs.getDouble("Mano_de_obra")), font, 10));
                table.addCell(createTextCell(String.valueOf(rs.getTime("tiempo")), font, 10));
                table.addCell(createTextCell(rs.getString("Estado"), font, 10));
                table.addCell(createTextCell(String.valueOf(rs.getDate("fecha")), font, 10));
                table.addCell(createTextCell(String.valueOf(rs.getInt("Mecanico_No_Empleado")), font, 10));
                table.addCell(createTextCell(String.valueOf(rs.getInt("Factura_ID_Factura")), font, 10));
                table.addCell(createTextCell(rs.getString("Repuesto_Codigo_Repuesto"), font, 10));
                table.addCell(createTextCell(rs.getString("vehiculo_Matricula"), font, 10));
            }
            
            document.add(table);
            document.close();
            System.out.println("PDF generado con éxito: " + OUTPUT_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Cell createTextCell(String text, PdfFont font, float fontSize) {
        return new Cell()
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph(new Text(text).setFont(font).setFontSize(fontSize)))
                .setBorder(Border.NO_BORDER);
    }
    
    public Cell createColoredTextCell(String text, PdfFont font, float fontSize, Color color) {
        return new Cell()
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph(new Text(text).setFont(font).setFontSize(fontSize).setFontColor(color)))
                .setBorder(Border.NO_BORDER);
    }
}
