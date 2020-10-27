package Appium.Appitumtest;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class browserProjectActivity1 {
	WebDriverWait wait;
	AndroidDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("deviceId", "-----");
		 caps.setCapability("platformName", "android");
		 caps.setCapability("appPackage", "com.google.android.apps.tasks");
		 caps.setCapability("appActivity", ".ui.TaskListsActivity");
	     caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		//driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void todolistpage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium");
		
		String uiSelector = "new UiSelector().textMatches(\"Login Form\")";

		String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ")";

		driver.findElementByAndroidUIAutomator(command).click();	

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@text='']")));

		ArrayList<String> taskLists = new ArrayList<String>();
		taskLists.add("Add tasks to list");
		taskLists.add("Get number of tasks");
		taskLists.add("Clear the list");

		for (String tasklist : taskLists) {

			driver.findElementByXPath("//android.widget.EditText[@text='']").click();
			driver.findElementByXPath("//android.widget.EditText[@text='']").sendKeys(tasklist);

			driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();

			List<MobileElement> taskNames = driver.findElementsByXPath("//android.view.View[@text='" + tasklist + "']");

			for (MobileElement taskName : taskNames) {

				Assert.assertEquals(taskName.getText(), tasklist);

				taskName.click();
			}
		}

		driver.findElementByXPath("//android.view.View[@text='']").click();

	}
	@AfterClass
	public void afterclass() {
		//driver.close();
	}
}