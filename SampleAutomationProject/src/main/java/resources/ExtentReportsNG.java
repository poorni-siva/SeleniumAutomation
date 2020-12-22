package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportsNG {
	

	static ExtentReports extent;	
	public static ExtentReports config() {
	String path = System.getProperty("user.dir")+ "\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Selenium Automation Test");
	reporter.config().setDocumentTitle("TC results");	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tested by", "Annapoorni");
	return extent;
}
	
}