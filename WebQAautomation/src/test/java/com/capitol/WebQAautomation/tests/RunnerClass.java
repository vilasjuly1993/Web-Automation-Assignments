package com.capitol.WebQAautomation.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capitol.WebQAautomation.BaseTest;
import com.capitol.WebQAautomation.pages.LoginPage;
import com.capitol.WebQAautomation.pages.PaymentPage;
import com.capitol.WebQAautomation.pages.ProductPage;
import com.capitol.WebQAautomation.pages.ProfilePage;

public class RunnerClass extends BaseTest{
	public  static LoginPage loginpage= new LoginPage();
	public static ProductPage pdp=new ProductPage();
	public static PaymentPage pay=new PaymentPage();
	public static ProfilePage profile=new ProfilePage();

	@Test(priority=1)
	public static void  navigate() {
		loginpage.navigateToURL();
	} 
	
	@Test(priority=2,enabled=true)
	public static void invalidcred() {
		loginpage.signInwithinvalidcred();
	}
	@Test(priority=3,enabled=false)
	public static void reLaunch() {
		loginpage.reLaunchToLoginPage();

	}
	@Test(priority=4)
	public static void validCred() {
		loginpage.signInwithvalidcred();
	}
	@Test(priority=5)
	public static void selectproducts() throws IOException {
		pdp.selectLatestProducts();
	}
	@Test(priority=6)
	public static void selectProductQuantity() {
		pdp.selectQuantity("5",2);
	}
	@Test(priority=7,dataProvider="address")
	public void provideaddress(String adl1,String adl2,String city,String state,String country,String pcode,String phone) {


		pdp.enterAddress(adl1,adl2,city,state,country,pcode,phone);

	}

	@Test(priority=8)
	public static void proceedToPayment() {
		pdp.payment();
	}
	@Test(priority=9)
	public void addCardDetails(){
		pay.addCard();

	}
	@Test(priority=10)
	public static void validatePaymentSuccessful() {
		pay.VerifyReceiptPage();
	}


	@DataProvider(name = "address")
	public Object[][] giveaddress(){

		Object[][] allCredentials = {{"rpc layout","hampinagar","bangalore","karnatka","India","560040","8886663333"}};


		return allCredentials;
	}

	@Test(priority=11)
	public static void SwitchToParentWindow() {
		profile.SwitchToApplicationWindow();

	}
	@Test(priority=12)
	public static void NavigatetoProfile() {
		profile.selectProfile();

	}
	@Test(priority=13)
	public static void modifyUser() {
		profile.updateprofile();
	}
	@Test(priority=14)
	public static void logout() {
		loginpage.logoutAction();
	}
	@Test(priority=15)
	public static void loginwithModifiedpassword() {
		loginpage.loginWithnewPassword();
	}

}

