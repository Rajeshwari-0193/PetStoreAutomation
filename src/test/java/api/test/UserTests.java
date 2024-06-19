package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	
	Faker faker;
	User userPayload;
	public Logger logger;       //----------------> for logs
	
	@BeforeTest
	public void setupData() {
		
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger= LogManager.getLogger(this.getClass());       //-------->logs
		
	}
	@Test(priority=1)
	public void testPostUser() {
		logger.info("********************* creating User ****************");
		Response response = UserEndpoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********************* created User ****************");
	}
	@Test(priority=2)
	public void testGetUser() {
		logger.info("********************* reading User info  ****************");
		Response response = UserEndpoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		logger.info("******************** User info is displayed ****************");
	}
	@Test(priority=3)
	public void testUpdateUserByName() {
		logger.info("********************* updating User ****************");
		//Update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndpoints.UpdateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
		//response.then().log().body().statusCode(200)  //we can these also for our validations
		//response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		//Checking data after update
		Response responseAfterUpdate = UserEndpoints.readUser(this.userPayload.getUsername());
		responseAfterUpdate.then().log().all();
		AssertJUnit.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		logger.info("*********************  User is updated ***************");
	}
	@Test(priority=4)
	public void testDeleteUserByName() {
		logger.info("********************* deleting User ****************");
		Response response = UserEndpoints.deleteUser(this.userPayload.getUsername());
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		logger.info("*********************  User deleted****************");
	}
}
