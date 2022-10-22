package com.baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	Response response;
	RequestSpecification reqSpec;

	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}

	public void addBody(Object body) {
		reqSpec = reqSpec.body(body);

	}

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);

	}

	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}

	public void addQueryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);

	}

	public void addPathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);

	}

	public void addBody(String bodyAdd) {
		reqSpec = reqSpec.body(bodyAdd);
	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public Response requestType(String type, String endPoint) {
		switch (type) {
		case "GET":
			response = reqSpec.get(endPoint);
			break;
		case "POST":
			response = reqSpec.post(endPoint);
			break;
		case "PUT":
			response = reqSpec.put(endPoint);
			break;
		case "DELETE":
			response = reqSpec.delete(endPoint);
			break;

		default:
			break;
		}
		return response;

	}

	public void basicAuth(String userName, String password) {

		reqSpec.auth().preemptive().basic(userName, password);

	}

}
