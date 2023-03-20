package com.capitol.WebQAautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.capitol.WebQAautomation.BaseWeb;
import com.capitol.WebQAautomation.utils.ScreenUtils;
import com.qapitol.webautomation.utils.CommonUtils;

public class LoginPage extends BaseWeb {
	public  ScreenUtils screenutils=null;
	public  void navigateToURL() {
		try {

			driver.get("http://139.59.27.246:3000/login?redirect=/");
			CommonUtils.delay(2);
			String Expected="Sign In";

			String Actual= driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/h1")).getText();
			CommonUtils.delay(2);
			Assert.assertEquals(Expected, Actual);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public   void signInwithinvalidcred() {
		try {
			driver.findElement(By.id("userNameOrEmail")).sendKeys("bhbss");
			CommonUtils.delay(3);
			driver.findElement(By.id("password")).sendKeys("xhshss");
			CommonUtils.delay(3);
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			CommonUtils.delay(3);
			ScreenUtils.captureScreen("C:\\Users\\QQA0220\\Desktop\\Screenshot\\xcopy2.png");
			CommonUtils.delay(3);

			String actual=driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/div[1]/div")).getText();
			String expected="\"Bad credentials\"";
			Assert.assertEquals(actual, expected);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public  void reLaunchToLoginPage() {
		try {
			driver.close();
			driver=new ChromeDriver();
			CommonUtils.delay();
			driver.manage().window().maximize();
			CommonUtils.delay();
			driver.navigate().to("http://139.59.27.246:3000/login?redirect=/");
			CommonUtils.delay();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void signInwithvalidcred() {
		try {
			driver.findElement(By.id("userNameOrEmail")).clear();
			driver.findElement(By.id("userNameOrEmail")).sendKeys("demo1@gmail.com");
			CommonUtils.delay();
			driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("vilas1234");
			CommonUtils.delay();
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			CommonUtils.delay(5);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void logoutAction() {
		try {
			Thread.sleep(3000);
			driver.findElement(By.id("username")).click();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}catch(Exception e) {
		e.printStackTrace();
	}
		
}
	public void loginWithnewPassword() {
		try {
			driver.findElement(By.id("userNameOrEmail")).clear();
			driver.findElement(By.id("userNameOrEmail")).sendKeys("demo1@gmail.com");
			CommonUtils.delay();
			driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("vilas1234");
			CommonUtils.delay();
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			CommonUtils.delay(5);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
}


