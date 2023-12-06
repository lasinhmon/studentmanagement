/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

/**
 *
 * @author lasin
 */
public class LopHocPhan {
    String MaLHP;
    String MaMH;
    String MaGV;
    int HocKy;
    String NienKhoa;
    int SoTC;
    float DiemCC;
    float DiemThiGK;
    float DiemThiCK;
    float DiemTB;
    String TrangThai;

    public LopHocPhan() {
        this.MaLHP = "";
        this.MaMH = "";
        this.MaGV = "";
        this.HocKy = 0;
        this.NienKhoa = "";
        this.SoTC = 0;
        this.DiemCC = 0;
        this.DiemThiGK = 0;
        this.DiemThiCK = 0;
        this.DiemTB = 0;
        this.TrangThai="";
        
    }
    
    public LopHocPhan(String MaLHP, String MaMH, String MaGV, int HocKy, String NienKhoa, 
            int SoTC, float DiemCC, float DiemThiGK, float DiemThiCK, float DiemTB,String TrangThai) {
        this.MaLHP = MaLHP;
        this.MaMH = MaMH;
        this.MaGV = MaGV;
        this.HocKy = HocKy;
        this.NienKhoa = NienKhoa;
        this.SoTC = SoTC;
        this.DiemCC = DiemCC;
        this.DiemThiGK = DiemThiGK;
        this.DiemThiCK = DiemThiCK;
        this.DiemTB = DiemTB;
        this.TrangThai=TrangThai;
    }

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

    public int getHocKy() {
        return HocKy;
    }

    public void setHocKy(int HocKy) {
        this.HocKy = HocKy;
    }

    public String getNienKhoa() {
        return NienKhoa;
    }

    public void setNienKhoa(String NienKhoa) {
        this.NienKhoa = NienKhoa;
    }

    public int getSoTC() {
        return SoTC;
    }

    public void setSoTC(int SoTC) {
        this.SoTC = SoTC;
    }
    public float getDiemCC() {
        return DiemCC;
    }

    public void setDiemCC(float DiemCC) {
        this.DiemCC = DiemCC;
    }

    public float getDiemThiGK() {
        return DiemThiGK;
    }

    public void setDiemThiGK(float DiemThiGK) {
        this.DiemThiGK = DiemThiGK;
    }

    public float getDiemThiCK() {
        return DiemThiCK;
    }

    public void setDiemThiCK(float DiemThiCK) {
        this.DiemThiCK = DiemThiCK;
    }

    public float getDiemTB() {
        return DiemTB;
    }

    public void setDiemTB(float DiemTB) {
        this.DiemTB = DiemTB;
    }
     public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
}
