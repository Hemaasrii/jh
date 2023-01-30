package tasks;
import org.openqa.selenium.By;
import Mano.Maven_Project.base_class;
public class Flipkart extends base_class {
	public static void main(String[] args) {
		browser_Launch("chrome");
		geturl("https://www.google.com/search?q=flipkart&oq=&aqs=chrome.0.69i59i450l3.611228166j0j15&sourceid=chrome&ie=UTF-8");
		window_max();
		elementclick(driver.findElement(By.xpath("//h3[text()='Flipkart']")));
		elementclick(driver.findElement(By.xpath("//button[text()='✕']")));
		mousehover(driver.findElement(By.xpath("//div[text()='Electronics']")));
		mousehover(driver.findElement(By.xpath("//a[text()='Gaming']")));
		elementclick(driver.findElement(By.xpath("//a[text()='Controllers']")));
	}
}
