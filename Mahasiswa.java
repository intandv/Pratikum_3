/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.db;

/**
 *
 * @author HP
 */
public class Mahasiswa {
    private String No_BP;
    private String Nama;
    private String Tempat_Lahir;
    private String Tgl_Lahir;
    private String Alamat;
    private String Phone;
    private String Asal_Sekolah;
    
    public Mahasiswa() {
        
    }
    public String getasalsekolah(){
        return Asal_Sekolah;
    }
    public void setasalsekolah(String asalsekolah) {
        this.Asal_Sekolah = asalsekolah;
    }
    public String getphone() {
        return Phone;
    }
    public void setphone(String phone) {
        this.Phone = phone;
    }
    public String getalamat() {
        return Alamat;
    }
    public void setalamat(String alamat) {
        this.Alamat = alamat;
    }
    public String gettgllahir() {
        return Tgl_Lahir;
    }
    public void settgllahir(String tgllahir) {
        this.Tgl_Lahir = tgllahir;
    }
    public String gettempatlahir() {
        return Tempat_Lahir;
    }
    public void settempatlahir(String tempatlahir) {
        this.Tempat_Lahir = tempatlahir;
    }
    public String getnama() {
        return Nama;
    }
    public void setnama(String nama) {
        this.Nama = nama;
    }
    public String getnobp() {
        return No_BP;
    }
    public void setnobp(String nobp) {
        this.No_BP = nobp;
    }
    
}
