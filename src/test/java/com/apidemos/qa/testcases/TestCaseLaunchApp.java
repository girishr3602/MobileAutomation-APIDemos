package com.apidemos.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.apidemos.qa.base.TestBase;

public class TestCaseLaunchApp extends TestBase {
	
	@BeforeMethod
	public void launch() {
		initCapabilities();
	}
	
	
	@Test
	public void helloWorld() {
		System.out.println("Hello Mobile World Automation");
	}

}
