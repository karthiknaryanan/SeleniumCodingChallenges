package com.Zoopla.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Zoopla.Base.BaseTest;

public class HomePage extends BaseTest {
	

	@FindBy(id = "search-input-location")
	public static WebElement inputLocation;

	@FindBy(id = "search-submit")
	public static WebElement searchBtn;
	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}

	public static void enterLocation() {
		inputLocation.sendKeys(properties.getProperty("Location"),Keys.TAB);
	}

	public static PropertyDetailsPage search() {
		searchBtn.click();
		return new PropertyDetailsPage();
	}

}
