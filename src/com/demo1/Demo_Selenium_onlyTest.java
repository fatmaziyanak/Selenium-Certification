package com.demo1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utils.Constants;

public class Demo_Selenium_onlyTest {

	WebDriver driver;
	
	/*
	 * This method will open webpage
	 */
	
	@Test
	public void test() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.get("https://www.seleniumeasy.com/test/");
		
		driver.manage().window().maximize();

		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("at-cv-lightbox-close")).click();
		
	
	/*
	 * This method will submit form same logic with login
	 */
	
	
	
		driver.findElement(By.id("btn_basic_example")).click();
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Simple Form Demo")).click();
			
		driver.findElement(By.id("sum1")).sendKeys("5");
		driver.findElement(By.id("sum2")).sendKeys("7");
		driver.findElement(By.xpath("//button[@onclick='return total()']")).click();
		Thread.sleep(2000);
		
		String actualResult = driver.findElement(By.id("displayvalue")).getText();
		
		
	
	/*
	 * This methods will apply radio button and check box
	 */
	
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Checkbox Demo")).click();
		WebElement ageCheckBox=driver.findElement(By.id("isAgeSelected"));
		//Checking if the checkbox is selected
		if(!ageCheckBox.isSelected()) {
			ageCheckBox.click();//clicks only if not selected
		}
		Thread.sleep(2000);
		
		//to uncheck
		Thread.sleep(2000);
		ageCheckBox.click();
			
	
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		
		//This method will click radio button in order
	
//		List<WebElement> radioButtons = driver.findElements(By.name("optradio"));

//		for (int i = 0; i < radioButtons.size(); i++) {
//			
//			boolean isSelected=radioButtons.get(i).isSelected();
//
//			if(!isSelected) {
//
//			radioButtons.get(i).click();
//			Thread.sleep(1000);
//
//			}}
		
		//if we want to check only one radio button
		WebElement maleRadioB = driver.findElement(By.xpath("//input[@name='optradio' and @value='Male']"));

		Thread.sleep(2000);

		maleRadioB.click();
	
	
	
	/*
	 * This method will handle alert
	 */
	
	
		driver.findElement(By.linkText("Alerts & Modals")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	
	/*
	 * This method will read data from table
	 */
	

	
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
	//	List<WebElement> rows=driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));

	//	for(int i=0; i<rows.size(); i++) {

		//	String rowText=rows.get(i).getText();
		
	    //  System.out.println(rowText);}
		
		WebElement firstRow = driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr[1]"));
        System.out.println(firstRow.getText());
    	WebElement secondRow = driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr[2]/td[2]"));
        System.out.println(secondRow.getText());
	
	
	/*
	 * This method will validate the data
	 */
	
	
		
			driver.findElement(By.linkText("Input Forms")).click();
			driver.findElement(By.linkText("Simple Form Demo")).click();
				
			driver.findElement(By.id("sum1")).sendKeys("5");
			driver.findElement(By.id("sum2")).sendKeys("7");
			driver.findElement(By.xpath("//button[@onclick='return total()']")).click();
			Thread.sleep(2000);
			
			//This will write value of element
			String slogan = driver.findElement(By.id("site-slogan")).getText();
			System.out.println("Slogan of webpage is "+slogan);
			
			//Validation starts from here
			String actualResult1 = driver.findElement(By.id("displayvalue")).getText();
			
			String expectedResult="12";
			Assert.assertEquals(actualResult1, expectedResult); //validation
		    System.out.println("actual ->"+actualResult1);
		
	/*
	 * This method will handle windows
	 */
			
		driver.findElement(By.linkText("Alerts & Modals")).click();
		driver.findElement(By.linkText("Window Popup Modal")).click();
		driver.findElement(By.xpath("//a[@title='Follow @seleniumeasy on Facebook']")).click();
		Thread.sleep(2000);
		
		Set <String> allwindowsID=driver.getWindowHandles();
				
		//How many windows are opened

		System.out.println("How man Windows opened: "+allwindowsID.size());

		//To get each id from the iterator above, we use iterator

		Iterator<String> it = allwindowsID.iterator();

		//get the first id

		String parentW = it.next();

		//get the second id

		String childW = it.next();	
		
		//to go facebook page

		driver.switchTo().window(childW);

		driver.manage().window().maximize();
		
		System.out.println("Title of child window is "+driver.getTitle());
		
		driver.switchTo().window(parentW);
	    
		System.out.println("Title of main window is "+driver.getTitle());

	
		driver.quit();

}}
