Feature: Testing the rental agreement and rent recipts functionalities

  Background: 
    Given user must be on the homepage

  @validlogin
  Scenario: User successfully logs in with valid number and OTP
    Given the user is on the homepage
    When the user enters their phone number
    And requests an OTP
    And the user receives an OTP on their registered phone number
    And the user enters the correct OTP
    Then the user is successfully logged in

  @rentreceiptvalid
  Scenario: User validates Rent Receipts process with valid credentials
    Given user clicks on the menu button
    When the user searches rent receipts and clicks
    And the user is on the generate receipt page
    And user enters the valid details credentials
    And the user clicks on the generate receipts
    Then the user has created the rent receipts

  @rentinvalid
  Scenario: User validates Rent Receipts process with invalid credentials
    Given user clicks on the menu tab
    When the user searches for rent receipts option and clicks
    And the user navigates to generate receipt page
    And user enters the invalid details credentials
    And the user clicks on the create generate receipts
    Then the user is propmt regarding invalid credentials
   
   @creditCard
  Scenario Outline: Paying rent with Credit card Online
  	Given user must be in the rent receipt page
    When User able to click on pay rent
    And User able to enter the details and click the get started button "<Name>", "<Mobile Number>", "<Email>"
    Then User has able to use the available Payment Options
   	Examples:
   	|	Name 		 |	Mobile Number	|	Email							|
   	|	John doe |	9876543210 		| abcd123@gmail.com |
   	
   @agreementinvalid1
  Scenario: User validates the rental agreement with invalid generate estimate
    Given the user is on the home page and logs in
    When the user clicks on the rental agreement option
    And the user selects the location , clicks on check prices
    And the user is navigated to rental agreement page
    And the user should not select e stamp package
    Then the system prompt and highlight the errors
    
  @invalidlogin
  Scenario: User should not login with invalid number and OTP
    Given the user is on the homepage2
    When the user enters their phone number2
    And requests an OTP2
    And the user receives an OTP on their registered phone number2
    And the user enters the invalid OTP
    Then the user failed to login
    
    
    
