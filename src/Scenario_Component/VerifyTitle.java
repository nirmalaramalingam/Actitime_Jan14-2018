package Scenario_Component;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import Generic_Component.BaseClass;

public class VerifyTitle extends BaseClass {
public static Logger log= Logger.getLogger(VerifyTitle.class);
@Test(groups= {"regression"})
public void VerifyTitle() throws InterruptedException, IOException
{
	log.info("Executing Verify title test cases");
	setup();
	Login("admin","manager");
	Thread.sleep(3000);
	
	String Exp_Result="actiTIME - Open Tasks";
	System.out.println("Expected result is " + Exp_Result);
	
	String Act_Result = driver.getTitle();
	System.out.println("Actual result is " + Act_Result);
	
SoftAssert sAssert = new SoftAssert();
sAssert.assertEquals(Act_Result, Exp_Result);

if(Exp_Result.equals(Act_Result))
{
	System.out.println("Pass");
	log.info("Testcase Passed as Actual result is " + Act_Result + " expected result is " + Exp_Result );
	Capture_Screenshot();
}
else
{
	System.out.println("Fail");
	sAssert.fail();
	log.info("Testcase failed as Actual result is " + Act_Result + " expected result is " + Exp_Result );
	Capture_Screenshot();
}

	sAssert.assertAll();
	teardown();
	
}
}
