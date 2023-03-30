package com.SeleniumOnWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class WebTest {
	public static WebDriver driver;
	public static void main(String []args) throws Exception {
		System.out.println("start selenium");
//		System.setProperty("webdriver.edge.driver",
//				"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe");
		driver = new EdgeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://iwarship.net/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"menu-item-277\"]/a")).click();
		driver.findElement(By.id("username-128")).sendKeys("2801382156@qq.com");
		driver.findElement(By.id("user_password-128")).sendKeys("2801382156xxl");
		driver.findElement(By.id("um-submit-btn")).click();
		Thread.sleep(2000);
		click_id("menu-item-25");
		Thread.sleep(2000);
		driver.get("https://iwarship.net/wowsdb/index");
//		System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div/div/span[2]/div/button")));
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/span[2]/div/button")));
		action.moveToElement(ele);
//		click_xpath("/html/body/div/div[2]/div/div/span[2]/div/button");
		ele.click();
//		click_id("ship-select");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/span[2]/div/div/div[1]/input")).sendKeys("布林迪西");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/span[2]/div/div/div[1]/input")).sendKeys(Keys.ENTER);
		click_xpath("//*[@id=\"table-hull-toolbar\"]/div[1]/button[1]");
		click_xpath("//*[@id=\"btn-table-hull-model-tonnage\"]");
		Thread.sleep(10000);
		driver.close();
	}
	public static void click_xpath(String path) throws Exception {
		driver.findElement(By.xpath(path)).click();
		Thread.sleep(1000);
	}
	public static void click_id(String id) throws InterruptedException {
		driver.findElement(By.id(id)).click();
		Thread.sleep(1000);
	}
}
