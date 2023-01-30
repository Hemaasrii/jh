package tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Mano.Maven_Project.base_class;
public class Flipkart_MI extends base_class{
	public static void main(String[] args) throws InterruptedException {
		browser_Launch("chrome");
		geturl("https://www.flipkart.com/");
		window_max();
		elementclick(driver.findElement(By.xpath("//button[text()='✕']")));
		elementclick(driver.findElement(By.xpath("//div[text()='Mobiles']")));
		threadsleepforseconds(3);
		mousehover(driver.findElement(By.xpath("//div[@class='_1kidPb']//child::span[text()='Electronics']")));
		threadsleepforseconds(3);
		elementclick(driver.findElement(By.xpath("//a[text()='Mi']")));
		threadsleepforseconds(3);
		elementisDisplayed(driver.findElement(By.xpath("//h1[text()='Mi Mobiles']")));
		selectmethod(driver.findElement(By.xpath("(//select[@class='_2YxCDZ'])[2]")),"value","20000");
		threadsleepforseconds(3);
		elementsendkeys(driver.findElement(By.name("q")),"redmi note 10s\n");
		threadsleepforseconds(3);
		elementclick(driver.findElement(By.xpath("//div[text()='REDMI Note 10S (Frost White, 64 GB)']")));
		switchtowindow("REDMI Note 10S ( 64 GB Storage, 6 GB RAM ) Online at Best Price On Flipkart.com");
		WebElement price = driver.findElement(By.xpath("(//div[text()='₹12,999'])[1]"));
		String text = price.getText().replaceAll("[^0-9]","");
		int parseInt = Integer.parseInt(text);
		int s=0;
		if (s>=parseInt) {
			System.out.println("Test pass");
		}
		elementsendkeys(driver.findElement(By.id("pincodeInputId")),"625531\n");
		threadsleepforseconds(2);
		elementclick(driver.findElement(By.xpath("//span[text()='View Details']")));
		threadsleepforseconds(2);
		elementclick(driver.findElement(By.xpath("(//button[text()='✕'])[1]")));
		elementclick(driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")));
		threadsleepforseconds(3);
		quit();
	}
}