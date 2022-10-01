package com.amazon;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class OnlineShoping {
	
	public static WebDriver driver;
	
	
	
	@BeforeSuite
	public void setProperty() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Naveen Krish Kalyan\\eclipse-workspace\\AmazonTestNG\\driver\\chromedriver.exe");
	}
	
	@BeforeTest
	public void browser() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
	}

	@BeforeClass
	public void pageURL() {
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void login() throws Throwable {
		
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='nav-action-button'])[1]")).click();
		driver.findElement(By.name("email")).sendKeys("naveenkrishkalyan1998@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Naveenkrish@98");
		driver.findElement(By.id("signInSubmit")).click();
	}
	
	//@Ignore
	@Test(priority = 3)
	public void searchRedmi() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Redmi note 5 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
	}
	
	//@Ignore
	@Test(priority = 1)
	public void searchSamsungFridge() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung fridge");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
	}
	
	//@Ignore
	@Test(priority = 2)
	public void voltasAC() {
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("voltas ac 1.5 ton 5 star");
		driver.findElement(By.id("nav-search-submit-button")).click();
	}
	
	
	
	@AfterMethod
	public void validation() {
		
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.id("nav-link-accountList"))).perform();
		ac.moveToElement(driver.findElement(By.id("nav-item-signout"))).click().perform();
		
//		String Expected = "https://www.amazon.in/s?k=redmi+note+5+pro&crid=FCWOYFJR5OZ8&sprefix=redmi+note+5+pro%2Caps%2C295&ref=nb_sb_noss_1";
//		System.out.println(Expected);
//		String actual = driver.getCurrentUrl();
//		System.out.println(actual);
//		assertEquals(Expected, actual);
	}
	
	@AfterClass
	public void logOut() {
//		Actions ac = new Actions(driver);
//		ac.moveToElement(driver.findElement(By.id("nav-link-accountList"))).perform();
//		ac.moveToElement(driver.findElement(By.id("nav-item-signout"))).click().perform();
	}
	
	@AfterTest
	public void browserClose() {
		//driver.quit();
	}
	
	@AfterSuite
	public void cookies() {
	//	driver.manage().deleteAllCookies();
	}
	

}
