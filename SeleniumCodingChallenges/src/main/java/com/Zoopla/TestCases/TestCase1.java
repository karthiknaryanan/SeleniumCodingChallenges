package com.Zoopla.TestCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Zoopla.Base.BaseTest;
import com.Zoopla.Pages.HomePage;
import com.Zoopla.Pages.PropertyForSalePage;

public class TestCase1 extends BaseTest {
	
	@Test
	public void testRun() {
		
		 HomePage homePage = new HomePage();
		 WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(HomePage.inputLocation));
		HomePage.enterLocation();
		HomePage.search();
		
		PropertyForSalePage forSalePage = new PropertyForSalePage();
		forSalePage.getPropertiesList();
		
		
	}
	
	

}
