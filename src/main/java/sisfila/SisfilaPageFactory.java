package sisfila;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import sisfila.pages.AdminAlunoListPage;
import sisfila.pages.AdminAlunoNewPage;
import sisfila.pages.AdminPage;
import sisfila.pages.HomePage;
import sisfila.pages.LoginPage;
import sisfila.pages.TelaPage;

public class SisfilaPageFactory {
	WebDriver driver;
	String baseURL;
	
	public SisfilaPageFactory(WebDriver driver, String baseURL) {
		super();
		this.driver = driver;
		this.baseURL = baseURL;
	}
	
	public SisfilaPageFactory resetDatabase() {
		driver.get(this.baseURL + "/reset");
		assertTrue(driver.getPageSource().contains("Ok"));
		return this;
	}
	public SisfilaPageFactory criaCenario() {
		driver.get(this.baseURL + "/cria-cenario");
		assertTrue(driver.getPageSource().contains("Ok"));
		return this;
	}
	
	public HomePage home() {
		return new HomePage(driver, baseURL);
	}
	
	public LoginPage login() {
		return new LoginPage(driver, baseURL);
	}
	public AdminPage admin() {
		return new AdminPage(driver, baseURL);
	}
	public AdminAlunoNewPage adminAlunoNew() {
		return new AdminAlunoNewPage(driver, baseURL).get();
	}
	public AdminAlunoListPage adminAlunoList() {
		return new AdminAlunoListPage(driver, baseURL).get();
	}
	public TelaPage tela() {
		return new TelaPage(driver, baseURL).get();
	}


	
}
