package repo;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Uirepo {
	
	public static WebDriver dr;
	
	@FindBy(xpath="//div[normalize-space()='All']")
	public static WebElement all;
	
	@FindBy(xpath="//a[@aria-label='Titles']")
	public static WebElement titles;
	
	@FindBy(xpath="//input[@id='suggestion-search']")
	public static WebElement searchentry;
	
	@FindBy(xpath="html/body/div[3]/div/div[2]/div/div[1]/div/div[2]/table/tbody/tr/td/a")
	public static List<WebElement> movielist;
	
	/*public Uirepo(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(driver, this);
	}*/
	
	public ArrayList<String> api(WebDriver driver)
	{
		
		RestAssured.baseURI="http://www.omdbapi.com/";
		HashMap<String, String> hs=new HashMap<String, String>();
		hs.put("apikey", "66e2267d");
		hs.put("type", "movie");
		hs.put("s", "lord of the rings");
		
		JsonPath response=given().log().all()
				.queryParams(hs).get()
				.then().log().all().assertThat().statusCode(200).extract().response().jsonPath();
		
		System.out.println(response);
		ArrayList<String> al=new ArrayList<String>();
		int i=response.getInt("Search.size()");
		System.out.println(i);
		String actual="";
		ArrayList<String> arr=new ArrayList<String>();
		
		arr.add("The Lord of the Rings: The Fellowship of the Ring");
		arr.add("The Lord of the Rings: The Two Towers");
		arr.add("The Lord of the Rings: The Return of the King");

		for(int a=0;a<i;a++)
		{
			actual=response.get("Search["+a+"].Title");
			
				if(arr.contains(actual))
				{
					al.add(response.get("Search["+a+"].Title"));
				}
		}
		return al;
	}
	
	public static List<WebElement> imdbsearch(WebDriver driver) throws InterruptedException
	{
		
			
			all.click();
			titles.click();
			searchentry.sendKeys("lord of the rings");
			searchentry.sendKeys(Keys.ENTER);
			List<WebElement> uilist=movielist;
			return uilist;
	}
	
	public boolean verify(ArrayList<String> apimov, List<WebElement> uimov)
	{
		Iterator<WebElement> it=uimov.iterator();
		ArrayList<String> al3=new ArrayList<String>();
		boolean flag=false;
		while(it.hasNext())
		{
			al3.add(it.next().getText());
			
		}
		String act="";
		for(int y=0;y<apimov.size();y++)
		{
			act=apimov.get(y);
			
			if(al3.contains(act))
			{
				flag=true;
			}
			else
			{
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	

}
