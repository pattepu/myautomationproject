package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.TestUtil;

public class BrowseBySubject extends TestBase {

	@Test(dataProvider="getData")
	public void browsebysubjectTest(String cardnumber,String cvnnumber) throws InterruptedException{
		
		signin("ppreeti4395@gmail.com", "June@123");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='banner-proceed-button']")).click();
		getObject("browsebysubject_link").click();
		getObject("browsebysubject_actioninteachereducation_link").click();
		getObject("purchaseissue_link").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		payment(cardnumber,cvnnumber);
		driver.quit();
	}
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData("DatabasesBrowseTest");
}
}
