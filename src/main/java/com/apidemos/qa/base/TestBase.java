package com.apidemos.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.apidemos.qa.util.TestUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class TestBase {

	static AppiumDriverLocalService service;
	
	public static AndroidDriver<AndroidElement> driver;
	
	public static AndroidDriver<AndroidElement> initCapabilities() {
		
		try {
			/*
			 * File f = new File(System.getProperty("user.dir") +
			 * "/src/main/java/com/apidemos/qa/apk/ApiDemos-debug.apk");
			 * System.out.println(System.getProperty("user.dir")); System.out.println(f);
			 */
			File fis = new File(System.getProperty("user.dir") + "/src/main/java/com/apidemos/qa/apk/ApiDemos-debug.apk");
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
			cap.setCapability(MobileCapabilityType.APP, fis.getAbsolutePath());
			
			
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
		
	}

	
	public static void startAppiumServer() {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	
	
	public static void stopAppiumServer() {
		service = AppiumDriverLocalService.buildDefaultService();
		service.stop();
	}
	
	public static void startEmulator() {
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/java/com.apidemos.qa.resources/startEmulator.bat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
