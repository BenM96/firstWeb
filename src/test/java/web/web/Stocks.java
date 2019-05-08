package web.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Stocks {
	
	static WebDriver driver;
	String url="https://www.hl.co.uk/shares/stock-market-summary/ftse-100";
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop/chromedriver.exe");
		driver=new ChromeDriver();	
		
	}
	
	@AfterClass
	public static void tearDown() throws InterruptedException {
		//TimeUnit.SECONDS.sleep(5);
		driver.quit();
	}
	
	@Test
	public void test1() {		
		driver.get(url);
		WebElement table= driver.findElement(By.xpath("//*[@id=\"view-constituents\"]/div/table/tbody"));
		
		List<WebElement> rows= table.findElements(By.tagName("tr"));		
		String maxName = null;
		String minName= null;
		Double max=0.00;
		Double min=0.00;
		for(WebElement row : rows) {
			List<WebElement> cols= row.findElements(By.tagName("td"));
			String name= cols.get(0).getAttribute("innerHTML");
			String changeS=cols.get(3).findElement(By.tagName("span")).getAttribute("innerHTML");
			Double change= Double.parseDouble(changeS);
			System.out.println(name+change);
			if(change>max) {
				max=change;
				maxName=name;
			}
			if(change<min) {
				min=change;
				minName=name;
			}
			
		}
		System.out.println("max: "+ maxName+max);
		System.out.println("min: "+ minName+min);
		
	}

}
