package com.OrangeHRM.pages;

import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OrangeHRMHomePage extends OrangeHRMBasePage{
	
//	public Page page;
	
//	public OrangeHRMHomePage(Page page) {
//		this.page =page;
//	}

	private String userName = "input[name='username']";
	private String password = "input[name='password']";
	private String logInBtn = "button[type='submit']";
	private String forgetPassword = ".orangehrm-login-forgot p";
	private String inputUserName = "//p[text()='Username : Admin']";
	private String inputPassword = "//p[text()='Password : admin123']";
	private String LoginHeader = "h5.oxd-text.oxd-text--h5.orangehrm-login-title";
	String extractUserName = extractInput(inputUserName);
	String extractPassword = extractInput(inputPassword);
	
	private String resetBtn ="button[type='submit']";
	
	
	
	public void logInPage() {
		System.out.println(extractUserName);
		System.out.println(extractPassword);
		assertThat(find(LoginHeader)).containsText("Login") ;
		enterText(userName, extractUserName);
		enterText(password, extractPassword);
		btnClick(logInBtn);
//		closeAll();
		
	}
	
	public void forgetPasswordPage() {
		btnClick(forgetPassword);
		enterText(userName, extractUserName);
		btnClick(resetBtn);
		
	}
}
