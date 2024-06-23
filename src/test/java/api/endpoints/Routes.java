package api.endpoints;

/*
 Swagger URL : https://petstore.swagger.io
 Create User (Post) : https://petstore.swagger.io/v2/user
 Get User (Get) : https://petstore.swagger.io/v2/user/{username}
 Update user(Put) : https://petstore.swagger.io/v2/user/{username}
 Delete User (Delete) : https://petstore.swagger.io/v2/user/{username}
  
  */

public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	public static String store_url = "https://petstore.swagger.io/v2/store";

	
	//User Module
	
	public static String post_url = base_url +"/user";
	public static String get_url = base_url +"/user/{username}";
	public static String update_url = base_url +"/user/{username}";
	public static String delete_url = base_url +"/user/{username}";
	
	//Store Module
	
	public static String store_inv_url = store_url +"/inventory";
	public static String order_url = store_url +"/order";
	public static String orderby_id_url = store_url+"/order/{orderid}";
	public static String deleteby_id_url = store_url+"/order/{orderid}";
	
	
	
	
	//Pet Module
	
	public static String order_pet_url = base_url +"/pet";
	public static String update_existing_pet_url = base_url +"/pet";
	public static String findby_status_pet_url = base_url +"/pet/findByStatus";
	public static String get_pet_url = base_url + "/pet/{petid}";
	public static String update_pet_url = base_url + "/pet/{petid}";
	public static String delete_pet_url = base_url + "/pet/{petid}";
	
	
	

}
