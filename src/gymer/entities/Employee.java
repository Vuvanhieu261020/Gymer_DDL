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
public class Employee {
    
    private String IdLogin;
    private String hspass;
    private String MaNV;
    private String Ten;
    private String CMND;
    private String SDT;
    private String Address;
    private int YearofBirh;
    private boolean Sex;
    private String ViTri;

    public Employee() {
        this.MaNV = "";
        this.Ten = "";
        this.CMND = "";
        this.SDT = "";
        this.Address = "";
        this.YearofBirh = 0;
        this.Sex = true;
        this.ViTri = "";
        this.IdLogin = "";
        hspass = "";
    }    

    public String getIdLogin() {
        return IdLogin;
    }

    public void setIdLogin(String IdLogin) {
        this.IdLogin = IdLogin;
    }

    public String getHspass() {
        return hspass;
    }

    public void setHspass(String hspass) {
        this.hspass = hspass;
    }
    
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getYearofBirh() {
        return YearofBirh;
    }

    public void setYearofBirh(int YearofBirh) {
        this.YearofBirh = YearofBirh;
    }

    public boolean getSex() {
        return Sex;
    }

    public void setSex(boolean Sex) {
        this.Sex = Sex;
    }

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String ViTri) {
        this.ViTri = ViTri;
    }

}
