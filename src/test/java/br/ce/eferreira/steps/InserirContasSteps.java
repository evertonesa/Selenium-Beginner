package br.ce.eferreira.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import junit.framework.Assert;

public class InserirContasSteps {
	
	private WebDriver driver;
	
	@Dado("que desejo adicionar uma conta")
	public void que_desejo_adicionar_uma_conta() {
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me");
		driver.findElement(By.id("email")).sendKeys("a@a");
		driver.findElement(By.id("senha")).sendKeys("a");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("Contas")).click();
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("adiciono a conta {string}")
	public void adiciono_a_conta(String string) {
		driver.findElement(By.id("nome")).sendKeys(string);
		driver.findElement(By.tagName("button")).click();
	}
	
	@SuppressWarnings("deprecation")
	@Então("recebo a mensagem {string}")
	public void recebo_a_mensagem(String string) {
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
	    Assert.assertEquals(string, texto);
	}
	
	@After
	public void fecharBrowser() {
		driver.quit();
		System.out.println("Terminado");
	}
}
	

