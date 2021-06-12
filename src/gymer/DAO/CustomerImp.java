/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// Truong GioiTinh bi ghi nham thanh GioiTinh


package gymer.DAO;
import gymer.DAO.CustomerDAO;
import gymer.entities.Customer;
import java.util.List;
import java.sql.*;
import gymer.database.DButil;
import gymer.entities.MemberCard;
import java.util.ArrayList;

/**
 *
 * @author luyen
 */
public class CustomerImp implements CustomerDAO{
    
    private static final String DELETE = "delete from tbl_khachhang where MaKH=?";
    private static final String DELETECARD = "delete from tbl_The where MaKH=?";
    private static final String FIND_ALL = "select * from tbl_khachhang";
    private static final String FIND_BY_NAME = "select * from tbl_khachhang where Ten like concat('%',?,'%') ";
    private static final String FIND_BY_SDT = "select * from tbl_khachhang where SDT=?";
    private static final String INSERT = "insert into tbl_khachhang(MaKH, Ten, CMND, SDT, DiaChi, NamSinh, GioiTinh) values(?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "update tbl_khachhang set Ten=?, CMND=?, SDT=?, DiaChi=?, NamSinh=?, GioiTinh=? where MaKH=?";
    private static final String COUNT = "select count(*) as coo from tbl_khachhang";
    
    
    @Override
    public List<Customer> getAll() {
        List<Customer> data = new ArrayList<Customer>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Customer cs = new Customer();
                cs.setID(rs.getString("MaKH"));
                cs.setCMND(rs.getString("CMND"));
                cs.setName(rs.getString("Ten"));
                cs.setSDT(rs.getString("SDT"));
                cs.setAddress(rs.getString("DiaChi"));
                cs.setYearofBirh(rs.getInt("NamSinh"));
                cs.setSex(rs.getBoolean("GioiTinh"));
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
    public boolean insert(Customer Input) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, Input.getID());
            stmt.setString(2, Input.getName());
            stmt.setString(3, Input.getCMND());
            stmt.setString(4, Input.getSDT());
            stmt.setString(5, Input.getAddress());
            stmt.setInt(6, Input.getYearofBirh());
            stmt.setBoolean(7, Input.getSex());
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
            stmt = conn.prepareStatement(DELETECARD);
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
    public boolean update(Customer Input) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, Input.getName());
            stmt.setString(2, Input.getCMND());
            stmt.setString(3, Input.getSDT());
            stmt.setString(4, Input.getAddress());
            stmt.setInt(5, Input.getYearofBirh());
            stmt.setBoolean(6, Input.getSex());
            stmt.setString(7, Input.getID());
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
    public List<Customer> findByName(String Name) {
        List<Customer> data = new ArrayList<Customer>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_NAME);
            stmt.setString(1, Name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Customer cs = new Customer();
                cs.setID(rs.getString("MaKH"));
                cs.setCMND(rs.getString("CMND"));
                cs.setName(rs.getString("Ten"));
                cs.setSDT(rs.getString("SDT"));
                cs.setAddress(rs.getString("DiaChi"));
                cs.setSex(rs.getBoolean("GioiTinh"));
                cs.setYearofBirh(rs.getInt("NamSinh"));
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
    public List<Customer> findBySDT(String SDT) {
        List<Customer> data = new ArrayList<Customer>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
      
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_SDT);
            stmt.setString(1, SDT);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Customer cs = new Customer();
                cs.setID(rs.getString("MaKH"));
                cs.setCMND(rs.getString("CMND"));
                cs.setName(rs.getString("Ten"));
                cs.setSDT(rs.getString("SDT"));
                cs.setAddress(rs.getString("DiaChi"));
                cs.setSex(rs.getBoolean("GioiTinh"));
                cs.setYearofBirh(rs.getInt("NamSinh"));
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
