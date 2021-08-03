/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.software;
import gymer.DAO.*;
import gymer.entities.*;
import gymer.utilities.*;
import java.util.List;
import gymer.GUI.*;
import gymer.database.DButil;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author luyen
 */
public class MainClass {
    public static void main(String[] args){
        
//        Employee em = new Employee ();
//        EmployeeImp emi = new EmployeeImp ();
//        em.setMaNV(KeyDB.genKey());
//        em.setAddress("40/80 Hoàng Đạo Thành");
//        em.setSDT("0822203990");
//        em.setSex(true);
//        em.setTen("ngocdtbn");
//        em.setViTri("Quản lý");
//        em.setYearofBirh(2000);
//        em.setCMND("031200003515");
//        emi.insert(em, "admin", "1");
        
        
//        String pwdDB = JOptionPane.showInputDialog("PASSWORD DATABASE");
//        DButil.setPWD(pwdDB);
          LoginForm lg = new LoginForm();
          lg.setVisible(true);

    }
}
