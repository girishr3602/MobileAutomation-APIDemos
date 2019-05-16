import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		File f = new File(System.getProperty("user.dir")+"/src/main/java/com/apidemos/qa/apk/ApiDemos-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
		cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

	}

}
