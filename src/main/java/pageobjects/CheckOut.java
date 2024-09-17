package pageobjects;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class CheckOut extends Base{
	
	//Page Factory
			@FindBy(xpath="//a[@id='add-new-address-popover-link']")
			WebElement addNewAddress;
			
			@FindBy(id="address-ui-widgets-enterAddressFullName")
			WebElement fullName;
			
			@FindBy(id="address-ui-widgets-enterAddressPhoneNumber")
			WebElement phoneNumber;
			
			@FindBy(id="address-ui-widgets-enterAddressPostalCode")
			WebElement pinCode;
			
			@FindBy(id="address-ui-widgets-enterAddressLine1")
			WebElement houseNum;
			
			@FindBy(id="address-ui-widgets-enterAddressLine2")
			WebElement street;
			
			@FindBy(xpath="//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
			WebElement useThisAddressBtn;
			
			
			//initializing the Page Objects
			public CheckOut() {
				PageFactory.initElements(driver, this);
			}
			
			
			//Actions
			
			public void selectAddNewAddress() {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOf(addNewAddress)).click();;
			}
			
			public void enterFullName(String Name) {        
				fullName.sendKeys(Name);
	        }
	              
			
			public void enterPhoneNum(String contact) {
				phoneNumber.sendKeys(contact);
			}
			
			public void enterPinCode(String postalCode) {
				pinCode.sendKeys(postalCode);
			}
			
			public void enterHouseNumber(String h_Number) {
				houseNum.sendKeys(h_Number);
			}
			
			
			public void enterStreet(String str) {
				street.sendKeys(str);
			}
		
			public PaymentDetailsPage selectAddressButton() {
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//				wait.until(ExpectedConditions.visibilityOf(useThisAddressBtn)).click();
				
				return new PaymentDetailsPage();
			}

}
