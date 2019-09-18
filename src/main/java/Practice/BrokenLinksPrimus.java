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

public class BrokenLinksPrimus {

	public static void main(String[] args) throws MalformedURLException, Throwable {
		
		System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
				
		driver.get("http://primusbank.qedgetech.com/personal_banking.html");
		
		List<WebElement> linklists = driver.findElements(By.tagName("a"));
		
		linklists.addAll(driver.findElements(By.tagName("img")));
		
		int size = linklists.size();
		
		System.out.println(size);
		
		List<WebElement> activelinks= new ArrayList<WebElement>();
		
		for (int i = 0; i < size; i++) {
			
			if (linklists.get(i).getAttribute("href")!=null) {
				
				activelinks.add(linklists.get(i));
			}
			
		}
		
	System.out.println("Size of active links and images -- > "+ activelinks.size());
		
		System.out.println("Size of All links and images -- > "+ size);
	
		for (int j = 0; j < activelinks.size(); j++) {
			
		HttpURLConnection connection = (HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			
		connection.connect();
		
		String responce = connection.getResponseMessage();
		
		System.out.println(responce);
		
		connection.disconnect();
				
		if (("OK".equalsIgnoreCase("OK"))) {
			
			System.out.println(activelinks.get(j).getAttribute("href")+"--->"+responce);
			
		}
		
		
		
		}
		
		
	}

}
