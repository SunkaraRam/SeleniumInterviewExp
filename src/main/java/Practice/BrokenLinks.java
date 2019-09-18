package Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "d://JARS//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
				
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		//1. Get the list of all Links and Images
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		
		linklist.addAll(driver.findElements(By.tagName("img")));
		
		int lksize = linklist.size();
		
		System.out.println(lksize);
		
		List<WebElement> activelinks = new ArrayList<WebElement>();
		
		//2.Iterate linklist
		
		for (int i = 0; i < lksize; i++) {
			
			if (linklist.get(i).getAttribute("href") != null) {
				
				activelinks.add(linklist.get(i));
				
			}
			
		}
		
		System.out.println("Size of active links and images -- > "+ activelinks.size());
		
		System.out.println("Size of All links and images -- > "+ lksize);
	
		for (int j = 0; j < activelinks.size(); j++) {
			
		HttpURLConnection connection =	(HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			
		connection.connect();
		
		String responce =connection.getResponseMessage();
		
		connection.disconnect();
		
		//System.out.println(activelinks.get(j).getAttribute("href")+" ---->"+responce);
		
		if (!("OK".equalsIgnoreCase("OK"))) {
			
			System.out.println(activelinks.get(j).getAttribute("href")+" ---->"+responce);
		}
		
		}
		
		
	}

}
