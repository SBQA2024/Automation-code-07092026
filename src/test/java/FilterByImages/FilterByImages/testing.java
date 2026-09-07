package FilterByImages.FilterByImages;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class testing {
public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://127.0.0.1:5500/index.html");
	
	driver.manage().window().maximize();
	
	Thread.sleep(3000);
	
	List<WebElement> allCars = driver.findElements(
	        By.cssSelector("#carContainer .car-card img"));

	System.out.println("Total cars displayed: " + allCars.size());

	for(WebElement car : allCars){
	    System.out.println(car.getAttribute("alt"));
	}
	
	Thread.sleep(3000);
	//driver.findElement(By.xpath("//Select[@id='brandFilter']")).click();
	
	Select brandDropdown = new Select(driver.findElement(By.id("brandFilter")));
	
	brandDropdown.selectByValue("Toyota");
	
	
	List<WebElement> brands = driver.findElements(
	        By.cssSelector("#carContainer .brand"));

	for (WebElement brand : brands) {
	    System.out.println("After applying TOYOTA filter - " + "Brand: " + brand.getText());
	}

	

	SoftAssert softAssert = new SoftAssert();

	for (WebElement car : brands) {

	    String brand = car.getText().trim();

	    softAssert.assertEquals(
	            brand,
	            "Toyota",
	            "Non Toyota car displayed: " + brand
	    );
	}

	// Duplicate check
	List<WebElement> carCards =
	        driver.findElements(By.cssSelector("#carContainer .car-card"));

	Set<String> uniqueCars = new HashSet<>();

	for (WebElement card : carCards) {

	    String brand = card.findElement(
	            By.cssSelector(".brand")).getText().trim();

	    String carName = card.findElement(
	            By.cssSelector(".car-name")).getText().trim();

	    String carIdentifier = brand + "-" + carName;

	    if (uniqueCars.contains(carIdentifier)) {
	        softAssert.fail("Duplicate car found: " + carIdentifier);
	    }

	    uniqueCars.add(carIdentifier);
	}

	// Collect all failures here
	softAssert.assertAll();
}}
