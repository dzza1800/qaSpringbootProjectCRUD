package com.project.selenium;


import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

class order {
	
	private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

  
    @Test
    public void createOrder() {
        driver.get("http://localhost:8081/HomePage.html");
        driver.findElement(By.xpath("(//button[@id=\'Userbutton\'])[3]")).click();
        driver.findElement(By.xpath("(//button[@id=\'FormButton\'])[7]")).click();
        driver.findElement(By.xpath("//input[@id=\'Quantity\']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@id=\'Process\']")).sendKeys("true");
        driver.findElement(By.xpath("//form[@id=\'CreateOrderForm\']/input[3]")).click();
        driver.switchTo().alert().accept();
    }
  
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
