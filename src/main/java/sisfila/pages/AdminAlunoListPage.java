package sisfila.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class AdminAlunoListPage extends LoadableComponent<AdminAlunoListPage> {
	WebDriver driver;
	String baseURL;
	static final String SUFFIX = "/admin/aluno";
	
	WebElement bulk_form;
		
	public AdminAlunoListPage(WebDriver driver, String baseURL) {
		this.driver = driver;
		this.baseURL = baseURL;
		
		PageFactory.initElements(driver, this);
	}
	
	public String textoDaListagem() {
		return bulk_form.getText();
	}
	
	@Override
	protected void load() {
		driver.get(baseURL + SUFFIX);
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue(driver.getCurrentUrl().endsWith(SUFFIX));
	}

}
