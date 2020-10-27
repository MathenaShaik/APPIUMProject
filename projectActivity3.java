package Appium.Appitumtest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class projectActivity3 {
	AppiumDriver<MobileElement> driver = null;
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
  public void googleKeepNoteWithReminder() throws InterruptedException {
	  
	  NoteTitle = "Complete activity with Google Keep Note With Reminder";
	  NoteDesc = "This note has been created in Google Keep for testing note with reminder";
	  
	  Thread.sleep(3000);
	  //Adding Note 
	  driver.findElementById("com.google.android.keep:id/new_note_button").click();
	  Thread.sleep(1000);
	  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys(NoteTitle);
	  Thread.sleep(1000);
	  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys(NoteDesc);
	  Thread.sleep(1000);
	  
	  
			
  }
  
  @AfterClass
  public void afterClass() {
      driver.quit();
  }
}
