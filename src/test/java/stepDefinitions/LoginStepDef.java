package stepDefinitions;

import org.pages.LoginPage;
import org.testng.Assert;

import applicationHooks.AppHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	LoginPage lp_Obj = new LoginPage(AppHooks.driver);
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		AppHooks.driver.get(AppHooks.prop.getProperty("url"));
	}
	@Then("Username field is displayed")
	public void username_field_is_displayed() {
		Assert.assertTrue(lp_Obj.isUserNameFieldDisplayed());
	}
	@Then("Password field is displayed")
	public void password_field_is_displayed() {
		Assert.assertTrue(lp_Obj.isPasswordFieldDisplayed());
	}
	@Then("Login button is displayed")
	public void login_button_is_displayed() {
		Assert.assertTrue(lp_Obj.isLoginBtnDisplayed());
	}
	@Then("Keep me login checkbox is displayed")
	public void keep_me_login_checkbox_is_displayed() {
		Assert.assertTrue(lp_Obj.isKeepMeLognChkBoxDisplayed());
	}
	@Then("Actitime logo is displayed")
	public void actitime_logo_is_displayed() {
		Assert.assertTrue(lp_Obj.isLoginLogosDisplayed());
	}
	@When("User enters username")
	public void user_enters_username() {
		lp_Obj.enterUserName(AppHooks.prop.getProperty("uName"));
	}
	@When("User enters password")
	public void user_enters_password() {
		lp_Obj.enterPassword(AppHooks.prop.getProperty("pwd"));
	}
	@When("Clicks on login button")
	public void clicks_on_login_button() {
		lp_Obj.clickLoginBtn();
	}
	@Then("Dashboard URL should be displayed as {string}")
	public void dashboard_url_should_be_displayed_as(String expURL) {
		lp_Obj.verifyDashboardUrl(expURL);
	}
	@Then("Dashboard page title should be displayed as {string}")
	public void dashboard_page_title_should_be_displayed_as(String expTitle) {

	}
	@Then("{int} tabs should be displayed")
	public void tabs_should_be_displayed(Integer expTabNumber) {
		
	}
}