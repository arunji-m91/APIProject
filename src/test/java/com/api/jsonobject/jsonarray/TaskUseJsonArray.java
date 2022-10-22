package com.api.jsonobject.jsonarray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TaskUseJsonArray {

	public static void main(String[] args) throws IOException, ParseException {
		// read value from json file using JSONParser class and JSONArray class
		FileReader fileReader = new FileReader(
				"C:\\Users\\DELL\\eclipse-workspace\\APIProject\\src\\test\\resources\\TaskUseJsonArray.json");

		JSONParser jsonParser = new JSONParser();
		Object parse = jsonParser.parse(fileReader);
		JSONObject jsonObject = (JSONObject) parse;
		Object page = jsonObject.get("page");
		Object perPage = jsonObject.get("per_page");
		Object total = jsonObject.get("total");
		Object totalPages = jsonObject.get("total_pages");
		System.out.println(page + "\n" + perPage + "\n" + total + "\n" + totalPages);
		System.out.println();

		Object object = jsonObject.get("data");
		JSONArray jsonArray = (JSONArray) object;

		for (int i = 0; i < jsonArray.size(); i++) {
			Object object2 = jsonArray.get(i);
			JSONObject jsonObject1 = (JSONObject) object2;
			Object id = jsonObject1.get("id");
			Object email = jsonObject1.get("email");
			Object firstName = jsonObject1.get("first_name");
			Object lastName = jsonObject1.get("last_name");
			Object avatar = jsonObject1.get("avatar");
			System.out.println(id + "\n" + email + "\n" + firstName + "\n" + lastName + "\n" + avatar);
			System.out.println();

		}

		Object object2 = jsonObject.get("support");
		JSONObject jsonObject3 = (JSONObject) object2;
		Object url = jsonObject3.get("url");
		Object text = jsonObject3.get("text");
		System.out.println(url + "\n" + text);
	}

}
