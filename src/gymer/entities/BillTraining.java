/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.entities;
import java.util.List;
/**
 *
 * @author luyen
 */
public class BillTraining {
    private String MaHoaDonTap;
    private String Ngay;
    private String MaNV;
    private String MaKH;
    private int TongTien;
    private List<BillTraning_Details> details;
            
    public BillTraining() {
        this.MaHoaDonTap = "";
        this.Ngay = "";
        this.MaNV = "";
        this.MaKH = "";
        this.TongTien = 0;
        this.details = null;
    }

    public List<BillTraning_Details> getDetails() {
        return details;
    }

    public void setDetails(List<BillTraning_Details> details) {
        this.details = details;
    }

    public String getMaHoaDonTap() {
        return MaHoaDonTap;
    }

    public void setMaHoaDonTap(String MaHoaDonTap) {
        this.MaHoaDonTap = MaHoaDonTap;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String Ngay) {
        this.Ngay = Ngay;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
}
