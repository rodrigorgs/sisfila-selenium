package sisfila.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPage extends LoadableComponent<LoginPage> {
	WebDriver driver;
	String baseURL;
	
	WebElement user_email;
	WebElement user_password;
	
	public LoginPage(WebDriver driver, String baseURL) {
		this.driver = driver;
		this.baseURL = baseURL;
		
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String email, String password) {
		user_email.sendKeys(email);
		user_password.sendKeys(password);
		user_email.submit();
		
		return new HomePage(driver, baseURL);
	}
	
	public HomePage loginAsAdmin() {
		return login("admin@example.com", "admin2222");
	}
	
	public HomePage loginAsRegularUser() {
		return login("tela@example.com", "tela2222");
	}

	@Override
	protected void load() {
		driver.get(this.baseURL + "/users/sign_in");
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(driver.getCurrentUrl().endsWith("/users/sign_in"));
	}
	
}
