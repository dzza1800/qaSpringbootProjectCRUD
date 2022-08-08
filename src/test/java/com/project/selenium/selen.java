package com.project.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class selen {
	
	private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void untitled() {
      driver.get("http://localhost:8081/test");
      Assertions.assertEquals(driver.getTitle(), "");
      Assertions.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Message Here");
      driver.navigate().to("http://google.co.uk");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
