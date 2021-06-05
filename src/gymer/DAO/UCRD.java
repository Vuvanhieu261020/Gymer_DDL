/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.DAO;
import java.util.List;
/**
 *
 * @author luyen
 */
public interface UCRD<T> {
    List<T> getAll();
    boolean insert (T input);
    boolean update (T input);
    boolean delete (String ID);
}
