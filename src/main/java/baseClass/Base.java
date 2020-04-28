package baseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import browser.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;

public class Base {

	public WebDriver driver;	

	@Step("Launch browser")
	@BeforeMethod
	public void beforeMethod() {
		
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "F:\\Workspace\\PageObjectModel\\CRMApplicationTest\\drivers\\chrome\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		Browser.setDriver(driver);
	}	

	@Step("Close browser")
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}