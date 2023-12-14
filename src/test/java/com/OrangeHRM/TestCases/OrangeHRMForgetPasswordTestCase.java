package com.OrangeHRM.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.pages.OrangeHRMHomePage;

public class OrangeHRMForgetPasswordTestCase {
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
		homePage.forgetPasswordPage();
		
	}

}
