package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class ShoppingCart extends Base{
	
	//Page Factory
		@FindBy(name="proceedToRetailCheckout")
		WebElement proceedToBuy;
		
		
		//initializing the Page Objects
		public ShoppingCart() {
			PageFactory.initElements(driver, this);
		}
		
		
		//Actions
		
		public CheckOut selectProceedToBuy() {
			proceedToBuy.click();
			
			return new CheckOut();
		}

}
