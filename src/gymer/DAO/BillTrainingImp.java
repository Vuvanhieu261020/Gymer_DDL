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

public class BillTrainingImp implements UCRD<BillTraining>, BillTrainingDAO{

    
    private static final String DELETEBILL = "delete from tbl_hoadontap where MaHoaDonTap=?";
    private static final String DELETEDETAILS = "delete from tbl_cthdtap where MaHoaDonTap=?";
    private static final String FIND_ALL = "select MaHoaDonTap, Ngay, MaNV, MaKH, TongTien from tbl_hoadontap";
    private static final String FIND_BY_IDNV = "select MaHoaDonTap, Ngay, MaNV, tbl_hoadontap.MaKH, TongTien from tbl_hoadontap inner join tbl_nhanvien on tbl_hoadontap.MaNV = tbl_nhanvien.MaNV where tbl_nhanvien.Ten=?";
    private static final String FIND_BY_SDT = "select MaHoaDonTap, Ngay, MaNV, tbl_hoadontap.MaKH, TongTien from tbl_hoadontap inner join tbl_khachhang on tbl_hoadontap.MaKH = tbl_khachhang.MaKH where tbl_khachhang.SDT=? ";
    private static final String FIND_BY_MAHD = "select MaHoaDonTap, Ngay, MaNV, MaKH, TongTien from tbl_hoadontap where MaHoaDonTap=?";
    private static final String FIND_BY_TEN = "select MaHoaDonTap, Ngay, MaNV, tbl_hoadontap.MaKH, TongTien from tbl_hoadontap inner join tbl_khachhang on tbl_hoadontap.MaKH = tbl_khachhang.MaKH where tbl_khachhang.Ten like concat('%',?,'%') ";
    private static final String INSERTBILL = "insert into tbl_hoadontap(MaHoaDonTap, Ngay, MaNV, MaKH, TongTien) values(?, ?, ?, ?, ?)";
    private static final String INSERTDETALS = "insert into tbl_cthdtap(MaHoaDonTap, MaDV) values(?, ?)";
    private static final String GETDETAILS = "select MaDV, tbl_dichvu.Ten, tbl_dichvu.Gia, tbl_dichvu.ThoiGian from tbl_cthdtap inner join tbl_dichvu on tbl_cthdtap.MaDV = tbl_dichvu.MaDV where tbl_cthdtap.MaHaoDonTap=?";
    private static final String RPDATEDIFF = "select * from tblHoaDonTap where Ngay between ? and ?";
    private static final String FIND ="select tbl_hoadontap.MaHoaDonTap, tbl_hoadontap.Ngay, tbl_hoadontap.MaNV, tbl_hoadontap.MaKH, tbl_hoadontap.TongTien from tbl_hoadontap inner join tbl_khachhang on tbl_hoadontap.MaKH = tbl_khachhang.MaKH inner join tbl_nhanvien on tbl_hoadontap.MaNV = tbl_nhanvien.MaNV where tbl_khachhang.Ten like concat('%',?,'%') or tbl_hoadontap.MaHoaDonTap=? or tbl_khachhang.SDT=? or tbl_nhanvien.Ten=?";
    
