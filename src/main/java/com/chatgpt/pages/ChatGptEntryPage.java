package com.chatgpt.pages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.awt.Taskbar.State;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import baseplaywright.BaseClassPW;

public class ChatGptEntryPage extends BaseClassPW{
	
	private Locator terms,privacy;
	private String EMAIL="arunsenthil761@gmail.com";
	
	private Locator  signInBtn/*Signin*/,
	                 email,
	                 haveAccount,
	                 loginElementbtn,
	                 ContinueBtn,
	                 signinPassword,errorMsg;
	
	private Locator loginInBtn/*Login*/,
	                username,
	                googleBtn,next1,next2,
	                loginPassword;
	
	
	public ChatGptEntryPage(Page page) {
		this.page=page;
		this.signInBtn =page.locator("//div[text()='Sign up']");
		this.terms =page.locator("//a[contains(text(),'Terms of use')]");
		this.privacy =page.locator("//a[contains(text(),'Privacy policy')]");
		this.email =page.locator("#email");
		this.haveAccount = page.locator("p.cc69e7a02.c4af8ca74.c05fe9174");
		this.loginElementbtn =page.locator("a.c01f9230f.c67c75d5d");
		this.ContinueBtn =page.locator("button[name='action']");
		this.signinPassword=page.locator("#password");
		this.errorMsg =page.locator("span[role='img']");
		
		this.loginInBtn=page.locator("//div[text()='Log in']");
		this.googleBtn=page.locator("button[data-provider='google']");
		this.username=page.locator("#identifierId");
		this.next1=page.locator("//span[text()='Next']");
		this.next2=page.locator("(//div[@class='VfPpkd-RLmnJb'])[2]");
		
	}
	public void mainPage() {
		getPageTitle();
		System.out.println(getText(terms));
		assertThat(terms).hasText("Terms of use");
		System.out.println(getText(privacy));
		assertThat(privacy).hasText("Privacy policy");
		System.out.println("[1]Main page assertion completed");
	
	}
	public void signinPage() {
		btnClick(signInBtn);
		page.waitForLoadState(LoadState.LOAD);
		enterText(email, EMAIL);
		System.out.println(getText(haveAccount));
		assertThat(haveAccount).containsText("Already have an account?");
		System.out.println(getText(loginElementbtn));
		assertThat(loginElementbtn).containsText("Log in");
		btnClick(ContinueBtn);
		enterText(signinPassword, "qwertyuiop"); 
		btnClick(ContinueBtn);
		System.out.println(getText(errorMsg));
		assertThat(errorMsg).containsText("The user already exists.");
		System.out.println("[2]Signin page assertion completed");
		
	}
	public void loginPage() {
		btnClick(loginInBtn);
		btnClick(googleBtn);
		enterText(username, EMAIL);
		btnClick(next1);
		enterText(loginPassword, "sarun761");
		btnClick(next2);
		
		
		
		
		
	}

}
