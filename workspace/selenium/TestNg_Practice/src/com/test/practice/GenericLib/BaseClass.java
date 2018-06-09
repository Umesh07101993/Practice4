package com.test.practice.GenericLib;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void configBC(String browserName)
	{
		if(browserName.equals("firefox")){
			driver= new FirefoxDriver();
		}else if(browserName.equals("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	@BeforeMethod
	public void configBM()
	{
		driver.get("http://localhost:80");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		
		while(true)
		{
			try
			{
				driver.findElement(By.id("loginButton")).click();
				break;
			}catch(Exception ae)
			{
			System.out.println("Login exception handled");	
			}
			
		}
	}
	@AfterMethod
	public void configAM()
	{
		while(true)
		{
			try{
		driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
		break;}
			catch(Exception ae)
			{
				System.out.println("Logout exception handled");
			}
		}
	}
	@AfterClass
	public void configAC()
	{
		driver.close();
	}
}
