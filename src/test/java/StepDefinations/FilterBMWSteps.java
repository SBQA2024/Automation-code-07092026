package StepDefinations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import PageFactory.FilterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterBMWSteps {
	WebDriver driver;
	
	
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() throws InterruptedException {
		 driver = new ChromeDriver();
		
		driver.get("http://127.0.0.1:5500/index.html");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
	}


	
	@Given("user can view the entire list of vehicles")
	public void user_can_view_the_entire_list_of_vehicles() throws InterruptedException {
		List<WebElement> allCars = driver.findElements(
		        By.cssSelector("#carContainer .car-card img"));

		System.out.println("Total cars displayed: " + allCars.size());

		for(WebElement car : allCars){
		    System.out.println(car.getAttribute("alt"));
		}
		
		Thread.sleep(3000);
	   
	}

	@When("the user applies the {string} filter under the brand category")
	public void the_user_applies_the_filter_under_the_brand_category(String string) {
		
Select brandDropdown = new Select(driver.findElement(By.id("brandFilter")));
		
		brandDropdown.selectByValue("BMW");
		
		
	}

	@Then("BMW car results should be displayed")
	public void bmw_car_results_should_be_displayed() throws InterruptedException {
		
		List<WebElement> brands = driver.findElements(
		        By.cssSelector("#carContainer .brand"));

		for (WebElement brand : brands) {
		    System.out.println("After applying filter - " + "Brand: " + brand.getText());
		}

	
		SoftAssert softAssert = new SoftAssert();

		for (WebElement car : brands) {

		    String brand = car.getText().trim();

		    softAssert.assertEquals(
		            brand,
		            "BMW",
		            "Non BMW car displayed: " + brand
		    );
		}

		

	}
	
	
	@Then("user again selecting {string} filter")
	public void user_again_selecting_filter(String brand) throws InterruptedException {

	    Select brandDropdown =
	            new Select(driver.findElement(By.id("brandFilter")));

	    brandDropdown.selectByValue("Toyota");

	    Thread.sleep(2000);
	}

	@Then("Toyota car results should be displayed")
	public void toyota_car_results_should_be_displayed() {
		
		List<WebElement> brands = driver.findElements(
		        By.cssSelector("#carContainer .brand"));

		for (WebElement brand : brands) {
		    System.out.println("After applying filter - " + "Brand: " + brand.getText());
		}

	
		SoftAssert softAssert = new SoftAssert();

		for (WebElement car : brands) {

		    String brand = car.getText().trim();

		    System.out.println("Displayed Brand : " + brand);

		    if(!brand.equals("Toyota")) {
		        System.out.println("FAIL -> Expected Toyota but found " + brand);
		    } else {
		        System.out.println("PASS -> Toyota displayed correctly");
		    }

		    softAssert.assertEquals(
		            brand,
		            "Toyota",
		            "Expected Toyota but found " + brand
		    );
		
		}

		

		// Collect all failures here
		
		
	}
	
	@When("user  selecting {string} filter")
	public void user_selecting_filter(String string) throws InterruptedException {
		
		
Select brandDropdown = new Select(driver.findElement(By.id("brandFilter")));
		
		brandDropdown.selectByValue("Mercedes");
		
		Thread.sleep(3000);
	}
	
	@Then("Mercedes car results should be displayed")
	public void mercedes_car_results_should_be_displayed() {
		
		List<WebElement> carCards =
				
				driver.findElements(By.cssSelector("#carContainer .car-card"));
		
		Set<String> uniqueCars = new HashSet<>();

		for (WebElement card : carCards) {

		    String brand = card.findElement(By.cssSelector(".brand")).getText().trim();
		    String carName = card.findElement(By.cssSelector(".car-name")).getText().trim();

		    String carIdentifier = brand + "-" + carName;

		    if (!uniqueCars.add(carIdentifier)) {
		        Assert.fail("Duplicate Brand + Car Name found : " + carIdentifier);
		    }
		}

		System.out.println("PASS - No duplicate Brand + Car Name found");
	}}
