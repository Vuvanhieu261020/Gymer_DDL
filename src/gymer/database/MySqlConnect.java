/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.database;

import java.sql.*;

public class MySqlConnect {
    private String DB_URL;
    // change the user name here
    static private String USER_NAME;
    // change the pass word here
    private String PASSWORD;
    Connection conn;
    MySqlConnect () {
        this.USER_NAME = "";
        this.PASSWORD = "";
        this.DB_URL = "";
        this.conn = null;
    }
    
    public void setDB_URL (String DB_URL) {
        this.DB_URL = DB_URL;
    }

    public void setLoginInformation (String USER_NAME,String PASSWORD){
        this.USER_NAME = USER_NAME;
        this.PASSWORD = PASSWORD;
    }
    public boolean connecttoDB (){
        conn = null;
        try {
            // connnect to database
            Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            conn.close();
            System.out.println("Connected");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
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
    public void SQLUpdate (String SQL){
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
        }
    }
    
}
