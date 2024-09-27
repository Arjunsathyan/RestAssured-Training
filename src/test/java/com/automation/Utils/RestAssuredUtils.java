package com.automation.Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestAssuredUtils {
    static RequestSpecification requestSpecification= RestAssured.given();
    static String endpoint;
    static Response response;

    public static void setEndpoint(String endpoint)
    {
        RestAssuredUtils.endpoint=endpoint;
    }

    public static void setHeaders(String key, String value) {
        requestSpecification=requestSpecification.header(key,value);
    }


    public static void setBody(String filename) throws FileNotFoundException {
        String jsonFolderPath=ConfigReader.getConfigValue("json.file.path");
        requestSpecification=requestSpecification.body(getDataFile(jsonFolderPath+filename));
    }

    public static String getDataFile(String filepath) throws FileNotFoundException {
        String content=null;
        try {
            content = new Scanner(new FileInputStream(filepath)).useDelimiter("\\z").next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    public static Response post() {
        requestSpecification.log().all(); // Just for logging purpose
        response = requestSpecification.post(endpoint);
        response.then().log().all(); // Just for logging purpose
        return response;
    }

    public static int getStatusCode()
    {
        return response.getStatusCode();
    }

    public static Response getResponse()
    {
        return response;
    }

    public static Response get() {
        requestSpecification.log().all();
        response=requestSpecification.get(endpoint);
        response.then().log().all();
        return response;
    }

    public static void setBodyUsingPojo(Object object) {
        requestSpecification = requestSpecification.body(object);
    }
}
