package tasks;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Mano.Maven_Project.base_class;
public class Amazon_Task extends base_class {
	public static void main(String[] args) throws IOException, InterruptedException {
		browser_Launch("chrome");
		geturl(Excel(0, 0));
		window_max();
		elementsendkeys(driver.findElement(By.id("twotabsearchtextbox")), "Vivo\n");
		List<WebElement> product = driver.findElements(By
				.xpath("//span[text()='RESULTS']//following::span[@class='a-size-medium a-color-base a-text-normal']"));
		elementclick(product.get(1));
		switchtowindow(
				"Vivo Y16 (Drizzling Gold, 4GB RAM, 64GB Storage) with No Cost EMI/Additional Exchange Offers : Amazon.in: Electronics");
		elementclick(driver.findElement(By.id("add-to-cart-button")));
		wait_method();
		elementclick(driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button']")));
		int q = 3;
		selectmethod(driver.findElement(By.xpath("//select[@name='quantity']")), "value", String.valueOf(q));
		threadsleepforseconds(5);
		List<WebElement> oneprice = driver.findElements(By.xpath("//span[@class='currencyINR']//parent::span"));
		String price = get_text(oneprice.get(2)).replaceAll("[^0-9]", "").replace(" ", "");
		int actPrice = Integer.parseInt(price) * q;
		System.out.println(actPrice);
		
		String price1 = get_text(oneprice.get(0)).replaceAll("[^0-9]", "").replace(" ", "");
		int expPrice = Integer.parseInt(price1);
		System.out.println(expPrice);

		if (actPrice == expPrice) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Fail");
		}
	}
}
