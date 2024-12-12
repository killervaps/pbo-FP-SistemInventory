import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaksi {
    private String idTransaksi;
    private Date tanggal;
    private Pelanggan pelanggan;
    private Pegawai pegawai;
    private List<Barang> daftarBarang;
    private List<Integer> jumlahBarang;

    public Transaksi(String idTransaksi, Date tanggal, Pelanggan pelanggan, Pegawai pegawai) {
        this.idTransaksi = idTransaksi;
        this.tanggal = tanggal;
        this.pelanggan = pelanggan;
        this.pegawai = pegawai;
        this.daftarBarang = new ArrayList<>();
        this.jumlahBarang = new ArrayList<>();
    }

    public void tambahBarang(Barang barang, int jumlah) {
        if (barang.getStok() >= jumlah) {
            daftarBarang.add(barang);
            jumlahBarang.add(jumlah);
            barang.kurangiStok(jumlah);
        } else {
            System.out.println("Stok barang " + barang.getNamaBarang() + " tidak mencukupi.");
        }
    }

    public void hapusBarang(Barang barang) {
        int index = daftarBarang.indexOf(barang);
        if (index != -1) {
            barang.tambahStok(jumlahBarang.get(index));
            daftarBarang.remove(index);
            jumlahBarang.remove(index);
        } else {
            System.out.println("Barang tidak ditemukan dalam transaksi.");
        }
    }

    public double hitungTotalHarga() {
        double total = 0;
        for (int i = 0; i < daftarBarang.size(); i++) {
            total += daftarBarang.get(i).getHarga() * jumlahBarang.get(i);
        }
        return total;
    }

    public void printTransaksi() {
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Pelanggan: " + pelanggan);
        System.out.println("Pegawai: " + pegawai);
        System.out.println("Barang yang dibeli:");
        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println("- " + daftarBarang.get(i).getNamaBarang() + " x" + jumlahBarang.get(i));
        }
        System.out.println("Total Harga: Rp " + hitungTotalHarga());
    }
}
