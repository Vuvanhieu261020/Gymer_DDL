/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.entities;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author luyen
 */
public class BillGoods {
    private String MaHoaDonHang;
    private String Ngay;
    private String TenKH;
    private String SDT;
    private String MaNV;
    private int TongTien;
    private List<BillGoods_Details> details;

    public BillGoods() {
        this.MaHoaDonHang = "";
        this.Ngay = "";
        this.TenKH = "";
        this.SDT = "";
        this.MaNV = "";
        this.TongTien = 0;
        details = new ArrayList<BillGoods_Details>();
    }

    public List<BillGoods_Details> getDetails() {
        return details;
    }

    public void setDetails(List<BillGoods_Details> details) {
        this.details = details;
    }

    public String getMaHoaDonHang() {
        return MaHoaDonHang;
    }

    public void setMaHoaDonHang(String MaHoaDonHang) {
        this.MaHoaDonHang = MaHoaDonHang;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String Ngay) {
        this.Ngay = Ngay;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
    
}

