package TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import Page_Objects.Create_an_Account;
public class TC_01_CreateAccount extends Start_Test_FromHere
{
     Logger logger;     
     @Test()
     public void Varify_Password_Field_Error01() throws Exception
     {
      Create_an_Account CreatAccount= new Create_an_Account();
	  String ErrorMassageCheck01=CreatAccount.Filling_Data_01(driver);
	  String Massage= "\n"
	  		+ 
			  "The password field is either empty or less than 6 chars.\n"
	  		+ "\n"
	  		+ "Please enter your password.";
	  Assert.assertEquals(ErrorMassageCheck01, Massage,"Provide less than 6chars in Pass. field || Failed");
	  
     }
    @Test()
    public void Varify_Password_Field_Error02() throws Exception
    {Create_an_Account CreatAccount= new Create_an_Account();
  	  String ErrorMessageCheck02=CreatAccount.Filling_Data_02(driver);
  	String Massage= "\n"
	  		+ 
			  "The password field is either empty or less than 6 chars.\n"
	  		+ "\n"
	  		+ "Please enter your password.";
  	  Assert.assertEquals(ErrorMessageCheck02, Massage, "Provide Empty Pass. field"); 
	
    }
}
