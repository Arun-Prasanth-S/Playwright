package com.Chatgpt.Testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.chatgpt.pages.ChatGptEntryPage;
import com.microsoft.playwright.Page;

public class EntryPageTC extends baseplaywright.BaseClassPW {
	ChatGptEntryPage ChatGptEntryPage;
	@BeforeTest
	public void launchPage() {
		Page page = launchBrowser("chrome", "https://chat.openai.com/auth/login");
		
		ChatGptEntryPage =new ChatGptEntryPage(page);
	}
	@Test
    public void entryPage() {
    	ChatGptEntryPage.mainPage();
    	ChatGptEntryPage.signinPage();
    	ChatGptEntryPage.loginPage();
    }
}
