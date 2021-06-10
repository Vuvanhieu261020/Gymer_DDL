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
public class BillTraning_Details {
    private String MaHoaDonTap;
    private String MaDV;
    private String Ten;
    private int Gia;
    private int ThoiGian;

    public BillTraning_Details() {
        this.MaHoaDonTap = "";
        this.MaDV = "";
        this.Ten = "";
        this.Gia = 0;
        this.ThoiGian = 0;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public int getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(int ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    
    public String getMaHoaDonTap() {
        return MaHoaDonTap;
    }

    public void setMaHoaDonTap(String MaHoaDonTap) {
        this.MaHoaDonTap = MaHoaDonTap;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }
}
