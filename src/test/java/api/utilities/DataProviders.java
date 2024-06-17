package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

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
	
}
