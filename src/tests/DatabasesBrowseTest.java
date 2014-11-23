package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.TestUtil;

public class DatabasesBrowseTest extends TestBase{

	@Test(dataProvider="getData")
	public void databasesbrowseTest(String cardnumber,String cvnnumber) throws InterruptedException{
	
		signin("ppreeti4395@gmail.com", "June@123");
		driver.manage().window().maximize();
		
		getObject("browsetab").click();
		
		driver.findElement(By.xpath("//input[@id='banner-proceed-button']")).click();
		
		getObject("databases").click();
		getObject("databasetitle").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		getObject("payasyougoaccess_button").click();
		//getObject("Buynow_link").click();
		
		getObject("studiesonwomenandgenderabstract").click();
		getObject("addtocart_button").click();
		
		payment(cardnumber,cvnnumber);
		driver.quit();
		
	}
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData("DatabasesBrowseTest");
	}
}
