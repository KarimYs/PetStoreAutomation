package api.utilities;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.DataProvider;

import api.payload.Pet;

public class DataProviders {
	
	@DataProvider(name = "Data")
	
	public String [][] getAllData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/UserData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum = xl.getRowCount("Sheet1");
		int colcount = xl.getCellCount("Sheet1", 1);
		
		String apidata [][] = new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		return apidata;
	}
	
@DataProvider(name = "UpdateData")
	
	public String [][] getUpdateData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/UserData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum = xl.getRowCount("Sheet2");
		int colcount = xl.getCellCount("Sheet2", 1);
		
		String apidata [][] = new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j] = xl.getCellData("Sheet2", i, j);
			}
		}
		return apidata;
	}

	@DataProvider(name = "UserNames")
	
	public String [] getUserName() throws IOException
	{
		String path = System.getProperty("user.dir")+"/UserData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum =xl.getRowCount("Sheet1");
		String apidata[] = new String[rownum];
		
		for(int i =1; i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("Sheet1", i, 1);
		}
		
		return apidata;
	}
	
	@DataProvider(name = "Order")
	
	public String [][] getOrder() throws IOException
	{
		String path = System.getProperty("user.dir")+"/StoreData.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum = xl.getRowCount("Sheet1");
		int colcount = xl.getCellCount("Sheet1", 1);
		
		String apidata [][] = new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		return apidata;
	}
	
  @DataProvider(name = "OrderById")
	
public Object[] getOrderById() throws IOException {
    String path = System.getProperty("user.dir") + "/OrderData.xlsx";
    XLUtility xl = new XLUtility(path);

    int rownum = xl.getRowCount("Sheet1");
    Object[] apidata = new Object[rownum];

    for (int i = 1; i <= rownum; i++) {
        // Convert the cell data to an integer
        apidata[i - 1] = Integer.parseInt(xl.getCellData("Sheet1", i, 0)); // column index 0 for orderId
    }

    return apidata;
}
  
  @DataProvider(name = "PetData")
  public Object[][] getPetData() throws Exception {
      String path = System.getProperty("user.dir") + "/PetData.xlsx";
      XLUtility xl = new XLUtility(path);

      int rownum = xl.getRowCount("Sheet1");

      // We will return an array of Pet objects
      Object[][] apidata = new Object[rownum][1];

      for (int i = 1; i <= rownum; i++) {
          Pet pet = new Pet();

          Pet.Category category = new Pet.Category();
          category.setId(Integer.parseInt(xl.getCellData("Sheet1", i, 1)));
          category.setName(xl.getCellData("Sheet1", i, 2));

          Pet.Tag tag = new Pet.Tag();
          tag.setId(Integer.parseInt(xl.getCellData("Sheet1", i, 3)));
          tag.setName(xl.getCellData("Sheet1", i, 4));

          pet.setId(Integer.parseInt(xl.getCellData("Sheet1", i, 0)));
          pet.setCategory(category);
          pet.setName(xl.getCellData("Sheet1", i, 5));
          pet.setPhotoUrls(Arrays.asList(xl.getCellData("Sheet1", i, 6)));
          pet.setTags(Arrays.asList(tag));
          pet.setStatus(xl.getCellData("Sheet1", i, 7));

          apidata[i - 1][0] = pet;
      }

      return apidata;
  }
  
  @DataProvider(name = "UpdatePetData")
  public Object[][] getUpdatePetData() throws Exception {
      String path = System.getProperty("user.dir") + "/PetData.xlsx";
      XLUtility xl = new XLUtility(path);

      int rownum = xl.getRowCount("Sheet2");

      // We will return an array of Pet objects
      Object[][] apidata = new Object[rownum][1];

      for (int i = 1; i <= rownum; i++) {
          Pet pet = new Pet();

          Pet.Category category = new Pet.Category();
          category.setId(Integer.parseInt(xl.getCellData("Sheet2", i, 1)));
          category.setName(xl.getCellData("Sheet2", i, 2));

          Pet.Tag tag = new Pet.Tag();
          tag.setId(Integer.parseInt(xl.getCellData("Sheet2", i, 3)));
          tag.setName(xl.getCellData("Sheet2", i, 4));

          pet.setId(Integer.parseInt(xl.getCellData("Sheet2", i, 0)));
          pet.setCategory(category);
          pet.setName(xl.getCellData("Sheet2", i, 5));
          pet.setPhotoUrls(Arrays.asList(xl.getCellData("Sheet2", i, 6)));
          pet.setTags(Arrays.asList(tag));
          pet.setStatus(xl.getCellData("Sheet2", i, 7));

          apidata[i - 1][0] = pet;
      }

      return apidata;
  }
  
  @DataProvider(name = "FindByStatus")
	
  public Object[] getFindByStatus() throws IOException {
      String path = System.getProperty("user.dir") + "/PetData.xlsx";
      XLUtility xl = new XLUtility(path);

      int rownum = xl.getRowCount("Sheet3");
      Object[] apidata = new Object[rownum];

      for (int i = 1; i <= rownum; i++) {
          
          apidata[i - 1] = xl.getCellData("Sheet3", i, 0); // column index 0 for orderId
      }

      return apidata;
  }

  
  @DataProvider(name = "findPetId")
	
  public Object[] getfindPetId() throws IOException {
      String path = System.getProperty("user.dir") + "/PetData.xlsx";
      XLUtility xl = new XLUtility(path);

      int rownum = xl.getRowCount("Sheet4");
      Object[][] apidata = new Object[rownum][1];

      for (int i = 1; i <= rownum; i++) {
    	  apidata[i - 1][0] = Integer.parseInt(xl.getCellData("Sheet4", i, 0));
      }

      return apidata;
  }
  
  @DataProvider(name = "UpdatePetData1")
  public Object[][] getUpdatePetData1() throws Exception {
      String path = System.getProperty("user.dir") + "/PetData.xlsx";
      XLUtility xl = new XLUtility(path);

      int rownum = xl.getRowCount("Sheet5");

      // We will return an array of Pet objects
      Object[][] apidata = new Object[rownum][1];

      for (int i = 1; i <= rownum; i++) {
          Pet pet = new Pet();
          pet.setId(Integer.parseInt(xl.getCellData("Sheet5", i, 0)));
          pet.setName(xl.getCellData("Sheet5", i, 1));
          pet.setStatus(xl.getCellData("Sheet5", i, 2));

          apidata[i - 1][0] = pet;
      }

      return apidata;
  }
  
  @DataProvider(name = "DeleteById")
	
  public Object[] getDeleteById() throws IOException {
      String path = System.getProperty("user.dir") + "/PetData.xlsx";
      XLUtility xl = new XLUtility(path);

      int rownum = xl.getRowCount("Sheet6");
      Object[] apidata = new Object[rownum];

      for (int i = 1; i <= rownum; i++) {
          
          apidata[i - 1] = Integer.parseInt(xl.getCellData("Sheet6", i, 0)); // column index 0 for orderId
      }

      return apidata;
  }
	
}
