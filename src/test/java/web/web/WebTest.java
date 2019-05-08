package web.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebTest {
	
	static WebDriver driver;
	String url="http://thedemosite.co.uk/";
	
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop/chromedriver.exe");
		driver=new ChromeDriver();	
		
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
	@Test
	public void test1() {
		driver.get(url);
		driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
		assertEquals(driver.getCurrentUrl(),"http://thedemosite.co.uk/login.php");
	}
	
	@Test
	public void test2() {
		driver.get(url);
		driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
		driver.findElement(By.name("username")).sendKeys("john"+Keys.TAB+"1234"+Keys.TAB+Keys.ENTER);
	}

}
