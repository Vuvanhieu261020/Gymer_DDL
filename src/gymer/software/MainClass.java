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
        
        // tets MB
        /*MemberCardImp mbi = new MemberCardImp();
        MemberCard mb = new MemberCard();
        mb.setID(KeyDB.genKey());
        mb.setMaDV("103968");
        mb.setMaKH("257412");
        mb.setStatus(true);
        mb.setStartDate("2000-11-22");
        mbi.delete("441754");
        
        List<MemberCard> data;
        data = mbi.getAll();
        for (MemberCard mm : data){
            System.out.println(mm.getCardID());
        }*/
        
        //System.out.println("Anh yeu Em");
        
        // Customer Test
        
        /*Customer cs = new Customer();
        CustomerImp csi = new CustomerImp();
        cs.setID(KeyDB.genKey());
        cs.setCMND("031500003515");
        cs.setAddress("oxford");
        cs.setSDT("074845145");
        cs.setYearofBirh(2211);
        cs.setSex(true);
        cs.setName("Đồng Xuân Luyện");
        csi.delete("257412");
        
        List<Customer> data;
        data = csi.getAll();
        data = csi.findByName("dtbn");
        for (Customer mm : data){
            System.out.println(mm.getID());
        }*/
        
        
        // Service test
        
        /*Service sv = new Service();
        ServiceImp svi = new ServiceImp();
        sv.setGia(221100);
        sv.setMaDV(KeyDB.genKey());
        sv.setTen("Yoga");
        sv.setThoiGian(12);
        svi.insert(sv);
        List<Service> data;
        data = svi.getAll();
        for (Service mm : data){
            System.out.println(mm.getMaDV());
        }*/
        
        /*EquipmentImp eqi = new EquipmentImp();
        for (Equipment eq : eqi.getAll()){
            System.out.println(eq.getTen());
        }*/
        
        LoginForm lg = new LoginForm();
        lg.setVisible(true);
       /*QL_hoivien ds = new QL_hoivien();
       ds.setVisible(true);*/
       
        
        
        // test Ulity
        //String number = "04515662";
        //System.out.println(Regex.NumericCheck(number));
        //System.out.println(HashPassword.Hash("luyen3222513"));
        //System.out.println(DateTime.convertDB("11-02-2000"));
        
    }
}
