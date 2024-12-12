public class Barang {
    private String idBarang;
    private String namaBarang;
    private String kategori;
    private double harga;
    private int stok;
    private String deskripsi;

    public Barang(String idBarang, String namaBarang, String kategori, double harga, int stok, String deskripsi) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
        this.deskripsi = deskripsi;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak cukup untuk mengurangi " + jumlah);
        }
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public String toString() {
        return namaBarang + " - Rp " + harga + " - Stok: " + stok;
    }
}
