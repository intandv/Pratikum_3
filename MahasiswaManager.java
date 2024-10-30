/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//mengimpor atau menkoneksikan kepada database
package app.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class MahasiswaManager {
    Connection conn = null;
    Statement st = null;
    //ini mengkoneksikan kepada database
   String driver = "com.mysql.cj.jdbc.Driver"; //diakses di test package
   String url = "jdbc:mysql://localhost:3306/db_si_26";
    
    public MahasiswaManager(){
     try {
          Class.forName(driver);
          conn = DriverManager.getConnection (url, "root", "");
            st = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List getMahasiswa(){
        ResultSet rs = null;
        List Mahasiswa = new ArrayList();
            try {
                rs = st.executeQuery("Select * From tbl_mahasiswa"); //dia mengambil dari variabel yang ada di database yaitu tbl mahasiswa
                while (rs.next()) {
                    Mahasiswa m = new Mahasiswa();
                    m.setnobp(rs.getString("NoBP"));
                    m.setnama(rs.getString("Nama"));
                    m.settempatlahir(rs.getString("TmpLahir"));
                    m.settgllahir(rs.getString("TglLahir"));
                    m.setalamat(rs.getString("Alamat"));
                    m.setphone(rs.getString("Phone"));
                    m.setasalsekolah(rs.getString("AsalSekolah"));
                    Mahasiswa.add(m);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } 
            return Mahasiswa;
    }
    public int Insert(Mahasiswa m){ //menambahkan nilai variabel pada tbl mahasiswa
        int result = 0;
        try {
            result = st.executeUpdate("insert into tbl_mahasiswa value ('"+ m.getnobp() +"','"+ m.getnama() +"','"+m.gettempatlahir() +"','"+ m.gettgllahir() +"','"+ m.getalamat()+"','"+ m.getphone() +"','"+ m.getasalsekolah() +"')");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public int Delete(Mahasiswa m){ //menghapus nilai yang telah ditambhakan, hanya dengan menghapus nilai dari variabel NOBP saja karna mewakilkan data berikutnya, maka data selanjutmya akan ikut terhapus
        int result = 0;
        try {
            result = st.executeUpdate("delete from tbl_mahasiswa where nobp='"+ m.getnobp() +"'");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public int Update(Mahasiswa m){ //untuk memperbarui data yang ada pada tbl mahasiswa
        int result = 0;
        try {
            result = st.executeUpdate("UPDATE tbl_mahasiswa SET nobp='" + m.getnobp() + "', nama='" + m.getnama() + "', tmplahir='" + m.gettempatlahir() + "', tgllahir='" + m.gettgllahir() + "', Alamat='" + m.getalamat() + "', phone='" + m.getphone() + "', asalsekolah='" + m.getasalsekolah() + "' WHERE nobp='" + m.getnobp() + "'");
        } catch (Exception e) {
        }
        return result;
    }
    public void closeConnection(){ //memutus koneksi
        try {
            conn.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
