package tasks;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Mano.Maven_Project.base_class;
public class Amazon2 extends base_class {
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
		String replaceall_method = replaceall_methodforloop(driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")));
		String replaceall_method2 = replaceall_methodforloop(driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[1]")));
		if (replaceall_method==replaceall_method2) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
	}
}