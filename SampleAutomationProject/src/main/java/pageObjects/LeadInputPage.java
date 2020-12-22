package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeadInputPage {
	
	public WebDriver driver;

		
		public LeadInputPage(WebDriver driver) {
			this.driver = driver;
		}
	    
		By firstName = By.id("firstName");
		By lastName = By.id("lastName");
		By phoneNumber = By.id("phNo");
		By Email = By.id("email");
		By date = By.className("schedulingRequestDate");
		By time = By.id("scheduleRequestTime");
		By document = By.xpath("//p[text()='Add Document']");
		By image = By.xpath("//p[@class ='choose-image']");
		
	    public void getExcelSheetData() throws IOException, InterruptedException {
			FileInputStream fis = new FileInputStream("C:\\Users\\sivajana\\Documents\\Selenium\\Sample data.xlsx");
			XSSFWorkbook book = new XSSFWorkbook(fis);
			int sheetcount = book.getNumberOfSheets();
			for(int i=0;i<sheetcount;i++) {
				if(book.getSheetName(i).equalsIgnoreCase("Lead Personal Details")) {					
					XSSFSheet sheet = book.getSheetAt(i);	
					int rowcount = sheet.getPhysicalNumberOfRows();
					for(int j=1;j<rowcount;j++) {
					   XSSFRow row=sheet.getRow(j);
					   int cellcount = row.getPhysicalNumberOfCells();
					   for(int k=0;k<cellcount;k++) {
						   XSSFCell cell=row.getCell(k);
						   String cellvalue = getCellTypeValue(cell);
						   switch(k) {
						   case 1 : driver.findElement(lastName).sendKeys(cellvalue);break;
						   case 2 : driver.findElement(phoneNumber).sendKeys(cellvalue);break;
						   case 3 : driver.findElement(Email).sendKeys(cellvalue);break;
						   case 4 : driver.findElement(date).sendKeys(cellvalue);break;
						   case 5 : driver.findElement(time).sendKeys(cellvalue);break;
						   case 6 : driver.findElement(document).sendKeys(cellvalue);break;
						   case 7 : driver.findElement(image).sendKeys(cellvalue);break;
						   default : driver.findElement(firstName).sendKeys(cellvalue);break;
						   }
						   	    System.out.println(cellvalue);
						   	    
	}
					   driver.findElement(By.id("btn-addLeadsForm")).click();
					   Thread.sleep(2000L);
					   if(j != rowcount-1) {
						   driver.navigate().back();
						   driver.navigate().back();
						   AddLeadPage addleadpage=new AddLeadPage(driver);
						   addleadpage.addLeadClick().click();
					   }    
}}
				book.close();}}
	   public static String getCellTypeValue(XSSFCell cell) {
		   switch(cell.getCellType()) {
		   case NUMERIC:
			   return String.valueOf(cell.getNumericCellValue());
		   case STRING:
			   return cell.getStringCellValue();
		   default:
				   return cell.getStringCellValue();
		   }
		
		   
	   }
}