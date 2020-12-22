package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class HomePage{
	
	public WebDriver driver;
	
	By login = By.cssSelector("a[href*='/signin']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

}
