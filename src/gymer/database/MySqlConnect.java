/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.database;

import java.sql.*;

public class MySqlConnect {
    private String DB_URL;
    private String USER_NAME;
    private String PASSWORD;
    Connection conn;
    public MySqlConnect () {
        // change user name here
        this.USER_NAME = "root";
        // change password here
        this.PASSWORD = "22112000";
        this.DB_URL = "jdbc:mysql://localhost:3306/testdb";
        this.conn = null;
        try {
            // connnect to database
            Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet SQLQuery (String SQL) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            conn.close();
            return rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean ExeSQL (String SQL){
        boolean rs;
        try {
            Statement stm = conn.createStatement();
            rs = stm.execute(SQL);
            return rs;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
