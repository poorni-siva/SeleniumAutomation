package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddLeadPage {
public WebDriver driver;

	
	public AddLeadPage(WebDriver driver) {
		this.driver = driver;
	}
    
	By addLeadButton = By.cssSelector("a.btn.btn-primary.hide-mobile.introjs-l-9.introjs-l-83");
	
    public WebElement addLeadClick() {
    	return driver.findElement(addLeadButton);
    }
    
}
