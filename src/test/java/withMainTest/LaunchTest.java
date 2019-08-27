package withMainTest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.apidemos.qa.base.TestBase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class LaunchTest{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f = new File(System.getProperty("user.dir")+"/src/main/java/com/apidemos/qa/apk/ApiDemos-debug.apk");
		
		/*
		 * startAppiumServer(); startEmulator();
		 */
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\com\\apidemos\\qa\\resources\\startEmulator.bat");
		
		DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
			cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		
			
			
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
			driver.findElementByXPath("//*[@text='Preference']").click();
			driver.findElementByXPath("//*[@text='3. Preference dependencies']").click();
			driver.findElementByXPath("//*[@resource-id='android:id/checkbox']").click();
			driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
			driver.findElementByXPath("//*[@class='android.widget.EditText']").sendKeys("Hello");
			//driver.findElementByClassName("android.widget.EditText").sendKeys("Hello World");
			driver.findElementsByXPath("//*[@class='android.widget.Button']").get(1).click();
			
		
		//stopAppiumServer();

	}

}
