package play;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDomElement {
public static void main(String[] args) {
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
	Page page = browser.newContext().newPage();
	
	//page -- DOM --> ShadowDom ---> Element
	
	page.navigate("https://books-pwakit.appspot.com/");
	page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
	String text = page.locator("book-app[apptitle='BOOKS'] .books-desc").innerText();
	System.out.println(text);

	//page --iframe -->shadowDOM -- Element
	page.navigate("url");
	page.frameLocator("frameLocator").locator("locator").fill("Ginger Tea");
	
	
}
}
