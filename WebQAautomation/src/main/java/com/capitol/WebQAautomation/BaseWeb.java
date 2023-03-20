package com.capitol.WebQAautomation;

import java.time.Duration;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseWeb 
{

	Logger log = Logger.getLogger(BaseWeb.class.getName());
	public static WebDriver driver = null;
	public static WebDriverWait explicitWait = null;
	public static FluentWait<WebDriver> fluentWait = null;
	public final int TIME_OUT = 10;

	//protected static RemoteWebDriver driver = null;

	public void initialiseDriver() {
		log.info("Starting...");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\QQA0220\\eclipse-workspace\\WebQAautomation\\Library\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("http://139.59.27.246:3000/login?redirect=/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	public void endDriver() {
		driver.quit();
	}

}
