package sisfila.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class HomePage extends LoadableComponent<HomePage> {
	WebDriver driver;
	String baseURL;
	
	public HomePage(WebDriver driver, String baseURL) {
		this.driver = driver;
		this.baseURL = baseURL;
		
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void load() {
		driver.get(this.baseURL + "/");
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(driver.getCurrentUrl().equals(this.baseURL + "/"));
	}
}
