/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;
import java.util.List;
import gymer.entities.Service;
import gymer.database.DButil;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author luyen
 */
public class ServiceImp implements UCRD<Service> {

    
    private static final String DELETE = "delete from tbl_dichvu where MaDV=?";
    private static final String FIND_ALL = "select * from tbl_dichvu";
    private static final String FIND_BY_NAME = "select * from tbl_dichvu where Ten=?";
    private static final String INSERT = "insert into tbl_dichvu (MaDV, Ten, ThoiGian, Gia) values(?, ?, ?, ?)";
    private static final String UPDATE = "update tbl_dichvu set Ten=?, ThoiGian=?, Gia=? where MaDV=?";
    
    
    
    @Override
    public List<Service> getAll() {
        List<Service> data = new ArrayList<Service>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Service cs = new Service();
                cs.setMaDV(rs.getString("MaDV"));
                cs.setTen(rs.getString("Ten"));
                cs.setThoiGian(rs.getInt("ThoiGian"));
                cs.setGia(rs.getInt("Gia"));
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
    public boolean insert(Service input) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, input.getMaDV());
            stmt.setString(2, input.getTen());
            stmt.setInt(3, input.getThoiGian());
            stmt.setInt(4, input.getGia());
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
    public boolean update(Service input) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(4, input.getMaDV());
            stmt.setString(1, input.getTen());
            stmt.setInt(2, input.getThoiGian());
            stmt.setInt(3, input.getGia());
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
    
}