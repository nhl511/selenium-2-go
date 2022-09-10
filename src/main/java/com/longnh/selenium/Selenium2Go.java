/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.longnh.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Admin
 */
public class Selenium2Go {
    public static void main(String[] args) throws InterruptedException{
        searchGoogle();
    }
    
    public static void searchGoogle() throws InterruptedException{
        WebDriver myBrowser;
        String driverPath = "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        myBrowser = new ChromeDriver(); 
        
        myBrowser.get("https://google.com");
    
        myBrowser.manage().window().maximize();
    
        WebElement searchBox = myBrowser.findElement(By.name("q"));
    
        searchBox.sendKeys("gau gau");
        
        searchBox.submit();
        
        Thread.sleep(5000);
        
        myBrowser.quit();
    }

    public static void searchGoogleV2(){
        WebDriver myBrowser;
        String driverPath = "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");
        opt.addArguments("--lang=vi");
        
        myBrowser = new ChromeDriver(opt); 
        
        myBrowser.get("https://google.com");
    
        myBrowser.manage().window().maximize();
    }    
}
