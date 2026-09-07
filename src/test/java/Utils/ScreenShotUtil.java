package Utils;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class ScreenShotUtil {
	public static void captureElementImage(WebDriver driver,String fileName) throws IOException
		 {

		WebElement image =driver.findElement(By.className("vehicle-image"));
				
//take the screenshot				
	    Screenshot screenshot =
	            new AShot()
	                    .takeScreenshot(driver, image);
	    
//Save image	    

	    ImageIO.write(
	            screenshot.getImage(),
	            "PNG",
	            new File("c://newfolder://actual_tata.png"));
	}

}
