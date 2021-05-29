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
public class MemberCar_Detail {
    private String CardID;
    private String Time;
    
    public MemberCar_Detail (String ID){
        this.CardID = ID;
        this.Time = "";
    }

    public String getCardID() {
        return CardID;
    }

    public void setCardID(String CardID) {
        this.CardID = CardID;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
    
    
}
