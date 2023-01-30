package Mano.Maven_Project;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base_class {
	public static WebDriver driver;
	public static String path;
	
	public static void browser_Launch(String browser) {
			try {
				if(browser.equals("chrome")){
                   WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}
				else if(browser.equals("firefox"))
				{
					 WebDriverManager.firefoxdriver().setup();
					 driver=new FirefoxDriver();
				}
			} catch (Exception e) {
				System.out.println("Unable to get browserlaaunch :"+e.getMessage());
			 }
	}
	public static void geturl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println("Unable to get url:" + e.getMessage());
		}
	}

	public static void window_max() {
		driver.manage().window().maximize();
	}

	public static WebElement xpath(String value) {
		WebElement findElement = driver.findElement(By.xpath(value));
		return findElement;
	}

	public static List<WebElement> xpathElements(String value) {
		List<WebElement> findElements = driver.findElements(By.xpath(value));
		return findElements;
	}

	public static void elementsendkeys(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Unable to Send Keys:" + e.getMessage());
		}
	}

	public static void elementclick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("Unable to click:" + e.getMessage());
		}
	}

	public static void switchtowindow(String titlename) {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			for (String window : windowHandles) {
				String title = driver.switchTo().window(window).getTitle();
				if (titlename.equals(title)) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Unable to Windowhandles:" + e.getMessage());
		}
	}

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

	public static String get_text(WebElement element) {
		String text = null;
		try {
			text = element.getText();
		} catch (Exception e) {
			System.out.println("Invalid text :" + e.getMessage());
		}
		return text;
	}
	
	public static void wait_method() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void threadsleepforseconds(int sec) throws InterruptedException {
		TimeUnit.SECONDS.sleep(sec);
	}

	public static void selectmethod(WebElement findelement, String option, String i) {
		Select s = new Select(findelement);
		try {
			if (option.equals("index")) {
				s.selectByIndex(Integer.parseInt(i));

			} else if (option.equals("text")) {
				s.selectByVisibleText(i);
			} else if (option.equals("value")) {
				s.selectByValue(i);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid dropdown :"+e.getMessage());
		}
	}

	public static void mousehover(WebElement element) {
		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			System.out.println("Unable to click Mouse :" + e.getMessage());
		}

	}

	public static void replaceall_methodforeach(List<WebElement> findelements) {
		for (WebElement value : findelements) {
			String replace = value.getText().replaceAll("[^0-9]", "");
			int parseInt = Integer.parseInt(replace);
			System.out.println(parseInt);
		}
	}

	public static String replaceall_methodforloop(WebElement findelement) {
		String replaceAll2 = findelement.getText().replaceAll("[^0-9]", "");
		int parseInt1 = Integer.parseInt(replaceAll2);
		System.out.println(parseInt1);
		return replaceAll2;
	}

	public static boolean elementisDisplayed(WebElement element) {
		boolean displayed = false;

		try {
			displayed = element.isDisplayed();
			System.out.println(displayed);
		} catch (Exception e) {
			System.out.println("Invalid displayed :"+e.getMessage());
		}
		return displayed;
	}

	public static boolean elementisenabled(WebElement element) {
		boolean enabled = false;
		try {
			enabled = element.isEnabled();
		} catch (Exception e) {
			System.out.println("Invalid isenabled :"+e.getMessage());
		}
		return enabled;
	}

	public boolean elementisselected(WebElement element) {

		boolean selected = false;
		try {
			selected = element.isSelected();
		} catch (Exception e) {
			System.out.println("Invalid isSelected :"+e.getMessage());
		}
		return selected;
	}

	public void dragdrop(WebElement element1, WebElement element2) {

		Actions ac = new Actions(driver);
		ac.dragAndDrop(element1, element2).build().perform();
	}

	public void iframes(WebElement elements) {
		driver.switchTo().frame(elements);
	}

	public static void actionsClick(WebElement element) {
		Actions ac2 = new Actions(driver);
		ac2.click(element).build().perform();
	}

	public static void rightClick(WebElement element) {
		Actions ac3 = new Actions(driver);
		ac3.contextClick(element).build().perform();
	}

	public static void navigateto(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			System.out.println("Unable to navigate to :"+e.getMessage());
		}
	}

	public static void navigateforward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			System.out.println("Unable to forward :"+e.getMessage());
		}
	}

	public static void navigatebackward() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			System.out.println("Unable to backward :"+e.getMessage());
		}
	}

	public static void Pagerefresh() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			System.out.println("Unable to refresh :"+e.getMessage());
		}
	}

	public static void close() {
		driver.close();
	}
	
	public static void quit() {
		driver.quit();
	}
	public static String currenturl() {
		try {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			System.out.println("Unable to get current url :"+e.getMessage());
		}
		return currenturl();
	}

	public static void scroll(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrolltoView", element);
		} catch (Exception e) {
			System.out.println("Unable to scrolldown :"+e.getMessage());
		}
	}
}
