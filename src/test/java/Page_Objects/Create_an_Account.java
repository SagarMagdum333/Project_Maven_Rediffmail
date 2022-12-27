package Page_Objects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility_Section.ReadConfig;

public class Create_an_Account 
{
  public static WebElement CreateAccount(WebDriver driver)
  {

	 WebElement element = driver.findElement(By.xpath("//a[@title='Create Rediffmail Account']"));
	return element;
  }
	
  public static WebElement FullName(WebDriver driver)
  {
	 WebElement element= driver.findElement(By.xpath("//input[@maxlength='61']"));
	 return element;	 
  }

  public static WebElement EnterMailID(WebDriver driver)
  {
	 WebElement element= driver.findElement(By.xpath("//input[@onclick='javascript:UncheckAllOptions();']"));
	return element;	 
  }
 
  public static WebElement Password(WebDriver driver)
  {
 	 WebElement element= driver.findElement(By.xpath("//input[@id='newpasswd']"));
 	return element;	 
  }
 
  public static WebElement RetypePassword(WebDriver driver)
  {
 	 WebElement element= driver.findElement(By.xpath("//input[@id='newpasswd1']"));
 	return element;	 
  }
  //Remaining
  public static WebElement SecurityQuestion(WebDriver driver)
  {
 	 WebElement element= driver.findElement(By.xpath("//select[@style='width:285px;']"));
 	return element;	 
  }
    
  public static WebElement AltEmail(WebDriver driver)
  {
 	 WebElement element= driver.findElement(By.xpath("//input[@maxlength='100']"));
 	return element;	 
  }
  
  public static WebElement CheckBox(WebDriver driver)
  {
 	 WebElement element= driver.findElement(By.xpath("//input[@class='nomargin']"));
 	return element;	 
  }
  
  public static WebElement Mobnumber(WebDriver driver)
  {
 	 WebElement element= driver.findElement(By.xpath("//input[@style='width:125px;height:inherit;']"));
 	return element;	 
  }
  //It is problematic Element
  /*
  public static WebElement Day_dropdown(WebDriver driver)
  {
 	 WebElement element= driver.findElement(By.xpath("//select[@name='DOB_Dayc5e64206']"));
 	return element;	 
  }
  */
  
  public static WebElement Month_Dropdown(WebDriver driver)
  {
 	 WebElement element= driver.findElement(By.xpath("//select[@onchange='fieldTrack(this);'][2]"));
 	return element;	 
  }
  
  public static WebElement Year_Dropdown(WebDriver driver)
  {
 	 WebElement element= driver.findElement(By.xpath("//select[@onchange='fieldTrack(this);'][3]"));
 	return element;	 
  }
  
  public static WebElement Country_Dropdown(WebDriver driver)
  {
 	WebElement element= driver.findElement(By.xpath("//select[@id='country']"));
 	return element;	 
  }
  
  public static WebElement City_Dropdown(WebDriver driver)
  {
 	WebElement element= driver.findElement(By.xpath("//select[@style='width:183px;']"));
 	return element;	 
  }
  
  public static WebElement Capecha_Enter(WebDriver driver)
  {
 	WebElement element= driver.findElement(By.xpath("//input[@style='width:183px;']"));
 	return element;	 
  }
  
  public static WebElement Click_Enter(WebDriver driver)
  {
 	WebElement element= driver.findElement(By.xpath("//input[@value='Create my account >>']"));
 	return element;	 
  }
    
static ReadConfig Config= new ReadConfig();
  
 public static String FullName = Config.FullNameS();
 public String Mail= Config.RediffmailS();
 public String Pass=Config.PasswordS();
 public String RtypePass=Config.RetypePasswordS();
 public String Altaddress=Config.AlternateEmailS();
 public String Mobnumber=Config.MobileNoS();
 public String date=Config.DateS();
 public String month=Config.MonthS();
 public String year=Config.YearS();
 public String country=Config.CountryS();
 public String city=Config.CityS();
  
