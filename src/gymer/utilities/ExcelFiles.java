/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.utilities;
import gymer.entities.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author luyen
 */
public class ExcelFiles {
    public static void createRPBillGoods(List<RPDetails> data, String path){
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Bao Cao");
            sheet.setColumnWidth(0, 6000);
            sheet.setColumnWidth(1, 6000);
            sheet.setColumnWidth(2, 6000);
            sheet.setColumnWidth(3, 6000);
            sheet.setColumnWidth(4, 6000);
            sheet.setColumnWidth(5, 6000);
            sheet.setColumnWidth(6, 6000);
            Row headerRow = sheet.createRow(0);
            CellStyle header = workbook.createCellStyle();
            header.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Calibri");
            font.setFontHeightInPoints((short) 14);
            font.setBold(true);
            header.setFont(font);
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Mã hóa đơn");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Ngày Lập");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Tên khách hàng");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("SDT khách hàng");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Nhân viên lập");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Mã nhân viên");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Tổng tiền");
            headerCell.setCellStyle(header);
            
            int rowNo = 1;
            int sum = 0;
            
            for (RPDetails bg : data){
                Row row = sheet.createRow(rowNo);
                Cell detailCell = row.createCell(0);
                detailCell.setCellValue(bg.getMaHD());
                detailCell = row.createCell(1);
                detailCell.setCellValue(bg.getNgayLap());
                detailCell = row.createCell(2);
                detailCell.setCellValue(bg.getTenKhach());
                detailCell = row.createCell(3);
                detailCell.setCellValue(bg.getSDTKhach());
                detailCell = row.createCell(4);
                detailCell.setCellValue(bg.getTenNV());
                detailCell = row.createCell(5);
                detailCell.setCellValue(bg.getMaNV());
                detailCell = row.createCell(6);
                detailCell.setCellValue(bg.getTongTien());
                sum += bg.getTongTien();
                rowNo++;
            }
            
            Row lastRow = sheet.createRow(rowNo + 2);
            Cell total = lastRow.createCell(5);
            total.setCellStyle(header);
            total.setCellValue("Tổng cộng");
            total = lastRow.createCell(6);
            total.setCellStyle(header);
            total.setCellValue(sum);
            
            
            FileOutputStream outputStream = new FileOutputStream(path + "BaoCaoHoaDonHang_TaoNgay_" + DateTime.getTimeFormat2()+".xlsx");
            workbook.write(outputStream);
            workbook.close();
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void createRPBillTraining(List<RPDetails> data, String path){
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Bao Cao");
            sheet.setColumnWidth(0, 6000);
            sheet.setColumnWidth(1, 6000);
            sheet.setColumnWidth(2, 6000);
            sheet.setColumnWidth(3, 6000);
            sheet.setColumnWidth(4, 6000);
            sheet.setColumnWidth(5, 6000);
            sheet.setColumnWidth(6, 6000);
            sheet.setColumnWidth(7, 6000);
            Row headerRow = sheet.createRow(0);
            CellStyle header = workbook.createCellStyle();
            header.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Calibri");
            font.setFontHeightInPoints((short) 14);
            font.setBold(true);
            header.setFont(font);
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Mã hóa đơn");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Ngày Lập");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Dịch vụ");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("Tên khách hàng");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("SDT khách hàng");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Nhân viên lập");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Mã nhân ");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(7);
            headerCell.setCellValue("Tổng tiền");
            headerCell.setCellStyle(header);
            
            int rowNo = 1;
            int sum = 0;
            
            for (RPDetails bg : data){
                Row row = sheet.createRow(rowNo);
                Cell detailCell = row.createCell(0);
                detailCell.setCellValue(bg.getMaHD());
                detailCell = row.createCell(1);
                detailCell.setCellValue(bg.getNgayLap());
                detailCell = row.createCell(2);
                detailCell.setCellValue(bg.getTenDV());
                detailCell = row.createCell(3);
                detailCell.setCellValue(bg.getTenKhach());
                detailCell = row.createCell(4);
                detailCell.setCellValue(bg.getSDTKhach());
                detailCell = row.createCell(5);
                detailCell.setCellValue(bg.getTenNV());
                detailCell = row.createCell(6);
                detailCell.setCellValue(bg.getMaNV());
                detailCell = row.createCell(7);
                detailCell.setCellValue(bg.getTongTien());
                sum += bg.getTongTien();
                rowNo++;
            }
            
            Row lastRow = sheet.createRow(rowNo + 2);
            Cell total = lastRow.createCell(6);
            total.setCellStyle(header);
            total.setCellValue("Tổng cộng");
            total = lastRow.createCell(7);
            total.setCellStyle(header);
            total.setCellValue(sum);
            
            
            FileOutputStream outputStream = new FileOutputStream(path + "BaoCaoHoaDonTap_TaoNgay_" + DateTime.getTimeFormat2()+".xlsx");
            workbook.write(outputStream);
            workbook.close();
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void createRPStaff(List<Employee> data, String path){
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Bao Cao");
            sheet.setColumnWidth(0, 6000);
            sheet.setColumnWidth(1, 6000);
            sheet.setColumnWidth(2, 6000);
            sheet.setColumnWidth(3, 6000);
            sheet.setColumnWidth(4, 6000);
            sheet.setColumnWidth(5, 6000);
            sheet.setColumnWidth(6, 6000);
            sheet.setColumnWidth(7, 6000);
            Row headerRow = sheet.createRow(0);
            CellStyle header = workbook.createCellStyle();
            header.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Calibri");
            font.setFontHeightInPoints((short) 14);
            font.setBold(true);
            header.setFont(font);
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Mã nhân viên");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Tên");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("CMND");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("Địa chỉ");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Vị Trí");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Năm Sinh");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Giới tính");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(7);
            headerCell.setCellValue("SĐT");
            headerCell.setCellStyle(header);
            
            int rowNo = 1;
            int sum = 0;
            
            for (Employee bg : data){
                Row row = sheet.createRow(rowNo);
                Cell detailCell = row.createCell(0);
                detailCell.setCellValue(bg.getMaNV());
                detailCell = row.createCell(1);
                detailCell.setCellValue(bg.getTen());
                detailCell = row.createCell(2);
                detailCell.setCellValue(bg.getCMND());
                detailCell = row.createCell(3);
                detailCell.setCellValue(bg.getAddress());
                detailCell = row.createCell(4);
                detailCell.setCellValue(bg.getViTri());
                detailCell = row.createCell(5);
                detailCell.setCellValue(bg.getYearofBirh());
                detailCell = row.createCell(6);
                if (bg.getSex()){
                    detailCell.setCellValue("Nữ");
                }
                else detailCell.setCellValue("Nam");
                detailCell = row.createCell(7);
                detailCell.setCellValue(bg.getSDT());
                rowNo++;
            }
            
            Row lastRow = sheet.createRow(rowNo + 2);
            Cell total = lastRow.createCell(6);
            total.setCellStyle(header);
            total.setCellValue("Tổng cộng");
            total = lastRow.createCell(7);
            total.setCellStyle(header);
            total.setCellValue(rowNo-1);
            
            
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void createRPCustomer(List<Customer> data, String path){
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Bao Cao");
            sheet.setColumnWidth(0, 6000);
            sheet.setColumnWidth(1, 6000);
            sheet.setColumnWidth(2, 6000);
            sheet.setColumnWidth(3, 6000);
            sheet.setColumnWidth(4, 6000);
            sheet.setColumnWidth(5, 6000);
            sheet.setColumnWidth(6, 6000);
            Row headerRow = sheet.createRow(0);
            CellStyle header = workbook.createCellStyle();
            header.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Calibri");
            font.setFontHeightInPoints((short) 14);
            font.setBold(true);
            header.setFont(font);
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Mã");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Tên khách hàng");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("CMND");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("SDT");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Địa chỉ");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Năm Sinh");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Giới tính");
            headerCell.setCellStyle(header);

            
            int rowNo = 1;
            int sum = 0;
            
            for (Customer bg : data){
                Row row = sheet.createRow(rowNo);
                Cell detailCell = row.createCell(0);
                detailCell.setCellValue(bg.getID());
                detailCell = row.createCell(1);
                detailCell.setCellValue(bg.getName());
                detailCell = row.createCell(2);
                detailCell.setCellValue(bg.getCMND());
                detailCell = row.createCell(3);
                detailCell.setCellValue(bg.getSDT());
                detailCell = row.createCell(4);
                detailCell.setCellValue(bg.getAddress());
                detailCell = row.createCell(5);
                detailCell.setCellValue(bg.getYearofBirh());
                detailCell = row.createCell(6);
                if (bg.getSex()){
                    detailCell.setCellValue("Nữ");
                }
                else detailCell.setCellValue("Nam");
                rowNo++;
            }
            
            Row lastRow = sheet.createRow(rowNo + 2);
            Cell total = lastRow.createCell(5);
            total.setCellStyle(header);
            total.setCellValue("Tổng cộng");
            total = lastRow.createCell(6);
            total.setCellStyle(header);
            total.setCellValue(rowNo-1);
            
            
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void createRPServices(List<RPDetails> data, String path){
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Bao Cao");
            sheet.setColumnWidth(0, 6000);
            sheet.setColumnWidth(1, 6000);
            sheet.setColumnWidth(2, 6000);
            Row headerRow = sheet.createRow(0);
            CellStyle header = workbook.createCellStyle();
            header.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Calibri");
            font.setFontHeightInPoints((short) 14);
            font.setBold(true);
            header.setFont(font);
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Tên gói tập");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Số lượng đã bán");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Tổng tiền");
            headerCell.setCellStyle(header);            
            
            int rowNo = 1;
            int sum = 0;
            
            for (RPDetails bg : data){
                Row row = sheet.createRow(rowNo);
                Cell detailCell = row.createCell(0);
                detailCell.setCellValue(bg.getTenDV());
                detailCell = row.createCell(1);
                detailCell.setCellValue(bg.getSoLuongDichVu());
                detailCell = row.createCell(2);
                detailCell.setCellValue(bg.getTongTien());
                sum += bg.getTongTien();
                rowNo++;
            }
            
            Row lastRow = sheet.createRow(rowNo + 2);
            Cell total = lastRow.createCell(1);
            total.setCellStyle(header);
            total.setCellValue("Tổng cộng");
            total = lastRow.createCell(2);
            total.setCellStyle(header);
            total.setCellValue(sum);
            
            
            FileOutputStream outputStream = new FileOutputStream(path + "BaoCaoDoanhSoDichVu_TaoNgay_" + DateTime.getTimeFormat2()+".xlsx");
            workbook.write(outputStream);
            workbook.close();
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void createRPGoods(List<RPDetails> data, String path){
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Bao Cao");
            sheet.setColumnWidth(0, 6000);
            sheet.setColumnWidth(1, 6000);
            sheet.setColumnWidth(2, 6000);
            sheet.setColumnWidth(3, 6000);
            Row headerRow = sheet.createRow(0);
            CellStyle header = workbook.createCellStyle();
            header.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Calibri");
            font.setFontHeightInPoints((short) 14);
            font.setBold(true);
            header.setFont(font);
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue("Tên hàng hóa ");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Số lượng đã bán");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("Tồn kho");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("Tổng tiền");
            headerCell.setCellStyle(header);            
            
            int rowNo = 1;
            int sum = 0;
            
            for (RPDetails bg : data){
                Row row = sheet.createRow(rowNo);
                Cell detailCell = row.createCell(0);
                detailCell.setCellValue(bg.getTenDV());
                detailCell = row.createCell(1);
                detailCell.setCellValue(bg.getSoLuongDichVu());
                detailCell = row.createCell(2);
                detailCell.setCellValue(bg.getTonKho());
                detailCell = row.createCell(3);
                detailCell.setCellValue(bg.getTongTien());
                sum += bg.getTongTien();
                rowNo++;
            }
            
            Row lastRow = sheet.createRow(rowNo + 2);
            Cell total = lastRow.createCell(2);
            total.setCellStyle(header);
            total.setCellValue("Tổng cộng");
            total = lastRow.createCell(3);
            total.setCellStyle(header);
            total.setCellValue(sum);
            
            
            FileOutputStream outputStream = new FileOutputStream(path + "BaoCaoDoanhSoBanHang_TaoNgay_" + DateTime.getTimeFormat2()+".xlsx");
            workbook.write(outputStream);
            workbook.close();
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
