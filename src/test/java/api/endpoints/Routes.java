package api.endpoints;

/*
 	Swagger URI ---> https://petstore.swagger.io/
 	
 	Create User(POST) : https://petstore.swagger.io/v2/user
 	Get User(GET) :https://petstore.swagger.io/v2/user{Username}
 	Update User(PUT) : https://petstore.swagger.io/v2/user{Username}
 	Delete User(DELETE) : https://petstore.swagger.io/v2/user{Username}
 	
 */

public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Module
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	//Store Module 
		//Here you will create store module URL's 
	
	//Pet Module
	//Here you will create Pet module URL's 

}
