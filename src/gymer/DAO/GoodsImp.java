package gymer.DAO;
import gymer.entities.*;
import java.util.List;
import gymer.database.*;
import gymer.utilities.*;
import java.util.ArrayList;
import java.sql.*;

public class GoodsImp implements UCRD<Goods> {

    private static final String DELETE = "delete from tbl_hanghoa where MaHang=?";
    private static final String FIND_ALL = "select * from tbl_hanghoa";
    private static final String FIND_BY_NAME = "select * from tbl_hanghoa where Ten=?";
    private static final String FIND_BY_ID = "select * from tbl_hanghoa where MaHang=?";
    private static final String INSERT = "insert into tbl_hanghoa (MaHang, Ten, Gia, SoLuong, DVT, HSD) values(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "update tbl_hanghoa set Ten=?, Gia=?, SoLuong=?, DVT=?, HSD=? where MaHang=?";


    public List<Goods> getAll(){
        List<Goods> data = new ArrayList<Goods>();
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Goods cs = new Goods();
                cs.setMaHang(rs.getString("MaHang"));
                cs.setTen(rs.getString("Ten"));
                cs.setGia(rs.getInt("Gia"));
                cs.setSoLuong(rs.getInt("SoLuong"));
                cs.setDVT(rs.getString("SVT"));
                cs.setHSD(rs.getString("HSD"));
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

    public boolean insert(Goods input){
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, input.getMaHang());
            stmt.setString(2, input.getTen());
            stmt.setInt(3, input.getSoLuong());
            stmt.setInt(4, input.getGia());
            stmt.setString(5, input.getDVT());
            stmt.setString(6, input.getHSD());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DButil.closeConn(conn);
            DButil.closeStm(stmt);
        }
    }

    public boolean update(Goods input){
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(6, input.getMaHang());
            stmt.setString(1, input.getTen());
            stmt.setInt(2, input.getSoLuong());
            stmt.setInt(3, input.getGia());
            stmt.setString(4, input.getDVT());
            stmt.setString(5, input.getHSD());
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DButil.closeConn(conn);
            DButil.closeStm(stmt);
        }
    }

    public boolean delete(String ID){
        PreparedStatement stmt = null;
        Connection conn = null;
        try {
            conn = DButil.getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setString(1, ID);
            stmt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DButil.closeConn(conn);
            DButil.closeStm(stmt);
        }
    }
}
