package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Mano.Maven_Project.base_class;

public class loginpage extends base_class {
	public loginpage(WebDriver xdriver) {
		this.driver=xdriver;
		PageFactory.initElements(driver,this );
	}
	@FindBy(xpath = "//img[@alt='Facebook']")
	private WebElement Fb_logo;
	
	@FindBy(xpath ="//a[text()='Create New Account']")
	private WebElement create_Account;
	
	public WebElement getFb_logo() {
		return Fb_logo;
	}
	
	public WebElement getCreate_Account() {
		return create_Account;
	}
}
