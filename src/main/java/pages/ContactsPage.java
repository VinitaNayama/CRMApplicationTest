package pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import browser.Browser;
import io.qameta.allure.Step;

public class ContactsPage extends Browser{

	Logger log = Logger.getLogger(this.getClass());
	//labels
	By label_contactInfo = By.xpath("//fieldset/legend[text()='Contact Information']");
	By label_title = By.xpath("//td[@align='left']/strong[text()='Title']");
	By label_firstName = By.xpath("//td[@align='left']/strong[text()='First Name']");
	By label_middleName = By.xpath("//td[@align='left']/strong[text()='Middle Name']");
	By label_lastName=By.xpath("//td[@align='left']/strong[text()='Last Name']");
	By label_suffix = By.xpath("//td[@align='left']/strong[text()='Suffix']");
	By label_image = By.xpath("//td[@align='left']/strong[text()='Image']");
	By imageBox = By.xpath("//input[@name='image_file']");
	By label_nickName= By.xpath("//td[@align='left']/strong[text()='Nickname']");
	By label_company = By.xpath("//td[@align='left']/strong[text()='Company']");
	By label_position = By.xpath("//td[@align='left']/strong[text()='Position']");
	By label_department = By.xpath("//td[@align='left']/strong[text()='Department']");
	By label_superVisor = By.xpath("//td[@align='left']/strong[text()='Supervisor']");
	By label_assistant = By.xpath("//td[@align='left']/strong[text()='Assistant']");
	By label_referredBy = By.xpath("//td[@align='left']/strong[text()='Referred By']");
	By label_owner = By.xpath("//td[@align='left']/strong[text()='Owner']");
	By label_textAddress = By.xpath("(//td/fieldset/legend[@class='fieldset'])[2]");
	By label_addressTitle = By.xpath("//td[@align='left']/strong[text()='Address Title']");
	By label_addressType = By.xpath("//td[@align='left']/strong[text()='Type']");
	By label_textDefault = By.xpath("//td[@align='left']/strong[text()='Default']");
	By label_textDefaultAddress = By.xpath("//td[@align='left']/em");
	By label_defaultAddressbox = By.xpath("//td[@align='left']/strong[text()='Address']");
	By label_city = By.xpath("//td[@align='left']/strong[text()='City']");
	By label_state_or_provinace = By.xpath("//td[@align='left']/strong[text()='State/Province']");
	By label_zip_or_postalCode = By.xpath("//td[@align='left']/strong[text()='Zip/Postal Code']");
	By label_country = By.xpath("//td[@align='left']/strong[text()='Country']");
	By label_tags = By.xpath("//td[@align='left'and text()=' (separate tags with commas)']");
	By label_notes_and_description = By.xpath("//td[@align='left']/strong[text()='Notes/Description']");
	By lable_Max = By.xpath("//input[@value='Max']");
	By label_contactTimeZone = By.xpath("//td[@align='left' and contains(text(),' Set the time zone to show local ')]");
	By label_Category = By.xpath("//td[@align='left']/strong[text()='Category']");
	By lable_Status = By.xpath("//td[@align='left']/strong[text()='Status']");
	By lable_Phone = By.xpath("//td[@align='left']/strong[text()='Phone']");
	By label_mobile= By.xpath("//td[@align='left']/strong[text()='Mobile']");
	By label_home_phone = By.xpath("//td[@align='left']/strong[text()='Home Phone']");
	By label_fax = By.xpath("//td[@align='left']/strong[text()='Fax']");
	By label_email = By.xpath("//td[@align='left']/strong[text()='Email']");
	By label_alternateemail = By.xpath("//td[@align='left']/strong[text()='Email (alt.)']");
	By label_receiveEmail = By.xpath("//td[@align='left']/strong[text()='Receive Email']");
	By label_receiveEmailbtns =By.xpath("(//input[@name='receive_email'])[1]/..");
	By label_receiveSms = By.xpath("//td[@align='left']/strong[text()='Receive SMS']");
	By label_receiveSmsbtns = By.xpath("(//input[@name='receive_email'])[2]/..");
	By label_allowcalls = By.xpath("//td[@align='left']/strong[text()='Allow Calls']");
	By label_allowCallbtns = By.xpath("(//input[@name='receive_email'])[3]/..");
	By label_messangerId = By.xpath("//td[@align='left']/strong[text()='Messenger ID']");
	By label_messangerNetwork = By.xpath("//td[@align='left']/strong[text()='Messenger Network']");
	By label_skypeID = By.xpath("//td[@align='left']/strong[text()='Skype ID']");
	By label_source = By.xpath("//td[@align='left']/strong[text()='Source']");
	By label_birthday = By.xpath("//td[@align='left']/strong[text()='Birthday']");
	By label_identifier = By.xpath("//td[@align='left']/strong[text()='Identifier']");

