package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.BaseClass;
import PageObject_Component.PageObject_LoginPage;

public class Invalid_Login extends BaseClass {
public static Logger log= Logger.getLogger(Invalid_Login.class);
	@Test(groups={"regression"})
	public void testInvalidLogin() throws IOException, InterruptedException {
		setup();
		Login("admin","admin");
SoftAssert sAssert = new SoftAssert();
		PageObject_LoginPage PO_LP = new PageObject_LoginPage(driver);
log.info("Executing Invalid login");
		//Explicit_Wait(PO_LP.InvalidLoginErrormsg, 30);
Thread.sleep(3000);
		String Act_Result = PO_LP.getInvalidLoginErrormsg();
		System.out.println("Actual result is " + Act_Result);
		String Exp_Result = "Username or Password is invalid. Please try again.";
		System.out.println("Expected result is " + Exp_Result);

		if (Act_Result.equals(Exp_Result))
		{
			System.out.println("Pass");
			Capture_Screenshot();
			log.info("Testcase Passed as Actual result is " + Act_Result + " expected result is " + Exp_Result );
		} 
		else 
		{
			System.out.println("Fail");
			sAssert.fail("Testcase failed as Actual result is " + Act_Result + " expected result is " + Exp_Result );
		Capture_Screenshot();
		log.info("Testcase failed as Actual result is " + Act_Result + " expected result is " + Exp_Result );
		}
		sAssert.assertAll();
		teardown();

	}
}
