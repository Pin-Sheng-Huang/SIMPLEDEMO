package util;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2023-01-18 20:41
 * @LastEditTime: 2023-01-18 20:41
 */

public class testReadExcel {
    public static void main (String[] args) throws Exception{
        FileInputStream input = null;
        String fileName = "C:\\Users\\USER\\Desktop\\testworkspace\\readexcel.xlsx";
        try {
            input = new FileInputStream(fileName);

            @SuppressWarnings("resource")
            XSSFWorkbook book = new XSSFWorkbook(input);

            XSSFSheet sheet = book.getSheetAt(0);
            XSSFRow row = sheet.getRow(0);

            XSSFCell cell = null;
            String title = "讀取單元格內容: ";
            for(int i = 0; i< 3; i++) {
                cell = row.getCell(i);

                if (cell.getCellType() == CellType.STRING) {
                    System.out.println(title + cell.getStringCellValue());
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    System.out.println(title + cell.getNumericCellValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