	By contactsBtn = By.xpath("//a[@title='Contacts']");
	By newContactsBtn = By.xpath("//a[@title='New Contact']");


	By questionmarkBtn1 = By.xpath("//select[@name='title']/following-sibling::input");

	//Child window elements

	By getText = By.xpath("(//td[@align='left'])[2]");

	//alert locator

	By loadFromCompanyBtn = By.xpath("//td[@align='center']/input[@type='button']");

	public void verifyLabels() {

		//switchToFrameByName("mainpanel");

		driver.switchTo().frame("mainpanel");

		moveToElement(findElement(contactsBtn)).moveToElement(findElement(newContactsBtn)).click().build().perform();

		/*Assert.assertEquals(findElement(label_contactInfo).getText(), "Contact Information");
		logger.info(findElement(label_contactInfo).getText()+" "+"Label is correct");

		Assert.assertEquals(findElement(label_title).getText(), "Title");
		logger.info(findElement(label_title).getText()+" "+"Title label is correct");

		Assert.assertEquals(findElement(label_firstName).getText(), "First Name");
		logger.info(findElement(label_firstName).getText()+" "+"FirstName label is correct");

		Assert.assertEquals(findElement(label_middleName).getText(), "Middle Name");
		logger.info(findElement(label_middleName).getText()+" "+"Middle Name label is correct");

		Assert.assertEquals(findElement(label_lastName).getText(), "Last Name");
		logger.info(findElement(label_lastName).getText()+" "+"Last Name label is correct");

		Assert.assertEquals(findElement(label_suffix).getText(), "Suffix");
		logger.info(findElement(label_suffix).getText()+" "+"Suffix label is correct");

		Assert.assertEquals(findElement(label_image).getText(), "Image");
		logger.info(findElement(label_image).getText()+" "+"Image label is correct");

		Assert.assertEquals(findElement(label_receiveEmailbtns).getText(), "Yes    No");
		logger.info(findElement(label_receiveEmailbtns).getText()+" "+" label is correct");

		Assert.assertEquals(findElement(label_contactTimeZone).getText(), "Contact Time Zone Set the time zone to show local time for this contact.");
		logger.info(findElement(label_contactTimeZone).getText()+" "+" label is correct");
		 */
	}	

	public void verifySwitchWindowConcept() {

		driver.switchTo().frame("mainpanel");

		moveToElement(findElement(contactsBtn)).moveToElement(findElement(newContactsBtn)).click().build().perform();

		findElement(questionmarkBtn1).click();

		Set<String> windowIds = driver.getWindowHandles();

		Iterator<String> ids = windowIds.iterator();

		String parentId = ids.next();
		String childID = ids.next();		

		driver.switchTo().window(childID);
		System.out.println("Child ID is  "+childID);
		log.info("***********Swithed to child window*******");
		System.out.println(driver.getTitle());

		String childWindowText = findElement(getText).getText();
		System.out.println(childWindowText);
		driver.switchTo().window(parentId);
		System.out.println("Parent ID is  "+driver.getTitle());

		switchToFrameByName("mainpanel");
		findElement(label_contactTimeZone).getText();
		log.info("Text matched successfully");

		log.info("***********Uploading image**************");
		findElement(imageBox).sendKeys("C:\\Users\\pushkar_nayama\\Desktop\\WebDriver_Hirarchy.png");
		System.out.println("Image uplaod is successful");
	}

	@Step("Verify Alert pop up")
	public void verifyAlert() {
	
		switchToFrameByName("mainpanel");
		moveToElement(findElement(contactsBtn)).moveToElement(findElement(newContactsBtn)).click().build().perform();
		findElement(loadFromCompanyBtn).click();
		System.out.println(alertGetText());
		alertAccept();
		System.out.println("Popup closed");
	}
}