 public  String Filling_Data_01(WebDriver driver) throws Exception
  {    /*
	    * Test Case 01: Provide less than 6chars in Pass. field || Verifying Error Message Regarding Pass field || 
	    */   
  Create_an_Account.CreateAccount(driver).click();
    
  Create_an_Account.FullName(driver).sendKeys(FullName);
  Thread.sleep(3000);
  
  Create_an_Account.EnterMailID(driver).sendKeys(Mail);
  Thread.sleep(3000);
  
  Create_an_Account.Password(driver).sendKeys(Pass);
  
  Create_an_Account.RetypePassword(driver).sendKeys(RtypePass);
  
  Create_an_Account.AltEmail(driver).sendKeys(Altaddress);
     /*
      *For the first we perform without clicking on check box. 
      */
  //Create_an_Account.CheckBox(driver).click();
  
  Create_an_Account.Mobnumber(driver).sendKeys(Mobnumber);
     /*The Element is not working. 
      *So we are using Robot Class
      */
  Robot robot= new Robot();
  robot.keyPress(KeyEvent.VK_TAB);
  robot.keyRelease(KeyEvent.VK_TAB);
  
  robot.keyPress(KeyEvent.VK_ENTER);
  robot.keyRelease(KeyEvent.VK_ENTER);
  
  robot.keyPress(KeyEvent.VK_DOWN);
  robot.keyRelease(KeyEvent.VK_DOWN);
  
  robot.keyPress(KeyEvent.VK_DOWN);
  robot.keyRelease(KeyEvent.VK_DOWN);
  
  robot.keyPress(KeyEvent.VK_ENTER);
  robot.keyRelease(KeyEvent.VK_ENTER);
  
  Create_an_Account.Month_Dropdown(driver).click();
  Create_an_Account.Month_Dropdown(driver).sendKeys(month);
  
  Create_an_Account.Year_Dropdown(driver).click();
  Create_an_Account.Year_Dropdown(driver).sendKeys(year);
  
  Create_an_Account.Country_Dropdown(driver).click();
  Create_an_Account.Country_Dropdown(driver).sendKeys(country);
  
  Create_an_Account.City_Dropdown(driver).click();
  Create_an_Account.City_Dropdown(driver).sendKeys(city);
  
    /*
     * This section should manually type 
     */
  Scanner Capecha= new Scanner(System.in);
  System.out.println("Enter The Capecha here:");
  String EnteredCapecha = Capecha.next();
  
  
  Create_an_Account.Capecha_Enter(driver).sendKeys(EnteredCapecha);
  
  Create_an_Account.Click_Enter(driver).click();
  
    /*
     * Observe the Error Messages 
     */
  
  Alert Popup= driver.switchTo().alert();
  String ErrorMessage=Popup.getText(); 
  System.out.println(ErrorMessage);
  Popup.accept();
  return ErrorMessage;
  }
  
 public String Filling_Data_02(WebDriver driver) throws Exception
{  //Test Case 02: Provide Empty Pass. field || Verifying Error Message Regarding Pass field ||  
	 String emptypPassField=Config.EmptyPass(); 
	 String RetypeEmptyField=Config.EmptyPass_Retype_Pass();
	 Create_an_Account.CreateAccount(driver).click();
	    
	  Create_an_Account.FullName(driver).sendKeys(FullName);
	  Thread.sleep(3000);
	  
	  Create_an_Account.EnterMailID(driver).sendKeys(Mail);
	  Thread.sleep(3000);
	  
	  Create_an_Account.Password(driver).sendKeys(emptypPassField);
	  
	  Create_an_Account.RetypePassword(driver).sendKeys(RetypeEmptyField);
	  
	  Create_an_Account.AltEmail(driver).sendKeys(Altaddress);
	     /*
	      *For the first we perform without clicking on check box. 
	      */
	  //Create_an_Account.CheckBox(driver).click();
	  
	  Create_an_Account.Mobnumber(driver).sendKeys(Mobnumber);
	     /*The Element is not working. 
	      *So we are using Robot Class
	      */
	  Robot robot= new Robot();
	  robot.keyPress(KeyEvent.VK_TAB);
	  robot.keyRelease(KeyEvent.VK_TAB);
	  
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  
	  robot.keyPress(KeyEvent.VK_DOWN);
	  robot.keyRelease(KeyEvent.VK_DOWN);
	  
	  robot.keyPress(KeyEvent.VK_DOWN);
	  robot.keyRelease(KeyEvent.VK_DOWN);
	  
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  
	  Create_an_Account.Month_Dropdown(driver).click();
	  Create_an_Account.Month_Dropdown(driver).sendKeys(month);
	  
	  Create_an_Account.Year_Dropdown(driver).click();
	  Create_an_Account.Year_Dropdown(driver).sendKeys(year);
	  
	  Create_an_Account.Country_Dropdown(driver).click();
	  Create_an_Account.Country_Dropdown(driver).sendKeys(country);
	  
	  Create_an_Account.City_Dropdown(driver).click();
	  Create_an_Account.City_Dropdown(driver).sendKeys(city);
	  
	    /*
	     * This section should manually type 
	     */
	  Scanner Capecha= new Scanner(System.in);
	  System.out.println("Enter The Capecha here:");
	  String EnteredCapecha = Capecha.next();
	  
	  
	  Create_an_Account.Capecha_Enter(driver).sendKeys(EnteredCapecha);
	  
	  Create_an_Account.Click_Enter(driver).click();
	  
	    /*
	     * Observe the Error Messages 
	     */
	  
	  Alert Popup= driver.switchTo().alert();
	  String ErrorMessage=Popup.getText(); 
	  System.out.println(ErrorMessage);
	  Popup.accept();
	  return ErrorMessage;
 
}
    
}
