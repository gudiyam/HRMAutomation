package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListernTestNG extends TestBase implements ITestListener{
	
	public void onStart(ITestContext context) {
		
		System.out.println("This is the method of onStart listners");
	}
   public void onFinish(ITestContext context) {
	   
	   System.out.println("This is the method of onFinish listners");
   }
   public void 	onTestStart(ITestResult result) {
	   
	   System.out.println("This is the method of onTestStart listners");
   }
   public void 	onTestSuccess(ITestResult result) {
	   
	   System.out.println("This is the method of onTestSuccess listners");
   }
   public void 	onTestFailure(ITestResult result) {
	   try {
	   System.out.println(result.getName());
	   System.out.println(driver.getCurrentUrl());
	  
	   TakesScreenshot ts =(TakesScreenshot)driver;
	   File source =ts.getScreenshotAs(OutputType.FILE);
	   String fileName = result.getName() + ".png";
	   File dest = new File("Screenshots",fileName);
	  
		FileUtils.copyFile(source, dest);
	} catch (IOException e) {
		e.printStackTrace();
	}
	   
	   
   }
}
