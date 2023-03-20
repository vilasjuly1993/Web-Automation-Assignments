package com.capitol.WebQAautomation.utils;

public class CommonUtils {

	public static void delay() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void delay(int sec) {
		try { Thread.sleep(sec * 1000); } catch (InterruptedException e) { e.printStackTrace(); }
	}

}
