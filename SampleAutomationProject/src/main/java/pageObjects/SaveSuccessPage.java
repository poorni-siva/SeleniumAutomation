package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SaveSuccessPage {
public WebDriver driver;

	
	public SaveSuccessPage(WebDriver driver) {
		this.driver = driver;
	}
    
	By successMessage = By.xpath("//*[@id='globalMessages']/div/ul/li");
	
    public WebElement addLeadSuccess() {
    	return driver.findElement(successMessage);
    }
    
}
