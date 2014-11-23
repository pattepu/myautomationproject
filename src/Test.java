import datatable.Xls_Reader;


public class Test {
public static void main(String args[]){
	System.out.println(System.getProperty("user.dir"));
	Xls_Reader datatable = new Xls_Reader(System.getProperty("user.dir")+"\\src\\config\\controller.xlsx");
	

	System.out.println(datatable.getCellData("TestCases","TCID",2));
	System.out.println(datatable.getRowCount("TestCases"));

	for(int i=2;i<=datatable.getRowCount("TestCases");i++){
		 if(datatable.getCellData("TestCases", "Runmode", i).equals("Y"))
			  System.out.println("Runmode is Yes");
		  else
			  System.out.println("Runmode is No");
	}
	
	}
	
	boolean b =Boolean.valueOf("true");
}

