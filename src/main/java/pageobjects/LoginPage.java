package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class LoginPage extends Base{
	
	//Page Factory
			@FindBy(id="ap_email")
			WebElement email;
			
			@FindBy(id="continue")
			WebElement continueBtn;
			
			@FindBy(id="ap_password")
			WebElement password;
			
			@FindBy(id="signInSubmit")
			WebElement signIn;
			
			
			//initializing the Page Objects
			public LoginPage() {
				PageFactory.initElements(driver, this);
			}
			
			
			//Actions
			
			public void enterEmail(String e_mail) {
				email.sendKeys(e_mail);
			}
			
			public void selectContinue() {
				continueBtn.click();
			}
			
			public void enterPassword(String pwd) {
				password.sendKeys(pwd);
			}
			
			public HomePage selectSignIn() {
				signIn.click();
				
				return new HomePage();
			}

}
