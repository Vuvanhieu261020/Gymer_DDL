package gymer.utilities;
import gymer.database.*;
import gymer.utilities.HashPassword;
public class PasswordCheck {
    public static boolean LoginInfoCheck (String ID, String PASS){
        String hashed = HashPassword.Hash(PASS);
        MySqlConnect MySQL = new MySqlConnect();
        String sqlQuery = "SELECT * FROM tbl_Login WHERE ID =" + ID + "AND hashed_code =" + hashed;
        if (MySQL.SQLQuery(sqlQuery) == null){
            return false;
        }
        return true;
    }
}
