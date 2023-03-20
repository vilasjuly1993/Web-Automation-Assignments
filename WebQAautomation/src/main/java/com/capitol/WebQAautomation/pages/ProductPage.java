package com.capitol.WebQAautomation.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.capitol.WebQAautomation.BaseWeb;
import com.capitol.WebQAautomation.utils.CommonUtils;
import com.capitol.WebQAautomation.utils.ScreenUtils;

public class ProductPage extends BaseWeb{

	public  Actions action= null;
	public ScreenUtils screenutils=null;

	public  void selectLatestProducts() throws IOException {

		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[1]/div/div/a/div/strong")).click();
		CommonUtils.delay(3); 
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[3]/div/div/div[4]/button")).click();
		CommonUtils.delay(3);   
		for(int i=0;i<=1;i++) {
			driver.navigate().back();
		}

		CommonUtils.delay(3);     
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[3]/div/div/a/div/strong")).click();
		CommonUtils.delay(3); 
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[3]/div/div/div[4]/button")).click();
	}
	public void selectQuantity(String nos1,int dropdownno) {
		try {
			for(int i=0;i<dropdownno;i++) 
			{
				String xpath="//*[@id=\"root\"]/main/div/div[2]/div[1]/div[1]/div[{num}]/div/div[4]/select";
				xpath=xpath.replace("{num}",String.valueOf(i+1));
				WebElement dropdown1=  driver.findElement(By.xpath(xpath));

				Select selectdropdown= new Select(dropdown1);
				CommonUtils.delay(3); 
				selectdropdown.selectByVisibleText(nos1);
				CommonUtils.delay(3); 
			}
			// proceed to checkout
			driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/div/div[3]/button")).click();
			CommonUtils.delay(3);


		}catch(Exception e) {
			e.printStackTrace();
		}

	}


	public void enterAddress(String ad1,String ad2,String cityname,String statename,String countryname,String postalcode,String phonenumber)
	{
		action=new Actions(driver);

		try {
			driver.findElement(By.xpath("//*[@id=\"addressLine1\"]")).sendKeys(ad1);
			driver.findElement(By.xpath("//*[@id=\"addressLine2\"]")).sendKeys(ad2);

			driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(cityname);
			driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys(statename);
			CommonUtils.delay(3);
			WebElement dropdown=  driver.findElement(By.xpath("//*[@id=\"country\"]"));
			CommonUtils.delay(3);
			Select  select =new Select (dropdown);
			select.selectByVisibleText(countryname);
			CommonUtils.delay(3);
			driver.findElement(By.xpath("//*[@id=\"postalCode\"]")).sendKeys(postalcode);
			CommonUtils.delay(3);
			driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys(phonenumber);
			CommonUtils.delay(3);
			action.keyDown(Keys.PAGE_DOWN).build().perform();
			CommonUtils.delay(3);
			driver.findElement(By.xpath("//button[text()='Add New Address']")).click();
			CommonUtils.delay(3);
			//
			WebElement selectaddress= driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[3]/div[1]/div[1]/div/div/div[1]/div/input"));
			selectaddress.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void payment() {
		try {
			driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[4]/button")).click();
			CommonUtils.delay(3);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}








