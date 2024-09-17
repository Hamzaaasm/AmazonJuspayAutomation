package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class ProductInfo extends Base{

	@FindBy(name="submit.addToCart")
	WebElement addToCart;
	
	
	//initializing the Page Objects
	public ProductInfo() {
		PageFactory.initElements(driver, this);
	}
	
	public ShoppingCart selectAddToCart() {
		addToCart.click();
		
		return new ShoppingCart();
	}
	
}
