Feature: School Department

  Background:
    Given I navigate and login to website define in excel "loginDetails.xlsx"
    And I go to menu 1 2 6

  Scenario: Successfully creating and deleting "High School" department
    When I create department with name "High School" and code "HS-1"
    Then I see success message "School Department successfully created"
    When I delete row with name "High School"
    Then I see success message "School Department successfully deleted"

  Scenario: Successfully creating and deleting "Middle School" department
    When I create department with name "Middle School" and code "MS-1"
    Then I see success message "School Department successfully created"
    When I delete row with name "Middle School"
    Then I see success message "School Department successfully deleted"

  Scenario: Successfully creating and deleting department with random name and code
    When I create department with name random and code random
    Then I see success message "School Department successfully created"
    When I delete the department with name random and code random
    Then I see success message "School Department successfully deleted"
