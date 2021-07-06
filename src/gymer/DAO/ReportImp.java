/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;
import java.util.*;
import gymer.database.*;
import gymer.entities.*;
import gymer.utilities.*;
import java.sql.*;
/**
 *
 * @author luyen
 */
public class ReportImp {
    
    private static final String RPHDTAP_ALL = "select tbl_hoadontap.MaHoaDonTap, tbl_hoadontap.Ngay, tbl_dichvu.Ten as TenDV, tbl_khachhang.Ten as TenKH, tbl_khachhang.SDT, tbl_nhanvien.Ten, tbl_hoadontap.MaNV, tbl_hoadontap.TongTien from tbl_hoadontap inner join tbl_nhanvien on tbl_hoadontap.MaNV = tbl_nhanvien.MaNV inner join tbl_khachhang on tbl_hoadontap.MaKH = tbl_khachhang.MaKH inner join tbl_cthdtap on tbl_cthdtap.MaHoaDonTap = tbl_hoadontap.MaHoaDonTap inner join tbl_dichvu on tbl_cthdtap.MaDV = tbl_dichvu.MaDV";
    private static final String RPHDHANG_ALL = "select tbl_hoadonhang.MaHoaDonHang, tbl_hoadonhang.Ngay, tbl_hoadonhang.TenKH, tbl_hoadonhang.SDT, tbl_nhanvien.Ten, tbl_hoadonhang.MaNV, tbl_hoadonhang.TongTien from tbl_hoadonhang inner join tbl_nhanvien on tbl_hoadonhang.MaNV = tbl_nhanvien.MaNV";
    private static final String RPHDHANG = "select tbl_hoadonhang.MaHoaDonHang, tbl_hoadonhang.Ngay, tbl_hoadonhang.TenKH, tbl_hoadonhang.SDT, tbl_nhanvien.Ten, tbl_hoadonhang.MaNV, tbl_hoadonhang.TongTien from tbl_hoadonhang inner join tbl_nhanvien on tbl_hoadonhang.MaNV = tbl_nhanvien.MaNV where tbl_hoadonhang.Ngay between ? and ?";
    private static final String RPHDTAP = "select tbl_hoadontap.MaHoaDonTap, tbl_hoadontap.Ngay, tbl_dichvu.Ten as TenDV, tbl_khachhang.Ten as TenKH, tbl_khachhang.SDT, tbl_nhanvien.Ten, tbl_hoadontap.MaNV, tbl_hoadontap.TongTien from tbl_hoadontap inner join tbl_nhanvien on tbl_hoadontap.MaNV = tbl_nhanvien.MaNV inner join tbl_khachhang on tbl_hoadontap.MaKH = tbl_khachhang.MaKH inner join tbl_cthdtap on tbl_cthdtap.MaHoaDonTap = tbl_hoadontap.MaHoaDonTap inner join tbl_dichvu on tbl_cthdtap.MaDV = tbl_dichvu.MaDV where tbl_hoadontap.Ngay between ? and ?";
    private static final String RPDICHVU_ALL = "select tbl_dichvu.Ten, count(tbl_dichvu.MaDV) as num, sum(tbl_hoadontap.TongTien) as money from tbl_hoadontap inner join tbl_cthdtap on tbl_cthdtap.MaHoaDonTap = tbl_hoadontap.MaHoaDonTap inner join tbl_dichvu on tbl_dichvu.MaDV = tbl_cthdtap.MaDV group by tbl_dichvu.Ten";
    private static final String RPDICHVU = "select tbl_dichvu.Ten, count(tbl_dichvu.MaDV) as num, sum(tbl_hoadontap.TongTien) as money from tbl_hoadontap inner join tbl_cthdtap on tbl_cthdtap.MaHoaDonTap = tbl_hoadontap.MaHoaDonTap inner join tbl_dichvu on tbl_dichvu.MaDV = tbl_cthdtap.MaDV where tbl_hoadontap.Ngay between ? and ? group by tbl_dichvu.Ten";
    private static final String RPHANGHOA_ALL = "select tbl_hanghoa.Ten, sum(tbl_cthdhang.SoLuong) as num, tbl_hanghoa.SoLuong, (sum(tbl_cthdhang.SoLuong) * tbl_hanghoa.Gia) as money from tbl_hanghoa inner join tbl_cthdhang on tbl_hanghoa.MaHang = tbl_cthdhang.MaHang group by tbl_hanghoa.Ten";
    private static final String RPHANGHOA = "select tbl_hanghoa.Ten, sum(tbl_cthdhang.SoLuong) as num, tbl_hanghoa.SoLuong, (sum(tbl_cthdhang.SoLuong) * tbl_hanghoa.Gia) as money from tbl_hanghoa inner join tbl_cthdhang on tbl_hanghoa.MaHang = tbl_cthdhang.MaHang inner join tbl_hoadonhang on tbl_cthdhang.MaHoaDonHang = tbl_hoadonhang.MaHoaDonHang where tbl_hoadonhang.Ngay between ? and ? group by tbl_hanghoa.Ten";
    private static final String RPHANGHOASTRING = "select tbl_hoadonhang.MaHoaDonHang, tbl_hoadonhang.Ngay, tbl_hoadonhang.TenKH, tbl_hoadonhang.SDT, tbl_nhanvien.Ten, tbl_hoadonhang.MaNV, tbl_hoadonhang.TongTien \n" +
"from tbl_hoadonhang inner join tbl_nhanvien on tbl_hoadonhang.MaNV = tbl_nhanvien.MaNV\n" +
"where tbl_hoadonhang.SDT like concat('%',?,'%') or tbl_hoadonhang.TenKH like concat('%',?,'%') or tbl_hoadonhang.MaHoaDonHang like concat('%',?,'%') or tbl_nhanvien.Ten like concat('%',?,'%')";
    private static final String RPTAPSTRING = "select tbl_hoadontap.MaHoaDonTap, tbl_hoadontap.Ngay, tbl_dichvu.Ten as TenDV, tbl_khachhang.Ten as TenKH, tbl_khachhang.SDT, tbl_nhanvien.Ten, tbl_hoadontap.MaNV, tbl_hoadontap.TongTien \n" +
"from tbl_hoadontap inner join tbl_nhanvien on tbl_hoadontap.MaNV = tbl_nhanvien.MaNV inner join tbl_khachhang on tbl_hoadontap.MaKH = tbl_khachhang.MaKH inner join tbl_cthdtap on tbl_cthdtap.MaHoaDonTap = tbl_hoadontap.MaHoaDonTap inner join tbl_dichvu on tbl_cthdtap.MaDV = tbl_dichvu.MaDV\n" +
"where tbl_hoadontap.MaHoaDonTap like concat('%',?,'%') or tbl_khachhang.SDT like concat('%',?,'%') or tbl_khachhang.Ten like concat('%',?,'%') or tbl_nhanvien.Ten like concat('%',?,'%')";
    private static final String RPTAPGRALL = "select sum(TongTien) as num, Ngay as ngay, count(MaHoaDonTap) as num2 from tbl_hoadontap group by Ngay ";
    private static final String RPHANGGRALL = "select sum(TongTien) as num, Ngay as ngay, count(MaHoaDonHang) as num2 from tbl_hoadonhang group by Ngay ";
    private static final String RPNGUOITAP = "select count(MaThe) as num, MaThe, date(ThoiDiemSuDung) as ngay\n" +
"from tbl_ctthe group by ngay limit 30";
    private static final String RPNGUOITAP_1 = "select count(ThoiDiemSuDung) as num, month(ThoiDiemSuDung) as ngay \n" +
"from tbl_ctthe where tbl_ctthe.MaThe = ? group by ngay";
    private static final String RPHDTAPbyDATE = "select sum(TongTien) as num, Ngay as ngay, count(MaHoaDonTap) as num2 from tbl_hoadontap where ngay between ? and ? group by Ngay ";
    private static final String RPHDHANGbyDATE = "select sum(TongTien) as num, Ngay as ngay, count(MaHoaDonHang) as num2 where ngay between ? and ? from tbl_hoadonhang group by Ngay";
    
    
    public List<RPDetails> getAllTap (){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPHDTAP_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setMaHD(rs.getString("MaHoaDonTap"));
                cs.setNgayLap(rs.getString("Ngay"));
                cs.setTenDV(rs.getString("TenDV"));
                cs.setTenKhach(rs.getString("TenKH"));
                cs.setSDTKhach(rs.getString("SDT"));
                cs.setTenNV(rs.getString("Ten"));
                cs.setMaNV(rs.getString("MaNV"));
                cs.setTongTien(rs.getInt("TongTien"));
                data.add(cs);
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
    

    public List<RPDetails> getDataHang (String date1 , String date2){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPHDHANG);
            stmt.setString(1, date1);
            stmt.setString(2, date2);
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
                data.add(cs);
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
    
    
    public List<RPDetails> getAllHang (){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPHDHANG_ALL);
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
                data.add(cs);
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
            stmt.setString(2, date2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setMaHD(rs.getString("MaHoaDonTap"));
                cs.setNgayLap(rs.getString("Ngay"));
                cs.setTenDV(rs.getString("TenDV"));
                cs.setTenKhach(rs.getString("TenKH"));
                cs.setSDTKhach(rs.getString("SDT"));
                cs.setTenNV(rs.getString("Ten"));
                cs.setMaNV(rs.getString("MaNV"));
                cs.setTongTien(rs.getInt("TongTien"));
                data.add(cs);
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

    public List<RPDetails> getAllDichVuTap (){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPDICHVU_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setTenDV(rs.getString("Ten"));
                cs.setSoLuongDichVu(rs.getInt("num"));
                cs.setTongTien(rs.getInt("money"));
                data.add(cs);
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

    public List<RPDetails> getDichVuTapbyDate (String date1, String date2) {
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPDICHVU);
            stmt.setString(1,date1);
            stmt.setString(2,date2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setTenDV(rs.getString("Ten"));
                cs.setSoLuongDichVu(rs.getInt("num"));
                cs.setTongTien(rs.getInt("money"));
                data.add(cs);
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
    
    
    public List<RPDetails> getAllHangHoa (){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPHANGHOA_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setTenDV(rs.getString("Ten"));
                cs.setSoLuongDichVu(rs.getInt("num"));
                cs.setTonKho(rs.getInt("SoLuong"));
                cs.setTongTien(rs.getInt("money"));
                data.add(cs);
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
    
    public List<RPDetails> getAllHangHoabyDate (String date1, String date2){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPHANGHOA_ALL);
            stmt.setString(1, date1);
            stmt.setString(2, date2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setTenDV(rs.getString("Ten"));
                cs.setSoLuongDichVu(rs.getInt("num"));
                cs.setTonKho(rs.getInt("SoLuong"));
                cs.setTongTien(rs.getInt("money"));
                data.add(cs);
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
    
    public List<RPDetails> getAllTapbyString (String input){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPTAPSTRING);
            stmt.setString(1, input);
            stmt.setString(2, input);
            stmt.setString(3, input);
            stmt.setString(4, input);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setMaHD(rs.getString("MaHoaDonTap"));
                cs.setNgayLap(rs.getString("Ngay"));
                cs.setTenDV(rs.getString("TenDV"));
                cs.setTenKhach(rs.getString("TenKH"));
                cs.setSDTKhach(rs.getString("SDT"));
                cs.setTenNV(rs.getString("Ten"));
                cs.setMaNV(rs.getString("MaNV"));
                cs.setTongTien(rs.getInt("TongTien"));
                data.add(cs);
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
    
    public List<RPDetails> getAllHangbyString (String input){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPHANGHOASTRING);
            stmt.setString(1, input);
            stmt.setString(2, input);
            stmt.setString(3, input);
            stmt.setString(4, input);
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
                data.add(cs);
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
    
    public List<RPDetails> getTapforGraphAll (){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPTAPGRALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setTongTien(rs.getInt("num"));
                cs.setTenDV(rs.getString("ngay"));
                cs.setSoLuongDichVu(rs.getInt("num2"));
                data.add(cs);
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
    
    public List<RPDetails> getHangforGraphAll (){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPHANGGRALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setTongTien(rs.getInt("num"));
                cs.setTenDV(rs.getString("ngay"));
                cs.setSoLuongDichVu(rs.getInt("num2"));
                data.add(cs);
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
    
    public List<RPDetails> getHangSoLuotTap (){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPNGUOITAP);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setTongTien(rs.getInt("num"));
                cs.setTenDV(rs.getString("ngay"));
                data.add(cs);
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
    
    public List<RPDetails> getLuotTap_1 (String input){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPNGUOITAP_1);
            stmt.setString(1, input);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setTongTien(rs.getInt("num"));
                cs.setTenDV(rs.getString("ngay"));
                data.add(cs);
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
    
    public List<RPDetails> getTapforGraphAllbyDATE (String date1 , String date2){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPHDTAPbyDATE);
            stmt.setString(1, date1);
            stmt.setString(2, date2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setTongTien(rs.getInt("num"));
                cs.setTenDV(rs.getString("ngay"));
                cs.setSoLuongDichVu(rs.getInt("num2"));
                data.add(cs);
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
    
    public List<RPDetails> getHangforGraphAllbyDATE (String date1 , String date2){
        List<RPDetails> data = new ArrayList<RPDetails>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPHDHANGbyDATE);
            stmt.setString(1, date1);
            stmt.setString(2, date2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RPDetails cs = new RPDetails();
                cs.setTongTien(rs.getInt("num"));
                cs.setTenDV(rs.getString("ngay"));
                cs.setSoLuongDichVu(rs.getInt("num2"));
                data.add(cs);
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
