package PracticeSelenium.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class ParcticeDynamicTable {
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://qaplayground.com/practice/data-table");
		
		driver.manage().window().maximize();
		
		List<WebElement> li = driver.findElements(By.xpath("//*[@id='dataTable']/tbody/tr"));
		
		System.out.println("No of rows - " + li.size());
		qwerty
        List<WebElement> li2 = driver.findElements(By.xpath("//*[@id='dataTable']/tbody/tr[1]/td"));
		
		System.out.println("No of columns - " + li2.size());
		
	//Find Specific cel value --
		
   WebElement cellValue =  driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr/td[text()=\"Robert C. Martin\"]"));
		
		
		System.out.println(cellValue.getText());
		
		
		// to click on a specif button from one referrance
		
		List <WebElement> li3 = driver.findElements(By.xpath("//*[@id='dataTable']/tbody/tr"));
		
		for(WebElement row: li3) {
			
			if(row.getText().contains("Andrew Hunt")) {
				
				row.findElement(By.xpath("//*[text()=\"Edit\"]")).click();
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
