Feature: AddModeleFeature
  This feature deals with adding new model

  Scenario Outline: Adding model
    Given I navigate to the login page
    And I enter "<username>" and "<password>"
    And I click login button
    Then I navigate to the model page
    Then I add new model
    Then I navigate to projects page and I select COVID page
    Then I associate the model to the project
    Then I detach the model from the project
    Then I navigate to the model page
    Then I delete the model added
    Then I close the browser
    Examples:
      | username        | password |
      | rgauvin@kpmg.fr | aezan75  |