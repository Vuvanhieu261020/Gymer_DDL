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
public interface BillGoodsDAO {
    public List<BillGoods> findByIDNV (String ID);
    public List<BillGoods> findByTenKhach (String Name);
    public BillGoods findByMaHD (String MaHD);
    public List<BillGoods> findBySDT (String SDT);
    public List<BillGoods_Details> getDetails (String MaHD);
}
