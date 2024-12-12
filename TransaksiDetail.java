public class TransaksiDetail {
    private Barang barang;
    private int jumlah;

    // Konstruktor
    public TransaksiDetail(Barang barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }

    // Getter dan Setter
    public Barang getBarang() {
        return barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return "TransaksiDetail [barang=" + barang.getNamaBarang() + ", jumlah=" + jumlah + "]";
    }
}
