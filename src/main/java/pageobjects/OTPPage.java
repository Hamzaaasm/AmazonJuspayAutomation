package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.Base;

public class OTPPage extends Base{
	
	@FindBy(id="cards-web-sdk-iframe")
	WebElement iframe;
	
	@FindBy(xpath="//input[@placeholder='Enter OTP:']")
	WebElement otpButton;
	
	
	//initializing the Page Objects
	public OTPPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void switchToIframe() {
		driver.switchTo().frame(iframe);
	}
	
	public boolean validateOTPField(){
		return otpButton.isEnabled();
		
	}
	
}