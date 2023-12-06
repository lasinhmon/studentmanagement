/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Repository.SinhVien_Helper;
import Domain.LopHocPhan;
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
public class JdbcLopHocPhan {
    private final String SQL_SELECT2="call findLHPbyMSV (?);";
    private final String SQL_SELECT3="call findLHPbyLHP (?);";
    private final String SQL_TimDiem="call xemDiemSV (?,?);";
    private final String SQL_UPDATE="call updateDiembyMSV (?,?,?,?,?,?,?);";
    private final String SQL_GETNienKhoa="SELECT DISTINCT NienKhoa From GiangDay";
    public LopHocPhan xemdiem(String code,String ms){
        Connection conn=null;
        CallableStatement cs=null;
        ResultSet rs=null;       
        LopHocPhan lhp=new LopHocPhan();
        try{
            conn=JavaConnection.getConnection();
            cs=conn.prepareCall(SQL_TimDiem);
            cs.setString(1, code);
            cs.setString(2, ms);
            rs=cs.executeQuery();
            while(rs.next()){
                lhp.setMaMH(rs.getString(1));
                lhp.setSoTC(rs.getInt(2));
                lhp.setDiemCC(rs.getFloat(3));
                lhp.setDiemThiGK(rs.getFloat(4));
                lhp.setDiemThiCK(rs.getFloat(5));
                lhp.setDiemTB(rs.getFloat(6));
                lhp.setTrangThai(rs.getString(7));
                return lhp;
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(rs);
            JavaConnection.close(cs);
            JavaConnection.close(conn);
        }
        return null;
    }
    public List<String> getNienKhoa(){
        List<String> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=JavaConnection.getConnection();
       
                stmt=conn.prepareStatement(SQL_GETNienKhoa);
                rs=stmt.executeQuery(SQL_GETNienKhoa);
                while(rs.next()){
                    list.add(rs.getString(1));
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
    public List<LopHocPhan> select3(String code){
        Connection conn=null;
        CallableStatement cs=null;
        ResultSet rs=null;       
        List<LopHocPhan>TLHP=new ArrayList<>();
        try{
            conn=JavaConnection.getConnection();
            cs=conn.prepareCall(SQL_SELECT3);
            cs.setString(1, code);
            rs=cs.executeQuery();
            while(rs.next()){
                LopHocPhan lhp=new LopHocPhan();
                lhp.setMaLHP(rs.getString(1));
                lhp.setMaMH(rs.getString(2));
                lhp.setMaGV(rs.getString(3));
                lhp.setHocKy(rs.getInt(4));
                lhp.setNienKhoa(rs.getString(5));
                lhp.setSoTC(rs.getInt(6));
                lhp.setDiemCC(rs.getFloat(7));
                lhp.setDiemThiGK(rs.getFloat(8));
                lhp.setDiemThiCK(rs.getFloat(9));
                lhp.setDiemTB(rs.getFloat(10));
                lhp.setTrangThai(rs.getString(11));
                //  movien.setName(nombre);
                TLHP.add(lhp);
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(rs);
            JavaConnection.close(cs);
            JavaConnection.close(conn);
        }
        return TLHP;
    }
    public List<LopHocPhan> select2(String code){
        Connection conn=null;
        CallableStatement cs=null;
        ResultSet rs=null;       
        List<LopHocPhan>TLHP=new ArrayList<>();
        try{
            conn=JavaConnection.getConnection();
            cs=conn.prepareCall(SQL_SELECT2);
            cs.setString(1, code);
            rs=cs.executeQuery();
            while(rs.next()){
                LopHocPhan lhp=new LopHocPhan();
                lhp.setMaLHP(rs.getString(1));
                lhp.setMaMH(rs.getString(2));
                lhp.setMaGV(rs.getString(3));
                lhp.setHocKy(rs.getInt(4));
                lhp.setNienKhoa(rs.getString(5));
                lhp.setSoTC(rs.getInt(6));
                lhp.setDiemCC(rs.getFloat(7));
                lhp.setDiemThiGK(rs.getFloat(8));
                lhp.setDiemThiCK(rs.getFloat(9));
                lhp.setDiemTB(rs.getFloat(10));
                lhp.setTrangThai(rs.getString(11));
                //  movien.setName(nombre);
                TLHP.add(lhp);
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(rs);
            JavaConnection.close(cs);
            JavaConnection.close(conn);
        }
        return TLHP;
    }
    public int update(LopHocPhan lhp,String code) {
        SinhVien_Helper help=new SinhVien_Helper();
        Connection conn = null;
        CallableStatement cs=null;
        String tt="";
        int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            cs = conn.prepareCall(SQL_UPDATE);
            cs.setString(1, code);
            cs.setString(2, lhp.getMaMH());
            cs.setFloat(3, lhp.getDiemCC());
            cs.setFloat(4, lhp.getDiemThiGK());
            cs.setFloat(5, lhp.getDiemThiCK());
            float tb=help.SetTrangThai(lhp.getDiemCC(), lhp.getDiemThiGK(), lhp.getDiemThiCK());
            cs.setFloat(6, tb);
            
            if(lhp.getDiemCC()==0)
                tt= "Cam thi";
            else{
                if(tb<4)
                    tt= "Rot mon";
                else if(tb<5&&tb>=4)
                    tt= "Yeu";
                else if(tb<6.5&&tb>=5)
                    tt= "Trung binh";
                else if(tb<7&&tb>=6.5)
                    tt= "Trung binh kha";
                else if(tb<8.5&&tb>=7)
                    tt= "Kha";
                else 
                    tt= "Gioi";
            }
            cs.setString(7, tt);
           // cs.setFloat(6, lhp.getDiemCK());
            System.out.println("Executing query:" + SQL_UPDATE);
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
}
