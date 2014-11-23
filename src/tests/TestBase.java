package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;

import datatable.Xls_Reader;

public class TestBase {

	public static Properties config= null;
	public static Properties OR = null;
	public static WebDriver wbDv = null;
	public static WebDriver driver=null;
	public static Xls_Reader datatable = null;
	
	@BeforeSuite
	public static void testTaylor() throws IOException{
		config = new Properties();
		FileInputStream fp= new FileInputStream(System.getProperty("user.dir")+ "\\src\\config\\config.properties");
	    config.load(fp);
	    
	    OR = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\config\\OR.properties");
		OR.load(fis);
		
		 datatable = new Xls_Reader(System.getProperty("user.dir")+ "\\src\\config\\controller.xlsx");
		
		/*if(config.getProperty("browsertype").equals("Firefox"))
		{
		 driver= new FirefoxDriver();
		}
		else if(config.getProperty("browsertype").equals("IE"))
		{
		 driver = new InternetExplorerDriver();
		}else if(config.getProperty("browsertype").equals("Chrome")){
		
			System.setProperty("webdriver.chrome.driver", "C:\\softwares\\chromedriver.exe");
		 driver = new ChromeDriver();
		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}*/
	}
	
	public static WebElement getObject(String xpathkey){
		try{
		return driver.findElement(By.xpath(OR.getProperty(xpathkey)));
		}catch(Throwable t){
			return null;
		}
	}
	
	public static void signin(String emailaddress,String password)
	{
		driver= new FirefoxDriver();
		driver.get(config.getProperty("testsiteURL"));
		driver.manage().window().maximize();
		
//		getObject("cookies_button").click();
		getObject("siginin_link").click();
		getObject("emailaddress").sendKeys(emailaddress);
		getObject("password").sendKeys(password);
		getObject("signinbutton").click();
	}
	
	public static void payment(String cardnumber, String cvnnumber) throws InterruptedException{
		
		getObject("shoppingcart_nextstep").click();
		getObject("license_Iagree_button").click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		getObject("Billingandshippinf_nextstep").click();
		getObject("revieworder_nextstep_button").click();
		new Select(driver.findElement(By.xpath("//*[@id='cardType']"))).selectByVisibleText("Visa");
		getObject("summary_nextstep").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		getObject("submit_button").click();
		
		getObject("Visacard1").click();
		getObject("cardnumber").sendKeys(cardnumber);
		getObject("cvnnumber").sendKeys(cvnnumber);
		
//		new Select(driver.findElement(By.xpath("//select[@id='card_expiry_month']"))).selectByVisibleText("12");
//		new Select(driver.findElement(By.xpath("//select[@id='card_expiry_year']"))).selectByVisibleText("2018");
		new Select(driver.findElement(By.xpath("//select[@id='card_expiry_month']"))).selectByValue("02");
	    new Select(driver.findElement(By.xpath("//select[@id='card_expiry_year']"))).selectByValue("2015");
		getObject("paybutton").click();
		
	}
}

