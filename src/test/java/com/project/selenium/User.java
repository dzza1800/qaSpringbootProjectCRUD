package com.project.selenium;

import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

class User {
	
	private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
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
