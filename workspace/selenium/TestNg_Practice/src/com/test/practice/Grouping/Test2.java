package com.test.practice.Grouping;

import org.testng.annotations.Test;

public class Test2 
{
	@Test(groups={"smokeTest","regressionTest"})
	public void CreateTasks()
	{
		System.out.println("Create Task");
	}
	
	@Test(groups={"regressionTest"})
	public void modifyTasks()
	{
		System.out.println("Modify Tasks");
	}
	
	@Test(groups={"smokeTest","regressionTest"})
	public void DeleteTasks()
	{
		System.out.println("Delete Tasks");
	}
	
	@Test(groups={"regressionTest"})
	public void verifyErrors()
	{
		System.out.println("Validating error message's");
	}

}
