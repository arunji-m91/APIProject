package com.addresstask;



import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pojo.read.AddUserAddress_Input_Pojo;
import com.pojo.read.Login_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 **test comment by arun
**/

public class UserAddressVerify extends BaseClass {

	String logtoken;
	@Test(priority = 2)
	public void addAddress() {
		List<Header> listHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization"," Bearer "+logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
		
		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo =
				new AddUserAddress_Input_Pojo("Arun M", "Muni", "7845486608", "greensapart", 33, 3378, 101, "6044044", "Thoraippakkam", "Home");
		addBody(addUserAddress_Input_Pojo);
		Response response = requestType("POST","https://omrbranch.com/api/addUserAddress");
		int statusCode = response.getStatusCode();
		//System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200,"verify status code");
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		//System.out.println(resBodyAsPrettyString);
		//AddUserAddress_Input_Pojo as = response.as(AddUserAddress_Output_Pojo);
		
	}

		@Test(priority = 1)
		public void login() {
			addHeader("Content-Type", "application/json");
			basicAuth("arunji.m91@gmail.com", "Arun@123");
			Response response = requestType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
			int statusCode = getStatusCode(response);
			//System.out.println(statusCode);
			Assert.assertEquals(statusCode, 200,"verify statusCode");
			
			String resBodyAsPrettyString = getResBodyAsPrettyString(response);
			System.out.println(resBodyAsPrettyString);
			Login_Output_Pojo as = response.as(Login_Output_Pojo.class);
			logtoken = as.getData().getLogtoken();
			//System.out.println(logtoken);
		}

	}
