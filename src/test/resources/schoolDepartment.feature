Feature: School Department

  Background:
    Given I navigate to website "https://test.campus.techno.study/"
    And I login using username:daulet2030@gmail.com and password "TechnoStudy123@"
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
