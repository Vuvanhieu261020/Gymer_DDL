/*
    class duoc tao ra de giam thieu code trong dao
 */
package gymer.database;
import java.sql.*;
/**
 *
 * @author luyen
 */
public class DButil {
    // change DB url here
    public static String DB_URL = "jdbc:mysql://localhost:3306/gymer_oop";
    // change Password here
    public static String Password = "3222513";//LINHhoa117763
    // change user name here
    public static String UserName = "root";
    
    
    // ham ket noi voi co so du lieu, cac csdl khac co the thay doi o ben tren
    public static Connection getConnection (){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, UserName, Password);
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    
    
    // ham nay de ngat ket noi voi csdl
    public static void closeConn (Connection conn){
        if (conn != null){
            try {
                conn.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void closeStm (Statement stm){
        if (stm != null){
            try {
                stm.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
}
