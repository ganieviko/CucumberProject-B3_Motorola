Feature: School Department

  Background:
    Given I navigate and login to website define in excel "loginDetails.xlsx"
    And I go to menu 1 2 6

  Scenario: Successfully creating and deleting "High School" department
    When I create department with name and code from row 1
    Then I see success message "School Department successfully created"
    When I delete row with name from mysql
    Then I see success message "School Department successfully deleted"

  Scenario: Successfully creating and deleting "High School" department
    When I create department with name and code from row 20
    Then I see success message "School Department successfully created"
    When I delete row with name from mysql
    Then I see success message "School Department successfully deleted"
  Scenario: Successfully creating and deleting "High School" department
    When I create department with name and code from row 31
    Then I see success message "School Department successfully created"
    When I delete row with name from mysql
    Then I see success message "School Department successfully deleted"
  Scenario: Successfully creating and deleting "High School" department
    When I create department with name and code from row 48
    Then I see success message "School Department successfully created"
    When I delete row with name from mysql
    Then I see success message "School Department successfully deleted"
  Scenario: Successfully creating and deleting "High School" department
    When I create department with name and code from row 11
    Then I see success message "School Department successfully created"
    When I delete row with name from mysql
    Then I see success message "School Department successfully deleted"

