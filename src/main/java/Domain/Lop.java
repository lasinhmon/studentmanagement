/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author lasin
 */
public class Lop {
    //gd.MaLopHP,mh.TenMH,gv.TenGV,gd.NgayHoc,gd.CaHoc
    String MaLHP;
    String MaMH;
    String MaGV;
    int NgayHoc;
    int CaHoc;

    public String getMaLHP() {
        return MaLHP;
    }

    public void setMaLHP(String MaLHP) {
        this.MaLHP = MaLHP;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String MaMH) {
        this.MaMH = MaMH;
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public int getNgayHoc() {
        return NgayHoc;
    }

    public void setNgayHoc(int NgayHoc) {
        this.NgayHoc = NgayHoc;
    }

    public int getCaHoc() {
        return CaHoc;
    }

    public void setCaHoc(int CaHoc) {
        this.CaHoc = CaHoc;
    }

    public Lop(String MaLHP, String MaMH, String MaGV, int NgayHoc, int CaHoc) {
        this.MaLHP = MaLHP;
        this.MaMH = MaMH;
        this.MaGV = MaGV;
        this.NgayHoc = NgayHoc;
        this.CaHoc = CaHoc;
    }
    public Lop(){
        this.MaLHP = "";
        this.MaMH = "";
        this.MaGV = "";
        this.NgayHoc = 0;
        this.CaHoc = 0;
    }
    
}
