package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.TestUtil;

public class Advanced extends TestBase {

	@Test(dataProvider="getData")
	
	public void advancedsearch(String searcheverything,String articletitle,String publicationtitle,String author,String issndoi,String abstracted,String keywords,String selectsearcheverything,String selectarticletitle,String selectpublicationtitle, String selectauthor, String selectissndoi, String selectabstract,
			String journaltitle,String volume,String issue,String startpage, String fromday,String frommonth,String fromyear,String today,String tomonth,String toyear,String testType){
		driver.get(config.getProperty("testsiteURL"));
		getObject("browse_advancedandcitation_search").click();	
		getObject("advanced_journals_search").click();	
		getObject("advanced_referenceworks_search").click();	
		getObject("advanced_allcontent").click();	
		getObject("advanced_onlycontentihavefullaccess").click();	
		getObject("advanced_searcheverything").sendKeys(searcheverything);
		getObject("advanced_articletitle").sendKeys(articletitle);
		getObject("advanced_publicationtitle").sendKeys(publicationtitle);
		getObject("advanced_author").sendKeys(author);
		getObject("advanced_issndoi").sendKeys(issndoi);
		getObject("advanced_abstract").sendKeys(abstracted);
		getObject("advanced_keywords").sendKeys(keywords);
		getObject("advanecd_searcheverything_select").sendKeys(selectsearcheverything);	
		getObject("advanced_articletitle_select").sendKeys(selectarticletitle);	
		getObject("advanced_publicationtitle_select").sendKeys(selectpublicationtitle);
		getObject("advanced_author_select").sendKeys(selectauthor);	
		getObject("advanced_issndoi_select").sendKeys(selectissndoi);	
		getObject("advanced_abstract_select").sendKeys(selectabstract);
//		getObject("advanced_search_button").click();
		driver.manage().window().maximize();
		
//		getObject("citationsearch_journaltitle").sendKeys(journaltitle);
//		getObject("citationsearch_volume").sendKeys(volume);
//		getObject("citationsearch_issue").sendKeys(issue);
//		getObject("citationsearch_startpage").sendKeys(startpage);
//		getObject("citationsearch_search").click();
//		getObject("publicationdate_alldates").click();
//		getObject("publication_lastweek").click();
//		getObject("publication_last3months").click();
//		getObject("publication_last6months").click();
//		getObject("publication_lastyear").click();
//		getObject("publication_frombutton").click();
//		getObject("publication_fromday").sendKeys(fromday);
//		getObject("publicationfrommonth").sendKeys(frommonth);
//		getObject("publicationfromyear").sendKeys(fromyear);
//		getObject("publicationtoday").sendKeys(today);
//		getObject("publicationtomonth").sendKeys(tomonth);
//		getObject("publicationtoyear").sendKeys(toyear);
//		getObject("filterbyimprint_tandf").click();
//		getObject("filterbyimprint_routledge").click();
//
//		getObject("advanced_search_button").click();
		
		
	}
	
	@DataProvider
	
	public Object[][] getData(){
	return TestUtil.getData("Advanced");
	
	}
}
