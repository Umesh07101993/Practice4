import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IE11 {

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.ie.driver", "./IEDriverServer.exe");
		
		WebDriver driver = new InternetExplorerDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com");
	}

}
