package in.chrome.orange.testcases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.google.common.io.FileWriteMode;

import in.chrome.orange.commons.LoadWebDriver;
import in.chrome.orange.pageobject.LoginPageObjects;

public class LoginPageTestCase extends LoadWebDriver {
	public static WebDriver driver;
	public static Actions actions = null;

	static {
		driver = LoadWebDriver.getDriver();
		driver.get(LoadWebDriver.getUrl());
		driver.manage().window().maximize();
		actions = new Actions(driver);

	}

	public void initializePageFactory() {
		logger.info("Entering initializePageFactory method");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		PageFactory.initElements(driver, LoginPageObjects.class);
		
	}

	@Test(priority = 1)
	public void loginSuccessTestCase() throws IOException {
		

		initializePageFactory();
		LoginPageObjects.username.sendKeys("Admin");
		LoginPageObjects.password.sendKeys("admin123");
		LoginPageObjects.loginBtn.click();
		LoginPageObjects.dropDownForLogout.click();
		actions.moveToElement(LoginPageObjects.aboutLinkInDropDown).build().perform();
		actions.moveToElement(LoginPageObjects.supportLinkInDropDown).build().perform();
		actions.moveToElement(LoginPageObjects.changePasswordLinkInDropDown).build().perform();
		actions.moveToElement(LoginPageObjects.logoutLinkInDropDown).click().build().perform();
		String pageSource = driver.getPageSource();
		File file = new File("pageSource.html");
		FileWriter fos=null;
		if (file.exists()) {
			System.out.println("page ready");
			fos = new FileWriter(file);
			fos.write(pageSource);
			fos.flush();
		}
			
		
	}

	@Test(priority = 2)
	public void loginFailureWrongUsernameTestCase() {
		LoginPageObjects.username.sendKeys("Admin1");
		LoginPageObjects.password.sendKeys("admin123");
		LoginPageObjects.loginBtn.click();
		String actual = LoginPageObjects.wrongUserName.getText();
		String expected = "Invalid credentials";
		Assert.assertEquals(expected, actual);

	}

	@Test(priority = 3)
	public void loginFailureWrongPasswordTestCase() {
		LoginPageObjects.username.sendKeys("Admin");
		LoginPageObjects.password.sendKeys("admin");
		LoginPageObjects.loginBtn.click();
		String actual = LoginPageObjects.wrongUserName.getText();
		String expected = "Invalid credentials";
		Assert.assertEquals(expected, actual);

	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}
