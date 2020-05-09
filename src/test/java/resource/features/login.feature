Feature: Login into Application
  Scenario Outline: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to "QAClickAcademy" Site
    And Click on Login link in homepage to land on sign-on in Page
    When User enters <username> and <password> and logs in
    Then Verify that user is not logged in
    And Close browser

    Examples:
    |username |password|
    |"test99@gmail.com" |"123456"|
    |"test123@gmail.com" |"123456"|
