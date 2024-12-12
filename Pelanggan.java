public class Pelanggan {
    private String idPelanggan;
    private String nama;
    private String kontak;

    public Pelanggan(String idPelanggan, String nama, String kontak) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.kontak = kontak;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getKontak() {
        return kontak;
    }

    public String toString() {
        return nama + " (" + idPelanggan + ")";
    }
}
