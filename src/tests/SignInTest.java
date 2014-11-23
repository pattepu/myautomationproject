package tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.TestUtil;

public class SignInTest extends TestBase{

	@Test(dataProvider="getData")
	public void signinTest(String emailaddress,String password){
	
		signin( emailaddress, password);
		driver.quit();
}
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData("SignInTest");
	}
}
