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
    private String USER_NAME;
    // change the pass word here
    private String PASSWORD;
    Connection conn;
    public MySqlConnect () {
        this.USER_NAME = "";
        this.PASSWORD = "";
        this.DB_URL = "";
        this.conn = null;
    }

    public void setConnection (String DB_URL,String USER_NAME,String PASSWORD){
        this.USER_NAME = USER_NAME;
        this.PASSWORD = PASSWORD;
        this.DB_URL = DB_URL;
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
}
