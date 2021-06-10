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
public class Service {
    private String MaDV;
    private String Ten;
    private int ThoiGian;
    private int Gia;

    public Service(String MaDV, String Ten, int ThoiGian, int Gia) {
        this.MaDV = MaDV;
        this.Ten = Ten;
        this.ThoiGian = ThoiGian;
        this.Gia = Gia;
    }
    
    public Service() {
        this.MaDV = "";
        this.Ten = "";
        this.ThoiGian = 0;
        this.Gia = 0;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(int ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }
    
    
    
}