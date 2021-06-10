/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;
import gymer.entities.*;
import java.util.List;
import gymer.database.*;
import gymer.utilities.*;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author luyen
 */
public class EmployeeImp implements UCRD<Employee> , EmployeeDAO{


    private static final String DELETENV = "delete from tbl_nhanvien where MaNV=?";
    private static final String DELETELG = "delete from tbl_login where MaNV=?";
    private static final String FIND_ALL = "select * from tbl_nhanvien";
    private static final String FIND_BY_NAME = "select * from tbl_nhanvien where Ten=? ";
    private static final String FIND_BY_SDT = "select * from tbl_nhanvien where SDT=? ";
    private static final String FIND_BY_ID_LOGIN = "select tbl_nhanvien.MaNV, tbl_nhanvien.Ten, tbl_nhanvien.CMND, tbl_nhanvien.SDT, tbl_nhanvien.ViTri, tbl_nhanvien.DiaChi, tbl_nhanvien.NamSinh, tbl_nhanvien.GioiTinh from tbl_nhanvien inner join tbl_login on tbl_nhanvien.MaNV = tbl_login.MaNV where tbl_login.TK=? ";
    private static final String INSERTNV = "insert into tbl_nhanvien(MaNV, Ten, CMND, SDT, ViTri, DiaChi, NamSinh, GioiTinh) values(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String INSERTLG = "insert into tbl_login(MaNV, TK, hashed_code) values(?, ?, ?)";
    private static final String UPDATEPASSWORD = "update tbl_login set hashed_code=? where TK=?";
    private static final String UPDATE = "update tbl_nhanvien set SDT=?, ViTri=?, DiaChi=? where MaNV=?";
    private static final String INIT = "select * from tbl_nhanvien inner join tbl_login on tbl_nhanvien.MaNV = tbl_login.MaNV where tbl_login.TK=? and tbl_login.hashed_code=?";

    
    @Override
    public List<Employee> getAll() {
        List<Employee> data = new ArrayList<Employee>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Employee cs = new Employee();
                cs.setMaNV(rs.getString("MaNV"));
                cs.setTen(rs.getString("Ten"));
                cs.setCMND(rs.getString("CMND"));
                cs.setSDT(rs.getString("SDT"));
                cs.setViTri(rs.getString("ViTri"));
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

    public boolean insert(Employee input, String ID, String Passcode) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String HASHED = HashPassword.Hash(Passcode);
        String MNV = input.getMaNV();
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(INSERTNV);
            stmt.setString(1, MNV);
            stmt.setString(2, input.getTen());
            stmt.setString(3, input.getCMND());
            stmt.setString(4, input.getSDT());
            stmt.setString(5, input.getViTri());
            stmt.setString(6, input.getAddress());
            stmt.setInt(7, input.getYearofBirh());
            stmt.setBoolean(8, input.getSex());
            stmt.execute();
            stmt = conn.prepareStatement(INSERTLG);
            stmt.setString(1,MNV);
            stmt.setString(2,ID);
            stmt.setString(3,HASHED);
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
    public boolean update(Employee input) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, input.getSDT());
            stmt.setString(2, input.getAddress());
            stmt.setString(3, input.getViTri());
            stmt.setString(4, input.getMaNV());
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
            stmt = conn.prepareStatement(DELETELG);
            stmt.setString(1, ID);
            stmt.execute();
            stmt = conn.prepareStatement(DELETENV);
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
    public List<Employee> findByName(String Name) {
        List<Employee> data = new ArrayList<Employee>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_NAME);
            stmt.setString(1, Name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Employee cs = new Employee();
                cs.setMaNV(rs.getString("MaNV"));
                cs.setTen(rs.getString("Ten"));
                cs.setCMND(rs.getString("CMND"));
                cs.setSDT(rs.getString("SDT"));
                cs.setViTri(rs.getString("ViTri"));
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
    public List<Employee> findBySDT(String SDT) {
        List<Employee> data = new ArrayList<Employee>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_SDT);
            stmt.setString(1, SDT);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Employee cs = new Employee();
                cs.setMaNV(rs.getString("MaNV"));
                cs.setTen(rs.getString("Ten"));
                cs.setCMND(rs.getString("CMND"));
                cs.setSDT(rs.getString("SDT"));
                cs.setViTri(rs.getString("ViTri"));
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
    public List<Employee> findByIDLogin(String ID) {
        List<Employee> data = new ArrayList<Employee>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID_LOGIN);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Employee cs = new Employee();
                cs.setMaNV(rs.getString("MaNV"));
                cs.setTen(rs.getString("Ten"));
                cs.setCMND(rs.getString("CMND"));
                cs.setSDT(rs.getString("SDT"));
                cs.setViTri(rs.getString("ViTri"));
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
    
    // Hàm này để khởi tạo đối tượng login nhằm lưu trữ tên, passoword đã hashed, vị trí, bao gom login
    @Override
    public Employee initfromDB(String ID, String Password) {
        Employee Result = new Employee();
        String hashed =  HashPassword.Hash(Password);
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(INIT);
            stmt.setString(1, ID);
            stmt.setString(2, hashed);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Result.setMaNV(rs.getString("MaNV"));
                Result.setTen(rs.getString("Ten"));
                Result.setCMND(rs.getString("CMND"));
                Result.setViTri(rs.getString("ViTri"));
                Result.setAddress(rs.getString("DiaChi"));
                Result.setYearofBirh(rs.getInt("NamSinh"));
                Result.setSex(rs.getBoolean("GioiTinh"));
                Result.setIdLogin(rs.getString("TK"));
                Result.setHspass(rs.getString("hashed_code"));
                Result.setSDT(rs.getString("SDT"));
            }
            return Result;
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
    // Do nothing
    public boolean insert(Employee input) {
        return false;
    }

    @Override
    public boolean updatePass(Employee input, String currentPasword, String newPassword) {
        PreparedStatement stmt = null;
        Connection conn = null;
        String prevHash = input.getHspass();
        String newHash = HashPassword.Hash(newPassword);
        
        if (!prevHash.equals(currentPasword)){
            return false;
        }
        else 
        {
            try {
                conn = DButil.getConnection();
                stmt = conn.prepareStatement(UPDATEPASSWORD);
                stmt.setString(1, newHash);
                stmt.setString(2, input.getIdLogin());
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
    }
}
