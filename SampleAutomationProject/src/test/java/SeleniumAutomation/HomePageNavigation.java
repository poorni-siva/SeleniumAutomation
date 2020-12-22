package SeleniumAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AddLeadPage;
import pageObjects.HomePage;
import pageObjects.LeadInputPage;
import pageObjects.LoginPage;
import pageObjects.MainScreenPage;
import pageObjects.PopupPage;
import pageObjects.SaveSuccessPage;
import resources.Base;

public class HomePageNavigation extends Base{
    @Test(dataProvider= "getData")
	public void urlNavigation(String user,String pwd) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
       driver= intializeDriver();
       driver.get("http://m.liidaveqa.com/");
       driver.manage().window().maximize();
       HomePage navigateLogin = new HomePage(driver);
       navigateLogin.getLogin().click();
       LoginPage login = new LoginPage(driver);
       login.getUsername().sendKeys(user);
       login.getPassword().sendKeys(pwd);
       login.clickLoginSubmit().click();
       MainScreenPage mainPage = new MainScreenPage(driver);
       mainPage.clickMenu().click();
       mainPage.clicksalesbutton().click();
       mainPage.clickproposalbutton().click();
       PopupPage popup = new PopupPage(driver);
       WebElement leadSelect=driver.findElement(By.xpath("//*[@id='select-lead-model']/div/div/div[2]/div/a"));
       popup.leadSelection(driver, leadSelect);
       AddLeadPage addlead=new AddLeadPage(driver);
       addlead.addLeadClick().click();
       LeadInputPage inputPage=new LeadInputPage(driver);
       inputPage.getExcelSheetData();
       SaveSuccessPage success = new SaveSuccessPage(driver);
       String text = success.addLeadSuccess().getText();
       System.out.println(text);
       Assert.assertTrue(true, text);
			}
	
    @DataProvider
public Object[][] getData() {
	Object[][] data= new Object[1][2];
	data[0][0] = "lenproautomation8@lenqat.com";
	data[0][1] = "Community17";
	return data;
}
    
}
