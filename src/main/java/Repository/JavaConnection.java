/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author lasin
 */
public class JavaConnection {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/qlsv";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "123456";
    private static Driver driver;


    public static synchronized Connection getConnection() throws SQLException {
        if (driver == null) {
            try {
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver)jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
            } catch (Exception var1) {
                System.out.println("Failure to load the JDBC driver");
                var1.printStackTrace(System.out);
            }
        }

        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }

    }

    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }

    }
    public static void close(CallableStatement cs) {
        try {
            if (cs != null) {
                cs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }

    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }

    }
}
