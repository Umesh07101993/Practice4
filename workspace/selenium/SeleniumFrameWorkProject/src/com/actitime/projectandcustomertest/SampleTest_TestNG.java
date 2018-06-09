package com.actitime.projectandcustomertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest_TestNG 
{
	WebDriver driver;
	@BeforeClass
	public void configBC()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}
	@BeforeMethod
	public void configBM()
	{
		driver.get("http://localhost/login.do");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		
	}
	@Test
	public void CreateCustomerTest()
	{
		while(true)
		{
			try{
				driver.findElement(By.xpath("//div[text()='TASKS']/..")).click();
				break;
			}
			catch(Exception ae)
			{
				System.out.println("Handled tasks exception");
			}
		}
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		
		driver.findElement(By.xpath("//div[@class='item createNewCustomer ellipsis']")).click();
		
		
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys("HDFC_0001");
	
		
		driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
	
	}
	
	@Test
	public void ModifyCustomer()
	{
		while(true)
		{
			try{
				driver.findElement(By.xpath("//div[text()='TASKS']/..")).click();
				break;
			}
			catch(Exception ae)
			{
				System.out.println("Handled tasks exception");
			}
		}
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.xpath("//div[@class='item createNewCustomer ellipsis']")).click();
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys("HDFC_0001");
		driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
	}
	
	@AfterMethod
	public void configAM()
	{
		driver.findElement(By.id("logoutLink")).click();
	}
	@AfterClass
	public void configAC()
	{
		driver.close();
	}
	
}
