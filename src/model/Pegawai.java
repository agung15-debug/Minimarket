package model;

public class Pegawai {
    private String username = "";
    private String password = "";
    private String namaPegawai;
    private String noHp;
    private String alamat;
    private int privilage;
    private int id;
    private String nPrivilage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getPrivilage() {
        return privilage;
    }

    public void setPrivilage(int privilage) {
        this.privilage = privilage;
    }

    public String getnPrivilage() {
        return nPrivilage;
    }

    public void setnPrivilage(int privilage) {
        if(privilage == 0){
            this.nPrivilage = "Kasir";
        } else{
            this.nPrivilage = "Admin";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
