package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase1 {

	static 	WebDriver driver;
	
	public WebDriver openBrowser(String browserName){
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\AutomationWorkSpace\\Driver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\AutomationWorkSpace\\Driver\\chromedriver_win32\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String path = System.getProperty();
		
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElement(By.name("q")).sendKeys("Test");
		
		//TC01_Verify Wrong password
		WebElement e = driver.findElement(By.linkText("Sign in"));
		
		e.click();
		
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
		
		//Verify Forgot Password
		
		//TC02_Validate Label
		WebElement FP_link = driver.findElement(By.linkText("Forgot your password?"));
		FP_link.click();
		
		WebElement label = driver.findElement(By.xpath("//div[@class='form-group']/label"));
		String labelText = label.getText();
		
		if(labelText.equalsIgnoreCase("email address"))
			System.out.println("Label name is correct");
		else
			System.out.println("Label name is wrong");
		
		//TC03_Validate Email field
		WebElement FP_textBox = driver.findElement(By.xpath("//div[@class='form-group']/input"));
		String FP_textBox_type = FP_textBox.getAttribute("type");
		
		if(FP_textBox_type.equals("text"))
			System.out.println("Correct Email Address field");
		else
			System.out.println("Email address Text field is missing");
		
		//TC04_Validate submit button
		WebElement FP_submitButton = driver.findElement(By.xpath("//button[@class='btn btn-default button button-medium']/span"));
		String FP_submitButton_text = FP_submitButton.getText();
		
		System.out.println(FP_submitButton_text+"test");
		
		//TC05_Validate search
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
		
		driver.quit();
	}
}