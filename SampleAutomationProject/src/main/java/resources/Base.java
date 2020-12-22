package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver;
	public WebDriver intializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fileInput = new FileInputStream("C:\\Users\\sivajana\\Documents\\Selenium\\eclipse\\Seleniumpractice\\SampleAutomationProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fileInput);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sivajana\\Documents\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		     driver = new ChromeDriver();
		}else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sivajana\\Documents\\Selenium\\geckodriver.exe");
		     driver = new FirefoxDriver();
		}else if(browserName.equals("InternetExplorer")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sivajana\\Documents\\Selenium\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
		     driver = new InternetExplorerDriver();
		}
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
