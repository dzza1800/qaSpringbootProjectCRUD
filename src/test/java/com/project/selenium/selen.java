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
    public void ReadHeader() {
      driver.get("http://localhost:8081/HomePage.html");
      Assertions.assertEquals(driver.getTitle(), "Eurobeat Coins");
      Assertions.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Eurobeat");
    }
    
    @Test
    public void ReadHeader2() {
      driver.get("http://localhost:8081/HomePage.html");
      Assertions.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Coins");
    }
    @Test
    public void ReadButtons() {
        driver.get("http://localhost:8081/HomePage.html");
        Assertions.assertEquals(driver.findElement(By.xpath("//ul")).getText(), "Users\nCoins\nOrders");
      }
    @Test
    public void createUser() {
    	    driver.get("http://localhost:8081/HomePage.html");
    	    driver.findElement(By.id("Userbutton")).click();
    	    driver.findElement(By.id("FormButton")).click();
    	    driver.findElement(By.id("User")).sendKeys("dsd");
    	    driver.findElement(By.id("Pass")).sendKeys("dw");
    	    driver.findElement(By.id("submitButton")).click();
    	    driver.switchTo().alert().accept();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
