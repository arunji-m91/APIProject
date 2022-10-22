package com.baseclass;

import java.lang.reflect.Array;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ApiTestNgAssertionBasicReadOperation extends BaseClass {

	RequestSpecification reqSpec;

	@Test
	public void createUser() {
//Post example
		addHeader("Content-Type", "application/json");
		addBody("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}");
		Response response = requestType("POST", "https://reqres.in/api/users");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
	}

	@Test
	public void getDemo() throws ParseException {
		// Get example
		addHeader("Content-Type", "application/json");
		// reqSpec = RestAssured.given();
		Response response = requestType("GET", "https://reqres.in/api/users?page=2");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
		// get value from the response body
		/*
		 * get value from the response body by using 1 JSONArray/JSONObject 2
		 * ObjectMapper 3 JSONPath
		 */

		JSONParser jsonParser = new JSONParser();
		Object parse = jsonParser.parse(resBodyAsPrettyString);
		JSONObject jsonObject = (JSONObject) parse;
		Object object = jsonObject.get("data");
		// data is in the array format so convert jsonObject into json array

		JSONArray jsonArray = (JSONArray) object;
		Object object2 = jsonArray.get(0);
		jsonObject = (JSONObject) object2;
		Object object3 = jsonObject.get("first_name");
		String firstName = (String) object3;
		System.out.println(firstName);
		Assert.assertEquals(firstName, "Michael", "verify first name");
	}

	@Test
	
	public void getDemoUsingJsonPagh() {
		addHeader("Content-Type", "application/json");
		// reqSpec = RestAssured.given();
		Response response = requestType("GET", "https://reqres.in/api/users?page=2");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
		JsonPath jsonPath = response.jsonPath();
		Object object = jsonPath.get("data[0].first_name");
		String firstName =(String) object;
		System.out.println(firstName);
		Assert.assertEquals(firstName, "Michael","verify name");
		
	}
}
