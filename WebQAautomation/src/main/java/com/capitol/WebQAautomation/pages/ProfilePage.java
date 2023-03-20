package com.capitol.WebQAautomation.pages;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capitol.WebQAautomation.BaseWeb;
import com.capitol.WebQAautomation.utils.CommonUtils;

public class ProfilePage extends BaseWeb {

	public void SwitchToApplicationWindow() {
		String parent= driver.getWindowHandle();
		driver.switchTo().window(parent);
		String title=driver.getTitle();
		System.out.println("current window ttile "+title);
		Set<String> browser=driver.getWindowHandles();
		int a=browser.size();
		System.out.println(a);
		CommonUtils.delay(3);
	}
	public void selectProfile() {
		try {
			CommonUtils.delay(3);
			driver.findElement(By.id("username")).click();
			
			driver.findElement(By.linkText("Profile")).click();
			CommonUtils.delay(10);
            
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void updateprofile() {

		try{
			
			driver.findElement(By.id("password")).sendKeys("vilas1234");
			
			driver.findElement(By.id("confirmPassword")).sendKeys("vilas1234");
			
		WebElement ole=	driver.findElement(By.xpath("//button[text()='Update']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ole)); 
		ole.click();
			CommonUtils.delay(3);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
		

}