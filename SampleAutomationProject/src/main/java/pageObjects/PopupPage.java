package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupPage {
public WebDriver driver;

	
	public PopupPage(WebDriver driver) {
		this.driver = driver;
	}
    //By leadSelect=By.xpath("//*[@id='select-lead-model']/div/div/div[2]/div/a");
    
    
	
    public void leadSelection(WebDriver driver,WebElement leadSelect) {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click()",leadSelect);
    	
    }
   
}
