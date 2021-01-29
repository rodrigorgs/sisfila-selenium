package sisfila;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExemploTesteSimples {

	@Test
	public void testeLoginBemSucedido() {
		// Inicia web driver
		WebDriver driver = new ChromeDriver();
		
		// Reseta banco de dados
		driver.get("http://localhost:3000/reset");
		
		// Fornece usuário e senha
		driver.get("http://localhost:3000/users/sign_in");
		
		WebElement inputEmail = driver.findElement(By.name("user[email]"));
		WebElement inputPassword = driver.findElement(By.id("user_password"));
		WebElement button = driver.findElement(By.name("commit"));
		
		inputEmail.sendKeys("tela@example.com");
		inputPassword.sendKeys("tela2222");
		button.click();
		
		WebElement body = driver.findElement(By.tagName("body"));
		String textoDaPagina = body.getText();
		System.out.println(textoDaPagina);
		
		// Fecha web driver
		driver.close();
		
		// Assert
		assertTrue(textoDaPagina.contains("Usuário tela@example.com"));
	}
}
