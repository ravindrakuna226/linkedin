package linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
 
public class logintestcase {
    public String username = "YOUR_USERNAME";
    public String accesskey = "YOUR_ACCESSKEY";
    public static RemoteWebDriver driver = null;
    //public String gridURL = "@hub.lambdatest.com/wd/hub";
 
@BeforeClass
@Parameters("browser")
public void setUp(String browser) throws Exception {
 
        DesiredCapabilities capabilities = new DesiredCapabilities();
 
        if (browser.equalsIgnoreCase("Chrome")) {
                capabilities.setCapability("browserName", "ChromeDriver");
                capabilities.setCapability("version", "107.0");
                capabilities.setCapability("platform", "win11"); // If this cap isn't specified, it will just get the any available one
                capabilities.setCapability("build", "LoginTest");
                capabilities.setCapability("name", "LoginTestInChrome");
        }
       
        
        try {
        	WebDriver driver=new ChromeDriver();    
        	//driver = new ChromeDriver();
        } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
 
}
 
@Test()
public void test_1() {
 
        String url = "https://www.linkedin.com/";
 
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts(); //.pageLoadTimeout(10, TimeUnit.SECONDS);
 
 
        WebElement login = driver.findElement(By.linkText("Login"));
        System.out.println("Clicking on the login element in the main page");
        login.click();
 
        driver.manage().timeouts();
        //pageLoadTimeout(10,TimeUnit.SECONDS);
 
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
 
        email.clear();
        System.out.println("Entering the email");
        email.sendKeys("your_email");
 
        password.clear();
        System.out.println("entering the password");
        password.sendKeys("your_password");
 
        System.out.println("Clicking login button");
        loginButton.click();
 
        String title = "Welcome - LambdaTest";
 
        String actualTitle = driver.getTitle();
 
        System.out.println("Verifying the page title has started");
        Assert.assertEquals(actualTitle,title,"Page title doesnt match");
 
        System.out.println("The page title has been successfully verified");
 
        System.out.println("User logged in successfully");
 
 
    }
 
    @AfterClass
    public void closeBrowser() {
        driver.close();
 
    }
}