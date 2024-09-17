Feature: Payment of an e-commerce website

@E2E
Scenario: User should be able to get OTP while placing order using different payment methods
Given user visits amazon website
When user logged-in using valid credentials
And user select Health, Household and Personal Care section
And user select and item from ayurveda and click on add to cart
Then user should be on shopping cart page
When user clicks on proceed to buy 
Then user should be on checkout page
When user gives valid address
And user give payment details
Then user should be on OTP page