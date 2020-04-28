package browser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;


public class Browser {

	public static WebDriver driver;


	public static void setDriver(WebDriver dr) {
		driver = dr;
	}
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}

	public List findElements(By by) {
		return driver.findElements(by);
	}

	public void click(WebElement element) {
		element.click();
	}


	public Timeouts implicitlyWait(long time, TimeUnit unit) {
		return driver.manage().timeouts().implicitlyWait(time, unit);
	}
	public WebDriver switchToFrameByName(String name) {
		return driver.switchTo().frame(name);
	}

	public WebDriver switchToFrameByID(int id) {
		return driver.switchTo().frame(id);
	}

	public WebDriver switchToFrameDefaultContent() {
		return driver.switchTo().defaultContent();
	}

	public WebDriver switchToFrameByWebElement(WebElement element) {
		return driver.switchTo().frame(element);
	}

	public Actions moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		return action.moveToElement(element);
	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void deSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void DeSelectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void deSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void selectAll(WebElement element) {
		Select select = new Select(element);
		List elements = select.getOptions();			
	}

	public List<String> getDropDownValues(WebElement element) {
		Select select = new Select(element);
		List<WebElement> values= select.getOptions();
		List<String> list = new ArrayList<String>();
		for(WebElement option : values) {
			//		System.out.println(option.getText());			
			list.add(option.getText());
		}
		return list;
	}

	public void alertAccept() {
		Alert alert = 	driver.switchTo().alert();
		alert.accept();
	}

	public void alertDismiss() {
		Alert alert = 	driver.switchTo().alert();
		alert.dismiss();
	}

	public void alertSendKeys() {
		Alert alert = 	driver.switchTo().alert();
		alert.sendKeys(null);
	}

	public String alertGetText() {
		Alert alert = 	driver.switchTo().alert();
		String text =alert.getText();
		return text;
	}

	public void getScreenShot(String getMethodName) {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("F:\\Workspace\\PageObjectModel\\CRMApplicationTest\\src\\main\\resources\\Screenshots\\"+getMethodName+".jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}