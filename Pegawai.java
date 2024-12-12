public class Pegawai {
    private String idPegawai;
    private String nama;
    private String username;
    private String password;

    public Pegawai(String idPegawai, String nama, String username, String password) {
        this.idPegawai = idPegawai;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    public String getNama() {
        return nama;
    }
    
    public String getIdPegawai() {
        return idPegawai;
    }


    public String toString() {
        return nama + " (" + idPegawai + ")";
    }
}
