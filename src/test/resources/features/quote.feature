Feature: Implement cucumber test using selenium java

  Scenario: open website
    When open gerberlife website
    Then verify website title "Family Life Insurance from Gerber Life Insurance Company"

  Scenario: validate required field validation message
    When open gerberlife website
    Then click on apply button
    Then verify required validation message "Highlighted fields are required"

  Scenario: validate email validation message
    When open gerberlife website
    Then select "Alabama" in "State" dropdown
    Then select "1" in "Age" dropdown
    Then select "Boy" in "Gender" dropdown
    Then enter "abc" in email textbox
    Then click on apply button
    Then verify email validation message "Please enter an email address."

  Scenario: get a free quote
    When open gerberlife website
    Then select "Alabama" in "State" dropdown
    Then select "1" in "Age" dropdown
    Then select "Boy" in "Gender" dropdown
    Then enter "abc@abc.com" in email textbox
    Then click on apply button
    Then verify element on apply page
