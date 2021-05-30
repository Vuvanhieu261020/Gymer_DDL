/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;

import gymer.entities.Equipment;
import java.util.List;

/**
 *
 * @author luyen
 */
public interface EquimentDAO {
    public List<Equipment> getAll();
    public boolean insert(Equipment Input);
    public boolean delete(String ID);
    public boolean update(Equipment Input);
    public List<Equipment> findByName(String Name);
    public List<Equipment> getBrokenList();
    public List<Equipment> getAvailableList();
    public List<Equipment> reportbyDate();
    public List<Equipment> reportbyDateDiff(String startDate, String endDate);
}
