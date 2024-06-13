package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OrderorDeleteById {
	
	public static Response orderById(int orderid)
	{
		Response response= given()
		 .accept(ContentType.JSON)
		 .pathParam("orderid", orderid )
		 
		 .when()
		 .get(Routes.orderby_id_url);
		 
		 return response;
		
	}
	
	
	public static Response deleteorderById(int orderid)
	{
		Response response= given()
		 .accept(ContentType.JSON)
		 .pathParam("orderid", orderid )
		 
		 .when()
		 .get(Routes.deleteby_id_url);
		 
		 return response;
		
	}

}
