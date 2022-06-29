package org.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.utilities.BaseUtility;

public class LoginPage {
	private WebDriver driver;
	
	//older way
//	WebElement loginHeaderLabel =
//			driver.findElement(By.cssSelector("#headerContainer"));
	
	//WebElements
	@FindBy(css="#headerContainer")
	private WebElement loginHeaderLabel;
	
	@FindBy(id="username")
	private WebElement userNameTxtField;
	
	@FindBy(xpath="//input[@name='pwd']")
	private WebElement passwordTxtField;
	
	@FindBy(css="#loginButton>div")
	private WebElement loginBtn;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement keepMeLoginChkBox;
	
	@FindBy(css="#logoContainer img")
	private List<WebElement> loginLogos;
	//OR
	@FindBys(@FindBy(css="#logoContainer img"))
	private List<WebElement> loginLogos1;
	
	//OR & to find out multiple WebElements with multiple locators
	@FindAll({@FindBy(xpath="//input[@type='checkbox'"),
				@FindBy(xpath="//input[@type='radio'")})
	private List<WebElement> chkBoxRadioBtns;
	
	
	//Constructor
	public LoginPage(WebDriver driver) {
//		PageFactory.initElements(driver,LoginPage.class);
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	//Page action methods
	public boolean isUserNameFieldDisplayed() {
		return userNameTxtField.isDisplayed();
		//boolean flag = userNameTxtField.isDisplayed();
		//return flag;
	}
	public boolean isPasswordFieldDisplayed() {
		return passwordTxtField.isDisplayed();
	}
	public boolean isLoginBtnDisplayed() {
		return loginBtn.isDisplayed();
	}
	public boolean isKeepMeLognChkBoxDisplayed() {
		return keepMeLoginChkBox.isDisplayed();
	}
	public boolean isLoginLogosDisplayed() {
		if(loginLogos.size()==2) {
			return true;
		} else {
			return false;
		}
	}
	public void enterUserName(String uName) {
		userNameTxtField.sendKeys(uName);
		Assert.assertEquals(userNameTxtField.getAttribute("value"),uName);
		Reporter.log("getAttribute : "+userNameTxtField.getAttribute("value"));
		Reporter.log("Entered username as : "+uName);
	}
	public void enterPassword(String pwd) {
		passwordTxtField.sendKeys(pwd);
		Assert.assertEquals(passwordTxtField.getAttribute("value"),pwd);
		Reporter.log("Entered password.");
	}
	public void clickLoginBtn() {
		loginBtn.click();
		Reporter.log("Clicked on login button");
		BaseUtility bu = new BaseUtility();
		bu.waitForUrlContains(driver, 15, "submit_tt.do");
	}
	public void verifyDashboardUrl(String expURL) {
		String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, expURL,"Dashboard URL is changed !!!");
	}
}