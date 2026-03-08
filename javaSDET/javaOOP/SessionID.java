package javaOOP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;

public class SessionID {
    private WebDriver driver;

    @Test
    public void Run_On_Chrome() {
        driver = new ChromeDriver();
        SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session ID = " + sessionId);
        System.out.println("Driver ID = " + driver.toString());
        driver.quit();
    }

    @Test
    public void Run_On_Firefox() {
        driver = new FirefoxDriver();
        SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session ID = " + sessionId);
        System.out.println("Driver ID = " + driver.toString());
        driver.quit();
    }

    @Test
    public void Run_On_Edge() {
        driver = new EdgeDriver();
        SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session ID = " + sessionId);
        System.out.println("Driver ID = " + driver.toString());
        driver.quit();
    }
}
