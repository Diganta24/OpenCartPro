package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
			{
				String path=".\\testData\\DataDrivenOpenCart.xlsx";
				ExcelUtility xlu=new ExcelUtility(path);
				int totalrows=xlu.getRowCount("logdata");
				int totalcols=xlu.getCellCount("logdata", 1);
				String logindata[][]=new String[totalrows][totalcols];
				for(int i=1;i<=totalrows;i++)
				{
					for(int j=0;j<totalcols;j++)
					{
						logindata[i-1][j]=xlu.getCelldata("logdata", i, j);
					}
				}
				return logindata;
				
			}
	
}
