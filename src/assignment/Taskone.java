package assignment;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import repo.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import repo.Uirepo;

import static io.restassured.RestAssured.*;

public class Taskone extends Base{

	@Test
	public static void main() throws InterruptedException {
		// TODO Auto-generated method stub
	//	WebDriver dr=null;
		
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		PageFactory.initElements(dr, repo.Uirepo.class);
		
		Uirepo ui=new Uirepo();
		
		
		//ui arraylist
		List<WebElement> actualuilist=ui.imdbsearch(dr);
		
		//ui
		ArrayList<String> actualtitles=ui.api(dr);
		
		
		//ui code
		
			Boolean fl=ui.verify(actualtitles, actualuilist);
			
				Assert.assertTrue(fl);
				if(fl==true)
				{
					System.out.println("bc chala gaya");
				}
			
		

	}

}
