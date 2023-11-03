package amazon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.pages.HomePage;

public class HomepageTest extends baseplaywright.BaseClassPW {
	HomePage homepage;
	
//	BaseClassPW BC;
	@BeforeMethod
	public void frontPage() {
//		BC = new BaseClassPW();
		page = launchBrowser("chrome",  
		                        "https://www.amazon.in/");
		 homepage = new HomePage(page);
		
		
	}
	
	@Test
	public void TC1() {
		homepage.signInPage("Arun");
		homepage.validate();
	}
	
	@Test
	public void TC2() {
		homepage.searchFunction("oneplus earbuds");
		homepage.productAddToCart();
	}
	@AfterMethod
	public void close() {
		closeAll();
	}

	@AfterTest
	public void quit() {
	
		closePlaywright();
	}
}
