package com.api.jsonobject.jsonarray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Sample {

	public static void main(String[] args) throws IOException, ParseException {
		// mention the path of the json file
		FileReader fileReader = new FileReader(
				"C:\\Users\\DELL\\eclipse-workspace\\APIProject\\src\\test\\resources\\SampleVelsir.json");

		// create object for JSONParser class
		JSONParser jsonParser = new JSONParser();
		// pass jsonfile to fetch values
		Object parse = jsonParser.parse(fileReader);

		// convert to json object
		JSONObject jsonObject = (JSONObject) parse;

		
		Object object = jsonObject.get("name");
		String name = (String) object;
		System.out.println(name);

		Object object2 = jsonObject.get("address");
		JSONObject jsonObject2 = (JSONObject) object2;
		Object object3 = jsonObject2.get("streetName");
		System.out.println(object3);

	}

}
