package testSuite;

import org.testng.annotations.Test;

import baseClass.Base;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import pages.ContactsPage;
import pages.LoginPage;

@Epic("ID_01")
@Story("Story_ID_01")
@Feature("Contact Test")
public class ContactsTest extends Base{

	@Description("Verify the UI elements on contacts page")
	@TmsLink("Jira_TestCase_ID")
	@Test	
	public void verifyContactForm() {

		LoginPage test = new LoginPage();
		test.verifyLoginMethod("batchautomation", "test@12345");
		ContactsPage obj2 = new ContactsPage();
		obj2.verifySwitchWindowConcept();
		obj2.verifyAlert();
	}
}
