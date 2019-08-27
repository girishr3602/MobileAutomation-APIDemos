package com.apidemos.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.apidemos.qa.util.TestUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Baseclass {

	static DesiredCapabilities cap;
	static AndroidDriver<AndroidElement> driver; 
	static Properties prop;
	
	
	public Baseclass() {
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	static String DEVICE_NAME = "Emulator-Demo";
	static String APP_NAME = "ApiDemos-debug.apk";
	
	public static void desiredCapabilities() {
		cap = new DesiredCapabilities();
		
		File appDir = new File(System.getProperty("user.dir")+"/src/main/java/com/apidemos/qa/apk");
		File app = new File(appDir, APP_NAME);
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, TestUtil.COMMAND_TIMEOUT);
		
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void startEmulator(String emulator_name) {
		if(emulator_name.contains("Emulator-Demo")) {
			try {
				Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/java/com/apidemos/qa/resources/Emulator-Demo.bat");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
