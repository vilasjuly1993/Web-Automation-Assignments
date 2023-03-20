package com.capitol.WebQAautomation.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.capitol.WebQAautomation.pages.LoginPage;

public class ScreenUtils extends LoginPage{
	     
	 public static void captureScreen(String filePath){
	        TakesScreenshot takeScreenshot = ((TakesScreenshot) driver);
	        File screenFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
	        File destFile = new File(filePath);
	        try {
	            FileHandler.copy(screenFile, destFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
