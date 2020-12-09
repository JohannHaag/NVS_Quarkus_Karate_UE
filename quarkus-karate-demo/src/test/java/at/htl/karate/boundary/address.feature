Feature: Somebody get Addresses

  Background:
    * url baseUrl

    Scenario: Get Address
      Given path '/address'
      When method Get
      Then status 200
