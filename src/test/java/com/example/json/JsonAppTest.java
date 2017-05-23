package com.example.json;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonAppTest {

	@Test
	public void 객체를_JSON으로_변경() {
		Person person = new Person();
		person.setName("kim");
		person.setAge(20);
		person.setGender("M");
		Gson gson = new Gson();
		String json = gson.toJson(person);
		System.out.println(json);
	}
	
	
	@Test
	public void 문자열_JSON을_파싱() {
		String json = "{\"name\":\"kim\",\"age\":20,\"gender\":\"M\"}";
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(json);
		String name = element.getAsJsonObject().get("name").getAsString();
		System.out.println("name = "+name);
		int age = element.getAsJsonObject().get("age").getAsInt();
		System.out.println("age = "+age);		
	}
	
	@Test
	public void 단순_JSON_만들기() {
		Gson gson = new Gson();
		JsonObject object = new JsonObject();
		object.addProperty("name", "park");
		object.addProperty("age", 22);
		object.addProperty("success", true);
		String json = gson.toJson(object);
		System.out.println(json);
	}

}
