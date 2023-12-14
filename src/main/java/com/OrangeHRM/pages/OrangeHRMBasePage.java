package com.OrangeHRM.pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class OrangeHRMBasePage {
	Playwright playwright;
	Browser browser;
	BrowserContext context;
	public Page page;
	
//	public OrangeHRMBasePage(Page page) {
//		// TODO Auto-generated constructor stub
//		this.page =page;
//	}
//	
	public void  launchWebsite() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		context = browser.newContext();
		page = context.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	public  Locator find(String selector) {
		Locator find=page.locator(selector);
		return find;
		
	}
	
	public  String extractInput(String input) {
		 String[] parts = input.split(":");
	        
	        // Get the second part and remove leading/trailing whitespaces
		 String text = parts.length > 1 ? parts[1].trim().replaceAll("[^a-zA-Z0-9]", "") : "";

		 return text;
	}
	
	
	public void btnClick(String selector) {
		find(selector).click();
		
	}
	public void enterText(String Selector,String Text) {
		find(Selector).fill(Text);
		
	}
	
	public void closeAll() {
		page.context().browser().close();
		playwright.close();
	}
//	public static void main(String[] args) {
//		Page page = null;
//		OrangeHRMBasePage hr =new OrangeHRMBasePage(page);
//		hr.launchWebsite();
//	}

}



















