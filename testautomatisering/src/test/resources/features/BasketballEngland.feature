Feature: Register user profile on Basketball England

  Scenario Outline: Create a user profile on Basketball England
    Given I am on Basketball Englands registration page using "<browser>"
    Given I have entered date of birth
    Given I have entered first name
    Given I have entered last name "<lastName>"
    Given I have entered and confirmed e-mail address "otto@mail.com"
    Given I have entered password "<password>"
    Given I have confirmed password "<confirmPassword>"
    Given Terms and condition "<status>"
    Given I have checked I am over 18 and accepted code of conduct
    When I click confirm and join
    Then Verify that "<text>" is shown

    Examples:
      | browser | lastName | password | confirmPassword | status    | text                                                                      |
      | Chrome  | Ottosson | abc123   | abc123          | checked   | THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND                 |
      | Chrome  |          | abc123   | abc123          | checked   | Last Name is required                                                     |
      | Chrome  | Ottosson | abc123   | abc12           | checked   | Password did not match                                                    |
      | Chrome  | Ottosson | abc123   | abc123          | unchecked | You must confirm that you have read and accepted our Terms and Conditions |
      | Edge    | Ottosson | abc123   | abc123          | checked   | THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND                 |
      | Edge    |          | abc123   | abc123          | checked   | Last Name is required                                                     |
      | Edge    | Ottosson | abc123   | abc12           | checked   | Password did not match                                                    |
      | Edge    | Ottosson | abc123   | abc123          | unchecked | You must confirm that you have read and accepted our Terms and Conditions |