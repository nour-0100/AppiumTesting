package mobileTestingProject;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.net.URL;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class myClass extends Parameter{

	DesiredCapabilities Caps = new DesiredCapabilities();
	AndroidDriver driver ;
	
	@BeforeTest 
	public void mySetup() {
		Caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		Caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Nour");
		File myapplication = new File ("src/MyApplications/calculator.apk");
		Caps.setCapability(MobileCapabilityType.APP,myapplication.getAbsolutePath());


		
	}
	@Test (enabled = false)
	public void ClickOnAllButtons () throws IOException {
		driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),Caps);
		List<WebElement>AllButtons = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i = 0 ; i < AllButtons.size();i++) {
			
			AllButtons.get(i).click();
		}
		
		WebElement Results = driver.findElement(By.id("com.google.android.calculator:id/result_preview"));
		String AcutalValue = Results.getText();
		String ExpectedValue = "Format error";
		AssertJUnit.assertEquals(AcutalValue, ExpectedValue);
		takeScreenShotFunction(driver);
	}
	@Test 
	public void ClickOnNumbersOnly ()throws IOException {
		driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),Caps);
		
		String ExpectedValue = "7894561230";
		String ActualValue = "";

		List<WebElement>AllButtons = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i = 0 ; i < AllButtons.size();i++) {
			
			if (AllButtons.get(i).getAttribute("resource-id").contains("digit")) {
			AllButtons.get(i).click();
			
}
			WebElement Formula = driver.findElement(By.id("com.google.android.calculator:id/formula"));
			String Actual = Formula.getText();
			ActualValue = Actual ;
		}
		AssertJUnit.assertEquals(ActualValue, ExpectedValue);
		takeScreenShotFunction(driver);
	}
	@Test
	public void checkTime () {
	Date date = new Date();
	System.out.println(date.toString().replace(":", "-"));
	}
}
