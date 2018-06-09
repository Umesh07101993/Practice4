package com.test.practice.actitime.tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.test.practice.GenericLib.BaseClass;

public class createpro extends BaseClass
{
	@Test
	public void CreateProject()
	{
		while(true)
		{
			try{
		driver.findElement(By.xpath("//a[@href='/tasks/tasklist.do']")).click();
		break;
			}
			catch(Exception ae)
			{
				System.out.println("Exception handled");
			}
		}
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.xpath("//div[@class='item createNewProject ellipsis']")).click();
		driver.findElement(By.id("projectPopup_projectNameField")).sendKeys("umesh_project25");
		driver.findElement(By.xpath("//button[text()='-- Please Select Customer to Add Project for  --']")).click();
		driver.findElement(By.xpath("//a[text()='CUSTOMER1']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
	}
}
