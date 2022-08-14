package com.project.selenium;


import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

class Coin {
	
	private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void createCoin() {
        driver.get("http://localhost:8081/HomePage.html");
        driver.findElement(By.xpath("//ul[@id=\'button_list\']/li[2]/button")).click();
        driver.findElement(By.xpath("//div[@id=\'CoinsSection\']/ul/li[2]/button")).click();
        driver.findElement(By.xpath("//input[@id=\'price\']")).sendKeys("15");
        driver.findElement(By.xpath("//input[@id=\'coins\']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@id=\'name\']")).sendKeys("test");
        driver.findElement(By.xpath("//form[@id=\'CreateCoinForm\']/input[4]")).click();
        driver.switchTo().alert().accept();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
