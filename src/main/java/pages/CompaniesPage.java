package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import browser.Browser;

public class CompaniesPage extends Browser {

	By companiesBtn = By.xpath("//a[@title='Companies']");
	By newCompanyBtn = By.xpath("//a[@title='New Company']");
	By validateText = By.xpath("//legend[contains(text(),'Create New  Company')]");
	
	//Create new company locators
	By companyName = By.xpath("//input[@name='company_name']");
	By industry = By.xpath("//input[@name='industry']");
	By annual_Revenue = By.xpath("//input[@name='annual_revenue']");
	By empCount = By.xpath("//input[@name='num_of_employees']");
	By status = By.xpath("//select[@name='status']");
	By category = By.xpath("//select[@name='category']");
	By priority = By.xpath("//select[@name='priority']");
	By source = By.xpath("//select[@name='source']");
	By identifier = By.xpath("//input[@name='identifier']");
	By taxNumber = By.xpath("//input[@name='vat_number']");
	By addressTitle = By.xpath("//input[@name='address_title']");
	By addressType = By.xpath("//td/select[@name='type']");
	By address = By.xpath("//td/textarea[@name='address']");
	By addressCity = By.xpath("//input[@name='city']");
	By state = By.xpath("//input[@name='state']");
	By postalCode = By.xpath("//input[@name='postcode']");
	By country = By.xpath("//input[@name='country']");
	By tags = By.xpath("//input[@name='tags']");
	By discription = By.xpath("//textarea[@name='service']");
	By submitBtn = By.xpath("(//td[@colspan='2']/input[@type='submit'])[2]");
	
	public void validateNewCompanyBtn() {

		implicitlyWait(2000, TimeUnit.SECONDS);
		Actions element = moveToElement(findElement(companiesBtn)).moveToElement(findElement(newCompanyBtn));

		element.click().build().perform();
		String actualText = findElement(validateText).getText();
		String expectedText = "Create New Company";
		Assert.assertEquals(actualText, expectedText);

		/*	Actions action = new Actions(driver);
		action.moveToElement(findElement(companiesBtn))
		.moveToElement(findElement(newCompanyBtn))
		.click()
		.build().perform();
		String actualText = findElement(validateText).getText();
		String expectedText = "Create New Company";
		Assert.assertEquals(actualText, expectedText);
		 */
	}

	public void fillNewCompanyPage() {

		findElement(this.companyName).sendKeys("Upside");
		findElement(this.industry).sendKeys("Elearning");
		findElement(this.annual_Revenue).sendKeys("1000000");
		findElement(this.empCount).sendKeys("150");
		selectByVisibleText(findElement(status), "Hot");
		selectByValue(findElement(category), "Client");
		selectByIndex(findElement(priority), 2);
		selectByValue(findElement(source), "Ad");
		findElement(this.identifier).sendKeys("identifier");
		findElement(this.taxNumber).sendKeys("ABCXYZ");
		findElement(this.addressTitle).sendKeys("CompanyAddress");
		selectByVisibleText(findElement(addressType), "Billing Address");
		findElement(this.address).sendKeys("Warje pune");
		findElement(this.addressCity).sendKeys("Pune");
		findElement(this.state).sendKeys("Maharastra");
		findElement(this.postalCode).sendKeys("411058");
		findElement(this.country).sendKeys("India");
		findElement(this.tags).sendKeys("additional");
		findElement(this.discription).sendKeys("End ofthe value");
		findElement(submitBtn).click();
	}
	
}
