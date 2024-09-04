package com.demo.steps;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.pages.NoBrokerPayRent;
import com.demo.pages.NoBrokerRentalPage;
import com.demo.runner.DriverSetup;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	static WebDriver driver;
	WebDriverWait wait;
	NoBrokerRentalPage mainPage;
	NoBrokerPayRent rent;

	@Given("user must be on the homepage")
	public void user_must_be_on_the_homepage() {
		DriverSetup dri = new DriverSetup("chrome");
		driver = dri.initDriver();
		driver.get("https://www.nobroker.in/");
		driver.manage().window().maximize();

		mainPage = new NoBrokerRentalPage(driver);
		rent = new NoBrokerPayRent(driver);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------
	/*
	 * CREATED BY: KEERTHANA R
	 * REVIEWED BY: MEDHA JOSHI
	 * MOTIVE: THE USER SHOULD BE ABLE TO LOGIN WITH VALID OTP
	 */
	
//--------------------------------------------------------------------------------------------------------------------------------------------
	
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() 
	{
		mainPage.loginBtnClick();
	}
	@When("the user enters their phone number")
	public void the_user_enters_their_phone_number() 
	{
		mainPage.enterPhoneNumber();
	}

	@When("requests an OTP")
	public void requests_an_otp() 
	{

	}

	@When("the user receives an OTP on their registered phone number")
	public void the_user_receives_an_otp_on_their_registered_phone_number() 
	{

	}

	@When("the user enters the correct OTP")
	public void the_user_enters_the_correct_otp() 
	{
		mainPage.enterOTPNumber();
	}

	@Then("the user is successfully logged in")
	public void the_user_is_successfully_logged_in() 
	{
		mainPage.clickContinueButton();
		mainPage.assertValidOtp();
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------
		/*
		 * CREATED BY: KEERTHANA R
		 * REVIEWED BY: MEDHA JOSHI
		 * MOTIVE: THE USER SHOULD BE ABLE TO GENERATE RENT RECEIPTS WITH VALID DETAILS
		 */
//--------------------------------------------------------------------------------------------------------------------------------------------------

	@Given("user clicks on the menu button")
	public void user_clicks_on_the_menu_button() {
		mainPage.clickMenu();
	}

	@When("the user searches rent receipts and clicks")
	public void the_user_searches_rent_receipts_and_clicks() {
		mainPage.selectRentReceipt();
	}

	@When("the user is on the generate receipt page")
	public void the_user_is_on_the_generate_receipt_page() {

	}

	@When("user enters the valid details credentials")
	public void user_enters_the_valid_details_credentials() {
		mainPage.InputForReceipt();
	}

	@When("the user clicks on the generate receipts")
	public void the_user_clicks_on_the_generate_receipts() {
		mainPage.clickGenerateReceiptButton();
	}

	@Then("the user has created the rent receipts")
	public void the_user_has_created_the_rent_receipts() {
		mainPage.assertValidReceipt();
	}

//-------------------------------------------------------------------------------------------------------------------------------------------------
			/*
			 * CREATED BY: KEERTHANA R
			 * REVIEWED BY: MEDHA JOSHI
			 * MOTIVE: THE USER SHOULD VALIDATES GENERATE RENT RECEIPTS WITH INVALID DETAILS
			 */
//--------------------------------------------------------------------------------------------------------------------------------------------------

	@Given("user clicks on the menu tab")
	public void user_clicks_on_the_menu_tab() {
		mainPage.clickMenu();
	}

	@When("the user searches for rent receipts option and clicks")
	public void the_user_searches_for_rent_receipts_option_and_clicks() {
		mainPage.selectRentReceipt();
	}

	@When("the user navigates to generate receipt page")
	public void the_user_navigates_to_generate_receipt_page() {

	}

	@When("user enters the invalid details credentials")
	public void user_enters_the_invalid_details_credentials() {
		mainPage.InputForInvalidReceipt();
	}

	@When("the user clicks on the create generate receipts")
	public void the_user_clicks_on_the_create_generate_receipts() {
		mainPage.clickGenerateReceiptButton();
	}

	@Then("the user is propmt regarding invalid credentials")
	public void the_user_is_propmt_regarding_invalid_credentials() {
	}

	//-------------------------------------------------------------------------------------------------------------------------------------------------
			/*
			 * CREATED BY: KEERTHANA R
			 * REVIEWED BY: MEDHA JOSHI
			 * MOTIVE: THE USER VALIDATES THE PAY RENT WITH CREDIT CARD OPTION 
			 */
	//--------------------------------------------------------------------------------------------------------------------------------------------------

	@Given("user must be in the rent receipt page")
	public void user_must_be_in_the_rent_receipt_page() {
		mainPage.clickMenu();
		mainPage.selectRentReceipt();
	}

	@When("User able to click on pay rent")
	public void user_able_to_click_on_pay_rent() {
		rent.clickPayRent();
	}

	@When("User able to enter the details and click the get started button {string}, {string}, {string}")
	public void user_able_to_enter_the_details_and_click_the_get_started_button(String string, String string2,
			String string3) {
		rent.enterDetails(string, string2, string3);
	}

	@Then("User has able to use the available Payment Options")
	public void user_has_able_to_use_the_available_payment_options() {
		rent.assertVerify();
	}

//-------------------------------------------------------------------------------------------------------------------------------------------------
			/*
			 * CREATED BY: KEERTHANA R
			 * REVIEWED BY: MEDHA JOSHI
			 * MOTIVE: THE USER SHOULD 
			 */
//--------------------------------------------------------------------------------------------------------------------------------------------------

	@Given("the user is on the home page and logs in")
	public void the_user_is_on_the_home_page_and_logs_in() {

	}

	@When("the user clicks on the rental agreement option")
	public void the_user_clicks_on_the_rental_agreement_option() {
		mainPage.clickRentalagree();
	}

	@When("the user selects the location , clicks on check prices")
	public void the_user_selects_the_location_clicks_on_check_prices() {
		mainPage.selectCity();
		mainPage.selectCheckPrices();
		mainPage.enterPhoneNumber();
		mainPage.enterOTPNumber();
		mainPage.clickContinueButton();
	}

	@When("the user is navigated to rental agreement page")
	public void the_user_is_navigated_to_rental_agreement_page() {
		mainPage.selectPackageAgree();
	}

	@When("the user should not select e stamp package")
	public void the_user_should_not_selects_e_stamp_package() {
		mainPage.selectSave();
	}

	@Then("the system prompt and highlight the errors")
	public void the_system_prompt_and_highlight_the_errors() {
		mainPage.assertRentalAgreement();
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------
			/*
			 * CREATED BY: KEERTHANA R
			 * REVIEWED BY: MEDHA JOSHI
			 * MOTIVE: THE USER SHOULD NOT LOGIN WITH INVALID OTP
			 */
//--------------------------------------------------------------------------------------------------------------------------------------------------

	@Given("the user is on the homepage2")
	public void the_user_is_on_the_homepage2() {
		mainPage.loginBtnClick();
	}

	@When("the user enters their phone number2")
	public void the_user_enters_their_phone_number2() {
		mainPage.enterPhoneNumber();
	}

	@When("requests an OTP2")
	public void requests_an_otp2() {

	}

	@When("the user receives an OTP on their registered phone number2")
	public void the_user_receives_an_otp_on_their_registered_phone_number2() {

	}

	@When("the user enters the invalid OTP")
	public void the_user_enters_the_invalid_otp() {
		mainPage.enterOTPNumber();
	}

	@Then("the user failed to login")
	public void the_user_failed_to_login() {
//		mainPage.clickContinueButton();
		mainPage.assertInvalidOtp();
	}
//----------------------------------------------------------------------------------------
	
	@AfterStep
	public static void tearDown(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}
}
