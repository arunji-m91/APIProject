package com.api.jsonobject.jsonarray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TaskUseJsonObject {

	public static void main(String[] args) throws IOException, ParseException {

		// read value from json file using JSONParser class and JSONObject class
		FileReader fileReader = new FileReader(
				"C:\\Users\\DELL\\eclipse-workspace\\APIProject\\src\\test\\resources\\Taskusingjsonobject.json");
		JSONParser jsonParser = new JSONParser();
		Object parse = jsonParser.parse(fileReader);
		JSONObject jsonObject = (JSONObject) parse;
		Object object = jsonObject.get("data");
		// System.out.println(object);

		JSONObject jsonObject1 = (JSONObject) object;
		Object object2 = jsonObject1.get("id");
		// System.out.println(object2);

		Object object3 = jsonObject1.get("email");
		Object object4 = jsonObject1.get("first_name");
		Object object5 = jsonObject1.get("last_name");
		Object object6 = jsonObject1.get("avatar");
		System.out.println(object2 + "\n" + object3 + "\n" + object4 + "\n" + object5 + "\n" + object6);

		Object object7 = jsonObject.get("support");
		JSONObject jsonObject6 = (JSONObject) object7;
		Object object8 = jsonObject6.get("url");
		Object object9 = jsonObject6.get("text");
		String support = (String) object8;
		String support1 = (String) object9;
		System.out.println(support + "\n" + support1);

	}

}
