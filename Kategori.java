import java.util.ArrayList;
import java.util.List;

public class Kategori {
    private String idKategori;
    private String namaKategori;
    private List<Barang> daftarBarang;

    public Kategori(String idKategori, String namaKategori) {
        this.idKategori = idKategori;
        this.namaKategori = namaKategori;
        this.daftarBarang = new ArrayList<>();
    }

    public void tambahBarang(Barang barangBaru) {
        // Cek apakah barang dengan nama yang sama sudah ada
        for (Barang barang : daftarBarang) {
            if (barang.getNamaBarang().equalsIgnoreCase(barangBaru.getNamaBarang())) {
                // Jika barang dengan nama yang sama ditemukan, perbarui stok
                barang.tambahStok(barangBaru.getStok());
                return;
            }
        }
        // Jika barang belum ada, tambahkan sebagai barang baru
        daftarBarang.add(barangBaru);
    }

    public void kurangiStokBarang(String namaBarang, int jumlah) {
        Barang barangDitemukan = null;
        for (Barang barang : daftarBarang) {
            if (barang.getNamaBarang().equalsIgnoreCase(namaBarang)) {
                barang.kurangiStok(jumlah);
                if (barang.getStok() <= 0) {
                    barangDitemukan = barang;
                }
                break;
            }
        }
        if (barangDitemukan != null) {
            daftarBarang.remove(barangDitemukan);
        }
    }

    public List<Barang> getDaftarBarang() {
        return daftarBarang;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void printBarangDalamKategori() {
        System.out.println("Kategori: " + namaKategori);
        for (Barang barang : daftarBarang) {
            System.out.println("- " + barang);
        }
    }
}

