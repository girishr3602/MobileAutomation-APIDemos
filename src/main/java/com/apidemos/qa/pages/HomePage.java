package com.apidemos.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.apidemos.qa.base.TestBase;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends TestBase {
	
	//AndroidDriver<AndroidElement> driver;
	
	public HomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Object Repository
	@AndroidFindBy(xpath = "//*[@text='Preference']")		////*[@text='Preference']
	public WebElement preference;
	
	
	
	// Actions  -- Features
	public void preferenceTest() {
		preference.click();
		//return new PreferencePage();
	}
	
}
