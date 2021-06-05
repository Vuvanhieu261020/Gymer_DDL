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
    public List<Equipment> findByName(String Name);
    public List<Equipment> getBrokenList();
    public List<Equipment> getAvailableList();
    public List<Equipment> reportbyDate(String Date);
    public List<Equipment> reportbyDateDiff(String startDate, String endDate);
}
