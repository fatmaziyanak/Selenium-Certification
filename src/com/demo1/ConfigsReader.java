package com.demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


	public class ConfigsReader {

WebDriver driver;

//public static void main (String[] args) throws InterruptedException {
@Test	
public void validationViaLongWay () throws InterruptedException {
	System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
	
	driver = new FirefoxDriver();
	
	driver.get("https://www.seleniumeasy.com/test/");
	
	driver.manage().window().maximize();

	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(2000);
	driver.findElement(By.id("at-cv-lightbox-close")).click();
	
	//
	driver.findElement(By.id("btn_basic_example")).click();
	driver.findElement(By.linkText("Input Forms")).click();
	driver.findElement(By.linkText("Simple Form Demo")).click();
		
			
		 String filePath = System.getProperty("user.dir")+ "\\src\\Credentials.properties";
		
		 readProperties(filePath);
		 
        String firstNumber = getProperty("number1");
        String secondNumber = getProperty("number2");
     
      
		driver.findElement(By.id("sum1")).sendKeys(firstNumber);
		Thread.sleep(3000);
		driver.findElement(By.id("sum2")).sendKeys(secondNumber);
		driver.findElement(By.xpath("//button[@onclick='return total()']")).click();
		Thread.sleep(2000);
	
		
		String actualResult = driver.findElement(By.id("displayvalue")).getText();
		
		String expectedResult="12";
		Assert.assertEquals(actualResult, expectedResult); //validation
	    System.out.println("actual ->"+actualResult);
	
        driver.close();

		}

        private static Properties prop;

		public static Properties readProperties(String filePath) {

			try {

				FileInputStream fis = new FileInputStream(filePath);

				prop = new Properties();

				prop.load(fis);

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

			return prop;

		}



		public static String getProperty(String key) {

			return prop.getProperty(key);

		}

	
}
