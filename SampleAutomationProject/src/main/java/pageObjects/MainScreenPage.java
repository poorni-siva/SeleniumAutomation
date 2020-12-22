package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainScreenPage {
public WebDriver driver;

	
	public MainScreenPage(WebDriver driver) {
		this.driver = driver;
	}
    By menubutton=By.cssSelector("a[href*='#navigation']");
    By salesbutton=By.xpath("//a[text()='Sales Tools']");
    By proposalbutton=By.xpath("//a[text()='Build a Proposal']");
	
    public WebElement clickMenu() {
    	return driver.findElement(menubutton);
    }
    public WebElement clicksalesbutton() {
    	return driver.findElement(salesbutton);
    }
    public WebElement clickproposalbutton() {
    	return driver.findElement(proposalbutton);
    }
}
