/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;
import gymer.DAO.MemberCardDAO;
import gymer.entities.MemberCard;
import gymer.database.MySqlConnect;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author luyen
 */
public class MemberCardImp implements MemberCardDAO{
    MySqlConnect conn = new MySqlConnect();

    @Override
    public List<MemberCard> getAll() {
        List<MemberCard> data = null;
        ResultSet rs = conn.SQLQuery("select * from tbl_The");
        try {
            while(rs.next()){
                MemberCard mb = new MemberCard();
                mb.setID(rs.getString("MaThe"));
                mb.setMaDV(rs.getString("MaDV"));
                mb.setMaKH(rs.getString("MaKH"));
                mb.setStartDate(rs.getString("NgayBD"));
                mb.setStatus(rs.getBoolean("TrangThai"));
                data.add(mb);
                return data;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberCardImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public boolean insert(MemberCard Input) {
        String SQL =  'insert into tbl_The (MaThe, MaKH, TrangThai, NgayBD, MaDV) values (' 
            + Input.getCardID() + ',' 
            + Input.getMaKH() + ','
            + Input.getStatus() + ','
            + Input.getStartDate() + ','
            + Input.getMaDV() + ')';
                    
                    
                    
    }

    @Override
    public boolean delete(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(MemberCard Input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MemberCard findByID(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MemberCard findByName(String Name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkValid(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
