# Pemesanan Tiket Sepak Bola

Aplikasi `Pemesanan Tiket Sepak Bola` adalah program Java yang memungkinkan pengguna untuk memesan tiket pertandingan sepak bola dengan antarmuka grafis menggunakan Swing. Aplikasi ini menyajikan daftar pertandingan, memungkinkan pengguna untuk memilih jenis kursi, memasukkan jumlah tiket yang diinginkan, dan menampilkan total harga yang harus dibayar.

## Fitur Utama

- **Daftar Pertandingan**: Menampilkan daftar pertandingan sepak bola yang akan datang.
- **Formulir Pemesanan**: Pengguna dapat memasukkan nama, jumlah tiket, dan memilih jenis kursi (Ekonomi, VIP, VVIP).
- **Pengelolaan Tiket**: Menambahkan, menghapus dan memperbarui pemesanan tiket.
- **Total Harga**: Menampilkan total harga tiket yang dipesan.
- **Upload Gambar**: Mengizinkan pengguna untuk mengupload gambar terkait pemesanan.
- **Waktu dan Tanggal**: Menampilkan waktu dan tanggal saat ini yang diperbarui setiap detik.
- **Tampilan Klasemen**: Pengguna dapat melihat klasemen tim yang berpartisipasi dalam jendela terpisah.

## Prasyarat

Sebelum menjalankan aplikasi, pastikan Anda memiliki:
- **Java Development Kit (JDK)**: Versi 8 atau lebih baru.
- **IDE**: Seperti IntelliJ IDEA, Eclipse, atau NetBeans untuk menjalankan dan mengedit kode.

## Instalasi

1. Clone repositori ini atau unduh file Java.
2. Buka file `PemesananTiketApp.java` di IDE Anda.
3. Kompilasi dan jalankan aplikasi.

## Cara Menggunakan

1. Jalankan aplikasi.
2. Masukkan nama dan jumlah tiket yang ingin dipesan.
3. Pilih pertandingan dari dropdown yang tersedia.
4. Pilih jenis kursi (Ekonomi, VIP, VVIP).
5. Klik tombol "Pesan Tiket" untuk menambahkan tiket ke tabel.
6. Anda dapat memperbarui atau menghapus tiket yang telah dipesan.
7. Klik "Reset Total & Tiket" untuk menghapus semua pemesanan.
8. Untuk mengupload gambar, klik tombol "Upload Gambar".
9. Klik tombol "Cek Klasemen" untuk mengecek klasemen pekan ke 7

## Struktur Kode

```java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Kelas utama untuk aplikasi pemesanan tiket
public class PemesananTiketApp {
    // Variabel GUI
    public JFrame frame;
    public JTable table;
    public DefaultTableModel tableModel;
    public JTextField nameField, quantityField;
    public JLabel totalLabel, dateTimeLabel, imageLabel;
    public double totalHarga = 0;
    public DecimalFormat currencyFormat = new DecimalFormat("###,###.##");
    public String imagePath;

    // Data pertandingan dan harga kursi
    private String[][] matches = { ... }; // Data pertandingan
    private final int ECONOMY_PRICE = 100000;
    private final int VIP_PRICE = 250000;
    private final int VVIP_PRICE = 500000;

    // Konstruktor untuk inisialisasi GUI
    public PemesananTiketApp() {
        // Inisialisasi komponen GUI
        // ...
    }

    // Metode untuk menambahkan tiket
    public void addItem(String match, String kursi) { ... }

    // Metode untuk menghapus tiket
    public void deleteItem() { ... }

    // Metode untuk memperbarui tiket
    public void updateItem(String match, String kursi) { ... }

    // Metode untuk mereset pemesanan
    public void resetAll() { ... }

    // Metode untuk mengupload gambar
    private void uploadImage() { ... }

    // Metode utama
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PemesananTiketApp::new);
    }
}
```

## Pengujian

Aplikasi ini juga dilengkapi dengan unit testing menggunakan JUnit untuk memastikan fungsionalitas setiap metode. Pengujian ini mencakup penambahan, penghapusan, pembaruan, dan reset pemesanan tiket.

## Lisensi

Apilkasi ini dibuat untuk UAP Semester 3 dari Mata Kuliah Program Lanjut dengan menggunakan bahasa java