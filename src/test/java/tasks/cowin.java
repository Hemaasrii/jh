package tasks;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cowin {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cowin.gov.in/");
		driver.manage().window().maximize();
		WebElement State = driver.findElement(By.id("mat-select-4"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", State);
		String d = " Tamil Nadu ";
		String s = " Chennai ";
		List<WebElement> listofdistrict = driver
				.findElements(By.xpath("//div[@role='listbox']//child::mat-option//span"));
		System.out.println(listofdistrict.size());
		for (WebElement district : listofdistrict) {
			String text = district.getText();
			System.out.println(text);
			if (d.equalsIgnoreCase(text)) {
				district.click();
				break;
			}
			WebElement findElement = driver.findElement(By.id("mat-select-6"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", findElement);
			List<WebElement> listofstates = driver
					.findElements(By.xpath("//div[@role='listbox']//child::mat-option//span"));
			System.out.println(listofstates.size());
			for (WebElement state : listofdistrict) {
				String text2 = state.getText();
				System.out.println(text2);
				if (s.equalsIgnoreCase(text2)) {
					state.click();
					break;
				}
			}
		}
	}
}