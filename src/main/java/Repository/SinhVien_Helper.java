/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Domain.LopHocPhan;
import Domain.SinhVien;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author lasin
 */
public class SinhVien_Helper {
    public Object[] DisplayTable2(LopHocPhan lhp){
        Object dataRow[]=new Object[7];
        dataRow[0]=lhp.getMaMH();
        dataRow[1]=lhp.getSoTC();
        dataRow[2]=lhp.getDiemCC();
        dataRow[3]=lhp.getDiemThiGK();
        dataRow[4]=lhp.getDiemThiCK();
        dataRow[5]=lhp.getDiemTB();
        dataRow[6]=lhp.getTrangThai();
        return dataRow;
    }
    public Object[] DisplayTable(int so,LopHocPhan lhp){
        Object dataRow[]=new Object[8];
        dataRow[0]=so;
        dataRow[1]=lhp.getMaLHP();
        dataRow[2]=lhp.getMaMH();
        dataRow[3]=lhp.getSoTC();
        dataRow[4]=lhp.getDiemThiGK();
        dataRow[5]=lhp.getDiemThiCK();
        dataRow[6]=lhp.getDiemTB();
        dataRow[7]=lhp.getTrangThai();
        return dataRow;
    }
    public Object[] DisplayTable(SinhVien sv){
        Object dataRow[]=new Object[3];
        dataRow[0]=sv.getMSSV();
        dataRow[1]=sv.getMaLHP();
        dataRow[2]=sv.getTenSV();
        return dataRow;
    }
    public List<Object[]> DisplayThongke(String k,int hk,String nk, int xeploai){
        List<SinhVien>list;
        List<LopHocPhan>listdiem;
        JdbcLopHocPhan listlhp;
        JdbcSinhVien listsv;
        List<Object[]> kq=new ArrayList<>();
        listsv=new JdbcSinhVien();
        //list=listsv.getSV(cb_khoa.getSelectedItem().toString(), Integer.parseInt(cb_hk.getSelectedItem().toString()), cb_nienkhoa.getSelectedItem().toString());
        list=listsv.getSV(k, hk, nk);
        for(SinhVien sv:list){
            Object dataRow[]=new Object[3];
            String ms=sv.getMSSV();
            dataRow[0]=ms;
            dataRow[1]=sv.getTenSV();
            listlhp=new JdbcLopHocPhan();
            listdiem=listlhp.select2(ms);
            int tongtc=0;
            float tongdiem=0;
            for(LopHocPhan lhp:listdiem){
                tongdiem=tongdiem+(lhp.getDiemTB()*lhp.getSoTC());
                tongtc+=lhp.getSoTC();
            }
            double tinh=(double)tongdiem/tongtc;
            if(xeploai==0){
                if(tinh<5&&tinh>=4)
                    dataRow[2]=tinh;//yeu
                else{
                    dataRow[2]=0.0;
                }
            }
            if(xeploai==1){
                if(tinh<6.5&&tinh>=5)
                    dataRow[2]=tinh;//trung binh
                else{
                    dataRow[2]=0.0;
                }
            }
            if(xeploai==2){
                if(tinh<7&&tinh>=6.5)
                    dataRow[2]=tinh;//tbkha
                else{
                    dataRow[2]=0.0;
                }
            }
            if(xeploai==3){
                if(tinh<8.5&&tinh>=7)
                    dataRow[2]=tinh;//kha
                else{
                    dataRow[2]=0.0;
                }
            }
            if(xeploai==4){
                if(tinh>=8.5)
                    dataRow[2]=tinh;//gioi
                else{
                    dataRow[2]=0.0;
                }
            }
            if((Double)dataRow[2] != 0.0)
                kq.add(dataRow);
        }
        return kq;
    }
    
    
    
    public float SetTrangThai(float diemcc,float diemgk,float diemck){
        float tb=((60*diemck)/100)+((15*diemcc+25*diemgk)/100);
        return tb;
    }
    public String ThaydoiCosoDiem(int lenh , float diem){
        float diemmoi=0;
        if(lenh==0){
            diemmoi=diem*4/10;
        }
        return Float.toString(diemmoi);
    }
}
