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
        
        //System.out.println("Anh yeu Em");
        
        
        //System.out.println("Anh yeu Em");
        /*Customer cs = new Customer();
        CustomerImp csi = new CustomerImp();
        cs.setID("713747");
        cs.setCMND("031500003515");
        cs.setAddress("oxford");
        cs.setSDT("221124540");
        cs.setYearofBirh(2040);
        cs.setSex(true);
        cs.setName("stven haweye");
        boolean check = csi.update(cs);
        
        List<Customer> data;
        data = csi.findByName("dtbn");
        for (Customer mm : data){
            System.out.println(mm.getID());
        }*/
        MainForm mf = new MainForm();
        mf.setVisible(true);
        
        /*MainForm mf = new MainForm ();
        mf.setVisible(true);*/
        
        /*String number = "04515662";
        System.out.println(Regex.NumericCheck(number));*/
        //System.out.println(HashPassword.Hash("luyen3222513"));
    }
}
