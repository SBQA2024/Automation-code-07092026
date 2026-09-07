package PracticeAPI;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class GetMethodPractice {
	
	
	
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://dummy.restapiexample.com";
		
		String response= 	given().log().all().
		
		when().get("/api/v1/employees")		
		
		.then().log().all().extract().response().asString();
		
		System.out.println(response);
	
		
	
	
	
	JsonPath js = new JsonPath(response);
	
	int id = js.get("data[0].id");
	System.out.println("The id is " +  id);

	
	
	String salary =js.getString("data.find{it.employee_name=='Garrett Winters'}.employee_salary");
	
	System.out.println(salary);
	
	
	
	
	
	
	
	
	
	
	
}
}