    @Override
    public List<BillTraining> getAll() {
        List<BillTraining> data = new ArrayList<BillTraining>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillTraining cs = new BillTraining();
                cs.setMaHoaDonTap(rs.getString("MaHoaDonTap"));
                cs.setNgay(rs.getString("Ngay"));
                cs.setMaKH(rs.getString("MaKH"));
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

    @Override
    public boolean insert(BillTraining input) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            //MaHoaDonHang, Ngay, TenKH, SDT, MaNV, TongTien
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(INSERTBILL);
            stmt.setString(1, input.getMaHoaDonTap());
            stmt.setString(2, input.getNgay());
            stmt.setString(3, input.getMaNV());
            stmt.setString(4, input.getMaKH());
            stmt.setInt(5, input.getTongTien());
            stmt.execute();
            stmt = conn.prepareStatement(INSERTDETALS);
            for (BillTraning_Details dt : input.getDetails()){
                stmt.setString(1, dt.getMaHoaDonTap());
                stmt.setString(2, dt.getMaDV());
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
    // do nothing
    public boolean update(BillTraining input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String ID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(DELETEDETAILS);
            stmt.setString(1, ID);
            stmt.execute();
            stmt = conn.prepareStatement(DELETEBILL);
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
    public List<BillTraining> findByIDNV(String ID) {
        List<BillTraining> data = new ArrayList<BillTraining>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_IDNV);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillTraining cs = new BillTraining();
                cs.setMaHoaDonTap(rs.getString("MaHoaDonTap"));
                cs.setNgay(rs.getString("Ngay"));
                cs.setMaKH(rs.getString("MaKH"));
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

    @Override
    public List<BillTraining> findByTenKhach(String Name) {
        List<BillTraining> data = new ArrayList<BillTraining>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_TEN);
            stmt.setString(1, Name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillTraining cs = new BillTraining();
                cs.setMaHoaDonTap(rs.getString("MaHoaDonTap"));
                cs.setNgay(rs.getString("Ngay"));
                cs.setMaKH(rs.getString("MaKH"));
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

    @Override
    public BillTraining findByMaHD(String MaHD) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_MAHD);
            stmt.setString(1, MaHD);
            ResultSet rs = stmt.executeQuery();
            BillTraining cs = new BillTraining();
            while (rs.next()){
                cs.setMaHoaDonTap(rs.getString("MaHoaDonTap"));
                cs.setNgay(rs.getString("Ngay"));
                cs.setMaKH(rs.getString("MaKH"));
                cs.setMaNV(rs.getString("MaNV"));
                cs.setTongTien(rs.getInt("TongTien"));
            }
            return cs;
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
    public List<BillTraining> findBySDT(String SDT) {
        List<BillTraining> data = new ArrayList<BillTraining>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_SDT);
            stmt.setString(1, SDT);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillTraining cs = new BillTraining();
                cs.setMaHoaDonTap(rs.getString("MaHoaDonTap"));
                cs.setNgay(rs.getString("Ngay"));
                cs.setMaKH(rs.getString("MaKH"));
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

    @Override
    public List<BillTraning_Details> getDetails(String MaHD) {
        List<BillTraning_Details> data = new ArrayList<BillTraning_Details>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(GETDETAILS);
            stmt.setString(1, MaHD);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillTraning_Details cs = new BillTraning_Details();
                cs.setMaHoaDonTap(MaHD);
                cs.setMaDV(rs.getString("MaDV"));
                cs.setTen(rs.getString("Ten"));
                cs.setGia(rs.getInt("Gia"));
                cs.setThoiGian(rs.getInt("ThoiGian"));
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
    
    public List<BillTraining> reportDateDiff(String date1, String date2) {
        List<BillTraining> data = new ArrayList<BillTraining>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(RPDATEDIFF);
            stmt.setString(1, date1);
            stmt.setString(2, DateTime.plusDate(date2,1));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillTraining cs = new BillTraining();
                cs.setMaHoaDonTap(rs.getString("MaHoaDonTap"));
                cs.setNgay(rs.getString("Ngay"));
                cs.setMaKH(rs.getString("MaKH"));
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
    
    public List<BillTraining> findByString(String input) {
        List<BillTraining> data = new ArrayList<BillTraining>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND);
            stmt.setString(1, input);
            stmt.setString(2, input);
            stmt.setString(3, input);
            stmt.setString(4, input);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                BillTraining cs = new BillTraining();
                cs.setMaHoaDonTap(rs.getString("MaHoaDonTap"));
                cs.setNgay(rs.getString("Ngay"));
                cs.setMaKH(rs.getString("MaKH"));
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
