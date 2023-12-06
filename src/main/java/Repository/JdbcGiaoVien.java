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
public class JdbcGiaoVien {
    private final String SQL_ThongTingGiaoVienSQL="select distinct gv.Magv,gv.TenGV,gv.Makhoa from GIAOVIEN gv where gv.Magv =?";
    public Object[] thongtingiaovien(String code)
    {
        Object dataRow[]=new Object[5];
        Connection conn=null;
        PreparedStatement stmt=null;
        //CallableStatement cs=null;
        ResultSet rs=null;      
        try{
            conn=JavaConnection.getConnection();
            stmt=conn.prepareCall(SQL_ThongTingGiaoVienSQL);
            stmt.setString(1, code);
            rs=stmt.executeQuery();
            while(rs.next())
            {
                dataRow[0]=rs.getString(1);
                dataRow[1]=rs.getString(2);
                dataRow[2]=rs.getString(3);
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
    
}
