/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.database;

import java.sql.*;

public class MySqlConnect {
    private String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    // change the user name here
    static private String USER_NAME;
    // change the pass word here
    private String PASSWORD;
    MySqlConnect () {
        this.USER_NAME = "";
        this.PASSWORD = "";
    }
    public void setLoginInformation (String USER_NAME,String PASSWORD){
        this.USER_NAME = USER_NAME;
        this.PASSWORD = PASSWORD;
    }
    public boolean connecttoDB (){
        Connection conn = null;
        try {
            // connnect to database
            Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            conn.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
