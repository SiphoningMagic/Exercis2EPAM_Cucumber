package javaUtility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    public ExcelReader() throws IOException {
        FileInputStream file= new FileInputStream("C:\\TestNGProject\\TestNGFramework\\EPAMCucumberWithSelenium\\src\\main\\java\\resources\\RegData.xlsx");
        workbook= new XSSFWorkbook(file);
    }

    public String getData(int sheetNumber, int row, int col){
        sheet=workbook.getSheetAt(sheetNumber);
        XSSFCell cell = sheet.getRow(row).getCell(col);
        System.out.println(cell);
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }

    public double getNumbericData(int sheetNumber, int row, int col){
        sheet=workbook.getSheetAt(sheetNumber);
        XSSFCell cell = sheet.getRow(row).getCell(col);
        System.out.println(cell);
        return sheet.getRow(row).getCell(col).getNumericCellValue();
    }

}
