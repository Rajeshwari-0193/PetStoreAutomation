package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//UserEndpoints.java
//Created to perform create,retrive,update,delete requests to the user API

public class UserEndpoints2UsingPropertiesFile {
	
	//method created for getting URL's from properties file
	static ResourceBundle getURL(){
		
		ResourceBundle routes=ResourceBundle.getBundle("routes");//Load properties file
		return routes;    //("routes") is the file name that we have used 
	}

	public static Response createUser(User payload){
		
		String post_url = getURL().getString("post_url");
		
		Response response =given()
		.contentType(ContentType.JSON)  //getting from swagger
		.accept(ContentType.JSON)  //getting from swagger
		.body(payload)
		
		.when()
			.post(post_url);
		
		return response;
	}
	
	public static Response readUser(String userName){
		
		String get_url = getURL().getString("get_url");
		
		Response response =given()
				.pathParam("username", userName)
		
		.when()
			.get(get_url);
		
		return response;
	}
	
	public static Response UpdateUser(String userName, User payload){
		
		String update_url = getURL().getString("update_url");
		
		Response response =given()
		.contentType(ContentType.JSON)  //getting from swagger
		.accept(ContentType.JSON)  //getting from swagger
		.pathParam("username", userName)
		.body(payload)
		
		
		.when()
			.put(update_url);
		
		return response;
	}
	
	public static Response deleteUser(String userName){
		
		String delete_url = getURL().getString("delete_url");
		
		Response response =given()
				.pathParam("username", userName)
		
		.when()
			.delete(delete_url);
		
		return response;
	}
	
}
