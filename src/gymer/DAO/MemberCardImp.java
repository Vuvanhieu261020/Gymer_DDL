/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;
import gymer.DAO.MemberCardDAO;
import gymer.entities.MemberCard;
import java.util.List;
import java.sql.*;
import gymer.database.DButil;
import java.util.ArrayList;
import gymer.entities.MemberCar_Detail;
/**
 *
 * @author luyen
 */
public class MemberCardImp implements MemberCardDAO{
    

    
    // khoi tao cac cau lenh SQL phuc vu cho cac ham tuong ung
    
    
    private static final String DELETE = "delete from tbl_The where MaThe=?";
    private static final String FIND_BY_MAKH = "select * from tbl_The where MaKH=?";
    private static final String FIND_ALL = "select * from tbl_The";
    private static final String FIND_BY_ID = "select * from tbl_The where MaThe=?";
    private static final String FIND_BY_NAME = "select * from tbl_the inner join tbl_khachhang on tbl_the.MaKH = tbl_khachhang.MaKH where tbl_khachhang.Ten like concat('%',?,'%')";
    private static final String INSERT = "insert into tbl_the(MaThe, MaKH, TrangThai, NgayBD, MaDV) values(?, ?, ?, ?, ?)";
    private static final String INSERTDT = "insert into tbl_ctthe(MaThe, ThoiDiemSuDung) values(?, ?)";
    private static final String UPDATE = "update tbl_the set MaKH=?, TrangThai=?, NgayBD=?, MaDV=? where MaThe=?";
    private static final String CHECK_VALID = "select TrangThai from tbl_the where MaThe=?";
    private static final String GET_DETAIL = "select ThoiDiemSuDung from tbl_ctthe where MaThe=? order by ThoiDiemSuDung desc";
    private static final String FIND = "select * from tbl_the inner join tbl_khachhang on tbl_the.MaKH = tbl_khachhang.MaKH where tbl_khachhang.Ten like concat('%',?,'%') or tbl_khachhang.SDT=? or tbl_khachhang.MaKH=? or tbl_the.MaThe=?";
    
    
    public MemberCard fetchByKH (String MaKH) {
        PreparedStatement stmt = null;
        Connection conn = null;
        MemberCard mb = new MemberCard();
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_MAKH);
            stmt.setString(1, MaKH);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                mb.setID(rs.getString("MaThe"));
                mb.setMaDV(rs.getString("MaDV"));
                mb.setMaKH(rs.getString("MaKH"));
                mb.setStartDate(rs.getString("NgayBD"));
                mb.setStatus(rs.getBoolean("TrangThai"));
            }
            return mb;
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
    public List<MemberCard> getAll() {
        
        // khoi tao list cac thuc the se luu
        List<MemberCard> data = new ArrayList<MemberCard>();
        // khoi tao doi tuong cau lenh
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                MemberCard mb = new MemberCard();
                mb.setID(rs.getString("MaThe"));
                mb.setMaDV(rs.getString("MaDV"));
                mb.setMaKH(rs.getString("MaKH"));
                mb.setStartDate(rs.getString("NgayBD"));
                mb.setStatus(rs.getBoolean("TrangThai"));
                data.add(mb);
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
    public boolean insert(MemberCard Input) {
        PreparedStatement stmt = null;
        Connection conn = null;
        boolean result = false;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, Input.getCardID());
            stmt.setString(2, Input.getMaKH());
            stmt.setBoolean(3, Input.getStatus());
            stmt.setString(4, Input.getStartDate());
            stmt.setString(5, Input.getMaDV());
            result = stmt.execute();
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
    public boolean update(MemberCard Input) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(5, Input.getCardID());
            stmt.setString(1, Input.getMaKH());
            stmt.setBoolean(2, Input.getStatus());
            stmt.setString(3, Input.getStartDate());
            stmt.setString(4, Input.getMaDV());
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
    public MemberCard findByID(String ID) {
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            MemberCard mb = new MemberCard();
            while (rs.next()){
                mb.setID(rs.getString("MaThe"));
                mb.setMaDV(rs.getString("MaDV"));
                mb.setMaKH(rs.getString("MaKH"));
                mb.setStartDate(rs.getString("NgayBD"));
                mb.setStatus(rs.getBoolean("TrangThai"));
            }
            return mb;
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
    public List<MemberCard> findByName(String Name) {
        List<MemberCard> data = new ArrayList<MemberCard>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_BY_NAME);
            stmt.setString(1, Name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                MemberCard mb = new MemberCard();
                mb.setID(rs.getString("MaThe"));
                mb.setMaDV(rs.getString("MaDV"));
                mb.setMaKH(rs.getString("MaKH"));
                mb.setStartDate(rs.getString("NgayBD"));
                mb.setStatus(rs.getBoolean("TrangThai"));
                data.add(mb);
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
    public boolean checkValid(String ID, String Time) {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        boolean checker = false;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(CHECK_VALID);
            stmt.setString(1,ID);
            rs = stmt.executeQuery();
            while(rs.next()){
                if (rs.getBoolean("TrangThai")){
                    try {
                        conn = DButil.getConnection();
                        stmt = conn.prepareStatement(INSERTDT);
                        stmt.setString(1, ID);
                        stmt.setString(2, Time);
                        stmt.execute();
                        checker = true;
                    }
                    catch (Exception e){
                        e.printStackTrace();
                        return false;
                    }
                }
            }
            if (checker){
                return true;
            }
            else {
                return false;
            }
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
    public MemberCard getDetails(MemberCard Input) {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<MemberCar_Detail> data = new ArrayList<MemberCar_Detail>();
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(GET_DETAIL);
            stmt.setString(1, Input.getCardID());
            rs = stmt.executeQuery();
            while (rs.next()){
                MemberCar_Detail mbd = new MemberCar_Detail(Input.getCardID());
                mbd.setTime(rs.getString("ThoiDiemSuDung"));
                data.add(mbd);
            }
            Input.setDetail(data);
            return Input;
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
    
    public List<MemberCard> findByString(String Name) {
        List<MemberCard> data = new ArrayList<MemberCard>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND);
            stmt.setString(1, Name);
            stmt.setString(2, Name);
            stmt.setString(3, Name);
            stmt.setString(4, Name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                MemberCard mb = new MemberCard();
                mb.setID(rs.getString("MaThe"));
                mb.setMaDV(rs.getString("MaDV"));
                mb.setMaKH(rs.getString("MaKH"));
                mb.setStartDate(rs.getString("NgayBD"));
                mb.setStatus(rs.getBoolean("TrangThai"));
                data.add(mb);
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
