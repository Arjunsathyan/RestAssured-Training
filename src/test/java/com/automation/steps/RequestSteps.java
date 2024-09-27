package com.automation.steps;

import com.automation.Utils.ConfigReader;
import com.automation.Utils.RestAssuredUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;

import static com.automation.Utils.RestAssuredUtils.getDataFile;

public class RequestSteps {


   @Given("user want to call {string} endpoint")
    public void user_want_to_call_endpoint(String endPoint) {
    if(endPoint.contains("@")){
     endPoint = endPoint.replace("@id", ConfigReader.getConfigValue("resource.id"));
    }
    RestAssuredUtils.setEndpoint(endPoint);
    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
    RestAssuredUtils.setHeaders(key,value);
    }

    @Given("set request body from the file {string}")
    public void set_request_body_from_the_file(String filename) throws FileNotFoundException, JsonProcessingException {
     RestAssuredUtils.setBody(filename);
    }

    @When("user performs the post call")
    public void user_performs_the_post_call() {
    RestAssuredUtils.post();
    }


 @And("user perform the get call")
 public void userPerformTheGetCall() {
    RestAssuredUtils.get();
 }
}
