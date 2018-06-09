package com.actitime.projectandcustomertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.actitime.genericlib.FileDataUtils;

/**
 * 
 * @author UMESH.S
 *
 */
public class ProjectTest 
{

	public static void main(String[] args) throws Throwable
	{
		FileDataUtils lib = new FileDataUtils();
		String url = lib.getPropertyObj().getProperty("url");
		String username = lib.getPropertyObj().getProperty("username");
		String password = lib.getPropertyObj().getProperty("password");
		
		int numOfCustomers = lib.getExcelRowNum("Sheet1");
		
		
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for(int i=1;i<=numOfCustomers;i++)
		{
			driver.get(url);

		driver.findElement(By.id("username")).sendKeys(username);
		
		driver.findElement(By.name("pwd")).sendKeys(password);
		
		driver.findElement(By.id("loginButton")).click();
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='TASKS']/..")));
		
				driver.findElement(By.xpath("//div[text()='TASKS']/..")).click();
*/
		
			String projectName = lib.getExcelData("Sheet2", i, 1);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[text()='Add New']")).click();
				
				driver.findElement(By.xpath("//div[@class='item createNewProject ellipsis']")).click();
				
				
				driver.findElement(By.id("projectPopup_projectNameField")).sendKeys(projectName);
				
				driver.findElement(By.xpath("//button[text()='-- Please Select Customer to Add Project for  --']")).click();
				
				driver.findElement(By.xpath("//a[text()='CUSTOMER1']")).click();
			
				
				driver.findElement(By.xpath("//span[text()='Create Project']")).click();
				
				driver.findElement(By.id("logoutLink")).click();
			
		
		}	
		


	}

}
