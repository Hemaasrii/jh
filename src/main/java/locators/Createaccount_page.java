package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Mano.Maven_Project.base_class;

public class Createaccount_page extends base_class {
	public Createaccount_page(WebDriver xdriver) {
		this.driver = xdriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "firstname")
	private WebElement FirstName;
	
	@FindBy(name ="lastname")
	private WebElement LastName;
	
	@FindBy(name ="reg_email__")
	private WebElement PhNo;
	
	@FindBy(name ="reg_passwd__")
	private WebElement Password;
	
	@FindBy(name ="birthday_day")
	private WebElement Day;
	
	@FindBy(name = "birthday_month")
	private WebElement Month;
	
	@FindBy(name = "birthday_year")
	private WebElement Year;
	
	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement Gender;

	@FindBy(name = "websubmit")
	private WebElement Signup;
	
	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getPhNo() {
		return PhNo;
	}
	

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getDay() {
		return Day;
	}

	public WebElement getMonth() {
		return Month;
	}

	public WebElement getYear() {
		return Year;
	}

	public WebElement getGender() {
		return Gender;
	}

	public WebElement getSignup() {
		return Signup;
	}
}
