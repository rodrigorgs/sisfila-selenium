package sisfila.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class AdminPage extends LoadableComponent<AdminPage> {
	WebDriver driver;
	String baseURL;

	public AdminPage(WebDriver driver, String baseURL) {
		this.driver = driver;
		this.baseURL = baseURL;
		
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		driver.get(this.baseURL + "/admin");
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(driver.getCurrentUrl().endsWith("/admin"));
		
	}
}
