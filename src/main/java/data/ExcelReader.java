package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    static FileInputStream fis = null;
    public FileInputStream getFileInputSteam(){
        String filePath = System.getProperty("user.dir")+"/src/main/java/data/userData.xlsx";
        File srcFile = new File(filePath);
        try {
            fis = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found.");
            System.exit(0);
            //e.printStackTrace();
        }
        return fis;
    }

    public Object[][] getUserData() throws IOException {
        fis = getFileInputSteam();
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int TotalNumberOfRows = (sheet.getLastRowNum()+1);
        int TotalNUmberOfCols = 12;
        System.out.println(TotalNumberOfRows);
        String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNUmberOfCols];

        for (int i=0; i < TotalNumberOfRows; i++){
            for(int j=0; j < TotalNUmberOfCols; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
                System.out.println(arrayExcelData[i][j]);
            }
        }
        System.out.println(TotalNumberOfRows);
        //System.out.println(arrayExcelData);
        wb.close();
        return arrayExcelData;

    }
}
