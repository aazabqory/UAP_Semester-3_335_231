import org.junit.Before;
import org.junit.Test;

import javax.swing.table.DefaultTableModel;

import static org.junit.Assert.*;

public class PemesananTiketTest {
    public PemesananTiketApp app;

    @Before
    public void setUp() {
        app = new PemesananTiketApp();
    }

    @Test
    public void testGetPriceBasedOnSeatTypeEror() {
        assertEquals(100000, app.getPriceBasedOnSeatType("Ekonomi (Rp 100.000)"));
        assertEquals(250000, app.getPriceBasedOnSeatType("VIP (Rp 250.000)"));
        assertEquals(500000, app.getPriceBasedOnSeatType("VVIP (Rp 500.000)"));
    }

    @Test
    public void testAddItem() {
        app.nameField.setText("John Doe");
        app.quantityField.setText("2");
        String match = "Atalanta vs Sturm Graz";
        String seatType = "Ekonomi (Rp 100.000)";

        app.addItem(match, seatType);

        DefaultTableModel model = (DefaultTableModel) app.table.getModel();
        assertEquals(1, model.getRowCount());
        assertEquals("John Doe", model.getValueAt(0, 0));
        assertEquals(match, model.getValueAt(0, 1));
        assertEquals(2, model.getValueAt(0, 2));
        assertEquals(seatType, model.getValueAt(0, 3));
        assertEquals("200,000", model.getValueAt(0, 4));
    }

    @Test
    public void testDeleteItem() {
        app.nameField.setText("Jane Doe");
        app.quantityField.setText("1");
        app.addItem("Monaco vs Aston Villa", "VIP (Rp 250.000)");

        app.table.setRowSelectionInterval(0, 0);
        app.deleteItem();

        DefaultTableModel model = (DefaultTableModel) app.table.getModel();
        assertEquals(0, model.getRowCount());
    }

    @Test
    public void testResetAll() {
        app.nameField.setText("Test User");
        app.quantityField.setText("3");
        app.addItem("Club Brugge vs Juventus", "VVIP (Rp 500.000)");

        app.resetAll();

        DefaultTableModel model = (DefaultTableModel) app.table.getModel();
        assertEquals(0, model.getRowCount()); // Pastikan tabel kosong
        assertEquals(0, app.totalHarga, 0.01); // Pastikan total harga 0
    }

    @Test
    public void testUpdateItem() {
        app.nameField.setText("Test User");
        app.quantityField.setText("2");
        app.addItem("Benfica vs Barcelona", "Ekonomi (Rp 100.000)");

        app.table.setRowSelectionInterval(0, 0);
        app.nameField.setText("Updated User");
        app.quantityField.setText("3");
        app.updateItem("Benfica vs Barcelona", "Ekonomi (Rp 100.000)");

        DefaultTableModel model = (DefaultTableModel) app.table.getModel();
        assertEquals("Updated User", model.getValueAt(0, 0));
        assertEquals(3, model.getValueAt(0, 2)); // Pastikan jumlah tiket diupdate
        assertEquals("300,000", model.getValueAt(0, 4)); // Pastikan total harga diupdate
    }
}