package play;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserContext.StorageStateOptions;

public class SkipLogin {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		BrowserContext context = playwright.chromium().launch(setHeadless).newContext(
				//use this to to skip the authentication and go to the next step //always use json file to do that
//				new Browser.NewContextOptions().setStorageStatePath(Paths.get("./test-output/auth.json"))
				);
		Page page = context.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
//		page.click("//span[text()='Login']/..");
//		page.locator("input[formcontrolname='username']").fill("ortoni");
//		page.locator("input[formcontrolname='password']").fill("Pass1234$");
//		page.locator("button[color='primary']").click();
		String userName = page.locator("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]")
				.textContent();
		String user = userName.split(" ")[1].split(" ")[0];
		System.out.println("User: "+user);
		// first use this to generate the auth and then use it to login with out any authenthication
//		context.storageState(new StorageStateOptions().setPath(Paths.get("./test-output/auth.json")));
		
		
		
		playwright.close();

		
		

	}

}