package Mano.Maven_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class data_driven1 {
	public static String path;

	public static void to_get_particular_value() throws IOException {
		path = ".\\src\\test\\java\\test_data\\Book1.xlsx";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sheet = wb.getSheet("sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		DataFormatter df = new DataFormatter();
		String formatCellValue = df.formatCellValue(cell);
		System.out.println(formatCellValue);
	}

	public static void to_read_particularrow() throws IOException {
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sheetAt = wb.getSheetAt(0);
		int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();
		for (int i = 0; i < physicalNumberOfRows; i++) {
			Row row = sheetAt.getRow(i);
			Cell cell = row.getCell(0);
			DataFormatter df = new DataFormatter();
			String formatCellValue = df.formatCellValue(cell);
			System.out.println(formatCellValue);

		}

	}

	public static void to_read_particularcell() throws IOException {
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sheetAt = wb.getSheetAt(0);
		int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();
		Row row = sheetAt.getRow(0);
		for (int i = 0; i < physicalNumberOfRows; i++) {
			Cell cell = row.getCell(i);
			DataFormatter df = new DataFormatter();
			String formatCellValue = df.formatCellValue(cell);
			System.out.println(formatCellValue);

		}

	}

	public static void to_read_alldata() throws IOException {
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sheetAt = wb.getSheetAt(0);
		int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();
		for (int i = 0; i < physicalNumberOfRows; i++) {
			Row row = sheetAt.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				DataFormatter df = new DataFormatter();
				String formatCellValue = df.formatCellValue(cell);
				System.out.print(formatCellValue + "||");
			}
			System.out.println();
		}

	}

	public static void to_write_data() throws IOException {
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet createSheet = wb.getSheet("Data");
		Row row = createSheet.createRow(0);
		Cell createCell = row.createCell(0, CellType.STRING);
		createCell.setCellValue("Name");
		FileOutputStream out = new FileOutputStream(f);
		wb.write(out);
		out.close();
		System.out.println("complete");
	}

	public static void to_write_data1() throws IOException {
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sheet = wb.getSheetAt(2);
		Row row = sheet.getRow(0);
		if (row == null) {
			row = sheet.createRow(0);
		}
		Cell cell = row.getCell(0);
		if (cell == null) {
			cell = row.createCell(0, CellType.STRING);
		}
		cell.setCellValue("Value");
		FileOutputStream out = new FileOutputStream(f);
		wb.write(out);
		out.close();
		System.out.println("completed");
	}

	public static void main(String[] args) throws IOException {
//		to_get_particular_value();
//		to_read_particularrow();
//		to_read_particularcell();
		to_read_alldata();
//		to_write_data();
//		to_write_data1();
	}
}
