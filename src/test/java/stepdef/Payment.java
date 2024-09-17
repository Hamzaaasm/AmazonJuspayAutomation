package stepdef;

import org.junit.Assert;

import base.Base;
import io.cucumber.java.en.*;
import pageobjects.Ayurveda;
import pageobjects.CheckOut;
import pageobjects.HealthAndPC;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.OTPPage;
import pageobjects.PaymentDetailsPage;
import pageobjects.ProductInfo;
import pageobjects.ShoppingCart;

public class Payment extends Base{
	HomePage homePage;
	LoginPage loginPage;
	HealthAndPC healthAndPC;
	Ayurveda ayurveda;
	ProductInfo productInfo;
	ShoppingCart shoppingCart;
	CheckOut checkOut;
	PaymentDetailsPage paymentDetails;
	OTPPage otpPage;
	
	
	@Given("user visits amazon website")
	public void user_visits_amazon_website() {
		Base.initializeBrowser();
		homePage= new HomePage();
		loginPage = homePage.selectAccount();
	}
	
	
	@When("user logged-in using valid credentials")
	public void user_logged_in_using_valid_credentials() {
	   loginPage.enterEmail(prop.getProperty("email"));
	   loginPage.selectContinue();
	   loginPage.enterPassword(prop.getProperty("password"));
	   homePage = loginPage.selectSignIn();
	}
	
	
	@When("user select Health, Household and Personal Care section")
	public void user_select_health_household_and_personal_care_section() {
	    healthAndPC =homePage.selectHealthAndPC();
		
	}
	@When("user select and item from ayurveda and click on add to cart")
	public void user_select_and_item_from_ayurveda_and_click_on_add_to_cart() {
		ayurveda = healthAndPC.selectAyurveda();
		productInfo = ayurveda.selectKarelaJuice();
		shoppingCart = productInfo.selectAddToCart();
	    
	}
	@Then("user should be on shopping cart page")
	public void user_should_be_on_shopping_cart_page() {
		Assert.assertEquals("Amazon.in Shopping Cart", driver.getTitle());
	    
	}
	
	@When("user clicks on proceed to buy")
	public void user_clicks_on_proceed_to_buy() {
		checkOut = shoppingCart.selectProceedToBuy();
	}
	
	@Then("user should be on checkout page")
	public void user_should_be_on_checkout_page() {
	    Assert.assertEquals("Select a delivery address", driver.getTitle());
	}
	
	@When("user gives valid address")
	public void user_gives_valid_address() {
		checkOut.selectAddNewAddress();
		checkOut.enterFullName(prop.getProperty("name"));
		checkOut.enterPhoneNum(prop.getProperty("contact"));
		checkOut.enterPinCode(prop.getProperty("pin"));
		checkOut.enterHouseNumber(prop.getProperty("houseNumber"));
		checkOut.enterStreet(prop.getProperty("street"));
		paymentDetails = checkOut.selectAddressButton();
	}
	@When("user give payment details")
	public void user_give_payment_details() {
		paymentDetails.selectCard();
		paymentDetails.selectUseThisPaymentMethod();
		otpPage = paymentDetails.selectPlaceOrder();
		
	    
	}
	
	@Then("user should be on OTP page")
	public void user_should_be_on_otp_page() {
		otpPage.switchToIframe();
		boolean b = otpPage.validateOTPField();;
		Assert.assertTrue(b);
		if(b==true) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		
		Base.tearDown();
	}
	

}
