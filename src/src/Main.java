package src;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {

	private static WebDriver driver;
	private static WebDriverWait wait;

private static WebElement priceElement, priceElement2, priceElementt, searchBarElement, celularElement, buyButtonElement, warrantyElement, ProceedElement;
private static By searchBarLocator, celularLocator, clickButtonLocator, warrantyLocator, warrantyProceed, priceLocator, priceSeguro, priceTotal;
private static String xpathPrice, xpathPrice2, xpathCelular, xpathTotal; 


//Sellenium
@Before
public void beforeTask() {
	System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
driver = new ChromeDriver();
wait = new WebDriverWait(driver,Duration.ofSeconds(20));
}
@Test

public void test() throws InterruptedException {
	
	driver.manage().window().maximize();
	
	driver.get("https://www.submarino.com.br/");
	
	searchBarLocator = By.id("h_search-input");
	
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchBarLocator)));
	
	searchBarElement = driver.findElement(searchBarLocator);
	searchBarElement.click();
	searchBarElement.sendKeys("celular");
	searchBarElement.sendKeys(Keys.ENTER);
	
	Thread.sleep(7000);
	
	xpathCelular = "//h2[contains(text(),'Smartphone Samsung Galaxy Note 10+ 256GB')]";
	celularLocator = By.xpath(xpathCelular);
	celularElement = driver.findElement(celularLocator);
	celularElement.click();
		
	
	Thread.sleep(7000);
	
	clickButtonLocator = By.cssSelector("div a[id='btn-buy']");
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(clickButtonLocator)));
	buyButtonElement = driver.findElement(clickButtonLocator);
	buyButtonElement.click();
	
	Thread.sleep(9000);
	
	
	warrantyLocator = By.xpath("//*[@id='content']/div/div/main/div[2]/div/div/div[1]/section/div/div[2]/div/div[2]/div/div[2]/div/header");
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(warrantyLocator)));
	warrantyElement = driver.findElement(warrantyLocator);
	warrantyElement.click();
	
	Thread.sleep(5000);
	
	warrantyProceed = By.xpath("//*[@id='btn-continue']");
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(warrantyProceed)));
	ProceedElement = driver.findElement(warrantyProceed);
	ProceedElement.click();
	
	Thread.sleep(6000);

	
	xpathPrice = "//span[@class='basket-productPrice']";
	priceLocator = By.xpath(xpathPrice);
	priceElement = driver.findElement(priceLocator);
	System.out.println("Site Validado ============="+driver.getTitle());
	System.out.println("Valor Produto : "+ priceElement.getText().trim().replace("R$", ""));
	
	xpathPrice2 = "//span[@class='basket-productPrice --preview']";
	priceSeguro = By.xpath(xpathPrice2);
	priceElement2 = driver.findElement(priceSeguro);
	System.out.println("Valor Seguro : "+ priceElement2.getText().trim().replace("+ R$", ""));
	
	String vlrprod = priceElement.getText().trim().replace("R$", "").replace(".","").replace(",",".");
	String vlrseg = priceElement2.getText().trim().replace("+ R$", "").replace(".","").replace(",",".");
	float vlrtotal = Float.parseFloat(vlrprod)+Float.parseFloat(vlrseg);
	System.out.println(vlrtotal);
	
	//Validar Soma Produto + seguro
	
	xpathTotal = "//span[@class='summary-total']";
	priceTotal = By.xpath(xpathTotal);
	priceElementt = driver.findElement(priceTotal);
	System.out.println("Valor Total : "+ priceElementt.getText().trim().replace("R$", ""));
	
	String vlrtotalt = priceElementt.getText().trim().replace("R$", "").replace(".","").replace(",",".");
	float vlrtotalf = Float.parseFloat(vlrtotalt);
	System.out.println(vlrtotalf);		
	
	if 
		
		(vlrtotal == vlrtotalf) {
	
	System.out.println("Valor Confere, teste OK");
		
	} else {
			
			System.out.println("Valor Não bate, teste Falhou");
		}

	
		
}

}