package sisfila.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class AdminAlunoNewPage extends LoadableComponent<AdminAlunoNewPage> {
	WebDriver driver;
	String baseURL;
	static final String SUFFIX = "/admin/aluno/new"; 
	
	WebElement aluno_matricula;
	WebElement aluno_nome;
	@FindBy(className = "alert-danger")
	WebElement errorBox;
	
	public AdminAlunoNewPage(WebDriver driver, String baseURL) {
		this.driver = driver;
		this.baseURL = baseURL;
		
		PageFactory.initElements(driver, this);
	}
	
	public void addAluno(String nome, String matricula) {
		aluno_nome.sendKeys(nome);
		aluno_matricula.sendKeys(matricula);
		aluno_matricula.submit();
	}

	public String mensagemDeErro() {
		return errorBox.getText();
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
