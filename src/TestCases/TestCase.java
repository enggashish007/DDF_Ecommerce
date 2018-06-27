package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.EcommerceSuite.Configuration;

public class TestCase{

	WebDriver driver;
	
	public WebDriver setup(String BrowserName){
		
		Configuration confi = new Configuration();
		return confi.openBrowser(BrowserName);
		
	}
	
	public void tearDown(){
		driver.quit();
	}
	
	public void gotoSignInPage(WebDriver driver){
		
		WebElement e = driver.findElement(By.linkText("Sign in"));
		
		e.click();
		
	}
	
	public void gotoHomePage(WebDriver driver){
		
		driver.findElement(By.xpath("//img[@alt='My Store']")).click();
		
	}
	
	
	public void tc1_VeriyWrongPassword(WebDriver driver){
		
		gotoSignInPage(driver);
		
		System.out.println("test");
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("engg.ashish007@yahoo.com");
		
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys("123456");
		
		WebElement submit = driver.findElement(By.id("SubmitLogin"));
		submit.click();
		
		WebElement error = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li"));
		String message = error.getText();
		
		if(message.contains("failed"))
			System.out.println("Login Failed");
		else
			System.out.println("Login Successful");
		
		gotoHomePage(driver);
		
	}
	
	public void tc2_VerifyForgotPassword_label(WebDriver driver){
		
		gotoSignInPage(driver);
		
		WebElement FP_link = driver.findElement(By.linkText("Forgot your password?"));
		FP_link.click();
		
		WebElement label = driver.findElement(By.xpath("//div[@class='form-group']/label"));
		String labelText = label.getText();
		
		if(labelText.equalsIgnoreCase("email address"))
			System.out.println("Label name is correct");
		else
			System.out.println("Label name is wrong");
		
		gotoHomePage(driver);
		
	}
	
	public void tc3_VerifyForgotPassword_emailField(WebDriver driver){
		
		gotoSignInPage(driver);
		
		WebElement FP_link = driver.findElement(By.linkText("Forgot your password?"));
		FP_link.click();
		
		WebElement FP_textBox = driver.findElement(By.xpath("//div[@class='form-group']/input"));
		String FP_textBox_type = FP_textBox.getAttribute("type");
		
		if(FP_textBox_type.equals("text"))
			System.out.println("Correct Email Address field");
		else
			System.out.println("Email address Text field is missing");
		
		gotoHomePage(driver);
		
	}
	
	public void tc4_VerifyForgotPassword_submitButton(WebDriver driver){
		
		gotoSignInPage(driver);
		
		WebElement FP_link = driver.findElement(By.linkText("Forgot your password?"));
		FP_link.click();
		
		WebElement FP_submitButton = driver.findElement(By.xpath("//button[@class='btn btn-default button button-medium']/span"));
		String FP_submitButton_text = FP_submitButton.getText();
		
		System.out.println(FP_submitButton_text);
		
		gotoHomePage(driver);
		
	}
	
	
	public void tc5_VerifyWebsiteSearch(WebDriver driver){

		
		gotoSignInPage(driver);
		
		WebElement searchText = driver.findElement(By.id("search_query_top"));
		searchText.sendKeys("test");
		
		WebElement submitSearch = driver.findElement(By.name("submit_search"));
		submitSearch.click();
		
		WebElement failedSearchText = driver.findElement(By.xpath("//*[@id='center_column']/p"));
		String failedSearchTextContent = failedSearchText.getText();
		
		if(failedSearchTextContent.contains("test"))
			System.out.println("Error contains search text i.e. test");
		else
			System.out.println("Error not contains search text i.e. test");
		
		gotoHomePage(driver);
		
	}
	

	public static void main(String[] args) {
		
		TestCase obj = new TestCase();
		
		WebDriver driver = obj.setup("chrome");		
		
		driver.get("http://automationpractice.com/index.php");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Verify wrong Password
		obj.tc1_VeriyWrongPassword(driver);
		
		obj.tc2_VerifyForgotPassword_label(driver);
		
		obj.tc3_VerifyForgotPassword_emailField(driver);
		
		obj.tc4_VerifyForgotPassword_submitButton(driver);
		
		obj.tc5_VerifyWebsiteSearch(driver);
		
		obj.tearDown();
		
	}
		
}
