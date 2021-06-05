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
    public List<Employee> findBySDT();
    public List<Employee> findByIDLogin();
    public Employee initfromDB (Employee ID);
    public int checkLogin (Employee input);
}
