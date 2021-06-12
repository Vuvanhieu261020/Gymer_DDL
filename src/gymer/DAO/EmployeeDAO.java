/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;
import gymer.entities.Employee;
import java.util.List;
/**
 *
 * @author luyen
 */
public interface EmployeeDAO {
    public List<Employee> findByName(String Name);
    public Employee findByID(String ID);
    public List<Employee> findBySDT(String SDT);
    public Employee findByIDLogin(String ID);
    public Employee initfromDB (String ID, String Password);
    public boolean updatePass (Employee input, String currentPasword, String newPassword);
}
