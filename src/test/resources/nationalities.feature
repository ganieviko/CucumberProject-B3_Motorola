Feature: Testing nationalities

  Scenario: Create a nationality (and delete it)
    Given I navigate to website
    And I go to nationality menu
    When I create nationality with name "French"
    Then I see success message "Nationality successfully created"
    When I delete saved nationality
    Then I see success message "Nationality successfully deleted"

  Scenario: Create a duplicated nationality (and delete it)
    Given I navigate to website
    And I go to nationality menu
    When I create nationality with name "French"
    Then I see success message "Nationality successfully created"
    When I create nationality with name "French"
    Then I see error message 'The Nationality with Name "French" already exists.'
    When I delete saved nationality
    Then I see success message "Nationality successfully deleted"

  Scenario: Edit a nationality (create, edit and delete it)
    Given I navigate to website
    And I go to nationality menu
    When I create nationality with name "French"
    Then I see success message "Nationality successfully created"
    When I edit nationality with name "French" to "Frenchman"
    Then I see success message "Nationality successfully updated"
    When I delete nationality with name "Frenchman"
    Then I see success message "Nationality successfully deleted"