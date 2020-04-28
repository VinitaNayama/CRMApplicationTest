package testSuite;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.AddBoxesPage;
import pages.LoginPage;

public class AddBoxesTest extends Base {

	@Test
	public void BoxesListTest() {
		LoginPage obj1 = new LoginPage();
		obj1.verifyLoginMethod("batchautomation", "test@12345");
		AddBoxesPage obj2 = new AddBoxesPage();
		obj2.addBoxesBtn();
	}
}