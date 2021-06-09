/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;
import java.util.*;
import gymer.database.DButil;
import gymer.entities.*;
import gymer.utilities.HashPassword;
import java.sql.*;
/**
 *
 * @author luyen
 */
public class BillGoodsImp implements UCRD<BillGoods>, BillGoodsDAO{
    
    private static final String DELETEBILL = "delete from tbl_hoadonhang where MaHoaDonHang=?";
    private static final String DELETEDETAILS = "delete from tbl_cthdhang where MaHoaDonHang=?";
    private static final String FIND_ALL = "select MaHoaDonHang, Ngay, TenKH, tbl_hoadonhang.SDT, tbl_nhanvien.Ten, TongTien, MaNV from tbl_hoadonhang inner join tbl_nhanvien on tbl_hoadonhang.MaNV = tbl_nhanvien.MaNV";
    private static final String FIND_BY_IDNV = "select MaHoaDonHang, Ngay, TenKH, tbl_hoadonhang.SDT, tbl_nhanvien.Ten, TongTien, MaNV from tbl_hoadonhang inner join tbl_nhanvien on tbl_hoadonhang.MaNV = tbl_nhanvien.MaNV where MaNV=?";
    private static final String FIND_BY_SDT = "select MaHoaDonHang, Ngay, TenKH, tbl_hoadonhang.SDT, tbl_nhanvien.Ten, TongTien, MaNV from tbl_hoadonhang inner join tbl_nhanvien on tbl_hoadonhang.MaNV = tbl_nhanvien.MaNV where tbl_hoadonhang.SDT=? ";
    private static final String FIND_BY_MAHD = "select MaHoaDonHang, Ngay, TenKH, tbl_hoadonhang.SDT, tbl_nhanvien.Ten, TongTien, MaNV from tbl_hoadonhang inner join tbl_nhanvien on tbl_hoadonhang.MaNV = tbl_nhanvien.MaNV where tbl_hoadonhang.MaHoaDonHang=?";
    private static final String FIND_BY_TEN = "select MaHoaDonHang, Ngay, TenKH, tbl_hoadonhang.SDT, tbl_nhanvien.Ten, TongTien, MaNV from tbl_hoadonhang inner join tbl_nhanvien on tbl_hoadonhang.MaNV = tbl_nhanvien.MaNV where tbl_hoadonhang.Ten=? ";
    private static final String INSERTBILL = "insert into tbl_hoadonhang(MaHoaDonHang, Ngay, TenKH, SDT, MaNV, TongTien) values(?, ?, ?, ?, ?, ?)";
    private static final String INSERTDETALS = "insert into tbl_cthdhang(MaHoaDonHang, MaHang, SoLuong) values(?, ?, ?)";
    private static final String GETDETAILS = "select MaHang, TenHang, Gia, SoLuong, DVT from tbl_cthdhang inner join tbl_hanghoa on tbl_cthdhang.MaHang = tbl_hanghoa.MaHang where tbl_cthdhang.MaHaoDonHang=?";
    
    
    @Override
    public List<BillGoods> getAll() {
        List<BillGoods> data = new ArrayList<BillGoods>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillGoods cs = new BillGoods();
                cs.setMaHoaDonHang(rs.getString("MaHoaDonHang"));
                cs.setNgay(rs.getString("Ngay"));
                cs.setTenKH(rs.getString("TenKH"));
                cs.setSDT(rs.getString("SDT"));
                cs.setTongTien(rs.getInt("TongTien"));
                cs.setMaNV(rs.getString("MaNV"));
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

    @Override
    public boolean insert(BillGoods input) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            //MaHoaDonHang, Ngay, TenKH, SDT, MaNV, TongTien
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(INSERTBILL);
            stmt.setString(1, input.getMaHoaDonHang());
            stmt.setString(2, input.getNgay());
            stmt.setString(3, input.getTenKH());
            stmt.setString(4, input.getSDT());
            stmt.setString(5, input.getMaNV());
            stmt.setInt(6, input.getTongTien());
            stmt.execute();
            stmt = conn.prepareStatement(INSERTDETALS);
            for (BillGoods_Details dt : input.getDetails()){
                stmt.setString(1, dt.getMaHD());
                stmt.setString(2, dt.getMaHang());
                stmt.setInt(3, dt.getSoLuong());
                stmt.execute();
            }
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            DButil.closeConn(conn);
            DButil.closeStm(stmt);
        }
    }

    @Override
    public boolean update(BillGoods input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String ID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(DELETEBILL);
            stmt.setString(1, ID);
            stmt.execute();
            stmt = conn.prepareStatement(DELETEDETAILS);
            stmt.setString(1, ID);
            stmt.execute();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            DButil.closeConn(conn);
            DButil.closeStm(stmt);
        }
    }

    @Override
    public List<BillGoods> findByIDNV(String ID) {
        List<BillGoods> data = new ArrayList<BillGoods>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_IDNV);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillGoods cs = new BillGoods();
                cs.setMaHoaDonHang(rs.getString("MaHoaDonHang"));
                cs.setNgay(rs.getString("Ngay"));
                cs.setTenKH(rs.getString("TenKH"));
                cs.setSDT(rs.getString("SDT"));
                cs.setTongTien(rs.getInt("TongTien"));
                cs.setMaNV(rs.getString("MaNV"));
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

    @Override
    public List<BillGoods> findByTenKhach(String Name) {
        List<BillGoods> data = new ArrayList<BillGoods>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_TEN);
            stmt.setString(1, Name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillGoods cs = new BillGoods();
                cs.setMaHoaDonHang(rs.getString("MaHoaDonHang"));
                cs.setNgay(rs.getString("Ngay"));
                cs.setTenKH(rs.getString("TenKH"));
                cs.setSDT(rs.getString("SDT"));
                cs.setTongTien(rs.getInt("TongTien"));
                cs.setMaNV(rs.getString("MaNV"));
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

    @Override
    public List<BillGoods> findByMaHD(String MaHD) {
        List<BillGoods> data = new ArrayList<BillGoods>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_MAHD);
            stmt.setString(1, MaHD);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillGoods cs = new BillGoods();
                cs.setMaHoaDonHang(rs.getString("MaHoaDonHang"));
                cs.setNgay(rs.getString("Ngay"));
                cs.setTenKH(rs.getString("TenKH"));
                cs.setSDT(rs.getString("SDT"));
                cs.setTongTien(rs.getInt("TongTien"));
                cs.setMaNV(rs.getString("MaNV"));
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

    @Override
    public List<BillGoods> findBySDT(String SDT) {
        List<BillGoods> data = new ArrayList<BillGoods>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_SDT);
            stmt.setString(1, SDT);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillGoods cs = new BillGoods();
                cs.setMaHoaDonHang(rs.getString("MaHoaDonHang"));
                cs.setNgay(rs.getString("Ngay"));
                cs.setTenKH(rs.getString("TenKH"));
                cs.setSDT(rs.getString("SDT"));
                cs.setTongTien(rs.getInt("TongTien"));
                cs.setMaNV(rs.getString("MaNV"));
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

    @Override
    public List<BillGoods_Details> getDetails(String MaHD) {
        List<BillGoods_Details> data = new ArrayList<BillGoods_Details>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(GETDETAILS);
            stmt.setString(1, MaHD);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillGoods_Details cs = new BillGoods_Details();
                cs.setMaHD(rs.getString(MaHD));
                cs.setMaHang(rs.getString("MaHang"));
                cs.setTenHang(rs.getString("TenHang"));
                cs.setGia(rs.getInt("Gia"));
                cs.setSoLuong(rs.getInt("SoLuong"));
                cs.setDVT(rs.getString("SVT"));
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
