package Mano.Maven_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_Runner {
	public static String path;

	public static String Excel(int r, int c) throws IOException {
		path = ".\\src\\test\\java\\test_data\\Book1.xlsx";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sheet = wb.getSheet("New");
		Row row = sheet.getRow(r);
		Cell cell = row.getCell(c);
		DataFormatter df = new DataFormatter();
		String formatCellValue = df.formatCellValue(cell);
		System.out.println(formatCellValue);
		return formatCellValue;
	}

	public static void to_write_data(int r, int c, String value) throws IOException {
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet createSheet = wb.getSheetAt(3);
		Row row = createSheet.createRow(r);
		Cell createCell = row.createCell(c, CellType.STRING);
		createCell.setCellValue(value);
		FileOutputStream out = new FileOutputStream(f);
		wb.write(out);
		out.close();
		System.out.println("complete");
	}

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(Excel(0, 0));
		driver.manage().window().maximize();
		WebElement Search = driver.findElement(By.id("twotabsearchtextbox"));
		Search.sendKeys(Excel(1, 0), Keys.ENTER);

		List<WebElement> Allproducts = driver.findElements(By
				.xpath("//span[text()='RESULTS']//following::span[@class='a-size-medium a-color-base a-text-normal']"));
		for (int i = 0; i < Allproducts.size(); i++) {
			to_write_data(i, 0, Allproducts.get(i).getText());
		}

	}
}
