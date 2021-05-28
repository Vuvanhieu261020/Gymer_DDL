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
public class Customer {
    private String ID;
    private String Name;
    private String CMND;
    private String SDT;
    private String Address;
    private int YearofBirh;
    private boolean Sex;
    
    public Customer (){
        this.ID = "";
        this.CMND = "";
        this.Name = "";
        this.Sex = true;
        this.YearofBirh = 1900;
        this.Address = "";
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getCMND() {
        return CMND;
    }

    public String getAddress() {
        return Address;
    }

    public int getYearofBirh() {
        return YearofBirh;
    }
    
    public String getSDT() {
        return this.SDT;
    }

    public boolean getSex() {
        return Sex;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setYearofBirh(int YearofBirh) {
        this.YearofBirh = YearofBirh;
    }

    public void setSex(boolean Sex) {
        this.Sex = Sex;
    }
    
    public void setSDT (String SDT) {
        this.SDT = SDT;
    }
   
    
}
