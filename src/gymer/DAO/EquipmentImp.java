/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import gymer.utilities.*;
import gymer.DAO.EquimentDAO;
import gymer.database.DButil;
import gymer.entities.Customer;
import gymer.entities.Equipment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.jar.Attributes.Name;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author luyen
 */
public class EquipmentImp implements UCRD<Equipment>, EquimentDAO{  

    
    private static final String DELETE = "delete from tbl_thietbi where MaTBH=?";
    private static final String FIND_ALL = "select * from tbl_thietbi";
    private static final String FIND_BY_NAME = "select * from tbl_thietbi where Ten=? ";
    private static final String INSERT = "insert into tbl_thietbi(MaTB, Ten, NSX, SoLuong, TinhTrang, NgayNhap, Gia) values(?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "update tbl_thietbi set Ten=?, NSX=?, SoLuong=?, TinhTrang=?, NgayNhap=?, Gia where MaTB=?";
    private static final String BROKEN_LIST = "select * from tbl_thietbi where TinhTrang= 'Hỏng'";
    private static final String WORKING_LIST = "select * from tbl_thietbi where TinhTrang= 'Tốt'";
    private static final String FIND_BY_DATE = "select * from tbl_thietbi where NgayNhap=? ";
    private static final String FIND_BY_DATE_DIFF = "select * from tbl_thietbi where NgayNhap >= ? and NgayNhap <= ? ";

    @Override
    public List<Equipment> getAll() {
        List<Equipment> data = new ArrayList<Equipment>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Equipment cs = new Equipment();
                cs.setMaTB(rs.getString("MaTB"));
                cs.setTen(rs.getString("Ten"));
                cs.setNSX(rs.getString("NSX"));
                cs.setSoLuong(rs.getInt("SoLuong"));
                cs.setTinhTrang(rs.getString("TinhTrang"));
                cs.setNgayNhap(rs.getString("NgayNhap"));
                cs.setGiaNhap(rs.getInt("GiaNhap"));
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

    @Override
    public boolean insert(Equipment input) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, input.getMaTB());
            stmt.setString(2, input.getTen());
            stmt.setString(3, input.getNSX());
            stmt.setInt(4, input.getSoLuong());
            stmt.setString(5, input.getTinhTrang());
            stmt.setString(6, input.getNgayNhap());
            stmt.setInt(7, input.getGiaNhap());
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
    public boolean update(Equipment input) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(7, input.getMaTB());
            stmt.setString(1, input.getTen());
            stmt.setString(2, input.getNSX());
            stmt.setInt(3, input.getSoLuong());
            stmt.setString(4, input.getTinhTrang());
            stmt.setString(5, input.getNgayNhap());
            stmt.setInt(6, input.getGiaNhap());
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
    public boolean delete(String ID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(DELETE);
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
    public List<Equipment> findByName(String Name) {
        List<Equipment> data = new ArrayList<Equipment>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_NAME);
            stmt.setString(1, Name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Equipment cs = new Equipment();
                cs.setMaTB(rs.getString("MaTB"));
                cs.setTen(rs.getString("Ten"));
                cs.setNSX(rs.getString("NSX"));
                cs.setSoLuong(rs.getInt("SoLuong"));
                cs.setTinhTrang(rs.getString("TinhTrang"));
                cs.setNgayNhap(rs.getString("NgayNhap"));
                cs.setGiaNhap(rs.getInt("GiaNhap"));
                data.add(cs);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DButil.closeConn(conn);
            DButil.closeStm(stmt);
        }
    }

    @Override
    public List<Equipment> getBrokenList() {
        List<Equipment> data = new ArrayList<Equipment>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(BROKEN_LIST);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Equipment cs = new Equipment();
                cs.setMaTB(rs.getString("MaTB"));
                cs.setTen(rs.getString("Ten"));
                cs.setNSX(rs.getString("NSX"));
                cs.setSoLuong(rs.getInt("SoLuong"));
                cs.setTinhTrang(rs.getString("TinhTrang"));
                cs.setNgayNhap(rs.getString("NgayNhap"));
                cs.setGiaNhap(rs.getInt("GiaNhap"));
                data.add(cs);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DButil.closeConn(conn);
            DButil.closeStm(stmt);
        }
    }

    @Override
    public List<Equipment> getAvailableList() {
        List<Equipment> data = new ArrayList<Equipment>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(WORKING_LIST);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Equipment cs = new Equipment();
                cs.setMaTB(rs.getString("MaTB"));
                cs.setTen(rs.getString("Ten"));
                cs.setNSX(rs.getString("NSX"));
                cs.setSoLuong(rs.getInt("SoLuong"));
                cs.setTinhTrang(rs.getString("TinhTrang"));
                cs.setNgayNhap(rs.getString("NgayNhap"));
                cs.setGiaNhap(rs.getInt("GiaNhap"));
                data.add(cs);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DButil.closeConn(conn);
            DButil.closeStm(stmt);
        }
    }

    @Override
    public List<Equipment> reportbyDate(String Date) {
        List<Equipment> data = new ArrayList<Equipment>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_DATE);
            stmt.setString(1, Date);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Equipment cs = new Equipment();
                cs.setMaTB(rs.getString("MaTB"));
                cs.setTen(rs.getString("Ten"));
                cs.setNSX(rs.getString("NSX"));
                cs.setSoLuong(rs.getInt("SoLuong"));
                cs.setTinhTrang(rs.getString("TinhTrang"));
                cs.setNgayNhap(rs.getString("NgayNhap"));
                cs.setGiaNhap(rs.getInt("GiaNhap"));
                data.add(cs);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DButil.closeConn(conn);
            DButil.closeStm(stmt);
        }
    }

    @Override
    public List<Equipment> reportbyDateDiff(String startDate, String endDate) {
        List<Equipment> data = new ArrayList<Equipment>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_DATE_DIFF);
            stmt.setString(1, startDate);
            stmt.setString(2, DateTime.plusDate(endDate,1));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Equipment cs = new Equipment();
                cs.setMaTB(rs.getString("MaTB"));
                cs.setTen(rs.getString("Ten"));
                cs.setNSX(rs.getString("NSX"));
                cs.setSoLuong(rs.getInt("SoLuong"));
                cs.setTinhTrang(rs.getString("TinhTrang"));
                cs.setNgayNhap(rs.getString("NgayNhap"));
                cs.setGiaNhap(rs.getInt("GiaNhap"));
                data.add(cs);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DButil.closeConn(conn);
            DButil.closeStm(stmt);
        }
    }
}
