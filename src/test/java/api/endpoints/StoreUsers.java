package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;


import api.payload.StoreInventory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreUsers {
	
	static ResourceBundle getURL()
	{
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");  // Load Properties file
		
		return routes;
	}
	
	public static Response storeInventory()
	{
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.log().all()
		
		
		.when()
		.get(Routes.store_inv_url);
		
		
		return response;
		
	}	
	
	public static Response orderPets(StoreInventory storeinventorypayload)
	{
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(storeinventorypayload)
		.log().all()
		
		.when()
		.post(Routes.order_url);
		
		return response;
		
	}
	
		
}
