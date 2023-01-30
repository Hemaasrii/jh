package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Coronatable {
	public static WebDriver driver;
	public static void browser_launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().window().maximize();
	}
	public static void toreadalldata() {
		List<WebElement> alldata = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody/tr/td"));
		for (WebElement text : alldata) {
			System.out.println(text.getText());
		}
	}
	public static void toreadrow() {
		List<WebElement> row = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody/tr[1]/td"));
		for (WebElement text : row) {
			System.out.println(text.getText());
		}
	}
	public static void toreadcolumn() {
		List<WebElement> alldata = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody/tr/td[2]"));
		for (WebElement text : alldata) {
			System.out.println(text.getText());
		}
	}
	public static void toreadparticulardata() {
		WebElement particulardata = driver
				.findElement(By.xpath("//table[@id='main_table_countries_today']/tbody/tr[7]/td[3]"));
		System.out.println(particulardata.getText());
	}

	public static void main(String[] args) {
		browser_launch();
		toreadalldata();
		toreadrow();
		toreadcolumn();
		toreadparticulardata();
	}

}
