/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.software;
import gymer.DAO.*;
import gymer.entities.*;
import gymer.utilities.KeyDB;
import java.util.List;
import gymer.GUI.*;
import gymer.utilities.Regex;
/**
 *
 * @author luyen
 */
public class MainClass {
    public static void main(String[] args){
        
        
        // test code
        // test git
        /*MemberCardImp mbi = new MemberCardImp();
        MemberCard mb = new MemberCard();
        mb.setID(KeyDB.genKey());
        mb.setMaDV(KeyDB.genKey());
        mb.setMaKH(KeyDB.genKey());
        mb.setStatus(true);
        mb.setStartDate("2000-11-22");
        mbi.insert(mb);
        
        List<MemberCard> data;
        data = mbi.getAll();
        for (MemberCard mm : data){
            System.out.println(mm.getCardID());
        }*/
        
        /*System.out.println("Anh yeu Em");
        
        Customer cs = new Customer();
        CustomerImp csi = new CustomerImp();
        cs.setID(KeyDB.genKey());
        cs.setCMND("031500003515");
        cs.setAddress("massachussett");
        cs.setSDT("22112000");
        cs.setYearofBirh(2000);
        cs.setSex(true);
        cs.setName("dtbn");
        boolean check = csi.insert(cs);
        
        List<Customer> data;
        data = csi.getAll();
        for (Customer mm : data){
            System.out.println(mm.getID());
        }*/
        
        /*MainForm mf = new MainForm ();
        mf.setVisible(true);*/
        
        String number = "04515662";
        System.out.println(Regex.NumericCheck(number));
        
    }
}
