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
        cs.setName("ngocdtb");
        csi.delete("257412");
        csi.insert(cs);
        List<Customer> data;
        data = csi.getAll();
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
        
        /*ReportImp rpi = new ReportImp();
        for (RPDetails rp : rpi.getAllTap()){
            System.out.println(rp.getMaHD());
        }*/
        
        LoginForm lg = new LoginForm();
        lg.setVisible(true);
        /*QL_hoivien ds = new QL_hoivien();
        ds.setVisible(true);*/
       
        /*Employee em = new Employee ();
        EmployeeImp emi = new EmployeeImp ();
        em.setMaNV(KeyDB.genKey());
        em.setAddress("40/80 Hoàng Đạo Thành");
        em.setSDT("0822203990");
        em.setSex(true);
        em.setTen("ngocdtbn");
        em.setViTri("Quản lý");
        em.setYearofBirh(2000);
        em.setCMND("031200003515");
        emi.insert(em, "admin", "1");*/
        
        // test Ulity
        //String number = "04515662";
        //System.out.println(Regex.NumericCheck(number));
        //System.out.println(HashPassword.Hash("luyen3222513"));
        //System.out.println(DateTime.convertDB("11-02-2000"));
        
        //test Emoloyee
//        Employee ep= new  Employee();
//        EmployeeImp epa= new EmployeeImp();
//        ep.setTen("LINH");
//        ep.setMaNV("1");
//        ep.setAddress("dddd");
//        ep.setCMND("782373827");
//        ep.setHspass("123456");
//        ep.setIdLogin("LINH");
//        ep.setSDT("0944315816");
//        ep.setSex(false);
//        ep.setViTri("Quản lý");
//        ep.setYearofBirh(2000);
//        epa.insert(ep,"LINH","123456");
        
    }
}
