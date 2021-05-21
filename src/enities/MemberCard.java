/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enities;
import java.util.Date;

/**
 *
 * @author luyen
 */
public class MemberCard {
    private String CardID;
    private String MaKH;
    private boolean Status;
    private String StartDate;
    private String MaDV;
    
    MemberCard (String CardID, String MaKH, boolean Status, String StartDate, String MaDV){
        this.CardID = CardID;
        this.MaDV = MaDV;
        this.StartDate = StartDate;
        this.MaKH = MaKH;
        this.Status = Status;
        
    }
    
    MemberCard (){}
    
    public String getID (){
        return CardID;
    }
    public String getMaKH (){
        return MaKH;
    }
    public boolean getStatus (){
        return Status;
    }
    public String getStartDate (){
        return StartDate;
    }
    public String getMaDV (){
        return MaDV;
    }
    
    
    
}
