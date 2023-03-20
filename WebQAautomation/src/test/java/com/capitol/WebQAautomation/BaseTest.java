package com.capitol.WebQAautomation;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	BaseWeb baseWeb = new BaseWeb();

	@BeforeSuite
	public void setup() throws SecurityException, IOException {
		//InputStream inputStream = new FileInputStream(new File("logging.properties"));
		//LogManager.getLogManager().readConfiguration(inputStream);
				//propertyReader.loadProperties();
		baseWeb.initialiseDriver();
	}
	
	@AfterSuite
	public void endTest() {
		baseWeb.endDriver();
	}
}
