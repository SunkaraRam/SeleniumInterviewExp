package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "d://JARS//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("http://billing.scriptinglogic.net/index.php/sessions/login");
		
		WebElement ele=   driver.findElement(By.name("btn_login"));
		
		System.out.println("'type' " + ele.getAttribute("type"));
		
		System.out.println("'Color of button'  " + ele.getCssValue("color"));
	
		System.out.println("'Style of button' " + ele.getCssValue("font-style"));
	
		System.out.println("'value of button' " + ele.getAttribute("value"));
		
		driver.quit();
		
	}

}
