Feature: Login Functionality

  In order to do internet banking
  As a valid Para Bank Customer
  I want to login successfully

  Scenario Outline: Login Successfully

  Given i am in the login page of the Para Bank Application
    When I enter valid <username> and <password> credentials
    Then i Should be taken to the Overview page
    Examples:
      |username|password|
      |"tester123"|"password1"|
      |"autotester"|"password"|

