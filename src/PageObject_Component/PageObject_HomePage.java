package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_HomePage {
//step2: inspect elements
	
	@FindBy(css=".logoutImg")
	public WebElement logoutbtn;
	
	//step1: initialiae page factory
public PageObject_HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//step3: create keywords
public String getlogoutbtn()
{
	return logoutbtn.getAttribute("alt");
}

}
