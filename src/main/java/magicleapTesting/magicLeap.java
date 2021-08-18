package magicleapTesting;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class magicLeap {

    public String username = "XEAWCVZI";
    public String accesskey = "O0DJ5u81mYncv1xPNFIlNBrbjrnzjeGiDvqWPKBrsRmwJ0J2LL";
    public RemoteWebDriver driver;
    public String gridURL = "preprod-hub.lambdatest.com"; //hub-virginia.lambdatest.com/wd/hub"@eu-central-1-hub.lambdatest.com/wd/hub";https://dark-1-hub.lambdatest.com/wd/hub/status
    //https://dark-2-hub.lambdatest.com/wd/hub/status
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
    String BrowserValue;
    String versionValue;
    String PlatformValue;
    String FixedIpValue;
    String ResolutionValueCap;
    String TimeZoneValue;
    String GeoLocationValue;
    String hub;
    String TestName;
    String Space = "  ";
    String Tunnel;
    long SuiteStart;
    long SuiteStop;
    long SuiteTotalTime;
    Long AllVersions = null;
    Date date;


    @org.testng.annotations.Parameters(value = {"browser", "version", "platform", "fixedIp", "resolution", "timezone", "geoLocation", "tunnel"})
    public magicLeap(String browser, String version, String platform, String fixedIp, String resolution, String timezone, String geoLocation, String tunnel) {
        try {
            BrowserValue = browser;
            versionValue = version;
            PlatformValue = platform;
            FixedIpValue = fixedIp;
            ResolutionValueCap = resolution;
            TimeZoneValue = timezone;
            GeoLocationValue = geoLocation;
            Tunnel = System.getProperty("tunnel");
            if (BrowserValue != null) {
                TestName = BrowserValue;
                if (PlatformValue != null) {
                    TestName = BrowserValue + Space + PlatformValue;
                    if (versionValue != null) {
                        TestName = BrowserValue + Space + PlatformValue + Space + versionValue;
                        if (FixedIpValue != null)
                            TestName = BrowserValue + Space + PlatformValue + Space + versionValue + Space + FixedIpValue;

                    }
                }
            }

        } catch (Exception t) {
        }
    }

    @BeforeTest
    public void setUp() throws Exception {
        System.out.println(this.TestName);
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        date = new Date();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    String[] file = {"5mb.jpg", "10MB.jpg", "2mb.jpg", "real time.png", "15mb.jpg", "10MB1.jpg", "10MB2.jpg", "10MB3.jpg", "My15mb2.jpg", "My15mb3.jpg", "My15mb3.jpg"};
                    String region = "eu";
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("browserName", this.BrowserValue);
                    //   capabilities.setCapability("version", "latest");
                    capabilities.setCapability("version", "latest" + "-" + j);
                    capabilities.setCapability("platform", this.PlatformValue);
                    //capabilities.setCapability("build", date +"  "+this.PlatformValue + System.getenv("LT_BUILD_NAME"));
                    capabilities.setCapability("build", formatter.format(date) + "  " + "  " + region);
                    capabilities.setCapability("name", this.TestName);
//                    capabilities.setCapability("lambda:userFiles", file);
//                    capabilities.setCapability("console", true);
//                    capabilities.setCapability("network", true);
//                    capabilities.setCapability("visual", false);
//                    capabilities.setCapability("selenium_version", "3.141.59");
//                    capabilities.setCapability("region", region);
//                    capabilities.setCapability("idleTimeout", "600");

                    // capabilities.setCapability("fixedIP", this.FixedIpValue);
            /*capabilities.setCapability("safari.cookies", true);
            capabilities.setCapability("safari.popups", true);*/

           /* String[] Tags = new String[]{this.PlatformValue, this.versionValue};
            capabilities.setCapability("tags", Tags);*/


                    //      capabilities.setCapability("safari.cookies", true);


                    //  capabilities.setCapability("video", true);

                    //        capabilities.setCapability("tunnel", true);

                    //   capabilities.setCapability("selenium_version", "4.0.0-alpha-1");

          /*  System.out.println(Tunnel);
            if (this.Tunnel.matches("true")) {

               RunTunnelListener TunnelInitateObjectToStart= new RunTunnelListener();
                TunnelInitateObjectToStart.onExecutionStart();

                Thread.sleep(20000);
                capabilities.setCapability("tunnel", "true");
            }*/
                    //      capabilities.setCapability("safari.cookies",true);
                    //   capabilities.setCapability("region", "eu");
                    //
                    //   capabilities.setCapability("tunnel", "true");
        /*capabilities.setCapability("ie.driver","3.4.0");
        capabilities.setCapability("ie.compatibility",11001);*/
                    //     capabilities.setCapability("tunnelName", "prateek");
                    //           capabilities.setCapability("geoLocation", geoLocation);
                    //    capabilities.setCapability("unboundRegion", "PUSE-EU");
                    //       capabilities.setCapability("timezone", this.TimeZoneValue);
                    //        capabilities.setCapability("geoLocation", this.GeoLocationValue);
                    //     capabilities.setCapability("headless", true);
                    //   capabilities.setCapability("networkThrottling", "Regular 4G");
                    //  capabilities.setCapability("prerun", "lambda:BasicAuthChrome/pre/httpdialog.au3");
//            String[] Tags = new String[]{"myproject", "myproject2","myproject3"};
//
//            capabilities.setCapability("tags", Tags);

                    StopWatch driverStart = new StopWatch();
                    driverStart.start();

                    hub = "https://" + username + ":" + accesskey + "@" + gridURL + "/wd/hub";
                    //hub = "http://localhost:8080/wd/hub";
                    System.out.println(hub);
                    System.out.println("Start Time" + " " + formatter.format(date));
                    driver = new RemoteWebDriver(new URL(hub), capabilities);


                    //set timeout to 5 seconds

                    session = driver.getSessionId();

                    System.out.println("====================DriverStart-up+++++++++++" + session + "+++++++++++DriverStart-up===================================");

                    //   System.out.println(driver + "Session ID" + "  " + session.toString() + "\n" + browser + version + "\n" + fixedIp);
                    driverStart.stop();

                    float timeElapsed = driverStart.getTime() / 1000f;
                    System.out.println("Driver initiate time" + "   " + timeElapsed);
                    DesktopScript();
                    tearDown();


                } catch (MalformedURLException e) {
                    System.out.println("Invalid grid URL");


                } catch (java.net.SocketTimeoutException f) {
                    System.out.println("Stop Time" + " " + formatter.format(date));
                    status = "failed";
                    System.out.println(f);
                    // System.out.println(f.getMessage() + browser + version + fixedIp);
                }
            }
        }

    }

    @Test
    public void DesktopScript() {
        try {
            System.out.println("==================TestStart+++++++++++++" + session + "++++++++++++++++TestStart==================");

            SuiteStart = System.currentTimeMillis();

           TodoApp TodoAppTestObject = new TodoApp();
            TodoAppTestObject.TodoAppTest(driver, status, session);
//            LambdaTutrial tut = new LambdaTutrial();
//            tut.Lambdacert(driver, session);
           /* ResolutionTest ResolutionTestObject = new ResolutionTest();

            ResolutionTestObject.Resolution(driver, ResolutionValue, status, ResolutionTotal, this.ResolutionValueCap, session);*/
          /*  GoogleSpace space = new GoogleSpace();
            space.GSpace(driver, session);
            TestCase SeleniumTest = new TestCase();
            SeleniumTest.LongCase(driver, session);*/
           /* VideoUpload test = new VideoUpload();
            test.vidupload(driver);
            GeolocationTest geo = new GeolocationTest();
            geo.Geolocation(driver, status, GeolocationTotal, session);*/
           /* DownloadTest down = new DownloadTest();
            down.FileDownload(driver);
            TestCase SeleniumTest = new TestCase();
            SeleniumTest.LongCase(driver, session);

            GoogleSpace space = new GoogleSpace();
            space.GSpace(driver, session);*/
            /*
            DesignPlane plane = new DesignPlane();
            plane.plane(driver,session);*/
            for (int index  = 0; index<=100; index++) {
                Thread.sleep(1000);
            }
            SuiteStop = System.currentTimeMillis();
            SuiteTotalTime = SuiteStop - SuiteStart;
            System.out.println("Total Time Took for Test suite execute" + "   " + SuiteTotalTime / 1000f);
            System.out.println("=======================TestStop++++++++++++++" + session + "++++++++++++++++TestStop==============");
        } catch (Exception e) {
            System.out.println(e + "    " + " SessionID --->" + "  " + session);
        }
    }


    @AfterTest
    @org.testng.annotations.Parameters(value = {"browser", "version", "platform"})
    public void tearDown() throws Exception {
        long quitetimestart;
        long quitetimestop;

        quitetimestart = System.currentTimeMillis();
        if (driver != null) {
            System.out.println("=============" + session + "================");
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();


        }
        quitestoptime = System.currentTimeMillis();
        quitetimestop = quitestoptime - quitetimestart;

    }


}

