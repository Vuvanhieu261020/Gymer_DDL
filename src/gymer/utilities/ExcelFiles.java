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
            headerCell.setCellValue("M?? h??a ????n");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Ng??y L???p");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("T??n kh??ch h??ng");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("SDT kh??ch h??ng");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("Nh??n vi??n l???p");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("M?? nh??n vi??n");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("T???ng ti???n");
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
            total.setCellValue("T???ng c???ng");
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
            headerCell.setCellValue("M?? h??a ????n");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("Ng??y L???p");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("D???ch v???");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("T??n kh??ch h??ng");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("SDT kh??ch h??ng");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("Nh??n vi??n l???p");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("M?? nh??n ");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(7);
            headerCell.setCellValue("T???ng ti???n");
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
            total.setCellValue("T???ng c???ng");
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
            headerCell.setCellValue("M?? nh??n vi??n");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("T??n");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("CMND");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("?????a ch???");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("V??? Tr??");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("N??m Sinh");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Gi???i t??nh");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(7);
            headerCell.setCellValue("S??T");
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
                    detailCell.setCellValue("N???");
                }
                else detailCell.setCellValue("Nam");
                detailCell = row.createCell(7);
                detailCell.setCellValue(bg.getSDT());
                rowNo++;
            }
            
            Row lastRow = sheet.createRow(rowNo + 2);
            Cell total = lastRow.createCell(6);
            total.setCellStyle(header);
            total.setCellValue("T???ng c???ng");
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
            headerCell.setCellValue("M??");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("T??n kh??ch h??ng");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("CMND");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("SDT");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(4);
            headerCell.setCellValue("?????a ch???");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(5);
            headerCell.setCellValue("N??m Sinh");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(6);
            headerCell.setCellValue("Gi???i t??nh");
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
                    detailCell.setCellValue("N???");
                }
                else detailCell.setCellValue("Nam");
                rowNo++;
            }
            
            Row lastRow = sheet.createRow(rowNo + 2);
            Cell total = lastRow.createCell(5);
            total.setCellStyle(header);
            total.setCellValue("T???ng c???ng");
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
            headerCell.setCellValue("T??n g??i t???p");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("S??? l?????ng ???? b??n");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("T???ng ti???n");
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
            total.setCellValue("T???ng c???ng");
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
            headerCell.setCellValue("T??n h??ng h??a ");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(1);
            headerCell.setCellValue("S??? l?????ng ???? b??n");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(2);
            headerCell.setCellValue("T???n kho");
            headerCell.setCellStyle(header);
            
            headerCell = headerRow.createCell(3);
            headerCell.setCellValue("T???ng ti???n");
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
            total.setCellValue("T???ng c???ng");
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
