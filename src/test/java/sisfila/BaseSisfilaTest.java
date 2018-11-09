package sisfila;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseSisfilaTest {
	private WebDriver driver;
	private String baseURL;
	private SisfilaPageFactory factory = null;
		
	@Before
	public void setupDriver() {
		baseURL = System.getenv("SISFILA_BASEURL");
		if (baseURL == null || baseURL.trim().isEmpty()) {
			baseURL = "http://localhost:3000";
		}
		driver = new ChromeDriver();
		factory = new SisfilaPageFactory(driver, baseURL);
	}
	
	@After
	public void tearDownDriver() {
		driver.close();
	}
	
	public SisfilaPageFactory getFactory() {
		return factory;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
