package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class HealthAndPC extends Base{
	
	//Page Factory
			@FindBy(xpath="//span[text()='Ayurveda']")
			WebElement ayurveda;
			
			
			//initializing the Page Objects
			public HealthAndPC() {
				PageFactory.initElements(driver, this);
			}
			
			
			//Actions
			
			public Ayurveda selectAyurveda() {
				ayurveda.click();
				
				return new Ayurveda();
			}
			
		

}
