package com.OrangeHRM.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.pages.OrangeHRMBasePage;
import com.OrangeHRM.pages.OrangeHRMHomePage;
import com.microsoft.playwright.Page;

public class OrangeHRMHomePageTestcase {
//	public Page page;
//	public OrangeHRMHomePageTestcase(Page page) {
//		this.page = page;
//	}

	OrangeHRMHomePage  homePage;
	
	@BeforeMethod
	public void launchOrangeHRMWebsite() {
		homePage = new OrangeHRMHomePage();
		homePage.launchWebsite();
	}
	
	@AfterMethod
	public void tearDown() {
		homePage.closeAll(); 
	}
	
	@Test
	public void loggInPage() {
		homePage.logInPage();
		
	}
	
//	public void 

}
