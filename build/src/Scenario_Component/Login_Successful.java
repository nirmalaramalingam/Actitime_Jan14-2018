package Scenario_Component;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import Generic_Component.BaseClass;
import PageObject_Component.PageObject_HomePage;
//import junit.framework.Assert;

public class Login_Successful extends BaseClass {
public static Logger log = Logger.getLogger(Login_Successful.class);
	@Test( groups={"regression"})
	public void LoginSuccessful() throws InterruptedException, IOException
	{
setup();
Login("admin","manager");
log.info("Executing login successful test case");
Thread.sleep(5000);
SoftAssert sAssert= new SoftAssert();
PageObject_HomePage PO_HP = new PageObject_HomePage(driver);
String Act_Result = PO_HP.getlogoutbtn();
System.out.println("Actual result is " + Act_Result);
String Exp_Result = "LOGOUT";

System.out.println("Expected result is " + Exp_Result);

//Assert.assertEquals(Act_Result, Exp_Result);
 if( Act_Result.equals(Exp_Result))
 {
	 System.out.println("Pass");
	 log.info("Testcase Passed as Actual result is " + Act_Result + " expected result is " + Exp_Result );
	 Capture_Screenshot();
 }
 else
 {
	 System.out.println("Fail");
	sAssert.fail("Testcase failed as Actual result is " + Act_Result + " expected result is " + Exp_Result );
	 log.info("Testcase failed as Actual result is " + Act_Result + " expected result is " + Exp_Result );
	 Capture_Screenshot();
 }
sAssert.assertAll();
teardown();
	}

}
