package Utils;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.testng.Assert;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageComparisonUtil {
	public static boolean compareImages(
	        String expectedPath,
	        String actualPath)
	        throws Exception {

	    BufferedImage expected =
	            ImageIO.read(new File("c://newfolder://actual_tata.png"));

	    BufferedImage actual =
	            ImageIO.read(new File("src\\main\\java\\expectedImages\\ExpectedImages.file"));

	    ImageDiff diff =
	            new ImageDiffer()
	                    .makeDiff(expected, actual);

	    Assert.assertFalse(diff.hasDiff());
		return false;
		
	}
}
