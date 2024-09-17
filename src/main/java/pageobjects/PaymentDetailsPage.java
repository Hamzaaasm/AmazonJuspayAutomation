package pageobjects;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class PaymentDetailsPage extends Base{
	
	
	@FindBy(xpath="//input[@value='instrumentId=0h_PE_CUS_9af224c4-36d9-49fb-8f64-dc890d547509&isExpired=false&paymentMethod=CC&tfxEligible=false']")
	WebElement cardRadioBtn;
	
	
	@FindBy(xpath="//span[@class='a-button-inner']//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']")
	WebElement paymentBtn;
		
	@FindBy(xpath="//input[@aria-labelledby='bottomSubmitOrderButtonId-announce']")
	WebElement placeOrderBtn;
	
	
	
	//initializing the Page Objects
	public PaymentDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectCard() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(cardRadioBtn)).click();
	}
	

	
	public void selectUseThisPaymentMethod() {
		paymentBtn.click();
	}
	
	
	public OTPPage selectPlaceOrder() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOf(placeOrderBtn)).click();
		return new OTPPage();
		

	}
	

}
