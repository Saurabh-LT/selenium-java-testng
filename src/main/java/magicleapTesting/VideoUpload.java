package magicleapTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class VideoUpload {

    public void vidupload(RemoteWebDriver driver) {
        try {
            driver.get("https://www.tmz.com/");
            driver.manage().deleteAllCookies();
            TakeScreenShot screen = new TakeScreenShot();

            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);


            WebElement Sports = driver.findElement(By.cssSelector("#header > div > nav > ul > li:nth-child(2) > a"));
            Sports.click();
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            JavascriptExecutor scroll = (JavascriptExecutor) driver;
            scroll.executeScript("window.scrollBy(0,5000)");
            Thread.sleep(1000);
            JavascriptExecutor scrollup = (JavascriptExecutor) driver;
            scrollup.executeScript("window.scrollBy(0,-5000)");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            Thread.sleep(5000);
            WebElement Videos = driver.findElement(By.cssSelector("#header > div > nav > ul > li:nth-child(3) > a"));
            System.out.println("Before Video Click");

            Videos.click();
            System.out.println("Video Clicked");
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            scroll.executeScript("window.scrollBy(0,5000)");
            Thread.sleep(2000);
            scrollup.executeScript("window.scrollBy(0,-5000)");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.findElement(By.id("masthead-search__input")).sendKeys("Bill Gates");


            //   screen.Screenshot(driver, status);
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

            driver.findElement(By.className("masthead-search__submit")).click();

            WebElement Shop = driver.findElement(By.cssSelector("#header > div > nav > ul > li:nth-child(6) > a"));
            Shop.click();
            scroll.executeScript("window.scrollBy(0,5000)");
            Thread.sleep(2000);
            scrollup.executeScript("window.scrollBy(0,-5000)");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());


            WebElement News = driver.findElement(By.cssSelector("#header > div > nav > ul > li:nth-child(1) > a"));
            News.click();
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            scroll.executeScript("window.scrollBy(0,5000)");
            Thread.sleep(2000);
            scrollup.executeScript("window.scrollBy(0,-5000)");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.findElement(By.id("masthead-search__input")).sendKeys("Donald Trump");
            driver.findElement(By.className("masthead-search__submit")).click();
            // screen.Screenshot(driver, status);
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

            WebElement WatchTimz = driver.findElement(By.cssSelector("#nav-showtimes > a"));
            WatchTimz.click();
            scroll.executeScript("window.scrollBy(0,5000)");
            Thread.sleep(2000);
            scrollup.executeScript("window.scrollBy(0,-5000)");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

            WebElement photos = driver.findElement(By.cssSelector("#header > div > nav > ul > li:nth-child(4) > a"));
            photos.click();
            scroll.executeScript("window.scrollBy(0,5000)");
            Thread.sleep(2000);
            scrollup.executeScript("window.scrollBy(0,-5000)");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            driver.findElement(By.id("masthead-search__input")).sendKeys("Kanye West");
            //screen.Screenshot(driver, status);
            driver.findElement(By.className("masthead-search__submit")).click();
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

        } catch (Exception v) {
            System.out.println(v);
        }
    }
}
