Feature: Testing nationalities

  Background:
    Given I navigate to website "https://test.campus.techno.study/"
    And I login using username:daulet2030@gmail.com and password "TechnoStudy123@"
    And I go to menu 1 1 4

  Scenario: Create a nationality (and delete it)
    When I create nationality with name "French"
    Then I see success message "Nationality successfully created"
    When I delete saved nationality
    Then I see success message "Nationality successfully deleted"

  Scenario: Create a duplicated nationality (and delete it)
    When I create nationality with name "German"
    Then I see success message "Nationality successfully created"
    When I create nationality with name "German"
    Then I see error message 'The Nationality with Name "German" already exists.'
    When I delete saved nationality
    Then I see success message "Nationality successfully deleted"

  Scenario: Edit a nationality (create, edit and delete it)
    When I create nationality with name "Polak"
    Then I see success message "Nationality successfully created"
    When I edit nationality with name "Polak" to "Polish"
    Then I see success message "Nationality successfully updated"
    When I delete row with name "Polish"
    Then I see success message "Nationality successfully deleted"