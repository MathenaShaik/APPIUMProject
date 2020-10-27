package Appium.Appitumtest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class projectActivity1 {
	
	 AppiumDriver<MobileElement> driver = null;
	//WebDriver wait = new ;
	String GoogleTask1;
	String GoogleTask2;
	String GoogleTask3;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
	    // Set the Desired Capabilities
	    DesiredCapabilities caps = new DesiredCapabilities();
	    // caps.setCapability("deviceName", "<device name>");
	    caps.setCapability("deviceId", "-----");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("appPackage", "com.google.android.apps.tasks");
	    caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	    }
	
  @Test
  public void androidGoogleTasks() throws InterruptedException {
	
	  GoogleTask1 = "Complete Activity with Google Tasks";
	  GoogleTask2 = "Complete Activity with Google Keep";
	  GoogleTask3 = "Complete the second Activity Google Keep";
			Thread.sleep(3000);
			//Adding Task 1//com.google.android.apps.tasks:id/tasks_fab
			driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
			Thread.sleep(1000);
			driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys(GoogleTask1);
			Thread.sleep(1000);
			driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
			Thread.sleep(1000);
			//Adding Task 2
			driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
			Thread.sleep(1000);
			driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys(GoogleTask2);
			Thread.sleep(1000);
			driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
			Thread.sleep(1000);
			//Adding Task 3
			driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
			driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys(GoogleTask3);
			driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
			String GTask1text = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc="+"\""+""+GoogleTask1+"\"]/android.widget.LinearLayout/android.widget.TextView").getText();
			System.out.println("The First GTask is :" + GTask1text  );
			Assert.assertEquals(GTask1text, GoogleTask1);
			String GTask2text = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc="+"\""+GoogleTask2+"\"]/android.widget.LinearLayout/android.widget.TextView").getText();
			System.out.println("The Second GTask is :" + GTask2text  );
			Assert.assertEquals(GTask2text, GoogleTask2);
			String GTask3text = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc="+"\""+GoogleTask3+"\"]/android.widget.LinearLayout/android.widget.TextView").getText();
			System.out.println("The Third GTask is :" + GTask3text  );
			Assert.assertEquals(GTask3text, GoogleTask3);
			driver.findElementByXPath("(//android.view.View[@content-desc=\"Mark as complete\"])[1]").click();
			System.out.println("The First GTask is Completed");
			driver.findElementByXPath("(//android.view.View[@content-desc=\"Mark as complete\"])[2]").click();
			System.out.println("The Second GTask is Completed");
			driver.findElementByXPath("(//android.view.View[@content-desc=\"Mark as complete\"])[3]").click();
			System.out.println("The Third GTask is Completed");
		
  }
  
  @AfterClass
  public void afterClass() {
      driver.quit();
  }
}
