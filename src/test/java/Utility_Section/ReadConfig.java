package Utility_Section;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	static Properties pro;
	// Create a Constructor.....// pro is a object
	public ReadConfig()
  {
	File src = new File("./Configuration/Config.properties");
	
	  try 
	  {
		FileInputStream fis = new FileInputStream(src);
		 pro = new Properties();
		pro.load(fis);
	  }
	  catch(Exception e)
	  {
	  System.out.println("Exception is"+ e.getMessage());	
      }
	
  }
	
	public String FullNameS() 
	  {
	      String Fname= pro.getProperty("FullName");
	      return Fname;
	  }
	public String RediffmailS() 
	  {
	      String Mail= pro.getProperty("Rediffmail");
	      return Mail;
	  }
	
	public  String PasswordS() 
	  {
	      String Pass= pro.getProperty("Password");
	      return Pass;
	  }
	
	public  String RetypePasswordS() 
	  {
	      String Rpass= pro.getProperty("RetypePassword");
	      return Rpass;
	  }
	
	public  String AlternateEmailS() 
	  {
	      String Altmail= pro.getProperty("AlternateEmail");
	      return Altmail;
	  }
	public  String MobileNoS() 
	  {
	      String Mobile= pro.getProperty("MobileNo");
	      return Mobile;
	  }
	
	public  String DateS() 
	  {
	      String date= pro.getProperty("Date");
	      return date;
	  }
	public  String MonthS() 
	  {
	      String month= pro.getProperty("Month");
	      return month;
	  }
	public  String YearS() 
	  {
	      String year= pro.getProperty("Year");
	      return year;
	  }
	public  String CountryS() 
	  {
	      String country= pro.getProperty("Country");
	      return country;
	  }
	public  String CityS() 
	  {
	      String city= pro.getProperty("City");
	      return city;
	  }
	public  String EmptyPass()
	  {
		  String emptypass=pro.getProperty("EmptyPassword");
		  return emptypass;
	  }
	public  String EmptyPass_Retype_Pass()
	  {
		   String emptyPass_Retype=pro.getProperty("EmptyRetypePassword");
		   return emptyPass_Retype;
	  }
}
