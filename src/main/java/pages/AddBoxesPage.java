package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import browser.Browser;

public class AddBoxesPage extends Browser {

	By addBoxes = By.xpath("//a[contains(text(),'Add Boxes')]");
	By boxId =By.name("box_id");

	public void addBoxesBtn() {
		implicitlyWait(3000, TimeUnit.SECONDS);
		
		switchToFrameByName("mainpanel");

		findElement(addBoxes).click();
		List<String> drpDownValues = getDropDownValues(findElement(boxId));			
		System.out.println(drpDownValues);
	/*	
		for(String values : drpDownValues) {
			System.out.println(values);
		}
*/
		List<String> names = new ArrayList<String>();
		names.add("Calendar");
		names.add("Quick Create Form");
		names.add("This Week Overview");
		names.add("Call List (non scheduled)");
		names.add("Email Campaigns");
		names.add("CRMPRO News");
		names.add("Tag List");
		names.add("Scheduled Calls");
		names.add("Week Calendar");
		names.add("Day Calendar");
		names.add("Flagged Records");			
		System.out.println(names);

		Assert.assertEquals(drpDownValues, names);
	}	
}