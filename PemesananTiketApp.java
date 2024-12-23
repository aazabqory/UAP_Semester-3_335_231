import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PemesananTiketApp {
    public JFrame frame;
    public JTable table;
    public DefaultTableModel tableModel;
    public JTextField nameField, quantityField;
    public JLabel totalLabel, dateTimeLabel;
    public double totalHarga = 0;
    public DecimalFormat currencyFormat = new DecimalFormat("###,###.##");
    public String imagePath;

    private String[][] matches = {
            {"Atalanta vs Sturm Graz", "Rabu, 22 Januari 2024, 0:45"},
            {"Monaco vs Aston Villa", "Rabu, 22 Januari 2024, 0:45"},
            {"Club Brugge vs Juventus", "Rabu, 22 Januari 2024, 3:00"},
            {"Benfica vs Barcelona", "Rabu, 22 Januari 2024, 3:00"},
            {"Liverpool vs Lille", "Rabu, 22 Januari 2024, 3:00"},
            {"Atletico Madrid vs Bayer Leverkusen", "Rabu, 22 Januari 2024, 3:00"},
            {"FK Crvena Zvezda vs PSV Eindhoven", "Rabu, 22 Januari 2024, 3:00"},
            {"Bologna vs Borussia Dortmund", "Rabu, 22 Januari 2024, 3:00"},
            {"Slovan Bratislava vs VfB Stuttgart", "Rabu, 22 Januari 2024, 3:00"},
            {"Shakhtar Donetsk vs Brest", "Kamis, 23 Januari 2024, 0:45"},
            {"RB Leipzig vs Sporting CP", "Kamis, 23 Januari 2024, 0:45"},
            {"Sparta Praha vs Inter", "Kamis, 23 Januari 2024, 3:00"},
            {"Real Madrid vs Salzburg", "Kamis, 23 Januari 2024, 3:00"},
            {"Arsenal vs Dinamo Zagreb", "Kamis, 23 Januari 2024, 3:00"},
            {"Celtic vs Young Boys", "Kamis, 23 Januari 2024, 3:00"},
            {"Feyenoord vs Bayern Munich", "Kamis, 23 Januari 2024, 3:00"},
            {"AC Milan vs Girona", "Kamis, 23 Januari 2024, 3:00"},
            {"Paris Saint-Germain vs Manchester City", "Kamis, 23 Januari 2024, 3:00"}
    };

    private String[][] standings = {
            {"1", "Liverpool", "6", "6", "0", "0", "13", "1", "+12", "18"},
            {"2", "Barcelona", "6", "5", "0", "1", "21", "7", "+14", "15"},
            {"3", "Arsenal", "6", "4", "1", "1", "11", "2", "+9", "13"},
            {"4", "Bayer Leverkusen", "6", "4", "1", "1", "12", "5", "+7", "13"},
            {"5", "Aston Villa", "6", "4", "1", "1", "9", "3", "+6", "13"},
            {"6", "Inter Milan", "6", "4", "1", "1", "7", "1", "+6", "13"},
            {"7", "Brest", "6", "4", "1", "1", "10", "6", "+4", "13"},
            {"8", "Lille", "6", "4", "1", "1", "10", "7", "+3", "13"},
            {"9", "Borussia Dortmund", "6", "4", "0", "2", "18", "9", "+9", "12"},
            {"10", "Bayern Munchen", "6", "4", "0", "2", "17", "8", "+9", "12"},
            {"11", "Atletico Madrid", "6", "4", "0", "2", "14", "10", "+4", "12"},
            {"12", "AC Milan", "6", "4", "0", "2", "12", "9", "+3", "12"},
            {"13", "Atalanta", "6", "3", "2", "1", "13", "4", "+9", "11"},
            {"14", "Juventus", "6", "3", "2", "1", "9", "5", "+4", "11"},
            {"15", "Benfica", "6", "3", "1", "2", "10", "7", "+3", "10"},
            {"16", "AS Monaco", "6", "3", "1", "2", "12", "10", "+2", "10"},
            {"17", "Sporting CP", "6", "3", "1", "2", "11", "9", "+2", "10"},
            {"18", "Feyenoord", "6", "3", "1", "2", "14", "15", "-1", "10"},
            {"19", "Club Brugge KV", "6", "3", "1", "2", "6", "8", "-2", "10"},
            {"20", "Real Madrid", "6", "3", "0", "3", "12", "11", "+1", "9"},
            {"21", "Celtic", "6", "2", "3", "1", "10", "10", "0", "9"},
            {"22", "Manchester City", "6", "2", "2", "2", "13", "9", "+4", "8"},
            {"23", "PSV Eindhoven", "6", "2", "2", "2", "10", "8", "+2", "8"},
            {"24", "Dinamo Zagreb", "6", "2", "2", "2", "10", "15", "-5", "8"},
            {"25", "Paris Saint-Germain", "6", "2", "1", "3", "6", "6", "0", "7"},
            {"26", "VfB Stuttgart", "6", "2", "1", "3", "9", "12", "-3", "7"},
            {"27", "Shakhtar Donetsk", "6", "1", "1", "4", "5", "13", "-8", "4"},
            {"28", "Sparta Praha", "6", "1", "1", "4", "7", "18", "-11", "4"},
            {"29", "Sturm Graz", "6", "1", "0", "5", "4", "9", "-5", "3"},
            {"30", "Girona", "6", "1", "0", "5", "4", "10", "-6", "3"},
            {"31", "FK Crvena Zvezda", "6", "1", "0", "5", "10", "19", "-9", "3"},
            {"32", "Red Bull Salzburg", "6", "1", "0", "5", "3", "18", "-15", "3"},
            {"33", "Bologna", "6", "0", "2", "4", "1", "7", "-6", "2"},
            {"34", "RB Leipzig", "6", "0", "0", "6", "6", "13", "-7", "0"},
            {"35", "Slovan Bratislava", "6", "0", "0", "6", "5", "21", "-16", "0"},
            {"36", "Young Boys", "6", "0", "0", "6", "3", "22", "-19", "0"}
    };

    private final int ECONOMY_PRICE = 100000;
    private final int VIP_PRICE = 250000;
    private final int VVIP_PRICE = 500000;

    public PemesananTiketApp() {
        frame = new JFrame("Pemesanan Tiket Sepak Bola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"Nama", "Pertandingan", "Jumlah Tiket", "Jenis Kursi (Harga)", "Total Harga (Rp)", "Gambar"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 5) {
                    return ImageIcon.class;
                }
                return super.getColumnClass(column);
            }
        };
        table.setBackground(new Color(230, 255, 230));
        table.setGridColor(Color.GRAY);
        table.setSelectionBackground(new Color(100, 200, 100));
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        JScrollPane tableScroll = new JScrollPane(table);
        panel.add(tableScroll, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 5, 5));
        inputPanel.setBackground(new Color(220, 240, 255));
        inputPanel.add(new JLabel("Nama:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Pilih Pertandingan:"));
        JComboBox<String> matchComboBox = new JComboBox<>();
        for (String[] match : matches) {
            matchComboBox.addItem(match[0] + " (" + match[1] + ")");
        }
        inputPanel.add(matchComboBox);
        inputPanel.add(new JLabel("Jumlah Tiket:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Jenis Kursi:"));

        String[] kursiOptions = {"Ekonomi (Rp " + currencyFormat.format(ECONOMY_PRICE) + ")",
                "VIP (Rp " + currencyFormat.format(VIP_PRICE) + ")",
                "VVIP (Rp " + currencyFormat.format(VVIP_PRICE) + ")"};
        JComboBox<String> kursiComboBox = new JComboBox<>(kursiOptions);
        inputPanel.add(kursiComboBox);

        JButton addButton = new JButton("Pesan Tiket");
        addButton.setBackground(new Color(100, 200, 100));
        inputPanel.add(addButton);
        JButton deleteButton = new JButton("Hapus Tiket");
        deleteButton.setBackground(new Color(255, 100, 100));
        inputPanel.add(deleteButton);
        JButton updateButton = new JButton("Update Tiket");
        updateButton.setBackground(new Color(255, 200, 0));
        inputPanel.add(updateButton);
        JButton resetButton = new JButton("Reset Total & Tiket");
        resetButton.setBackground(new Color(255, 200, 0));
        inputPanel.add(resetButton);
        JButton uploadButton = new JButton("Upload Gambar");
        uploadButton.setBackground(new Color(100, 200, 100));
        inputPanel.add(uploadButton);
        JButton checkStandingsButton = new JButton("Cek Klasemen");
        checkStandingsButton.setBackground(new Color(100, 200, 100));
        inputPanel.add(checkStandingsButton);
        panel.add(inputPanel, BorderLayout.SOUTH);

        JPanel totalPanel = new JPanel(new BorderLayout());
        totalPanel.setBackground(new Color(255, 240, 200));
        totalLabel = new JLabel("Total Harga: Rp 0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        totalPanel.add(totalLabel, BorderLayout.WEST);
        dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        totalPanel.add(dateTimeLabel, BorderLayout.EAST);
        updateDateTime();
        panel.add(totalPanel, BorderLayout.NORTH);

        frame.add(panel);
        frame.setVisible(true);

        Timer timer = new Timer(1000, e -> updateDateTime());
        timer.start();

        addButton.addActionListener(e -> addItem(matchComboBox.getSelectedItem().toString().split(" \\(")[0], (String) kursiComboBox.getSelectedItem()));
        deleteButton.addActionListener(e -> deleteItem());
        updateButton.addActionListener(e -> updateItem(matchComboBox.getSelectedItem().toString().split(" \\(")[0], (String) kursiComboBox.getSelectedItem()));
        resetButton.addActionListener(e -> resetAll());
        uploadButton.addActionListener(e -> uploadImage());
        checkStandingsButton.addActionListener(e -> showStandings());
    }

    public void addItem(String match, String kursi) {
        try {
            int quantity = Integer.parseInt(quantityField.getText());
            String name = nameField.getText().trim();
            if (name.isEmpty() || match.isEmpty() || quantity <= 0) {
                throw new IllegalArgumentException("Semua kolom harus diisi.");
            }
            int price = getPriceBasedOnSeatType(kursi);
            double totalItemPrice = quantity * price;
            ImageIcon imageIcon = (imagePath != null) ? resizeImage(imagePath, 100, 100) : null; // Resize image if exists
            tableModel.addRow(new Object[]{name, match, quantity, kursi, currencyFormat.format(totalItemPrice), imageIcon});
            totalHarga += totalItemPrice;
            updateTotalLabel();
            clearFields();
            JOptionPane.showMessageDialog(frame, "Tiket berhasil dipesan!", "Pesan Tiket", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Jumlah harus angka valid.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getPriceBasedOnSeatType(String seatType) {
        if (seatType.contains("VIP")) {
            return VIP_PRICE;
        } else if (seatType.contains("VVIP")) {
            return VVIP_PRICE;
        } else {
            return ECONOMY_PRICE;
        }
    }

    public void deleteItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String totalHargaString = tableModel.getValueAt(selectedRow, 4).toString().replaceAll(",", "");
            double totalItemPrice = Double.parseDouble(totalHargaString);
            totalHarga -= totalItemPrice;
            tableModel.removeRow(selectedRow);
            updateTotalLabel();
            JOptionPane.showMessageDialog(frame, "Tiket berhasil dihapus!", "Hapus Tiket", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih baris yang ingin dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateItem(String match, String kursi) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            try {
                int quantity = Integer.parseInt(quantityField.getText());
                String name = nameField.getText().trim();
                if (name.isEmpty() || match.isEmpty() || quantity <= 0) {
                    throw new IllegalArgumentException("Data tidak valid.");
                }
                int price = getPriceBasedOnSeatType(kursi);
                double totalItemPrice = quantity * price;
                ImageIcon imageIcon = (imagePath != null) ? resizeImage(imagePath, 100, 100) : (ImageIcon) tableModel.getValueAt(selectedRow, 5); // Use existing image if no new image
                tableModel.setValueAt(name, selectedRow, 0);
                tableModel.setValueAt(match, selectedRow, 1);
                tableModel.setValueAt(quantity, selectedRow, 2);
                tableModel.setValueAt(kursi, selectedRow, 3);
                tableModel.setValueAt(currencyFormat.format(totalItemPrice), selectedRow, 4);
                tableModel.setValueAt(imageIcon, selectedRow, 5);
                updateTotalLabel();
                clearFields();
                JOptionPane.showMessageDialog(frame, "Tiket berhasil diperbarui!", "Update Tiket", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Jumlah harus angka valid.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih baris yang ingin diupdate.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void resetAll() {
        tableModel.setRowCount(0);
        totalHarga = 0;
        updateTotalLabel();
        JOptionPane.showMessageDialog(frame, "Semua tiket dan total harga telah direset.", "Reset Berhasil", JOptionPane.INFORMATION_MESSAGE);
    }

    private void uploadImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih Gambar");
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imagePath = selectedFile.getAbsolutePath();
            JOptionPane.showMessageDialog(frame, "Gambar berhasil diupload!", "Upload Gambar", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private ImageIcon resizeImage(String imagePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    private void updateTotalLabel() {
        totalLabel.setText("Total Harga: Rp " + currencyFormat.format(totalHarga));
    }

    private void updateDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateTimeLabel.setText("Tanggal & Waktu: " + formatter.format(new Date()));
    }

    private void clearFields() {
        nameField.setText("");
        quantityField.setText("");
        imagePath = null;
    }

    private void showStandings() {
        JFrame standingsFrame = new JFrame("Klasemen");
        standingsFrame.setSize(600, 400);
        standingsFrame.setLocationRelativeTo(frame);

        DefaultTableModel standingsModel = new DefaultTableModel(standings, new String[]{"Posisi", "Tim", "Main", "Menang", "Seri", "Kalah", "Gol Memasukkan", "Gol Kemasukan", "Selisih Gol", "Poin"});
        JTable standingsTable = new JTable(standingsModel);
        standingsTable.setFillsViewportHeight(true);

        JScrollPane standingsScroll = new JScrollPane(standingsTable);
        standingsFrame.add(standingsScroll);

        standingsFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PemesananTiketApp::new);
    }
}