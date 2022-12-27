package TestCases;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Start_Test_FromHere 
{
  static WebDriver driver;
  
  @BeforeMethod
  public  void beforeClass()
   {
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver(); 
	driver.get("https://www.rediff.com/");
	driver.manage().window().maximize();
   }

  @AfterMethod
  public void afterClass() 
   {
	  driver.quit();
   }
  
  
}
