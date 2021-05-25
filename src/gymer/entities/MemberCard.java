/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.entities;

/**
 *
 * @author luyen
 */


// class nay de tao ra thuc the , de luu tru, van can` them 1 list de lam chi the
public class MemberCard {
    private String MaThe;
    private String MaKH;
    private boolean Status;
    private String Date;
    private String MaDV;
    
    public MemberCard() {
        this.MaThe = "";
        this.MaKH = "";
        this.Status = false;
        this.Date = "";
        this.MaDV = "";
    }
    
    public String getCardID (){
        return MaThe;
    }
    
    public String getMaKH (){
        return MaKH;
    }
    
    public boolean getStatus (){
        return Status;
    }
    
    public String getStartDate (){
        return Date;
    }
    
    public String getMaDV (){
        return MaDV;
    }

    public void setID(String MaThe) {
        this.MaThe = MaThe;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public void setStartDate(String Date) {
        this.Date = Date;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }
    
}
