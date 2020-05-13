package com.Zoopla.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseTest {

	public static WebDriver driver;
	public static Properties properties;
	public static FileInputStream fis;

	public void loadProperty() {

		properties = new Properties();
		try {
			fis = new FileInputStream("C:\\SeleniumCodingChallenges\\config.properties");
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void initialize() {

		String browser = properties.getProperty("browser").toLowerCase();
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\91701\\Desktop\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\91701\\Desktop\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		loadProperty();
		initialize();
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement cookie = driver.findElement(By.xpath("(//button[text()='Accept all cookies'])[2]"));
		cookie.click();
	}

	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */

}
