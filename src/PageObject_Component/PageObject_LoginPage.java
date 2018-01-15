package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_LoginPage {
//step2: inspect elemnts
	@FindBy(xpath="//span[contains(text(),'Username or Password is invalid. Please try again.')]")
	public WebElement InvalidLoginErrormsg;
	
	//step1: initialise page factory
	public PageObject_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3: create keywords
	public String getInvalidLoginErrormsg()
	{
		return InvalidLoginErrormsg.getText();
	}
}
