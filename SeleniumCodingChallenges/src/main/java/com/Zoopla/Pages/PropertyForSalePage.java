package com.Zoopla.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Zoopla.Base.BaseTest;



public class PropertyForSalePage extends BaseTest {
	
	
	
	@FindBy(xpath="//ul[@class='listing-results clearfix js-gtm-list']//*[@class='listing-results-price text-price']")
	public static List<WebElement> priceList;
	List<String > lst= new ArrayList<String>();
	
	
	public PropertyForSalePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void getPropertiesList() {
		for (WebElement webElement : priceList) {
			lst.add(webElement.getText());
			for (String string : lst) {
				String replace1 = string.replaceAll("£", "");
			}
		}
	
	}
}
