Feature: Check men football shoes section

  Scenario: Check filters
    Given I open "www.sportland.lv" link
    When I push menu
    And I choose "PRODUKTI" section
    And I select "Futbols" under "APAVI" section in "VĪRIEŠI" tab
    #And we sort products by "Izpārdošana"
    And I select filters:
      | Futbola apavi cietam segumam |
      | adidas                         |
    Then on page appeared only "adidas" brand shoes
    And all products are on sale
    And we create txt file with with info about products
    And we create json file with the same information
    And we close browser