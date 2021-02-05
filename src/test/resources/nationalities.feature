Feature: Testing nationalities

  Scenario: Create a nationality (and delete it)
    Given I navigate to website
    And I go to nationality menu
    When I create nationality
    Then I see success message "Nationality successfully created"
    When I delete nationality
    Then I see success message "Nationality successfully deleted"