	package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostuser(String userID, String userName, String firstName, String lastName, String useremail, String pwd, String ph) 
	{
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2, dataProvider = "UpdateData", dataProviderClass = DataProviders.class)
	public void testUpdateuser(String userName, String firstName, String lastName, String useremail) 
	{
		
		System.out.println("Update User Data: " + userName + ", " + firstName + ", " + lastName + ", " + useremail);

		User userPayload = new User();
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(useremail);
		
		
		Response response = UserEndPoints.updateUser(userName, userPayload);
		System.out.println("Update User Response: " + response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	

	@Test(priority = 3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	
	public void testDeleteUserByName(String userName) 
	{
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
