package PracticeAPI;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class APIRestAssured {
	
	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://automationexercise.com";
		
		given().log().all().when().get("api/brandsList").then().log().all().assertThat().statusCode(200);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
