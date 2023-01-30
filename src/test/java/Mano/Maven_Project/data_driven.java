package Mano.Maven_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class data_driven {
	public static void to_read_particular_data() throws Throwable, Throwable {
		File a = new File(
				"C:\\Users\\Manoj\\eclipse-workspace\\Maven_Project\\src\\test\\java\\Mano\\Maven_Project\\Book1.xlsx");
		FileInputStream b = new FileInputStream(a);
		XSSFWorkbook c = new XSSFWorkbook(b);
		XSSFSheet sheet = c.getSheet("sheet1");
		XSSFCell cell = sheet.getRow(2).getCell(1);
		CellType cellType = cell.getCellType();
		if (cellType.equals(cellType.STRING)) {
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
		} else if (cellType.equals(cellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			int d = (int) numericCellValue;
			System.out.println(d);
		}
	}

	public static void to_write_data() throws Throwable {
		File f = new File(
				"C:\\Users\\Manoj\\eclipse-workspace\\Maven_Project\\src\\test\\java\\Mano\\Maven_Project\\Book1.xlsx");
		FileInputStream input = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(input);
		//wb.createSheet("New1").createRow(0).createCell(0).setCellValue("Name");
		wb.getSheet("New1").createRow(2).createCell(0).setCellValue("Mano");
		FileOutputStream output = new FileOutputStream(f);
		wb.write(output);
		wb.close();
	}

	public static void to_read_all_data() throws Throwable {
		File ff = new File(
				"C:\\Users\\Manoj\\eclipse-workspace\\Maven_Project\\src\\test\\java\\Mano\\Maven_Project\\Employee Sample Data.xlsx");
		FileInputStream input1 = new FileInputStream(ff);
		Workbook w = new XSSFWorkbook(input1);
		Sheet sheet = w.getSheet("Data");
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < physicalNumberOfRows; i++) {
			Row row = sheet.getRow(i);
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < physicalNumberOfCells; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				if (cellType.equals(cellType.STRING)) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				} else if (cellType.equals(cellType.NUMERIC)) {
					double numericCellValue = cell.getNumericCellValue();
					int ii = (int) numericCellValue;
					System.out.println(ii);
				}
			}
		}
	}

	public static void main(String[] args) throws Throwable {
		// to_read_particular_data();
		// to_write_data();
		to_read_all_data();
	}
}
