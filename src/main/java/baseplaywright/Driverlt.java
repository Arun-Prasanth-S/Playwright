package baseplaywright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


	public class Driverlt{

		private Playwright playwright;
		private Browser browser;
		private Page page;
		
		Driverlt(Playwright playwright,Browser browser, Page page){
			this.browser = browser;
			this.page = page;
			this.playwright =  playwright;
		}

		public Browser getBrowser() {
			return browser;
		}
		public Playwright getPlaywright() {
			return playwright;
		}

		public Page getPage() {
			return page;
		}
	}

