package api.test;

import java.util.List;

import javax.swing.text.html.HTML.Tag;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.PetEndpoints;
import api.endpoints.UserEndPoints;
import api.payload.Pet;


import api.payload.Pet.Category;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class PetTests {
	
	@Test(priority = 1, dataProvider = "PetData", dataProviderClass = DataProviders.class)
	
	public void testAddPet(Pet pet)
	{

		Response response = PetEndpoints.addPet(pet);
		int statusCode = response.getStatusCode();
	    String responseBody = response.getBody().asString();

	    System.out.println("Status Code: " + statusCode);
	    System.out.println("Response Body: " + responseBody);

	    Assert.assertEquals(statusCode, 200);
		
		
	}
	
	@Test(priority =2, dataProvider = "UpdatePetData", dataProviderClass =DataProviders.class)
	
	public void testUpdatePet(Pet pet)
	{

		Response response = PetEndpoints.updatePet(pet);
		int statusCode = response.getStatusCode();
	    String responseBody = response.getBody().asString();

	    System.out.println("Status Code: " + statusCode);
	    System.out.println("Response Body: " + responseBody);

	    Assert.assertEquals(statusCode, 200);
		
		
	}
	
@Test(priority =3, dataProvider = "FindByStatus", dataProviderClass =DataProviders.class)
	
	public void testFindByStatus(String status)
	{

		Response response = PetEndpoints.findByStatus(status);
		int statusCode = response.getStatusCode();
	    String responseBody = response.getBody().asString();

	    System.out.println("Status Code: " + statusCode);
	    System.out.println("Response Body: " + responseBody);

	    Assert.assertEquals(statusCode, 200);
		
		
	}

@Test(priority =4, dataProvider = "findPetId", dataProviderClass =DataProviders.class)

public void testfindPetId(int petid)
{

	Response response = PetEndpoints.findByPetId(petid);
	int statusCode = response.getStatusCode();
    String responseBody = response.getBody().asString();

    System.out.println("Status Code: " + statusCode);
    System.out.println("Response Body: " + responseBody);

    Assert.assertEquals(statusCode, 200);
	
	
}
@Test(priority =5, dataProvider = "UpdatePetData1", dataProviderClass =DataProviders.class)

public void testUpdatePet1(Pet pet)
{

	Response response = PetEndpoints.updatePet(pet);
	int statusCode = response.getStatusCode();
    String responseBody = response.getBody().asString();

    System.out.println("Status Code: " + statusCode);
    System.out.println("Response Body: " + responseBody);

    Assert.assertEquals(statusCode, 200);
	
	
}
@Test(priority =6, dataProvider = "DeleteById", dataProviderClass =DataProviders.class)

public void testdeleteById(int petid)
{

	Response response = PetEndpoints.deletePetById(petid);
	int statusCode = response.getStatusCode();
  String responseBody = response.getBody().asString();

  System.out.println("Status Code: " + statusCode);
  System.out.println("Response Body: " + responseBody);

  Assert.assertEquals(statusCode, 200);
	
	
}

}
