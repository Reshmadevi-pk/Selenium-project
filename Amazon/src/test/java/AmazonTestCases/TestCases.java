package AmazonTestCases;

import java.util.List;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;

public class TestCases extends BaseClass {
	
	WebDriver driver;
	@BeforeMethod

	public void initilization()
	{
		driver= browserInitilization("chrome");
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	
	public void TC01() throws InterruptedException
	
	{
		System.out.println("TEST CASE 1");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String brandname=driver.findElement(By.xpath("//span[text()='Apple']")).getText();
		String brandtagname=driver.findElement(By.xpath("//span[text()='Apple']")).getTagName();
		String brandclassname=driver.findElement(By.xpath("//span[text()='Apple']")).getAttribute("class");
		
		WebElement dropdown= driver.findElement(By.id("s-result-sort-select"));
		Select drop= new Select(dropdown);
		drop.selectByValue("review-rank");
		drop.selectByVisibleText("Price: Low to High");
		drop.selectByIndex(2);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("laptop");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> products=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	    int prodcount=products.size();
	    System.out.println("size"+prodcount);
	    System.out.println(brandname);
	    System.out.println(brandtagname);
	    System.out.println(brandclassname);
	    //driver.navigate().back();
	    //driver.navigate().forward();
	    //driver.navigate().refresh();
	    //driver.navigate().to("https://www.flipkart.com/");
	    //driver.close();
	    
	 
	   driver.get("https://www.redbus.in/");
	   driver.findElement(By.id("src")).sendKeys("Kochi");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("(//i[@class='icon icon-ic-city solr-icon'])[1]")).click();
	   driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
	   WebElement source=driver.findElement(By.id("column-a"));
	   WebElement destination=driver.findElement(By.id("column-b"));
	   Actions action= new Actions(driver);
	  //action.dragAndDrop(source, destination);
	  //action.contextClick();//to perform right click
	  driver.navigate().back();
	  Thread.sleep(2000);
	  action.doubleClick(driver.findElement(By.id("search_button")));
	  action.moveToElement(driver.findElement(By.xpath("//span[text()='Train Tickets']")));
	  action.build().perform();
	  
	
}
@Test

  public void TC02()
  { 
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("laptop");
	driver.findElement(By.id("nav-search-submit-button")).click();
	driver.findElement(By.xpath("(//input[@type='checkbox']//following-sibling::i)[1]")).click();
	driver.findElement(By.xpath("(//input[@type='checkbox']//following-sibling::i)[7]")).click();
	driver.navigate().to("https://form.immigration.ca/skilled-worker/");
	driver.findElement(By.xpath("(//label[text()='Yes'])[1]")).click();
  }
}