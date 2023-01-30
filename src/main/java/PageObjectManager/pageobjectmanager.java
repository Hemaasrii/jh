package PageObjectManager;

import org.openqa.selenium.WebDriver;

import Mano.Maven_Project.base_class;
import locators.Createaccount_page;
import locators.loginpage;

public class pageobjectmanager extends base_class {
	public pageobjectmanager(WebDriver driver) {
		this.driver = driver;
	}

	private loginpage loginpage;
	private Createaccount_page createaccount_page;

	public loginpage getLoginpage() {
		if (loginpage == null) {
			loginpage = new loginpage(driver);
		}
		return loginpage;
	}

	public Createaccount_page getCreateaccount_page() {
		if (createaccount_page == null) {
			createaccount_page = new Createaccount_page(driver);
		}
		return createaccount_page;
	}
}
