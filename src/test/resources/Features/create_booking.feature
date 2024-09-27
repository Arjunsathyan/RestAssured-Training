Feature: validate the create resource end point
  Scenario: verify whether user can create resource and get it by id
    Given user want to call "/posts" endpoint
    And set header "Content-type" to "application/json"
    And set request body from the file "createResource.json"
    When user performs the post call
    Then verify status code is 201
    And verify id is not null
    And stores the created resource id into "resource.id"
    When  user want to call "/posts/@id" endpoint
    And user perform the get call
    Then verify status code is 404


  Scenario: verify the functionalities of restful api
    Given user want to call "/objects" endpoint
    And set header "Content-type" to "application/json"
    And set request body from the file "CreateOb.json"
    When user performs the post call
    Then verify status code is 200
    And verify id is not null
    And stores the created resource id into "resource.id"
    When user want to call "/objects/@id" endpoint
    And user perform the get call
    Then verify status code is 200
    And verify the data is same as "CreateOb.json"
    And verify Response is matching with the "createOb_schema.json"

    
