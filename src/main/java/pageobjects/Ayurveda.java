package pageobjects;


import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class Ayurveda extends Base{
	
	//Page Factory
	@FindBy(xpath="//span[contains(text(),'Dabur Jamun Neem Karela Juice - 1L | Hel…')]")
	WebElement karelaJuice;
	
	
	//initializing the Page Objects
	public Ayurveda() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public ProductInfo selectKarelaJuice() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(karelaJuice)).click();
		
		return new ProductInfo();
	}

}
