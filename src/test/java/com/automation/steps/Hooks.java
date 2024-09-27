package com.automation.steps;

import com.automation.Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ga.Agus;
import io.restassured.RestAssured;

public class Hooks {

    @Before
    public void Setup()
    {
        ConfigReader.initConfig();
        if(ConfigReader.getConfigValue("application.name").equals("restful-api"))
        {
            RestAssured.baseURI=ConfigReader.getConfigValue("second.uri");
        }
        else
        {

            RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        }
        RestAssured.baseURI=ConfigReader.getConfigValue("second.uri");
    }


}
