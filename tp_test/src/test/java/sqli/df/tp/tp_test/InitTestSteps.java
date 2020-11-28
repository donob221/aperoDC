package sqli.df.tp.tp_test;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InitTestSteps {
	private InitTest initTest;
	
	@Given("^I want to configure my firefox browser$")
	public void i_want_to_configure_my_firefow_browser() throws Throwable {
		initTest = new InitTest();
		initTest.configureFirefoxBrowser();
	}
	
	@When("^I navigate to Google$")
	public void i_navigate_to_google() throws Throwable {
		initTest.navigateToGoogle();
	}
	
	@Then("^the title of the web page is Google$")
	public void the_title_of_the_web_page_is_google() throws Throwable {
		Assert.assertTrue("Title does match", initTest.getDriver().getTitle().equals("Google"));
	}
	
	@And("^I want to close my browser$")
	public void i_want_to_close_my_browser() throws Throwable {
		initTest.closeBrowser();
	}
}
