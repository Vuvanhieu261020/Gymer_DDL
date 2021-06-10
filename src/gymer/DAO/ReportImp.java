/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;
import java.util.*;
import gymer.database.DButil;
import gymer.entities.*;
import gymer.utilities.*;
import java.sql.*;
/**
 *
 * @author luyen
 */
public class ReportImp {
    private static final String RPHDHANG = "select tbl_hoadonhang.MaHoaDonHang, tbl_hoadonhang.Ngay, tbl_hoadonhang.TenKH, tbl_hoadonhang.SDT, tbl_nhanvien.Ten, tbl_hoadonhang.MaNV, tbl_hoadonhang.TongTien from tbl_hoadonhang inner join tbl_nhanvien on tbl_hoadonhang.MaNV = tbl_nhanvien.MaNV where tbl_hoadonhang.Ngay between ? and ?";
    private static final String RPHDTAP = "select tbl_hoadontap.MaHoaDonTap, tbl_hoadontap.Ngay, tbl_dichvu.Ten as TenDV, tbl_khachhang.Ten as TenKH, tbl_khachhang.SDT, tbl_nhanvien.Ten, tbl_hoadontap.MaNV, tbl_hoadontap.TongTien from tbl_hoadontap inner join tbl_nhanvien on tbl_hoadontap.MaNV = tbl_nhanvien.MaNV inner join tbl_khachhang on tbl_hoadontap.MaKH = tbl_khachhang.MaKH inner join tbl_cthdtap on tbl_cthdtap.MaHoaDonTap = tbl_hoadontap.MaHoaDonTap inner join tbl_dichvu on tbl_cthdtap.MaDV = tbl_dichvu.MaDV where tbl_hoadontap.Ngay between ? and ?";
    

    public List<RPDetails> getDataHang (String date1 , String date2){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPHDHANG);
            stmt.setString(1, date1);
            stmt.setString(2, DateTime.plusDate(date2, 1));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setMaHD(rs.getString("MaHoaDonHang"));
                cs.setNgayLap(rs.getString("Ngay"));
                cs.setTenKhach(rs.getString("TenKH"));
                cs.setSDTKhach(rs.getString("SDT"));
                cs.setTenNV(rs.getString("Ten"));
                cs.setMaNV(rs.getString("MaNV"));
                cs.setTongTien(rs.getInt("TongTien"));
            }
            return data;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            DButil.closeConn(conn);
            DButil.closeStm(stmt);
        }
    }
    
    
    public List<RPDetails> getDataTap (String date1 , String date2){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPHDTAP);
            stmt.setString(1, date1);
            stmt.setString(2, DateTime.plusDate(date2, 1));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setMaHD(rs.getString("MaHoaDonHang"));
                cs.setNgayLap(rs.getString("Ngay"));
                cs.setTenDV(rs.getString("TenDV"));
                cs.setTenKhach(rs.getString("TenKH"));
                cs.setSDTKhach(rs.getString("SDT"));
                cs.setTenNV(rs.getString("Ten"));
                cs.setMaNV(rs.getString("MaNV"));
                cs.setTongTien(rs.getInt("TongTien"));
            }
            return data;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            DButil.closeConn(conn);
            DButil.closeStm(stmt);
        }
    }
    
    

}
