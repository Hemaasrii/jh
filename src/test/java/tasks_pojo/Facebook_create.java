package tasks_pojo;

import Mano.Maven_Project.base_class;
import locators.Createaccount_page;
import locators.loginpage;

public class Facebook_create extends base_class {
	public static void main(String[] args) throws InterruptedException {
		browser_Launch("chrome");
		geturl("https://www.facebook.com/");
		window_max();
		loginpage login = new loginpage(driver);
		elementisDisplayed(login.getFb_logo());
		elementclick(login.getCreate_Account());
		Createaccount_page create = new Createaccount_page(driver);
		threadsleepforseconds(3);
		elementsendkeys(create.getFirstName(), "Manoj");
		elementsendkeys(create.getLastName(), "Kumar");
		elementsendkeys(create.getPhNo(), "9876543210");
		elementsendkeys(create.getPassword(), "Kumar@123");
		selectmethod(create.getDay(), "value", "15");
		selectmethod(create.getMonth(), "text", "Jun");
		selectmethod(create.getYear(), "value", "1998");
		elementclick(create.getGender());
		elementclick(create.getSignup());
	}
}