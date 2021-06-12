/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.utilities;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;
/**
 *
 * @author luyen
 */
public class LogFile {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static final int HOADONTAP = 1;
    public static final int HOADONHANG = 2;
    public static final int NHANVIEN = 3;
    public static final int THE = 4;
    public static final int KHACHHANG = 5;
    public static final int SANPHAM = 6;
    public static final int DICHVU = 7;
    
    
    
    public static void createDeleteLog (String ID, String Name, String DeID, String Reason, int Mode){
        // mode 1 for training 
        // mode 2 for goods
        String Infor = "";
        switch (Mode) {
            case 1 :
                Infor = ID + " " + Name + " Đã xóa hóa đơn tập cõ mã : " + DeID + " Lý do " + Reason;
                break;
            case 2 :
                Infor = ID + " " + Name + " Đã xóa hóa đơn hàng cõ mã : " + DeID + " Lý do " + Reason;
                break;
            case 3 :
                Infor = ID + " " + Name + " Đã xóa nhân viên cõ mã : " + DeID + " Lý do " + Reason;
                break;
            case 4 :
                Infor = ID + " " + Name + " Đã xóa thẻ cõ mã : " + DeID + " Lý do " + Reason;
                break;
            case 5 :
                Infor = ID + " " + Name + " Đã xóa khách hàng cõ mã : " + DeID + " Lý do " + Reason;
                break;
            case 6 :
                Infor = ID + " " + Name + " Đã xóa sản phẩm cõ mã : " + DeID + " Lý do " + Reason;
                break;
            case 7 :
                Infor = ID + " " + Name + " Đã xóa dịch vụ cõ mã : " + DeID + " Lý do " + Reason;
                break;
            default :
                return;
        }
        String FileName = "DeleteLog_" + DateTime.getTimeFormat2() + ".log";
        try {
            FileHandler fh = new  FileHandler(FileName, true);
            fh.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fh);
            LOGGER.info(Infor);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void createLoginLog (String ID, String Name){
        String Infor = ID + " " + Name + " Đẵ đăng nhập";
        String FileName = "LoginLog_" + DateTime.getTimeFormat2() + ".log";
        try {
            FileHandler fh = new  FileHandler(FileName, true);
            fh.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fh);
            LOGGER.info(Infor);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
