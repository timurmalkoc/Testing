package importExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class DataDriven{

    @Test
    public void getValue() throws IOException {

        String[][] excelData= getExcelData("resources/ExcelDoc/testcase.xlsx",0);
        System.out.println(Arrays.deepToString(excelData));
    }

    public String[][] getExcelData(String path, int workSheetIndex) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(path));
        XSSFSheet sheet = workbook.getSheetAt(workSheetIndex);
        Row row = sheet.getRow(sheet.getFirstRowNum());
        int nColumn = row.getLastCellNum()-row.getFirstCellNum();
        int nRow = sheet.getLastRowNum()-sheet.getFirstRowNum();
        String[][] data = new String[nRow+1][nColumn];

        for (int i = sheet.getFirstRowNum(); i<=sheet.getLastRowNum(); i++){
            row = sheet.getRow(i);
            String value;
            for (int j = row.getFirstCellNum(); j<row.getLastCellNum();j++){
                switch(row.getCell(j).getCellType()){
                    case STRING:
                        value = row.getCell(j).getStringCellValue(); 
                        break;
                    case NUMERIC:
                        value = String.valueOf(row.getCell(j).getNumericCellValue());
                    break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + row.getCell(j).getCellType());
                }
                data[i][j] = value;
            }
            System.out.println();
        }
    return data;
    }

    public String[][] getExcelData1(String path, int workSheetIndex) throws IOException {


        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(path));
        XSSFSheet sheet = workbook.getSheetAt(workSheetIndex);
        Row row = sheet.getRow(sheet.getFirstRowNum());
        int nColumn = row.getLastCellNum()-row.getFirstCellNum();
        int nRow = sheet.getLastRowNum()-sheet.getFirstRowNum();
        String[][] data = new String[nRow+1][nColumn];

        Iterator<Row> rowIterator = sheet.iterator();

        int r = 0;
        int c = 0;
        while (rowIterator.hasNext()) {
            Row rows = rowIterator.next();
            Iterator<Cell> cells = rows.cellIterator();
            while (cells.hasNext()) {

                // value can be string or numeric
                String value;
                Cell cell = cells.next();
                switch (cell.getCellType())
                {
                    case NUMERIC:
                        value = String.valueOf(cell.getNumericCellValue());
                        break;
                    case STRING:
                        value = cell.getStringCellValue();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + cell.getCellType());
                }

                if (c == nColumn) {
                    c = 0;
                    r++;
                }
                data[r][c] = value;
                c++;
            }
        }
        return data;
    }
}
