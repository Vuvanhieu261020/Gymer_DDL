/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.software;
import gymer.software.LoginForm;
import gymer.software.MainForm;
/**
 *
 * @author luyen
 */
public class MainClass {
    public static void main(String[] args){
        LoginForm lgf = new LoginForm();
        lgf.show();
        MainForm mf = new MainForm();
        mf.show();
    }
}
