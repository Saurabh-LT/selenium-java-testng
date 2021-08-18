package magicleapTesting;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class Random {
    public String username = System.getProperty("LT_USERNAME");
    public String accesskey = System.getProperty("LT_ACCESS_KEY");
    public RemoteWebDriver driver;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    String status;
    String ResolutionValue;
    long quitestoptime;
    long totaltime;
    long totaltimeforlocaltest;
    long Nettotalspeedtest;
    long GeolocationTotal;
    long ResolutionTotal;
    long totaltesttimeDuration;
    SessionId session;
    String browserNameValue;
    String platformVersionValue;
    String platformValueDevice;
    String fixedIpValue;
    String deviceNameValue;
    String geoLocationValue;
    String ResolutionValueCap;
    DateTimeFormatter dtf;
    LocalDateTime now;
    String[] VersionValue = {"14.2", "14.1", "14.3", "14.4"};
    String iOSVersion;
    Date date;

    @org.testng.annotations.Parameters(value = {"browser", "platformVersion", "platform", "fixedIp", "deviceName"})

    public Random(String browser, String platformVersion, String platform, String fixedIp, String deviceName) {
        browserNameValue = browser;
        platformVersionValue = platformVersion;
        platformValueDevice = platform;
        fixedIpValue = fixedIp;
        deviceNameValue = deviceName;
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        now = LocalDateTime.now();


        //   geoLocationValue = geoLocation;


    }


    @BeforeTest
    public void setUp() throws Exception {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        date = new Date();
        //  for (int i = 0; i < 100; i++) {
        if (platformValueDevice.matches("Android")) {
            for (int k = 0; k < 115; k++) {

                //  double version = 13.2;

            /*capability.setCapability("os_version", "8.0");
            capability.setCapability("device", "Samsung Galaxy S9");
            capability.setCapability("real_mobile", "true");
            capability.setCapability("automationName", "UiAutomator2");
            capability.addArguments("--disable-plugins");
            capability.addArguments("--disable-extensions");
            capability.addArguments("--disable-popup-blocking");
            capability.setExperimentalOption("prefs", prefs);*/
              /*  Map<String, Object> prefs = new HashMap<String, Object>();
             //   prefs.put("credentials_enable_service", true);*/
                ChromeOptions capability = new ChromeOptions();
                capability.setCapability("platformVersion", platformVersionValue);
                capability.setCapability("platform", this.platformValueDevice); // If this cap isn't specified, it will just get the any available one
                capability.setCapability("build", formatter.format(date) + System.getProperty("BUILD_NAME"));
                capability.setCapability("name", this.deviceNameValue);
                capability.setCapability("deviceName", this.deviceNameValue);
                capability.setCapability("network", true);
                capability.setCapability("console", true);
                capability.setCapability("visual", false);

                //capability.setCapability("tunnel", true);

                // capability.addArguments("--ignore-certificate-errors");
                //    capability.setCapability("isRealMobile", true);
                //   capability.setCapability("region", "eu");
                //   capability.setCapability("appiumVersion", "1.5.3");
            /* capability.setCapability("fixedIP", "23.105.12.48");
            capability.setCapability("fixedPort", "8000");*/

                // capability.setCapability("autoWebview", true);

                // capability.setCapability("isRealMobile", true);
                //  capability.setCapability("tunnel", true);
                //capability.setCapability("tunnelName", "73eea753-f3a1-4f96-9032-a875c0f37cb8");

                try {
                    StopWatch driverStart = new StopWatch();
                    driverStart.start();
                    String url = "http://" + username + ":" + accesskey + gridURL;
                    System.out.println(url);
                    driver = new RemoteWebDriver(new URL(url), capability);

                    //  sessionid = driver.getSessionId();

                    driverStart.stop();
                    float timeElapsed = driverStart.getTime() / 1000f;
                    System.out.println("Driver Setup time in Seconds " + "  " + timeElapsed + "Sec." + "  " + this.deviceNameValue + "  " + this.fixedIpValue);
                    MessageDigest m = MessageDigest.getInstance("MD5");
                    String s = username + ":" + accesskey;
                    m.update(s.getBytes(), 0, s.length());
                    System.out.println("MD5: " + new BigInteger(1, m.digest()).toString(16));
                    System.out.println(driver.getSessionId());
                    DesktopScript();
                    tearDown();

                } catch (MalformedURLException e) {
                    System.out.println("Invalid grid URL");
                    System.out.println("Test null pointer exception");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Test null pointer exception");
                }
            }
        } else {
            for (int k = 0; k < 100; k++) {
                for (int io = 0; io < VersionValue.length; io++) {
                    iOSVersion = VersionValue[io];
                    System.out.println(iOSVersion);


                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("platformVersion", iOSVersion);
                    capabilities.setCapability("platform", this.platformValueDevice); // If this cap isn't specified, it will just get the any available one
                    capabilities.setCapability("name", this.platformValueDevice + "   " + this.deviceNameValue + "  " + this.platformVersionValue + " " + this.fixedIpValue);
                    capabilities.setCapability("build", "iOS From local system Sanity" + dtf.format(now) + " " + this.platformValueDevice);
                    capabilities.setCapability("deviceName", this.deviceNameValue);
                    capabilities.setCapability("network", true);
                    capabilities.setCapability("console", true);
                    capabilities.setCapability("visual", true);

                    // capabilities.setCapability("fixedIP", this.fixedIpValue);
                    // capabilities.setCapability("tunnel", true);
                    // capabilities.setCapability("appiumVersion", "1.19.1");
                    //capabilities.setCapability("isRealMobile", true);
                    //  capabilities.setCapability("tunnel", true);


                    try {
                        StopWatch driverStart = new StopWatch();
                        driverStart.start();
                        String url = "http://" + username + ":" + accesskey + gridURL;
                        System.out.println(url);
                        driver = new RemoteWebDriver(new URL(url), capabilities);
                        //   session = driver.getSessionId();

                        driverStart.stop();
                        float timeElapsed = driverStart.getTime() / 1000f;
                        System.out.println("Driver Setup time in Seconds " + "  " + timeElapsed + "Sec." + "  " + this.deviceNameValue + "  " + this.platformVersionValue);
                        DesktopScript();
                        tearDown();
                        driver.quit();

                    } catch (MalformedURLException e) {
                        System.out.println("Invalid grid URL");
                        System.out.println("Test null pointer exception");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Test null pointer exception");
                    }

                }
            }
        }
        // }

    }

    @Test(priority = 1)
    public void DesktopScript() throws IOException {

        try {

            long startTest;
            long stopTest;
            startTest = System.currentTimeMillis();
            StopWatch teststarted = new StopWatch();
            teststarted.start();
            driver.get("https://www.google.com");
            driver.getTitle();
//            ResolutionTest deviceRes = new ResolutionTest();
//            deviceRes.Resolution(driver, ResolutionValue, status, ResolutionTotal, ResolutionValueCap);
           /* TunnelTest tunnel = new TunnelTest();
            tunnel.tunnelTest(driver, status, totaltimeforlocaltest);


            ChromeBrowserVersion Ver = new ChromeBrowserVersion();
            Ver.BrowserVersion(driver);
            AnroidVersion AVer = new AnroidVersion();
            AVer.AndVersion(driver, deviceNameValue, platformVersionValue);*/

        /*    IpConfig ip = new IpConfig();
            ip.IPData(driver);*/
        /*    TodoApp Todo = new TodoApp();
            Todo.TodoAppTest(driver, status);*/


            //driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).click();
//            // driver.findElement(MobileBy.id("com.android.packageinstaller:id/permission_allow_button")).click();
//            Thread.sleep(5000);
//            System.out.println(driver.getTitle());

            BadSslTest bad = new BadSslTest();
            bad.badSsl(driver, status);
            TakeScreenShot screen = new TakeScreenShot();
            screen.Screenshot(driver, status);

            StreamTest stream = new StreamTest();
            stream.TestStream(driver, status);
//
//

//            TunnelTest local = new TunnelTest();
//            local.tunnelTest(driver, status, totaltimeforlocaltest);
            stopTest = System.currentTimeMillis();
            totaltime = stopTest - startTest;

            System.out.println("Time taken by the test to execute" + "    " + totaltime / 1000f + "Sec.");
        } catch (Exception y) {
            status = "failed";
            System.out.println(y);
            File filetwo = driver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(filetwo, new File("myScreenshot.png"));

        }


    }

    @AfterTest
    public void tearDown() throws Exception {
        try {
            long quitetimestart;
            long quitetimestop;

            quitetimestart = System.currentTimeMillis();

            if (driver != null) {

                // System.out.println(driver + "Session ID" + "  " + session.toString());
                //    ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);



                status = "passed";
            } else {
                status = "failed";
            }
            quitestoptime = System.currentTimeMillis();
            quitetimestop = quitestoptime - quitetimestart;
        } catch (Exception T) {
            System.out.println(T);
        }

    }
}

