package api.test;

import static io.restassured.RestAssured.given;
import java.time.LocalDateTime;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.payload.StoreInventory;
import api.endpoints.OrderorDeleteById;
import api.endpoints.StoreUsers;
import api.endpoints.UserEndPoints;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class StoreTests {
	
	@Test(priority = 1, dataProvider = "Order", dataProviderClass = DataProviders.class)
	
	public void testPostOrderPets(String ID, String petId, String quantity, String shipDate, String status, String complete) {
	    StoreInventory storeinventorypayload = new StoreInventory();
	    
	    // Convert String arguments to appropriate data types
	    int convertedID = Integer.parseInt(ID);
	    int convertedPetId = Integer.parseInt(petId);
	    int convertedQuantity = Integer.parseInt(quantity);
	    boolean convertedComplete = Boolean.parseBoolean(complete);
	    
	    storeinventorypayload.setId(convertedID);
	    storeinventorypayload.setPetId(convertedPetId);
	    storeinventorypayload.setQuantity(convertedQuantity);
	    storeinventorypayload.setShipDate(new Date());
	    storeinventorypayload.setStatus(status);
	    storeinventorypayload.setComplete(convertedComplete);
	    
	    Response response = StoreUsers.orderPets(storeinventorypayload);
	    Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProviderClass= DataProviders.class)
	
	public void testStoreInventory()
	{
		Response response = StoreUsers.storeInventory();
	    int statusCode = response.getStatusCode();
	    String responseBody = response.getBody().asString();
		
	    System.out.println("Status Code: " + statusCode);
	    System.out.println("Response Body: " + responseBody);

	    Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority=3, dataProvider = "OrderById", dataProviderClass=DataProviders.class)
	
	public void testGetOrderId(int orderid) 
		{
	        Response response = OrderorDeleteById.orderById(orderid);
	        int statusCode = response.getStatusCode();
		    String responseBody = response.getBody().asString();
			
		    System.out.println("Status Code: " + statusCode);
		    System.out.println("Response Body: " + responseBody);

		    Assert.assertEquals(statusCode, 200);
	    }
	
	
@Test(priority=4, dataProvider = "OrderById", dataProviderClass=DataProviders.class)
	
	public void testdeleteOrderId(int orderid) 
		{
	        Response response = OrderorDeleteById.deleteorderById(orderid);
	        int statusCode = response.getStatusCode();
		    String responseBody = response.getBody().asString();
			
		    System.out.println("Status Code: " + statusCode);
		    System.out.println("Response Body: " + responseBody);

		    Assert.assertEquals(statusCode, 200);
	    }
	
}
	

