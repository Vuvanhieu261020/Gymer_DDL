/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;
import java.util.List;
import gymer.entities.MemberCard;
/**
 *
 * @author luyen
 */
public interface MemberCardDAO {
    public List<MemberCard> getAll();
    public boolean insert(MemberCard Input);
    public boolean delete(String ID);
    public boolean update(MemberCard Input);
    public MemberCard findByID(String ID);
    public MemberCard findByName(String Name);
    public boolean checkValid (String ID);
}
