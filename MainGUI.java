import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

public class MainGUI {
    private JFrame frame;
    private ArrayList<Kategori> daftarKategori;
    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<Pegawai> daftarPegawai;
    private ArrayList<Transaksi> daftarTransaksi;

    public MainGUI() {
        daftarKategori = new ArrayList<>();
        daftarPelanggan = new ArrayList<>();
        daftarPegawai = new ArrayList<>();
        daftarTransaksi = new ArrayList<>();

        // Tambahkan data awal
        Kategori kategoriElektronik = new Kategori("K001", "Elektronik");
        Kategori kategoriAksesori = new Kategori("K002", "Aksesori");
        daftarKategori.add(kategoriElektronik);
        daftarKategori.add(kategoriAksesori);

        Pegawai pegawai1 = new Pegawai("E001", "Budi", "budi123", "password");
        daftarPegawai.add(pegawai1);
    }

    public void tampilkan() {
        frame = new JFrame("Kelompok21 - Sistem Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel header = new JLabel("Kelompok21 - Sistem Inventory", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(Color.WHITE);
        header.setOpaque(true);
        header.setBackground(Color.BLUE);
        mainPanel.add(header, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel(new GridLayout(3, 2, 20, 20));
        JButton btnTambahBarang = new JButton("Tambah Barang");
        JButton btnTambahKategori = new JButton("Tambah Kategori");
        JButton btnTambahPelanggan = new JButton("Tambah Pelanggan");
        JButton btnTambahPegawai = new JButton("Tambah Pegawai");
        JButton btnTambahTransaksi = new JButton("Tambah Transaksi");
        JButton btnLihatBarang = new JButton("Lihat Barang");

        menuPanel.add(btnTambahBarang);
        menuPanel.add(btnTambahKategori);
        menuPanel.add(btnTambahPelanggan);
        menuPanel.add(btnTambahPegawai);
        menuPanel.add(btnTambahTransaksi);
        menuPanel.add(btnLihatBarang);

        mainPanel.add(menuPanel, BorderLayout.CENTER);

        JLabel footer = new JLabel("Dikembangkan oleh Kelompok 21", JLabel.CENTER);
        footer.setOpaque(true);
        footer.setBackground(Color.DARK_GRAY);
        footer.setForeground(Color.WHITE);
        mainPanel.add(footer, BorderLayout.SOUTH);

        frame.add(mainPanel);

        // Listener tombol
        btnTambahBarang.addActionListener(e -> bukaFormTambahBarang());
        btnTambahKategori.addActionListener(e -> bukaFormTambahKategori());
        btnTambahPelanggan.addActionListener(e -> bukaFormTambahPelanggan());
        btnTambahPegawai.addActionListener(e -> bukaFormTambahPegawai());
        btnTambahTransaksi.addActionListener(e -> bukaFormTambahTransaksi());
        btnLihatBarang.addActionListener(e -> bukaLihatBarang());

        frame.setVisible(true);
    }

    private void bukaFormTambahBarang() {
        JDialog dialog = new JDialog(frame, "Tambah Barang", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel lblNama = new JLabel("Nama Barang:");
        JTextField txtNama = new JTextField();

        JLabel lblKategori = new JLabel("Kategori:");
        JComboBox<String> cbKategori = new JComboBox<>();
        for (Kategori kategori : daftarKategori) {
            cbKategori.addItem(kategori.getNamaKategori());
        }

        JLabel lblHarga = new JLabel("Harga:");
        JTextField txtHarga = new JTextField();

        JLabel lblStok = new JLabel("Stok:");
        JTextField txtStok = new JTextField();

        JLabel lblDeskripsi = new JLabel("Deskripsi:");
        JTextField txtDeskripsi = new JTextField();

        JButton btnSimpan = new JButton("Simpan");

        dialog.add(lblNama);
        dialog.add(txtNama);
        dialog.add(lblKategori);
        dialog.add(cbKategori);
        dialog.add(lblHarga);
        dialog.add(txtHarga);
        dialog.add(lblStok);
        dialog.add(txtStok);
        dialog.add(lblDeskripsi);
        dialog.add(txtDeskripsi);
        dialog.add(new JLabel());
        dialog.add(btnSimpan);

        btnSimpan.addActionListener(e -> {
        try {
        String nama = txtNama.getText();
        String kategori = (String) cbKategori.getSelectedItem();
        double harga = Double.parseDouble(txtHarga.getText());
        int stok = Integer.parseInt(txtStok.getText());
        String deskripsi = txtDeskripsi.getText();

        Barang barangBaru = new Barang("B" + nama.hashCode(), nama, kategori, harga, stok, deskripsi);

        for (Kategori kat : daftarKategori) {
            if (kat.getNamaKategori().equalsIgnoreCase(kategori)) {
                kat.tambahBarang(barangBaru);
                break;
            }
        }

        JOptionPane.showMessageDialog(dialog, "Barang berhasil ditambahkan!");
        dialog.dispose();
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(dialog, "Input tidak valid.", "Error", JOptionPane.ERROR_MESSAGE);
    }
});


        dialog.setVisible(true);
    }

    private void bukaFormTambahKategori() {
        JDialog dialog = new JDialog(frame, "Tambah Kategori", true);
        dialog.setSize(300, 150);
        dialog.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel lblNamaKategori = new JLabel("Nama Kategori:");
        JTextField txtNamaKategori = new JTextField();

        JButton btnSimpan = new JButton("Simpan");

        dialog.add(lblNamaKategori);
        dialog.add(txtNamaKategori);
        dialog.add(new JLabel());
        dialog.add(btnSimpan);

        btnSimpan.addActionListener(e -> {
            String namaKategori = txtNamaKategori.getText();
            if (!namaKategori.isEmpty()) {
                daftarKategori.add(new Kategori("K" + namaKategori.hashCode(), namaKategori));
                JOptionPane.showMessageDialog(dialog, "Kategori berhasil ditambahkan!");
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Nama kategori tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.setVisible(true);
    }

    private void bukaFormTambahPelanggan() {
        JDialog dialog = new JDialog(frame, "Tambah Pelanggan", true);
        dialog.setSize(400, 200);
        dialog.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblNama = new JLabel("Nama Pelanggan:");
        JTextField txtNama = new JTextField();

        JLabel lblKontak = new JLabel("Kontak:");
        JTextField txtKontak = new JTextField();

        JButton btnSimpan = new JButton("Simpan");

        dialog.add(lblNama);
        dialog.add(txtNama);
        dialog.add(lblKontak);
        dialog.add(txtKontak);
        dialog.add(new JLabel());
        dialog.add(btnSimpan);

        btnSimpan.addActionListener(e -> {
            String nama = txtNama.getText();
            String kontak = txtKontak.getText();

            if (!nama.isEmpty() && !kontak.isEmpty()) {
                Pelanggan pelanggan = new Pelanggan("P" + nama.hashCode(), nama, kontak);
                daftarPelanggan.add(pelanggan);
                JOptionPane.showMessageDialog(dialog, "Pelanggan berhasil ditambahkan!");
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.setVisible(true);
    }

    private void bukaFormTambahPegawai() {
        JDialog dialog = new JDialog(frame, "Tambah Pegawai", true);
        dialog.setSize(400, 250);
        dialog.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblNama = new JLabel("Nama Pegawai:");
        JTextField txtNama = new JTextField();

        JLabel lblUsername = new JLabel("Username:");
        JTextField txtUsername = new JTextField();

        JLabel lblPassword = new JLabel("Password:");
        JPasswordField txtPassword = new JPasswordField();

        JButton btnSimpan = new JButton("Simpan");

        dialog.add(lblNama);
        dialog.add(txtNama);
        dialog.add(lblUsername);
        dialog.add(txtUsername);
        dialog.add(lblPassword);
        dialog.add(txtPassword);
        dialog.add(new JLabel());
        dialog.add(btnSimpan);

        btnSimpan.addActionListener(e -> {
            String nama = txtNama.getText();
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (!nama.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
                Pegawai pegawai = new Pegawai("E" + nama.hashCode(), nama, username, password);
                daftarPegawai.add(pegawai);
                JOptionPane.showMessageDialog(dialog, "Pegawai berhasil ditambahkan!");
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.setVisible(true);
    }

private void bukaFormTambahTransaksi() {
    JDialog dialog = new JDialog(frame, "Tambah Transaksi", true);
    dialog.setSize(600, 400);
    dialog.setLayout(new GridLayout(6, 2, 10, 10));

    JLabel lblPelanggan = new JLabel("ID Pelanggan:");
    JComboBox<String> cbPelanggan = new JComboBox<>();
    for (Pelanggan pelanggan : daftarPelanggan) {
        cbPelanggan.addItem(pelanggan.getIdPelanggan() + " - " + pelanggan.getNama());
    }

    JLabel lblPegawai = new JLabel("ID Pegawai:");
    JComboBox<String> cbPegawai = new JComboBox<>();
    for (Pegawai pegawai : daftarPegawai) {
        cbPegawai.addItem(pegawai.getIdPegawai() + " - " + pegawai.getNama());
    }

    JLabel lblBarang = new JLabel("Barang:");
    JComboBox<String> cbBarang = new JComboBox<>();
    for (Kategori kategori : daftarKategori) {
        for (Barang barang : kategori.getDaftarBarang()) {
            cbBarang.addItem(barang.getNamaBarang());
        }
    }

    JLabel lblJumlah = new JLabel("Jumlah:");
    JTextField txtJumlah = new JTextField();

    JButton btnSimpan = new JButton("Simpan");

    dialog.add(lblPelanggan);
    dialog.add(cbPelanggan);
    dialog.add(lblPegawai);
    dialog.add(cbPegawai);
    dialog.add(lblBarang);
    dialog.add(cbBarang);
    dialog.add(lblJumlah);
    dialog.add(txtJumlah);
    dialog.add(new JLabel());
    dialog.add(btnSimpan);

    btnSimpan.addActionListener(e -> {
    try {
        // Ambil data dari JComboBox
        String pelangganInfo = (String) cbPelanggan.getSelectedItem();
        String pegawaiInfo = (String) cbPegawai.getSelectedItem();
        String barangInfo = (String) cbBarang.getSelectedItem();
        int jumlah = Integer.parseInt(txtJumlah.getText());

        // Temukan pelanggan, pegawai, dan barang
        Pelanggan pelanggan = daftarPelanggan.stream()
                .filter(p -> pelangganInfo.startsWith(p.getIdPelanggan()))
                .findFirst()
                .orElse(null);

        Pegawai pegawai = daftarPegawai.stream()
                .filter(p -> pegawaiInfo.startsWith(p.getIdPegawai()))
                .findFirst()
                .orElse(null);

        Barang barang = null;
        for (Kategori kategori : daftarKategori) {
            barang = kategori.getDaftarBarang().stream()
                    .filter(b -> b.getNamaBarang().equalsIgnoreCase(barangInfo))
                    .findFirst()
                    .orElse(null);
            if (barang != null) break;
        }

        // Validasi data
        if (pelanggan == null || pegawai == null || barang == null) {
            JOptionPane.showMessageDialog(dialog, "Data pelanggan, pegawai, atau barang tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (jumlah > barang.getStok()) {
            JOptionPane.showMessageDialog(dialog, "Stok barang tidak mencukupi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buat transaksi
        Transaksi transaksi = new Transaksi("T" + new Date().hashCode(), new Date(), pelanggan, pegawai);
        transaksi.tambahBarang(barang, jumlah); // Stok barang dikurangi di sini oleh Transaksi

        // Tambahkan transaksi ke daftar
        daftarTransaksi.add(transaksi);

        JOptionPane.showMessageDialog(dialog, "Transaksi berhasil ditambahkan!");
        dialog.dispose();
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(dialog, "Jumlah harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
    }
});

    dialog.setVisible(true);
}


    private void bukaLihatBarang() {
        JDialog dialog = new JDialog(frame, "Daftar Barang", true);
        dialog.setSize(600, 400);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (Kategori kategori : daftarKategori) {
            textArea.append("Kategori: " + kategori.getNamaKategori() + "\n");
            for (Barang barang : kategori.getDaftarBarang()) {
                textArea.append(barang.toString() + "\n");
            }
            textArea.append("\n");
        }

        dialog.add(new JScrollPane(textArea));
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI app = new MainGUI();
            app.tampilkan();
        });
    }
}
