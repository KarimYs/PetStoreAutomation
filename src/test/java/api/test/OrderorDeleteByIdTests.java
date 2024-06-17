//package api.test;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import api.endpoints.OrderorDeleteById;
//import api.payload.Order;
//import api.utilities.DataProviders;
//import io.restassured.response.Response;
//
//public class OrderorDeleteByIdTests {
//	
//	@Test(priority=1, dataProvider = "OrderById", dataProviderClass=DataProviders.class)
//	
//public void testGetOrderId(int orderid) 
//	{
//        Response response = OrderorDeleteById.orderById(orderid);
//        int statusCode = response.getStatusCode();
//	    String responseBody = response.getBody().asString();
//		
//	    System.out.println("Status Code: " + statusCode);
//	    System.out.println("Response Body: " + responseBody);
//
//	    Assert.assertEquals(statusCode, 200);
//    }
//}
