package magicleapTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BadSslTest {

    public void badSsl(RemoteWebDriver driver, String status) {
        try {
            driver.get("https://self-signed.badssl.com/");
            String badSslTitle = driver.getTitle();
            String title = "self-signed.badssl.com";
            WebElement content = driver.findElement(By.id("content"));
            String WebContent = content.getAttribute("innerText");
            String ExpectedWebpageContent = "self-signed.\n" + "badssl.com";

            if (WebContent.matches(ExpectedWebpageContent)) {
                status = "passed";
            }
        } catch (Exception b) {
            status = "failed";
            System.out.println(b);
        }
        ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
    }

}
