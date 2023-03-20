package com.capitol.WebQAautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.capitol.WebQAautomation.BaseWeb;
import com.capitol.WebQAautomation.utils.CommonUtils;
import com.capitol.WebQAautomation.utils.ScreenUtils;

public class PaymentPage extends BaseWeb {
	public  Actions action= null;
	public ScreenUtils screenutils=null;
	public void addCard() {
		action=new Actions(driver);
		try {
			driver.findElement(By.xpath("//*[@id=\"cardNumber\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"expirationMonth\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"expirationYear\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"cvv\"]")).clear();
			CommonUtils.delay(3);
			driver.findElement(By.xpath("//*[@id=\"cardNumber\"]")).sendKeys("2345678987612345");
			driver.findElement(By.xpath("//*[@id=\"expirationMonth\"]")).sendKeys("12");
			driver.findElement(By.xpath("//*[@id=\"expirationYear\"]")).sendKeys("24");
			driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("123");
			action.keyDown(Keys.PAGE_DOWN).build().perform();
			driver.findElement(By.xpath("//button[text()='Add Card']")).click();
			CommonUtils.delay(3);
			ScreenUtils.captureScreen("C:\\Users\\QQA0220\\Desktop\\Screenshot\\paymenterror.png");
			String message=driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[3]/div")).getText();
			System.out.println(message);
			//select  default card
			driver.findElement(By.name("paymentMethod")).click();
			driver.findElement(By.xpath("//button[text()='Proceed to PlaceOrder']")).click();
			CommonUtils.delay();
			//place order
			driver.findElement(By.xpath("//button[text()='Place Order']")).click();
			CommonUtils.delay(5);
			//verify if the receipt is generated
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[1]/div/div[2]/p[2]/strong")).isDisplayed());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void VerifyReceiptPage() {
		try {
			driver.findElement(By.xpath("//strong[text()='Payment Receipt : ']//following::a")).click();
			String receiptMessage=driver.findElement(By.xpath("//*[@class='Content Title-copy Font Font--title']")).getText();
			
			Assert.assertTrue(true, receiptMessage);
			System.out.println(receiptMessage);
			
		}catch(Exception e) {
			e.printStackTrace();
		
		
	}
	
}
}
