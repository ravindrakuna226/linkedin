package linkedin;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class linkedinlogin {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\RAVINDRA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//System.setProperty("webdriver.edge.driver","D:\\Automationfiles\\msedgedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.linkedin.com/");
		driver.findElement(By.id("session_key") ).sendKeys("");
		driver.findElement(By.id("session_password")).sendKeys("");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.cssSelector("div[aria-label='Account']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
		driver.findElement(By.xpath("//span[text()='Log Out']")).click();
		driver.close();

	}

}
