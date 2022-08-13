package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Log4J {
    private static final Logger log = (Logger) LogManager.getLogger(Log4J.class.getName());
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +  "/BrowserDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        log.info("Window Maximized");
        log.debug("Now hitting Amazon server");
        driver.get("https://www.amazon.com/");
        log.info("Landed on amazon home page");
        Actions a =new Actions(driver);

        driver.get("http://jqueryui.com/demos/droppable/");
        log.debug("Getting the frames count");
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        log.info("Frames count retreived");
        try
        {
            driver.switchTo().frame(0);
            log.info("Successfully switched to frame");
        }
        catch(Exception e)
        {
            log.error("Cannot identify the frame");
        }
        log.debug("Identifying Draggable objects");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver).dragAndDrop(draggable, droppable).build().perform();
        log.info("Drag and drop success");
        driver.quit();
    }
}