package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPage {
	
	WebDriver driver;
	
	public FilterPage(WebDriver driver) {
        this.driver = driver;
    
	}
	
// if suppose website is having checkbox filter 
	
	
		    @FindBy (xpath="(By.id(tata))")
		    		
		    	WebElement tataFilter;
		    	
		   
		    @FindBy (xpath="By.id(ferrari)")
		    
		    WebElement ferrariFilter;

		    
		   
		        public void clickTataFilter() {
		            tataFilter.click();
		        }

		        public void clickFerrariFilter() {
		           ferrariFilter.click();
		        }
		    }


