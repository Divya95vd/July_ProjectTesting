import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class MobilePurchFilpkart {
	
	static long start;
	static WebDriver flipkart;
	static String ProductName;
	static String ProductName2;
	
	@BeforeClass
	public static void browserLaunch() {
		//System.setProperty("webdriver.edge.driver","C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	@AfterClass
	public static void browserQuit() {
		 System.out.println("browserQuit"); 
		flipkart.quit();
	}
	@Before
	public void startTime() {
		start = System.currentTimeMillis();
		System.out.println("before");
	}
	@After
	public void endTime() {
		long end = System.currentTimeMillis();
		System.out.println("After totaltime"+(end - start));
	}
	@Test
	public void mathod1() {
		flipkart.findElement(By.name("q")).sendKeys("vivo v50");
		((WebElement) flipkart).submit();
		flipkart.findElement(By.xpath("//span[contains(text(),'vivo V50 5G (Rose Red, 256 GB)')]")).click();
	}
	@Test
	public void mathod2() {
	flipkart.findElement(By.xpath("(//div[@class='KzDlHZ'])[1]")).getText();
    System.out.println("Vivo 2 = "+ProductName);
	}
	@Test
	public void mathod3() {
		String pwin=flipkart.getWindowHandle();   
	    Set<String> allwin=flipkart.getWindowHandles(); 
	    for(String x : allwin ) {
	    if(!pwin.equals(x)) {
	    flipkart.switchTo().window(x);
		flipkart.findElement(By.xpath("(//div[@class='KzDlHZ'])[1]")).getText();
		System.out.println("Vivo 2 = "+ProductName2);
	
    	}
    }
    
	}
	@Test
	public void mathod4() throws AWTException {
		String pro = String.valueOf(flipkart);
		String pro1 = String.valueOf(flipkart);
		if (pro.equals(pro1)) {
			System.out.println("Method 4 : Both product names are same");
		}
		else {
			System.out.println("Method 4 : product names are not same");
		}
		
	}
	@Test
	public void mathod5() throws AWTException {
		flipkart.findElement(By.xpath("(//button[@type='button'])")).click();
		Robot rb=new Robot();
        rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    flipkart.findElement(By.xpath("//input[@type='text']")).sendKeys("7339596074");
	    flipkart.findElement(By.xpath("//button[@type='submit']")).click(); 
	}
}

