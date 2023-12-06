/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Domain.Lop;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lasin
 */
public class JdbcLop {
    private final String SQL_kiemtralop="call kiemtralichtrong(?,?,?);";
    private final String SQL_LOADtkb="call xemTKBbyMSV (?,?);";
    private final String SQL_LOADtkbGV="call xemTKBbyTGV (?,?,?); ";
    private final String SQL_LOADtkbSV="call xemTKBSV (?,?,?); ";
    private final String SQL_LOADmonhoc="SELECT MaMH,TenMH FROM MonHoc";
    private final String SQL_LOADlop="SELECT MaLopHP FROM GiangDay";
    private final String SQL_INSERTmonhoc="call insertGD (?,?,?,?,?,?,?,?);";
    private final String SQL_IdGV="SELECT MaGV FROM GiaoVien Where TenGV=?";
    private final String SQL_LOADkhoa="SELECT MaKhoa FROM Khoa";
    public int kiemtraxeplich(int ngay, int ca, int hk){
        
        Connection conn = null;
        CallableStatement cs=null;
        ResultSet rs=null;     
        try {
            conn = JavaConnection.getConnection();
            cs = conn.prepareCall(SQL_kiemtralop);
            cs.setInt(1, ngay);
            cs.setInt(2, ca);
            cs.setInt(3, hk);
            rs = cs.executeQuery();
           if(rs.next())
               return 1;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            JavaConnection.close(cs);
            JavaConnection.close(conn);
        }
        return 0;
    }
    public List<Lop> loadTKB_SV(String code,String nk,int hk){
        Connection conn=null;
        CallableStatement cs=null;
        ResultSet rs=null;       
        List<Lop>TLop=new ArrayList<>();
        System.out.println(code);
        try{
            conn=JavaConnection.getConnection();
            cs=conn.prepareCall(SQL_LOADtkbSV);
            cs.setString(1, code);
            cs.setString(2, nk);
            cs.setInt(3, hk);
            rs=cs.executeQuery();
            while(rs.next()){
                Lop l=new Lop();
                l.setMaLHP(rs.getString(1));
                l.setMaMH(rs.getString(2));
                l.setMaGV(rs.getString(3));
                l.setNgayHoc(rs.getInt(4));
                l.setCaHoc(rs.getInt(5));
                TLop.add(l);
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(rs);
            JavaConnection.close(cs);
            JavaConnection.close(conn);
        }
        return TLop;
    }
    public String findID(String code) {
        String id="";
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=JavaConnection.getConnection();
            stmt=conn.prepareStatement(SQL_IdGV);
            stmt.setString(1, code);
            rs=stmt.executeQuery();
            while(rs.next()){
                id=rs.getString(1);
                return id;
            }
            //rows=stmt.executeUpdate();
            // System.out.println("Affected records:" + rows);
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
            JavaConnection.close(rs);
        }
        return null;
    }
    public int insertGiangDay(String malhp,String magv,String mamh,int hk,String nk,int tc,int nh,int ch){
        Connection conn = null;
        CallableStatement cs=null;
        int rows = 0;
        try{
            conn = JavaConnection.getConnection();
            cs = conn.prepareCall(SQL_INSERTmonhoc);
            cs.setString(1, malhp);
            cs.setString(2, magv);
            cs.setString(3, mamh);
            cs.setInt(4, hk);
            cs.setString(5, nk);
            cs.setInt(6, tc);
            cs.setInt(7, nh);
            cs.setInt(8, ch);
            System.out.println("Executing query:" + SQL_INSERTmonhoc);
            rows = cs.executeUpdate();
            System.out.println("Affected records:" + rows);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            JavaConnection.close(cs);
            JavaConnection.close(conn);
        }
        return rows;
    }
    public List<String> loadtoCombobox(int so){
        List<String> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=JavaConnection.getConnection();
            if(so==1){
                stmt=conn.prepareStatement(SQL_LOADmonhoc);
                rs=stmt.executeQuery(SQL_LOADmonhoc);
                while(rs.next()){
                //  movien.setName(nombre);
                    list.add(rs.getString(1)+" "+rs.getString(2));
                }
            }
            else if(so==2){
                stmt=conn.prepareStatement(SQL_LOADlop);
                rs=stmt.executeQuery(SQL_LOADlop);
                while(rs.next()){
                //  movien.setName(nombre);
                    list.add(rs.getString(1));
                }
            }
            else if(so==3){
                stmt=conn.prepareStatement(SQL_LOADkhoa);
                rs=stmt.executeQuery(SQL_LOADkhoa);
                while(rs.next()){
                //  movien.setName(nombre);
                    list.add(rs.getString(1));
                }
            }
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }
    public List<Lop> loadTKB(String code,String hk){
        Connection conn=null;
        CallableStatement cs=null;
        ResultSet rs=null;       
        List<Lop>TLop=new ArrayList<>();
        try{
            conn=JavaConnection.getConnection();
            cs=conn.prepareCall(SQL_LOADtkb);
            cs.setString(1, code);
            cs.setInt(2, Integer.parseInt(hk));
            rs=cs.executeQuery();
            while(rs.next()){
                Lop l=new Lop();
                l.setMaLHP(rs.getString(1));
                l.setMaMH(rs.getString(2));
                l.setMaGV(rs.getString(3));
                l.setNgayHoc(rs.getInt(4));
                l.setCaHoc(rs.getInt(5));
                //  movien.setName(nombre);
                TLop.add(l);
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(rs);
            JavaConnection.close(cs);
            JavaConnection.close(conn);
        }
        return TLop;
    }
    public List<Lop> loadTKB_GV(String code,String nk,String hk){
        Connection conn=null;
        CallableStatement cs=null;
        ResultSet rs=null;       
        List<Lop>TLop=new ArrayList<>();
        System.out.println(code);
        try{
            conn=JavaConnection.getConnection();
            cs=conn.prepareCall(SQL_LOADtkbGV);
            cs.setString(1, code);
            cs.setString(2, nk);
            cs.setString(3, hk);
            rs=cs.executeQuery();
            while(rs.next()){
                Lop l=new Lop();
                l.setMaLHP(rs.getString(1));
                l.setMaMH(rs.getString(2));
                l.setMaGV(rs.getString(3));
                l.setNgayHoc(rs.getInt(4));
                l.setCaHoc(rs.getInt(5));
                //  movien.setName(nombre);
                TLop.add(l);
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(rs);
            JavaConnection.close(cs);
            JavaConnection.close(conn);
        }
        return TLop;
    }
}
