package PracticeSelenium.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practicedynamic {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://practice.expandtesting.com/dynamic-table");
		
		
		List <WebElement> li = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//tr"));
		
		for(WebElement x:li) {
			
			if(x.getText().contains("Chrome")) {
				
				driver.findElement(By.xpath("//table[@class=\"table table-striped\"]//tr//td[2]"));
				break;
			}}
		
	
		
		
			
				
		
				
			}}
			


