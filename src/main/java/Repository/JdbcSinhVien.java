/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Domain.LopHocPhan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Repository.JavaConnection;
import Domain.SinhVien;
import java.util.*;
import java.sql.*;

/**
 *
 * @author lasin
 */
public class JdbcSinhVien {
    //private final String SQL_SELECT="SELECT sv.MSSV ,sv.Ten, sv.DiaChi, sv.NgaySinh,sv.MaKhoa,kq.MaLopHP,kq.DiemKTGiuaky,kq.DiemThilan1,kq.DiemThiLan2,kq.DTB from SinhVien sv inner join ketqua kq on kq.MSSV=sv.MSSV where sv.MSSV =?";
    private final String SQL_SELECT="call findSVbyMS (?);";
    private final String SQL_SELECT1="call findSVbyMLHP (?);";
    private final String SQL_danhsachSV="call getSVtheoKhoaHockiNienKhoa(?,?,?);";
    private final String SQL_ThongTinSinhVienSQL="select distinct sv.Ten,sv.MSSV,sv.PhaiNu,sv.MaKhoa,sv.SoDienThoai from SinhVien sv where sv.mssv=?";
    public Object[] thongtinsinhvien(String code)
    {
        Object dataRow[]=new Object[5];
        Connection conn=null;
        PreparedStatement stmt=null;
        //CallableStatement cs=null;
        ResultSet rs=null;      
        try{
            conn=JavaConnection.getConnection();
            stmt=conn.prepareCall(SQL_ThongTinSinhVienSQL);
            stmt.setString(1, code);
            rs=stmt.executeQuery();
            while(rs.next())
            {
                dataRow[0]=rs.getString(1);
                dataRow[1]=rs.getString(2);
                dataRow[2]=rs.getInt(3);
                dataRow[3]=rs.getString(4);
                dataRow[4]=rs.getString(5);
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return dataRow;
    }
    public List<SinhVien> getSV(String khoa,int hk,String nienkhoa){
        Connection conn=null;
       // PreparedStatement stmt=null;
        CallableStatement cs=null;
        ResultSet rs=null;       
        List<SinhVien>TSV=new ArrayList<>();
        try{
            conn=JavaConnection.getConnection();
            cs=conn.prepareCall(SQL_danhsachSV);
            cs.setString(1, khoa);
            cs.setInt(2, hk);
            cs.setString(3, nienkhoa);
            rs=cs.executeQuery();
            while(rs.next()){
                SinhVien sv=new SinhVien();  
                sv.setMSSV(rs.getString(1));
                sv.setTenSV(rs.getString(2));
                TSV.add(sv);
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(rs);
            JavaConnection.close(cs);
            JavaConnection.close(conn);
        }
        return TSV;
    }
    public SinhVien addDuLieu(ResultSet rs){
        SinhVien sv=new SinhVien();  
        try{                
            sv.setMSSV(rs.getString(1));
            sv.setTenSV(rs.getString(2));
            sv.setDiaChi(rs.getString(3));
            sv.setNgaySinh(rs.getDate(4));
            sv.setMaKhoa(rs.getString(5));
            sv.setMaLHP(rs.getString(6));
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
        return sv;
    }
    public List<SinhVien> select(String code) {
        Connection conn=null;
       // PreparedStatement stmt=null;
        CallableStatement cs=null;
        ResultSet rs=null;       
        List<SinhVien>TSV=new ArrayList<>();
        try{
            conn=JavaConnection.getConnection();
            cs=conn.prepareCall(SQL_SELECT);
            cs.setString(1, code);
            rs=cs.executeQuery();
            while(rs.next()){
                TSV.add(addDuLieu(rs));
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(rs);
            JavaConnection.close(cs);
            JavaConnection.close(conn);
        }
        return TSV;
    }
    public List<SinhVien> select1(String code) {
        Connection conn=null;
       // PreparedStatement stmt=null;
        CallableStatement cs=null;
        ResultSet rs=null;       
        List<SinhVien>TSV=new ArrayList<>();
        try{
            conn=JavaConnection.getConnection();
            cs=conn.prepareCall(SQL_SELECT1);
            cs.setString(1, code);
            rs=cs.executeQuery();
            while(rs.next()){
                
                TSV.add(addDuLieu(rs));
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(rs);
            JavaConnection.close(cs);
            JavaConnection.close(conn);
        }
        return TSV;
    }
    
   
}
