import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // 1. Buat Kategori
        Kategori kategoriElektronik = new Kategori("K001", "Elektronik");
        Kategori kategoriAksesori = new Kategori("K002", "Aksesori");

        // 2. Buat Barang dan Tambahkan ke Kategori
        Barang barang1 = new Barang("B001", "Laptop", "Elektronik", 7000000, 10, "Laptop Gaming");
        Barang barang2 = new Barang("B002", "Mouse", "Aksesori", 150000, 50, "Mouse Wireless");

        kategoriElektronik.tambahBarang(barang1);
        kategoriAksesori.tambahBarang(barang2);

        // 3. Cetak Barang dalam Kategori
        kategoriElektronik.printBarangDalamKategori();
        kategoriAksesori.printBarangDalamKategori();

        // 4. Buat Pelanggan dan Pegawai
        Pelanggan pelanggan1 = new Pelanggan("P001", "Andi", "08123456789");
        Pegawai pegawai1 = new Pegawai("E001", "Budi", "budi123", "password");

        // 5. Buat Transaksi
        Transaksi transaksi1 = new Transaksi("T001", new Date(), pelanggan1, pegawai1);

        // 6. Tambahkan Barang ke Transaksi
        transaksi1.tambahBarang(barang1, 1); // Beli 1 Laptop
        transaksi1.tambahBarang(barang2, 2); // Beli 2 Mouse

        // 7. Cetak Transaksi
        transaksi1.printTransaksi();

        // 8. Tambahkan Login untuk Pegawai
        System.out.println("\nLogin Pegawai:");
        if (pegawai1.login("budi123", "password")) {
            System.out.println("Login berhasil. Selamat datang, " + pegawai1.getNama() + "!");
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }
}
