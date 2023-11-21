package play;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Path;
import java.util.List;

public class windowHandelling {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
		BrowserContext newContext = browser.newContext();
		newContext.tracing().start(new Tracing.StartOptions()
				                              .setSnapshots(true)
				                              .setSnapshots(true)
				                              .setSources(true));
		Page page = newContext.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
		System.out.println(page.title());
		Page Popup = page.waitForPopup(()->{
			page.getByText("Follow On Twitter").click();	
		});
	    //interact with 2nd window tab
		Popup.waitForLoadState();
		assertThat(Popup).hasTitle("LambdaTest (@lambdatesting) / X");
		System.out.println(Popup.title());
		Popup.getByText("Log in").click();
		
		//interact with many pages
		Page tabs = page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(
			p->p.context().pages().size() == 3),
				()->{
			page.getByText("Follow All").click();	
		});
		
		List<Page> pages = tabs.context().pages();
		
		System.out.println(pages.size());
		
		pages.forEach(tab-> {
		tabs.waitForLoadState();
		System.out.println(tab.title());
		});
//		Page openpage1 = pages.get(0);
		newContext.tracing().stop(new Tracing.StopOptions()
				                             .setPath(Path.of("trace.zip")));
		
		page.close();
		browser.close();
		playwright.close();
		

	}

}
