package tasks_pom;

import Mano.Maven_Project.base_class;
import PageObjectManager.pageobjectmanager;

public class Facebook_create extends base_class {
	public static void main(String[] args) throws InterruptedException {
		pageobjectmanager pom = new pageobjectmanager(driver);
		browser_Launch("chrome");
		geturl("https://www.facebook.com/");
		window_max();
		elementisDisplayed(pom.getLoginpage().getFb_logo());
		elementclick(pom.getLoginpage().getCreate_Account());
		threadsleepforseconds(3);
		elementsendkeys(pom.getCreateaccount_page().getFirstName(),"Manoj");
		elementsendkeys(pom.getCreateaccount_page().getLastName(),"Kumar");
		elementsendkeys(pom.getCreateaccount_page().getPhNo(),"9876543210");
		elementsendkeys(pom.getCreateaccount_page().getPassword(),"Kumar@123");
		selectmethod(pom.getCreateaccount_page().getDay(),"value","15");
		selectmethod(pom.getCreateaccount_page().getMonth(),"text","Jun");
		selectmethod(pom.getCreateaccount_page().getYear(),"value","1998");
		elementclick(pom.getCreateaccount_page().getGender());
		elementclick(pom.getCreateaccount_page().getSignup());
	}
}
