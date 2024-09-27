package com.automation.steps;

import com.automation.Utils.ConfigReader;
import com.automation.Utils.RestAssuredUtils;
import com.automation.pojo.Data;
import com.automation.pojo.JsonData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Assert;

import java.io.FileNotFoundException;

public class ResponseSteps {

    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }

    @Then("verify id is not null")
    public void verify_id_is_not_null() {
        String userId = RestAssuredUtils.getResponse().jsonPath().getString("id");
        Assert.assertTrue(!userId.isEmpty());
    }

    @And("stores the created resource id into {string}")
    public void storesTheCreatedResourceIdInto(String key) {
        ConfigReader.setConfigValue(key, RestAssuredUtils.getResponse().jsonPath().getString("id"));
    }


    @And("verify the data is same as {string}")
    public void verifyTheDataIsSameAs(String fileName) throws FileNotFoundException, JsonProcessingException {
        String jsonFolderPath = ConfigReader.getConfigValue("json.file.path");
        String jsonBody = RestAssuredUtils.getDataFile(jsonFolderPath + fileName);
        ObjectMapper om = new ObjectMapper();
        //CreateBookingPojo createBookingPojo = om.readValue(jsonBody, CreateBookingPojo.class);

        JsonData jsPojo=om.readValue(jsonBody,JsonData.class);
        Assert.assertEquals(jsPojo.getName(),RestAssuredUtils.getResponse().jsonPath().getString("name"));
        Assert.assertEquals(jsPojo.getData(),RestAssuredUtils.getResponse().jsonPath().getObject("data", Data.class));
    }

    @And("verify Response is matching with the {string}")
    public void verifyResponseIsMatchingWithThe(String fileName) {
        RestAssuredUtils.getResponse().then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json/createOb_schema.json"));
    }
}
