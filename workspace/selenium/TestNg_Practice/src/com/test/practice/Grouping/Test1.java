package com.test.practice.Grouping;

import org.testng.annotations.Test;

public class Test1 
{

		@Test(groups={"smokeTest","regressionTest"},priority=2)
		public void CreateCust()
		{
			System.out.println("Create Customer");
		}
		
		@Test(groups={"regressionTest"})
		public void modifyCust()
		{
			System.out.println("Modify Customer");
		}
		
		@Test(groups={"smokeTest","regressionTest"},priority=1)
		public void DeleteCust()
		{
			System.out.println("Delete Customer");
		}
		
		@Test(groups={"regressionTest"})
		public void verifyErrors()
		{
			System.out.println("Validating error message's");
		}
}
