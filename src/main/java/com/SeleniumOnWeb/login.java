package com.SeleniumOnWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Random;

public class login {
	public static void main(String []args) throws InterruptedException {
		System.out.println("start selenium");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wuziqi123.com/");
		int time = 30;
		Random random = new Random();
		while(time-- != 0){
			int num = random.nextInt();
			num = (num%225+225)%225 +1;
			String path = "//*[@id='rb']/div/div[1]/div["+num+"]";
			System.out.println(path);
			By path_xy = By.xpath(path);
			driver.findElement(path_xy).click();
		}
		Thread.sleep(50000);
		driver.close();
	}
}
