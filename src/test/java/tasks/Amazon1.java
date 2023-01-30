package tasks;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.formula.functions.Replace;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon1 {
	public static WebDriver driver;

	public static void browser_Launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void geturl() {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	public static void elementsendkeys() throws InterruptedException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("vivo");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement phone_model = driver.findElement(By.xpath(
				"//span[text()='RESULTS']//following::span[@class='a-size-medium a-color-base a-text-normal'][3]"));
		phone_model.click();
		Set<String> windowHandles = driver.getWindowHandles();
		String s = "Vivo Y22 (Starlit Blue, 6GB RAM, 128GB Storage) with No Cost EMI/Additional Exchange Offers : Amazon.in";
		for (String string : windowHandles) {
			if (driver.switchTo().window(string).getTitle().equalsIgnoreCase(s)) {
				break;
			}
			System.out.println(driver.switchTo().window(string).getTitle());
		}

		WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
		addtocart.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button']")).click();
		WebElement qty = driver.findElement(By.xpath("//select[@name='quantity']"));
		Select ss = new Select(qty);
		String q = "3";
		int parseInt2 = Integer.parseInt(q);
		ss.selectByVisibleText(q);
		Thread.sleep(3000);
		WebElement oneprice = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
		String replaceAll = oneprice.getText().replaceAll("[^0-9]", "");
		int parseInt = Integer.parseInt(replaceAll);
		int Exp_sum = parseInt * parseInt2;
		System.out.println(Exp_sum);

		WebElement price = driver.findElement(
				By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[1]"));
		String replaceAll2 = price.getText().replaceAll("[^0-9]", "");
		int parseInt1 = Integer.parseInt(replaceAll2);
		System.out.println(parseInt1);
         
	}

	public static void main(String[] args) throws InterruptedException {
		browser_Launch();
		geturl();
		elementsendkeys();
	}

}
