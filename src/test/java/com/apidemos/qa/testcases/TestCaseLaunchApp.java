package com.apidemos.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.apidemos.qa.base.TestBase;
import com.apidemos.qa.pages.HomePage;

public class TestCaseLaunchApp extends TestBase {
	
	/*
	 * public TestCaseLaunchApp() { super(); }
	 */
	HomePage hp;
	
	@BeforeMethod
	public void launch() {
		initCapabilities();
		hp = new HomePage();
	}
	
	
	//@Test
	public void helloWorld() {
		System.out.println("Hello Mobile World Automation");
	}

	@Test
	public void clickPreference() {
		hp.preferenceTest();
	}
	
}
