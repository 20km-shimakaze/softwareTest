package com.SeleniumOnWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.Set;


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
		String handle = driver.getWindowHandle();
		System.out.println(handle);
//		driver.close();
		Thread.sleep(2000);
//		driver.get("https://iwarship.net/wowsdb/index");
//		System.out.println(driver.findElement(By.xpath("/html/body/div/div[2]/div/div/span[2]/div/button")));
//		click_xpath("//*[@id=\"menu-item-25\"]");
		driver.switchTo().window(change(handle));
		click_xpath("/html/body/div/div[2]/div/div/span[2]/div/button/div/div/div");
//		click_id("ship-select");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/span[2]/div/div/div[1]/input")).sendKeys("布林迪西");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/span[2]/div/div/div[1]/input")).sendKeys(Keys.ENTER);
		click_xpath("//*[@id=\"table-hull-toolbar\"]/div[1]/button[1]");
		click_xpath("//*[@id=\"btn-table-hull-model-tonnage\"]");
		Thread.sleep(20000);
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
	public static String change(String handle)throws Exception{
		Set<String>se = driver.getWindowHandles();
		for(String str:se){
			if (!str.equals(handle)){
				return str;
			}
		}
		return null;
	}
}
