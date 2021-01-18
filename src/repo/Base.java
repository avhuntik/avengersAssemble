package repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {

	public static WebDriver dr;
	@BeforeTest
	public void initializedriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\l1\\Documents\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\l1\\Documents\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		dr=new ChromeDriver(options);
			dr.get("https://www.imdb.com/");
			
	}
	
	@AfterTest
	public void tearndown()
	{
		dr.quit();
	}
}
