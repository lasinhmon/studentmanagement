/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;
import java.util.Date;
/**
 *
 * @author lasin
 */
public class SinhVien {
    String MSSV;
    String TenSV;
    String DiaChi;
    Date NgaySinh;
    String MaKhoa;
    String MaLHP;

    public SinhVien() {
        this.MSSV = "";
        this.TenSV = "";
        this.DiaChi = "";
        this.MaKhoa = "";
        this.MaLHP = "";
    }
    
    

    public SinhVien(String MSSV, String TenSV, String DiaChi, Date NgaySinh, String MaKhoa, 
            String MaLHP) {
        this.MSSV = MSSV;
        this.TenSV = TenSV;
        this.DiaChi = DiaChi;
        this.NgaySinh = NgaySinh;
        this.MaKhoa = MaKhoa;
        this.MaLHP = MaLHP;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String TenSV) {
        this.TenSV = TenSV;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String MaKhoa) {
        this.MaKhoa = MaKhoa;
    }

    public String getMaLHP() {
        return MaLHP;
    }

    public void setMaLHP(String MaLopHP) {
        this.MaLHP = MaLopHP;
    }
}
