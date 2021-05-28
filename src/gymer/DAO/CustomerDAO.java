/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;

import gymer.entities.Customer;
import java.util.List;

/**
 *
 * @author luyen
 */
public interface CustomerDAO {
    public List<Customer> getAll();
    public boolean insert(Customer Input);
    public boolean delete(String ID);
    public boolean update(Customer Input);
    public List<Customer> findByName(String Name);
    public List<Customer> findBySDT(String SDT);
}
