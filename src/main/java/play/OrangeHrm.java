package play;

import java.nio.file.Paths;

import com.microsoft.playwright.BrowserContext.StorageStateOptions;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class OrangeHrm {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		BrowserContext context = playwright.chromium().launch(setHeadless).newContext(
				//use this to to skip the authentication and go to the next step //always use json file to do that
				new Browser.NewContextOptions().setStorageStatePath(Paths.get("./test-output/orangehrm.json"))
				);
		Page page = context.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		page.getByPlaceholder("username").fill("Admin");
		page.getByPlaceholder("Password").fill("admin123");
		page.locator("//button[@type='submit']").click();
		
		String text = page.locator("//span[text()='Admin']").innerText();
		System.out.println(text);
		
//		context.storageState(new StorageStateOptions().setPath(Paths.get("./test-output/orangehrm.json")));
		page.close();
		context.close();
		playwright.close();
	}

}
