package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExamplePros {

	WebDriver driver;
	Properties p;
	@BeforeTest
	public void start() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
		
		driver = new ChromeDriver();
		
		FileInputStream fi = new FileInputStream("D:\\SeleniumInterviewExp\\PropertiesFiles\\secure.properties");

		p = new Properties();
		
		p.load(fi);
		
		driver.get(p.getProperty("url"));
	}
	
	@Test
	public void launch() {
		
		driver.findElement(By.id(p.getProperty("username"))).sendKeys("Admin");;
		driver.findElement(By.id(p.getProperty("password"))).sendKeys("Qedge123!@#");;
		driver.findElement(By.id(p.getProperty("login"))).click();;
	}
	@AfterTest
	public void stop() {
		
		driver.close();
		
	}

}
