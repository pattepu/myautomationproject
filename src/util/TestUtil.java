package util;
import tests.TestBase;

public class TestUtil extends TestBase{
	
	/*public static boolean isSkip(String testCase){
		for(int i=2; i<=datatable.getRowCount("Testcases");i++ ){
	    	  if(datatable.getCellData("Testcases", "TCID", i).equals(testCase)){
	    		  if(datatable.getCellData("Testcases", "Runmode", i).equals("Y"))
	    			  return false;
	    		  else
	    			  return true;
	    	  }
	    	  
	      }
		
		return false;
	}
	*/
	public static Object[][] getData(String sheetName){
		// return test data;
		// read test data from xls
		
		int rows=datatable.getRowCount(sheetName)-1;
		if(rows <=0){
			Object[][] testData =new Object[1][0];
			return testData;
			
		}
	    rows = datatable.getRowCount(sheetName);  // 3
		int cols = datatable.getColumnCount(sheetName);
		System.out.println("total rows -- "+ rows);
		System.out.println("total cols -- "+cols);
		Object data[][] = new Object[rows-1][cols];
		
		for( int rowNum = 2 ; rowNum <= rows ; rowNum++){
			
			for(int colNum=0 ; colNum< cols; colNum++){
				data[rowNum-2][colNum]=datatable.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		return data;
	}
}
