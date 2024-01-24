# src/test/resources/LoginPage.features

Feature: Login Functionality

  Scenario: Test the Login Page UI
    Given User is on the login page
    When Website logo image should be displayed
    And Heading text should be "Login"
    And Username label text should be "USERNAME"
    And Password label text should be "PASSWORD"
    And Login button should be displayed


  Scenario: Login Page Functionalities with empty inputs
    Given User is on the login page
    When User clicks on Login button
    Then User should get a error message

    Scenario:Login functionality with empty USERNAME
      Given User is on the login page
      When User don't enter any username field and enter password
      And User clicks on Login button
      Then User should get a error message

  Scenario:Login functionality with empty PASSWORD
    Given User is on the login page
    When User enter username field and don't enter password
    And User clicks on Login button
    Then User should get a error message

  Scenario:login With Invalid Username
    Given User is on the login page
    When User enter wrong username and correct password
    And User clicks on Login button
    Then User should get a error message as 'invalid username'

  Scenario:login With Invalid Password
    Given User is on the login page
    When User enter correct username and wrong password
    And User clicks on Login button
    Then User should get a error message as 'username and password didn't match'

  Scenario:login functionality with inValid Credentials
    Given User is on the login page
    When User enter incorrect username and correct password
    And User clicks on Login button


  Scenario:login functionality with Valid Credentials
    Given User is on the login page
    When User enter correct username and correct password
    And User clicks on Login button
    Then User should be redirected to the homepage
