package in.chrome.orange.pageobject;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
	@FindBy(name = "username")
	public static WebElement username;
	@FindBy(name = "password")
	public static WebElement password;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	public static WebElement loginBtn;
	@FindBy(xpath = "/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")
	public static WebElement dropDown;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
	public static WebElement wrongUserName ;
	@FindBy(className = "oxd-userdropdown-name")
	public static WebElement dropDownForLogout;
	@FindBy(linkText = "Support")
	public static WebElement supportLinkInDropDown;
	@FindBy(linkText = "Change Password")
	public static WebElement changePasswordLinkInDropDown;
	@FindBy(linkText = "Logout")
	public static WebElement logoutLinkInDropDown;
	@FindBy(linkText = "About")
	public static WebElement aboutLinkInDropDown;


}
