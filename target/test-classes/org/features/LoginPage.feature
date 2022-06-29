Feature: Login Page feature

@Smoke
Scenario: Validate login page
Given User is on login page
Then Username field is displayed
And Password field is displayed
And Login button is displayed
And Keep me login checkbox is displayed
And Actitime logo is displayed

@Regression
Scenario: Login successfully
Given User is on login page
When User enters username
And User enters password
And Clicks on login button
Then Dashboard URL should be displayed as "http://localhost/user/submit_tt.do123"
And Dashboard page title should be displayed as "actiTIME -  Enter Time-Track"

#Scenario: Invalid login
#Given User is on login page
#Then 4 tabs should be displayed