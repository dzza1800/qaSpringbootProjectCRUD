package com.project.selenium;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Page {
	
	private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void ReadHeader() {
      driver.get("http://localhost:8081/HomePage.html");
      Assertions.assertEquals(driver.getTitle(), "Eurobeat Coins");
      Assertions.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Eurobeat");
      Assertions.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Coins");
    }
    
    @Test
    public void ReadButtons() {
        driver.get("http://localhost:8081/HomePage.html");
        Assertions.assertEquals(driver.findElement(By.xpath("//ul")).getText(), "Users\nCoins\nOrders");
      }

    @Test
    public void testPage() {
      driver.get("http://localhost:8081/HomePage.html");
      {
        List<WebElement> elements = driver.findElements(By.xpath("//html"));
        assert(elements.size() > 0);
      }
      {
        List<WebElement> elements = driver.findElements(By.name("cryptoFrame"));
        assert(elements.size() > 0);
      }
      {
          List<WebElement> elements = driver.findElements(By.xpath("//img"));
          assert(elements.size() > 0);
        }
        {
          List<WebElement> elements = driver.findElements(By.xpath("//img[2]"));
          assert(elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.xpath("//p[@id=\'time\']"));
            assert(elements.size() > 0);
          }
    }
    
    

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
