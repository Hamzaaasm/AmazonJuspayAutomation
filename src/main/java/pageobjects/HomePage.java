package pageobjects;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class HomePage extends Base{
	
	//Page Factory
		@FindBy(id="nav-link-accountList")
		WebElement account;
		
		@FindBy(linkText="Health, Household & Personal Care")
		WebElement healthAndPC;
		
		
		//initializing the Page Objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		
		//Actions
		
		public LoginPage selectAccount() {
			account.click();
			return new LoginPage();
		}
		
		public HealthAndPC selectHealthAndPC(){
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(healthAndPC)).click();
			
			return new HealthAndPC();
		}

}
