package test.java.com.mobileforming.mobile.web;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(JUnit4.class)
public class MobileWebQAIT {

    @Test
    public void testHappyPath() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "iPad Air");
        desiredCapabilities.setCapability("automationName", "XCUITest");
        desiredCapabilities.setCapability("platformVersion", "10.3");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");

        try {
            new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AppiumDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        // Navigate to the page and interact with the elements.
        driver.get("http://10.111.1.44:8080/");
        driver.findElement(By.id("connect")).click();
        driver.findElement(By.id("name")).sendKeys("iOS test user");
        driver.findElement(By.id("send")).click();
        sleepTenSeconds();
        driver.findElement(By.id("send")).click();
    }

    @Test
    public void testHappyPathLocalhost() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "iPad Air");
        desiredCapabilities.setCapability("automationName", "XCUITest");
        desiredCapabilities.setCapability("platformVersion", "10.3");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");

        try {
            new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AppiumDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        // Navigate to the page and interact with the elements.
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.id("connect")).click();
        driver.findElement(By.id("name")).sendKeys("iOS test user");
        driver.findElement(By.id("send")).click();
        sleepTenSeconds();
        driver.findElement(By.id("send")).click();
    }


    @Test
    public void testHappyPathAndroid() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Android Emulator");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "7.1.1");
        desiredCapabilities.setCapability("androidPackage", "com.android.chrome");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        try {
            new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        // Navigate to the page and interact with the elements.
        driver.get("http://10.111.1.44:8080/");
        driver.findElement(By.id("connect")).click();
        driver.findElement(By.id("name")).sendKeys("Android user");
        driver.findElement(By.id("send")).click();
        sleepTenSeconds();
        driver.findElement(By.id("send")).click();
    }

    public static void sleepTenSeconds() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
