package utils;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // ✅ Ensure directory exists
            File screenshotDir = new File("screenshots");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();  // create folder if not exists
            }

            String path = "screenshots/" + testName + "_" + timestamp + ".png";
            FileUtils.copyFile(src, new File(path));

        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("Screenshot capture error: " + e.getMessage());
        }
    }
}
