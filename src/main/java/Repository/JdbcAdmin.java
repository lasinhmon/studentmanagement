/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lasin
 */
public class JdbcAdmin {
    private final String SQL_adminLogin="SELECT * FROM Admi where MaAdmin=?";
    private final String SQL_giaovienLogin="SELECT * FROM giaovien where MaGV = ?";
     private final String SQL_sinhvienLogin="SELECT * FROM sinhvien where MSSV = ?";
    public String adminLogin(String Ma){
        String id="";
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=JavaConnection.getConnection();
            stmt=conn.prepareStatement(SQL_adminLogin);
            stmt.setString(1, Ma);
            rs=stmt.executeQuery();
            while(rs.next()){
                //String nombre=rs.getString(2);
                //TblPublisher tp=new TblPublisher();
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
    
    public String giaovienLogin(String Ma)
    {
        String id="";
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=JavaConnection.getConnection();
            stmt=conn.prepareStatement(SQL_giaovienLogin);
            stmt.setString(1, Ma);
            rs=stmt.executeQuery();
            while(rs.next()){
                id=rs.getString(1);
                return id;
            }
            
        }catch(SQLException e)
        {
           e.printStackTrace(System.out);
        }finally
        {
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
            JavaConnection.close(rs);
        }
        
        return null;
    } 
   
    public String sinhvienLogin(String Ma)
    {
        String id="";
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try{
            conn=JavaConnection.getConnection();
            stmt=conn.prepareStatement(SQL_sinhvienLogin);
            stmt.setString(1, Ma);
            rs=stmt.executeQuery();
            while(rs.next())
            {
                id=rs.getString(1);
                return id;
            }
            
        }catch(SQLException e){
           e.printStackTrace(System.out);
        }finally{
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
            JavaConnection.close(rs);
        }
        
        return null;
    }
}
