/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Domain.Lop;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author lasin
 */
public class GiaoVien_Helper {
    public Object[] DisplayLichDay(Lop l){
        Object dataRow[]=new Object[3];
        dataRow[0]=l.getNgayHoc();
        dataRow[1]=l.getCaHoc();
        dataRow[2]=l.getMaLHP();
        return dataRow;
    }
    public List<String>LoadKhoa(){
        List<String>khoa=new ArrayList<>();
        JdbcLop listlop=new JdbcLop();
        khoa=listlop.loadtoCombobox(3);
        return khoa;
    }
    public List<String>LoadMonhoc(){
        List<String>mh=new ArrayList<>();
        JdbcLop listlop=new JdbcLop();
        mh=listlop.loadtoCombobox(1);
        return mh;
    }
    public List<String>LoadLop(){
        List<String>lop=new ArrayList<>();
        JdbcLop listlop=new JdbcLop();
        lop=listlop.loadtoCombobox(2);
        return lop;
    }
    public int kiemtralichtrong(int ng,int ca, int hk){
        JdbcLop lop=new JdbcLop();
        int so=lop.kiemtraxeplich(ng, ca, hk);
        return so;
    }
}
