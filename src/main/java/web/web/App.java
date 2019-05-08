package web.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args ){
    	String url="https://www.google.co.uk/";
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop/chromedriver.exe");
    	ChromeDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get(url);
    	driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("dogs"+ Keys.ENTER);
    	driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div[2]/div/center/input[1]")).click();
    	
    	
    	driver.quit();
        
    }
}



////*[@id="tsf"]/div[2]/div/div[1]/div/div[1]/input