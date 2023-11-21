package mail.pages;

import com.microsoft.playwright.Page;

import baseplaywright.BaseClassPW;

public class LoginMailId {
	
	public static void main(String[] args) {
		BaseClassPW baseClassPW = new BaseClassPW();
		Page page = baseClassPW.launchBrowser("chrome", "https://www.facebook.com/login");
		//[1]enter email address
		baseClassPW.enterText(page.locator("#email"), "7339226761");
		//[2]enter pass
		baseClassPW.enterText(page.locator("#pass"), "123456789sarun761");
		//[4]click next
		baseClassPW.btnClick(page.locator("//button[@name='login']"));
		
	}

}
