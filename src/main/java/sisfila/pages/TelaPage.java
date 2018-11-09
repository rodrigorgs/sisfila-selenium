package sisfila.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelaPage extends LoadableComponent<TelaPage> {
	WebDriver driver;
	String baseURL;
	static final String SUFFIX = "/tela";

	WebElement matricula;
	WebElement dialog;
    WebElement dialogTitleElem;
    WebElement dialogMensagemElem;
    WebElement botaoCloseDialog;
	
	String dialogTitle = "";
	String dialogMensagem = "";

	public TelaPage(WebDriver driver, String baseURL) {
		this.driver = driver;
		this.baseURL = baseURL;

		PageFactory.initElements(driver, this);
	}

	private void loadDialogWebElements() {
		List<WebElement> dialogs = new WebDriverWait(driver, 1)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ui-dialog")));
		
		// Wait until any dialog is visible
		ExpectedCondition<?> condition = ExpectedConditions.visibilityOf(dialogs.get(0));
		for (int i = 1; i < dialogs.size(); i++) {
			condition = ExpectedConditions.or(ExpectedConditions.visibilityOf(dialogs.get(i)), condition);
		}
		new WebDriverWait(driver, 1).until(condition);
				
		dialog = null;
		for (WebElement x : dialogs) {
			if (x.isDisplayed()) {
				dialog = x;
				break;
			}
		}

		dialogTitleElem = dialog.findElement(By.className("ui-dialog-titlebar"));
		dialogMensagemElem = dialog.findElement(By.className("ui-dialog-content"));
		botaoCloseDialog = dialog.findElement(By.className("ui-icon-closethick"));
	}
	
	private void readTextFromDialogWebElements() {
		if (dialog != null) {
			dialogTitle = dialogTitleElem.getText();
			dialogMensagem = dialogMensagemElem.getText();
			botaoCloseDialog.click();
			new WebDriverWait(driver, 1).until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.className("ui-dialog"))));
		} else {
			dialogTitle = "";
			dialogMensagem = "";
		}
	}
	
	public void insereMatriculaNaFila(String numMatricula) {
		matricula.clear();
		matricula.sendKeys(numMatricula, Keys.RETURN);
		
		loadDialogWebElements();
		readTextFromDialogWebElements();
	}

	public String tituloDialog() {
		return dialogTitle;
	}

	public String mensagem() {
		return dialogMensagem;
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
