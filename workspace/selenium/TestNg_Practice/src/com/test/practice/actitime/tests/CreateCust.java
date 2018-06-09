package com.test.practice.actitime.tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.test.practice.GenericLib.BaseClass;

public class CreateCust extends BaseClass
{
	
	@Test
	public void CreateCustomer()
	{
		while(true)
		{
			try{
		driver.findElement(By.xpath("//a[@href='/tasks/tasklist.do']")).click();
		break;
			}
			catch(Exception ae)
			{
				System.out.println("tasks Exception handled");
			}
		}
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.xpath("//div[@class='item createNewCustomer ellipsis']")).click();
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys("umesh_7");
		driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
	}

}
