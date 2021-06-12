/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;
import gymer.entities.*;
import java.util.*;
/**
 *
 * @author luyen
 */
public interface GoodsDAO {
    public Goods findByID(String ID);
    public List<Goods> findByName(String Name);
}
