Feature: Somebody will be greeting

  Background:
    * url baseUrl

  Scenario: GET a USER
    Given path '/person'
    When method GET
    Then status 200

  Scenario: GET one  USER
    Given path '/person/1'
    When method GET
    Then status 200

  Scenario: GET one  USER
    Given path '/person/Christian'
    When method GET
    Then status 200

  Scenario: POST a USER

    Given path '/person'
    And request {birth:'2000-12-17', name:'Christiane', status:'not ledig'}
    When method POST
    Then status 201

  Scenario: PUT a USER

    Given path '/person/3'
    And request {birth:'2000-12-18', name:'Christiano', status:'Noever Ledig'}
    When method PUT
    Then status 200

  Scenario: DELETE a USER

    Given path '/person/3'
    And request {birth:'2000-12-18', name:'Christiano', status:'Noever Ledig'}
    When method DELETE
    Then status 204


