/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.software;
import gymer.entities.MemberCard;
import gymer.DAO.MemberCardImp;
import gymer.utilities.KeyDB;
import java.util.List;

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
        
        System.out.println("Anh yeu Em");
    }
}
