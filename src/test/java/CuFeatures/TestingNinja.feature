Feature: TestingNinja Book

    @smoke
    Scenario Outline: TestingNinja Booking
    Given Customer is opened the Testninja ecom site
    Then Customer changes currency to "<currency>"
    And Customer search for "<search>" and hit search button
    When User validates the page name "Search"
    Then User select the product "<product>"
    Examples:
    |currency       |search                  |product                 |
    |Pound Sterling |MacBook Air             |MacBook Air             |
    |US Dollar      |Samsung SyncMaster 941BW|Samsung SyncMaster 941BW|
   
   @smoke
    Scenario Outline: TestingNinja Booking1
    Given Customer is opened the Testninja ecom site
    Then Customer changes currency to "<currency>"
    And Customer search for "<search>" and hit search button
    When User validates the page name "Search"
    Then User select the product "<product>"
    Examples:
    |currency       |search                  |product                 |
    |Pound Sterling |MacBook Air             |MacBook Air             |
    |US Dollar      |Samsung SyncMaster 941BW|Samsung SyncMaster 941BW|
      


  