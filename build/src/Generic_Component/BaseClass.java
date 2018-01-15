package Generic_Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
public WebDriver driver;
public void setup()
{
System.setProperty("webdriver.chrome.driver", "D:\\From Kavya\\chromedriver\\chromedriver.exe");
driver= new ChromeDriver();
driver.get("http://desktop-mi5d1li/login.do");
//driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

public void Login(String username, String password)
{
driver.findElement(By.name("username")).sendKeys(username);
driver.findElement(By.name("pwd")).sendKeys(password);
driver.findElement(By.xpath("//input[@type='submit']")).click();
}
public void teardown()
{
	driver.quit();
}
public void Capture_Screenshot() throws IOException
{
	Date date = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
	String str = df.format(date) + ".png";
	
	TakesScreenshot screenshot = (TakesScreenshot) driver;
	File scr= screenshot.getScreenshotAs(OutputType.FILE);
	//File target = new File("D:\\Mobile easylearn\\Framework_Data\\Actitime_Screenshot");
	FileUtils.copyFile(scr, new File("D:\\Mobile easylearn\\Framework_Data\\Actitime_Screenshot\\" + str));
}
public void Explicit_Wait(WebElement element, long tu)
{
	WebDriverWait wait= new WebDriverWait(driver, tu);
	wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
}
}
