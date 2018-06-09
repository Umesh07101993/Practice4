package com.actitime.projectandcustomertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.genericlib.FileDataUtils;
/**
 * 
 * @author UMESH.S
 *
 */
public class CustomerTest {

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
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		
		driver.findElement(By.id("loginButton")).click();
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='TASKS']/..")));
		
				driver.findElement(By.xpath("//div[text()='TASKS']/..")).click();
*/
		for(int i=1;i<=numOfCustomers;i++)
		{
			String customerName = lib.getExcelData("Sheet1", i, 1);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[text()='Add New']")).click();
				
				driver.findElement(By.xpath("//div[@class='item createNewCustomer ellipsis']")).click();
				
				
				driver.findElement(By.id("customerLightBox_nameField")).sendKeys(customerName);
			
				
				driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
			
		
		}	
		

	}

}
