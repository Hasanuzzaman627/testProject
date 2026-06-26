package page;

import com.microsoft.playwright.Page;
//import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static utils.constant.Resource_folder_path;
import static utils.constant.locatorsPageName;

public class getLocators  extends BasePage{
    private static String testDataExcelPath;
    private static XSSFWorkbook excelWBook;
    private static XSSFSheet excelWSheet;
    private static final Map<String, Integer> columnMap = new HashMap<>(); // Mapping column names to their indices
    private static final String DEFAULT_SHEET_NAME = locatorsPageName; // Default sheet name (Set your sheet name here)

    // Static block to automatically set the sheet when the class is loaded
    static {
        try {
            setExcelFileSheet(DEFAULT_SHEET_NAME); // Automatically set the sheet using default sheet name
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public getLocators(Page page) {
        super(page);
    }

    // Set the Excel file and sheet, and map column names to indices
    public static void setExcelFileSheet(String sheetName) throws java.io.IOException {
        String currentDir = System.getProperty("user.dir");

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            testDataExcelPath = currentDir + "/src/test/resources/";
        } else {
            testDataExcelPath = currentDir + Resource_folder_path;
        }

        FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + "locators.xlsx");
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);

        // Map column names
        mapColumnNames();
    }

    // Map column names in the header row to column indices
    private static void mapColumnNames() {
        XSSFRow headerRow = excelWSheet.getRow(0); // Assuming the first row is the header
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            String columnName = headerRow.getCell(i).getStringCellValue().trim(); // Trim extra spaces
            columnMap.put(columnName, i);
        }
    }

    // Get cell data by row name and column name
    public static String getLocator(String xpathName, String columnName) {
        Integer colNum = columnMap.get(columnName);
        if (colNum == null) {
            throw new IllegalArgumentException("Column " + columnName + " does not exist in the sheet.");
        }

        for (int i = 1; i <= excelWSheet.getLastRowNum(); i++) { // Start from row 1, assuming row 0 is the header
            XSSFRow currentRow = excelWSheet.getRow(i);
            String currentRowName = currentRow.getCell(0).getStringCellValue().trim(); // Assuming row names are in the first column
            if (currentRowName.equals(xpathName)) {
                XSSFCell cell = currentRow.getCell(colNum);
                DataFormatter formatter = new DataFormatter();
                return formatter.formatCellValue(cell);
            }
        }
        throw new NoSuchElementException("Row " + xpathName + " not found.");
    }

    // Set cell data by row name and column name
    public static void setCellDataByRowName(String value, String rowName, String columnName) throws java.io.IOException {
        Integer colNum = columnMap.get(columnName);
        if (colNum == null) {
            throw new IllegalArgumentException("Column " + columnName + " does not exist in the sheet.");
        }

        for (int i = 1; i <= excelWSheet.getLastRowNum(); i++) { // Start from row 1, assuming row 0 is the header
            XSSFRow currentRow = excelWSheet.getRow(i);
            String currentRowName = currentRow.getCell(0).getStringCellValue().trim(); // Assuming row names are in the first column
            if (currentRowName.equals(rowName)) {
                XSSFCell cell = currentRow.getCell(colNum);
                if (cell == null) {
                    cell = currentRow.createCell(colNum);
                }
                cell.setCellValue(value);

                FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + "locators.xlsx");
                excelWBook.write(fileOut);
                fileOut.flush();
                fileOut.close();
                return;
            }
        }
        throw new NoSuchElementException("Row " + rowName + " not found.");
    }
}
