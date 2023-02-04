package util;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2023-01-19 12:13
 * @LastEditTime: 2023-01-19 12:13
 */

public class testOutputExcel {
    //时间格式
    private static String getTime(){
        String pattern = "yyyy-MM-dd-HHmmss-SSS";
        SimpleDateFormat date = new SimpleDateFormat(pattern);
        return date.format(new Date());
    }
    private  static String PATH = "/Users/USER/Desktop/testworkspace/";
    private  static String PATH1 = "C:\\Users\\USER\\Desktop\\testworkspace\\";
    private  static String file ="openworkbook_%1$s.xlsx";
    private  static String PF = "C:\\Users\\USER\\Desktop\\testworkspace"+file;
    //TEST
    private  static String file1 ="openworkbook.xlsx";
    private  static String PF1 = "C:\\Users\\USER\\Desktop\\testworkspace"+file1;

    public static void main (String  args[]) throws IOException {
        //TEST
//      Runtime.getRuntime().exec("cmd /c start "+PF1);
        System.out.println("cmd /c start "+PF1);
        //路径
        File f = new File(PATH+"openworkbook.xlsx");
        System.out.println(f);

        //獲取 XLSX 文件的工作簿實例
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet opensheet = workbook.createSheet("Example-Sheet");
        //Create row object
        XSSFRow row;
        XSSFCell cell;
        Object[][] buffer = {
                { "Head First Java", "A", 90 },
                { "Effective Java", "B", 37 },
                { "Clean Code", "C", 42 },
                { "Thinking in Java", "D", 35 },
        };

        int rowIdx = -1;
        int colIdx = -1;
        CellRangeAddress cellAddr;
        int firstRow, lastRow, firstCol, lastCol;
        for (Object[] arrs : buffer) {
            // 建立行
            row = opensheet.createRow(++rowIdx);
            firstRow = lastRow = rowIdx;

            colIdx = -1;
            firstCol = (colIdx + 1);
            for (Object field : arrs) {
                // 建立單元格
                cell = row.createCell(++colIdx);

                // 單元格寫入內容
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
            lastCol = colIdx;

            // BorderStyle.THICK 粗邊框
            cellAddr = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
            RegionUtil.setBorderBottom(BorderStyle.THICK, cellAddr, opensheet);
            RegionUtil.setBorderTop(BorderStyle.THICK, cellAddr, opensheet);
        }
        file = String.format(file,getTime());
        PF = PATH1+file;
        try(FileOutputStream fileOutputStream = new FileOutputStream(PF);){
            workbook.write(fileOutputStream);
            System.out.println("cmd /c start "+PF+">>>>>>>>>>");
            Runtime.getRuntime().exec("cmd /c start "+PF);
        }catch (IOException e){
            e.printStackTrace();
        }


        if(f.exists() && f.isFile()){
            System.out.println("succesfully");
        }else{
            System.out.println("fail");
        }
    }

}
