package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.config.ConnectionConfig;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import api.payload.Pet;

public class PetEndpoints {
	
	public static void main(String[] args) {
        try {
            URL url = new URL("https://petstore.swagger.io/v2/pet");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static Response addPet(Pet pet)
	{
        int retryCount = 3;
        Response response = null;
        for (int i = 0; i < retryCount; i++) 
        {
            try 
            {
                response = given()
                		.accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .body(pet)
                        .log().all()
                        .when()
                        .post(Routes.order_pet_url);
                
                
                if (response.getStatusCode() != 0) 
                {
                    break;
                }
            } catch (Exception e) 
            {
                System.out.println("Retrying... " + (i + 1));
            }
        }
        return response;
        
	} 
	
	
	public static Response updatePet(Pet pet)
	{
			Response response= given() 
                		.accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .body(pet)
                        .log().all()
                        .when()
                        .post(Routes.update_existing_pet_url);
                
			return response;
                
       }
	
	public static Response findByStatus(String status)
	{
			Response response= given() 
                		.accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .queryParam("status", status)
                        .log().all()
                        .when()
                        .get(Routes.findby_status_pet_url);
                
			return response;
                
       }
	
	public static Response findByPetId(int petid)
	{
			Response response= given() 
                		.accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .pathParam("petid", petid)
                        .log().all()
                        .when()
                        .get(Routes.get_pet_url);
                
			return response;
                
       }
	public static Response updatePet1(Pet pet)
	{
			Response response= given() 
                		.accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .body(pet)
                        .log().all()
                        .when()
                        .post(Routes.update_pet_url);
                
			return response;
                
       }
        
	public static Response deletePetById(int petid)	
	{
			Response response= given() 
                		.accept(ContentType.JSON)
                        .pathParam("petid", petid)
                        .log().all()
                        .when()
                        .post(Routes.delete_pet_url);
                
			return response;
                
       }
        
	} 
	
	


