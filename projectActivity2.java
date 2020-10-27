package Appium.Appitumtest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class projectActivity2 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	String NoteTitle;
	String NoteDesc;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
	    // Set the Desired Capabilities
	    DesiredCapabilities caps = new DesiredCapabilities();
	    // caps.setCapability("deviceName", "<device name>");
	    caps.setCapability("deviceId", "-----");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("appPackage", "com.google.android.keep");
	    caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	    }
	
  @Test
  public void googleKeepNote() throws InterruptedException {
	  
	  NoteTitle = "Complete activity with Google Keep";
	  NoteDesc = "This note has been created in Google Keep for testing appium";
	  
			Thread.sleep(3000);
			//Adding Note 1//com.google.android.apps.tasks:id/tasks_fab
			driver.findElementById("com.google.android.keep:id/new_note_button").click();
			Thread.sleep(1000);
			driver.findElementById("com.google.android.keep:id/editable_title").sendKeys(NoteTitle);
			Thread.sleep(1000);
			driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys(NoteDesc);
			Thread.sleep(1000);
			
			//Press the back button and make an assertion to ensure that the note was added
			driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
			Thread.sleep(1000);
			
			String actNoteTitle = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
			System.out.println(actNoteTitle);
			
			Assert.assertEquals(actNoteTitle, NoteTitle);
			
			String actNoteDesc = driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
			System.out.println(actNoteDesc);
			
			Assert.assertEquals(actNoteDesc, NoteDesc);	
			
			//Delete Note
			driver.findElementById("com.google.android.keep:id/index_note_title").click();
			Thread.sleep(1000);
			//Click menu
			driver.findElementById("com.google.android.keep:id/bs_action_button").click();
			Thread.sleep(1000);
			
			//Click Delete
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.view.ViewGroup/"
					+ "android.widget.LinearLayout[2]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView").click();
			Thread.sleep(1000);
			
  }
  
  @AfterClass
  public void afterClass() {
      driver.quit();
  }
}
