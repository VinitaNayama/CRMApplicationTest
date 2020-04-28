package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import browser.Browser;
import io.qameta.allure.Step;
import retryAnalyzer.CustomListener;

@Listeners(CustomListener.class)
public class LoginPage extends Browser{

	Logger log = Logger.getLogger(this.getClass());

	By username = By.xpath("//input[@type='text']");
	By password = By.xpath("//input[@type='password']");
	By submitBtn = By.xpath("//input[@type='submit']");
	By homepageTitle = By.xpath("(//a[contains(text(),'Upgrade your account')])[2]");
	By singupLink = By.linkText("Sign Up");
	//logo webelement

	By seleniumJobsLink = By.linkText("Selenium Jobs");

	@Step("Verify login page title step...")
	public void verifyLoginPagetitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
		log.info("********Title verified successully*************");
	}

	@Step("Verify logo on login page step...")
	public void verifyLinkSeleniumJobs() {
		String expextedLogoText = findElement(seleniumJobsLink).getText();
		Assert.assertEquals(expextedLogoText, "Selenium Jobs");
		log.info("*******Logo is correct!************");
	}

	@Step("Verify Signup link is step...")
	public void verifySignupLink() {
		findElement(singupLink).isDisplayed();
		log.info("*******Link is present and displayed*********");
	}

	@Step("Verify login with blank user details: username:{0} and password:{1} step...")
	public void verifyLoginWithBlankDetails(String username, String pass) {
		findElement(this.username).clear();
		findElement(this.username).sendKeys("");
		findElement(this.password).clear();
		findElement(this.password).sendKeys("");
		findElement(submitBtn).click();		
		Assert.assertEquals("CRMPRO -CRM software for customer relationship management, sales, and support.", "CRMPRO - CRM software for customer relationship management, sales, and support.");
		log.info("***********User is not able to login. Landed on the same page*************");
	}

	@Step("Verify login with correct username:{0} and incorrect password :{1} step..")
	public void verifyLoginwithCorrectUsernameIncorrectPass(String username, String pass) {
		findElement(this.username).clear();
		findElement(this.username).sendKeys("batchautomation");
		findElement(this.password).clear();
		findElement(this.password).sendKeys("1233");
		findElement(submitBtn).click();		
		Assert.assertEquals("CRMPRO -CRM software for customer relationship management, sales, and support.", "CRMPRO - CRM software for customer relationship management, sales, and support.");
		log.info("********User is not able to login. Landed on the same page****************");			
	}

	@Step("Login with username: {0} and password: {1} step...")
	public ContactsPage verifyLoginMethod(String userName, String pass){
		findElement(username).clear();
		findElement(username).sendKeys(userName);
		findElement(password).clear();
		findElement(password).sendKeys(pass);		
		click(findElement(submitBtn));
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
		log.info("**************User logged in successfully****************");
		return new ContactsPage();
	}
}
