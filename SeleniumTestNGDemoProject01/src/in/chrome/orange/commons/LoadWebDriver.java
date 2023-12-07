package in.chrome.orange.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LoadWebDriver {
	public static Properties properties = null;
	public static WebDriver driver = null;
	public static Logger logger = null;
	static {
		try {
			PropertyConfigurator.configure("/Users/portarasusomasundaram/Desktop/Java_Final_Codes/TESTING/SELENIUM/WorkspaceEclipse/SeleniumTestNGDemoProject01/log4j.properties");
			logger = Logger.getLogger(LoadWebDriver.class);
			FileInputStream propertyFile = new FileInputStream("config.properties");
			logger.info("Properies file came in to java code");
			properties = new Properties();
			properties.load(propertyFile);
			System.setProperty(properties.getProperty("driver.name"), properties.getProperty("driver.path"));

		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());

		}

	}

	public static WebDriver getDriver() {
		logger.info("Entering get driver method");

		String driverName = properties.getProperty("driver.name");

		if (driver == null && "webdriver.chrome.driver".equalsIgnoreCase(driverName))
			return new ChromeDriver();
		else if (driver == null && "webdriver.gecko.driver".equalsIgnoreCase(driverName))
			return new FirefoxDriver();
		else if (driver == null && "webdriver.safari.driver".equalsIgnoreCase(driverName))
			return new SafariDriver();

		logger.info("Exiting get driver method");

		return driver;
	}

	public static String getUrl() {
		logger.info("Entering get URL method");

		String websiteUrl = properties.getProperty("url");
		logger.info("Exiting get URL method");

		return websiteUrl;
	}

	public static void quitBrowser() {
		logger.info("Going to quit browswe");

		driver.close();
	}

}
