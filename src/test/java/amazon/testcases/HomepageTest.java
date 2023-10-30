package amazon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import amazon.pages.HomePage;
import baseplaywright.BaseClassPW;

public class HomepageTest  {
	HomePage homepage;
	Page page;
	BaseClassPW BC;
	@BeforeMethod
	public void frontPage() {
		BC = new BaseClassPW();
		page = BC.launchBrowser("chrome",  
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
		BC.closeAll();
	}

	@AfterTest
	public void quit() {
	
		BC.closePlaywright();
	}
}
