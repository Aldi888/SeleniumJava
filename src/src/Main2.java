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


public class Main2 {

	private static WebDriver driver;
	private static WebDriverWait wait;

private static WebElement priceElement, searchBarElement, celularElement, buyButtonElement, warrantyElement, ProceedElement;
private static By searchBarLocator, celularLocator, clickButtonLocator, warrantyLocator, warrantyProceed, productPrice, priceLocator;
private static String xpathPrice, xpathCelular; 


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
	
	Thread.sleep(6000);
	
	xpathCelular = "//h2[contains(text(),'Smartphone Samsung Galaxy Note 10+ 256GB')]";
	celularLocator = By.xpath(xpathCelular);
	celularElement = driver.findElement(celularLocator);
	celularElement.click();
		
	
	Thread.sleep(12000);
	
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

	//*[@id="app"]/section/section/div[1]/div/div[1]/section/ul/li/div[2]/div[4]/span[2]
	//xpathPrice = "//*[@id='btn-continue']";
	//xpathPrice = By.xpath("//*[@id='btn-continue']");
	//priceLocator = By.xpath(xpathPrice);
	//priceElement = driver.findElement(priceLocator);
	//System.out.println("Valor : "+ priceLocator);
	
	
	priceLocator = (By.cssSelector("span class[id='basket-productPrice']"));
	//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(clickButtonLocator)));
	priceElement = driver.findElement(priceLocator);
	System.out.println("Valor : "+ priceLocator);
	
	
	//aDriver.FindElementByXPath(".//span[@basket-productPrice ']").Text
		
	System.out.println("Application title is ============="+driver.getTitle());
	
	
	
	
		
}

}