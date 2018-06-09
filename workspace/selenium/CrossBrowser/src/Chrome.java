import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.amazon.com");
		
		
		
		
	}

}
