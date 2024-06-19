package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//UserEndpoints.java
//Created to perform create,retrive,update,delete requests to the user API

public class UserEndpoints {

	public static Response createUser(User payload){
		
		Response response =given()
		.contentType(ContentType.JSON)  //getting from swagger
		.accept(ContentType.JSON)  //getting from swagger
		.body(payload)
		
		.when()
			.post(Routes.post_url);
		
		return response;
	}
	
	public static Response readUser(String userName){
		
		Response response =given()
				.pathParam("username", userName)
		
		.when()
			.get(Routes.get_url);
		
		return response;
	}
	
	public static Response UpdateUser(String userName, User payload){
		
		Response response =given()
		.contentType(ContentType.JSON)  //getting from swagger
		.accept(ContentType.JSON)  //getting from swagger
		.pathParam("username", userName)
		.body(payload)
		
		
		.when()
			.put(Routes.update_url);
		
		return response;
	}
	
	public static Response deleteUser(String userName){
		
		Response response =given()
				.pathParam("username", userName)
		
		.when()
			.delete(Routes.delete_url);
		
		return response;
	}
	
}
