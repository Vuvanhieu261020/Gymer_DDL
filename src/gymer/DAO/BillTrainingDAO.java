package gymer.DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import gymer.entities.*;
import java.util.*;
/**
 *
 * @author luyen
 */
public interface BillTrainingDAO {
    public List<BillTraining> findByIDNV (String ID);
    public List<BillTraining> findByTenKhach (String Name);
    public List<BillTraining> findByMaHD (String MaHD);
    public List<BillTraining> findBySDT (String SDT);
    public List<BillTraning_Details> getDetails (String MaHD);
}
