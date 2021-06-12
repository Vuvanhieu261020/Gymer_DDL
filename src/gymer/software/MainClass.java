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
        mb.setMaKH("256505");
        mb.setStatus(true);
        mb.setStartDate("2000-11-22");
        mbi.delete("441754");
        
        List<MemberCard> data;
        //mbi.insert(mb);
        data = mbi.findByName("Thao");
        for (MemberCard mm : data){
            System.out.println(mm.getCardID());
        }*/
        
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
        data = csi.findByString("0825452541");
        for (Customer mm : data){
            System.out.println(mm.getID());
            System.out.println(mm.getName());
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
        data = svi.findByString("44163");
        for (Service mm : data){
            System.out.println(mm.getMaDV());
        }*/
        

        // interface methods
        /*MainForm mf = new MainForm ();
        mf.setVisible(true);*/  
        LoginForm lg = new LoginForm();
        lg.setVisible(true);
        
        
        // Employee 
        
        /*Employee em = new Employee();
        EmployeeImp emi = new EmployeeImp();*/
        
        /*em.setMaNV("123456789");
        em.setAddress("40/80 Hoàn Đạo Thành");
        em.setSDT("0822208880");
        em.setTen("dtbn");
        em.setSex(true);
        em.setCMND("1154545515");
        em.setViTri("Mẹ");
        em.setYearofBirh(2000);
        emi.insert(em,"123456789","123456789");
        Employee em2 = new Employee();
        em2 = emi.initfromDB("123456789", "123456789");
        System.out.print(em2.getIdLogin());*/
        
        // Equipment
        
        /*EquipmentImp eqi = new EquipmentImp();
        Equipment eq = new Equipment();
        eq.setMaTB("611897");
        eq.setGiaNhap(100000);
        eq.setNgayNhap("2021-09-05");
        eq.setNSX("SLD Finance");
        eq.setTen("Jet Engine");
        eq.setTinhTrang("Tốt");
        eq.setSoLuong(100);
        eqi.update(eq);
        for (Equipment mm : eqi.getAvailableList()){
            System.out.println(mm.getMaTB());
        }*/
        
        
        // test Ulity
        //String number = "04515662";
        //System.out.println(Regex.NumericCheck(number));
        //System.out.println(HashPassword.Hash("luyen3222513"));
        //System.out.println(getDate.getTime());
        //String ip = ExcelFiles.createFile("Bao Cao");
        //ExcelFiles.writeFile(ip);
        //CustomerImp emi = new CustomerImp();
        //ExcelFiles.createRPCustomer(emi.getAll(), "D:/BaoCao.xlsx");
        //LogFile.createLoginLog("454545454", "Đồng Xuân Luyện");
        //LogFile.createDeleteLog("4523425", "dtbn","34234234","sadasd",LogFile.KHACHHANG);
        
    }
}
