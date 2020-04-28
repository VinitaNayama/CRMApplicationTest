package testSuite;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass.Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.LoginPage;
import retryAnalyzer.CustomListener;
import retryAnalyzer.TestNGRetryAnalyzer;

@Listeners(CustomListener.class)
public class LoginTest extends Base{

	@Test( description="Checking login page methods")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case description: Verify login with diffrent scenarios and login page webelements")
	@Story("Story Name : To check login method")
	public void loginMethodTest() {
		LoginPage obj = new LoginPage();
		obj.verifyLoginPagetitle();
		obj.verifyLinkSeleniumJobs();
		obj.verifySignupLink();
		obj.verifyLoginWithBlankDetails("", "");
		obj.verifyLoginwithCorrectUsernameIncorrectPass("batchautomation", "");
		obj.verifyLoginMethod("batchautomation", "test@12345");
	}
}
